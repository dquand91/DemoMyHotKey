package quanduong.com.demomyhotkey.customview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import quanduong.com.demomyhotkey.R;
import quanduong.com.demomyhotkey.utils.StringUtils;


public class MyItem extends LinearLayout {

    TextView itemTextView;
    LinearLayout layoutContent;

    public MyItem(Context context) {
        super(context);
        inflateView(context);
    }

    public MyItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflateView(context);
    }

    public MyItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateView(context);
    }

    public MyItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateView(context);
    }

    private void inflateView(Context context) {
        inflate(context, R.layout.my_item_layout, this);
        itemTextView = findViewById(R.id.textItem);
        layoutContent = findViewById(R.id.layoutContentItem);
        LayoutParams param = (LayoutParams) layoutContent.getLayoutParams();
        setLayoutParams(param);
        setGravity(Gravity.CENTER);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.d("QUAN123", "onGlobalLayout: witdh = " + layoutContent.getWidth() + " --- height = " + layoutContent.getHeight());
                layoutContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if(StringUtils.WordCount(itemTextView.getText().toString()) > 1){
                    LayoutParams param = (LayoutParams) layoutContent.getLayoutParams();
                    param.width = layoutContent.getWidth() * 7 / 10 ;
                    setLayoutParams(param);
                }
            }
        });
    }

    public MyItem setText(String text) {
        itemTextView.setText(text);
        return this;
    }

    public void setLayoutWidth() {
//        Log.d("QUAN123", "setLayoutWidth: text = " + itemTextView.getText());
////        int width = layoutContent.getWidth() / 2;
////        Log.d("QUAN123", "setLayoutWidth: width = " + width);
////        Log.d("QUAN123", "setLayoutWidth: widthLayout = " + layoutContent.getWidth());
////        LayoutParams param = (LayoutParams) layoutContent.getLayoutParams();
////        param.width = width;
////        Log.d("QUAN123", "width: text = " + param.width);
////        Log.d("QUAN123", "height: text = " + param.height);
//
////        setLayoutParams(param);
//        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                layoutContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                if(StringUtils.WordCount(itemTextView.getText().toString()) > 1){
//                    LayoutParams param = (LayoutParams) layoutContent.getLayoutParams();
//                    param.width = layoutContent.getWidth() * 7 / 10 ;
//                    setLayoutParams(param);
//                }
//            }
//        });
//        return this;
    }

    public String getText(){
        if(itemTextView == null) return "";
        return itemTextView.getText().toString();
    }

    public MyItem setColor(int colorCode){
        layoutContent.getBackground().setColorFilter(colorCode, PorterDuff.Mode.SRC_OVER);
        return this;
    }

    public MyItem build() {
        return this;
    }

}
