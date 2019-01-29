package quanduong.com.demomyhotkey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import quanduong.com.demomyhotkey.RetrofitService.APIUtils;
import quanduong.com.demomyhotkey.RetrofitService.DataClientListener;
import quanduong.com.demomyhotkey.utils.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
