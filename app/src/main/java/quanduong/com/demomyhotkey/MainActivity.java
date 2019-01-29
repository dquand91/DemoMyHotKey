package quanduong.com.demomyhotkey;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import quanduong.com.demomyhotkey.RetrofitService.APIUtils;
import quanduong.com.demomyhotkey.RetrofitService.DataClientListener;
import quanduong.com.demomyhotkey.customview.MyHorizontalView;
import quanduong.com.demomyhotkey.customview.MyItem;
import quanduong.com.demomyhotkey.utils.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnGetData;
    MyHorizontalView myHorizontalView;
    List<String> data = new ArrayList<>();
    int[] androidColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHorizontalView = findViewById(R.id.layoutContainer);
        androidColors = getResources().getIntArray(R.array.androidcolors);
        // Random color
//        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
//        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
//        view.setBackgroundColor(randomAndroidColor);


        btnGetData = findViewById(R.id.btnGetData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataClientListener getDataClient = APIUtils.getDataRetrofit();
                Call<List<String>> callback = getDataClient.getData();
                callback.enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        ArrayList<String> mList = (ArrayList<String>) response.body();
                        if(mList.size() > 0){
//                            Log.d("QUAN123", "onResponse: " + mList.get(0));
                            LogUtils.LogListString(mList);
                        }
                        data = mList;
                        setupList(MainActivity.this, data);

                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Log.d("QUAN123", "onFailure: " + t);
                        Toast.makeText(MainActivity.this, "FAIL!!!!!!!!!!!!!! Login", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void setupList(Context context, List<String> listData){

        if(listData == null || listData.isEmpty()) return;
        for (String textData: listData) {
            myHorizontalView.addItem(new MyItem(context)
                    .setText(textData)
                    .setColor(androidColors[new Random().nextInt(androidColors.length)])
                    .build());
        }
        myHorizontalView.build();
        myHorizontalView.setItemClickListener(new MyHorizontalView.OnItemClickListener() {
            @Override
            public void onItemClicked(MyItem clickedItem) {
                Toast.makeText(MainActivity.this, "Clicked " + clickedItem.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
