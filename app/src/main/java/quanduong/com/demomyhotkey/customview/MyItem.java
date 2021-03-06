package quanduong.com.demomyhotkey.customview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layoutContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                LayoutParams param = (LayoutParams) layoutContent.getLayoutParams();
                if(StringUtils.WordCount(itemTextView.getText().toString()) > 1){
                    param.width = itemTextView.getWidth() * 9 / 10 ;
                    param.setMargins(param.leftMargin, 0, 0, 0);
                    layoutContent.setLayoutParams(param);
                }
            }
        });
    }

    public MyItem setText(String text) {
        itemTextView.setText(text);
        return this;
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
