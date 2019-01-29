package quanduong.com.demomyhotkey.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyHorizontalView extends LinearLayout {

    private List<MyItem> items;
    private OnItemClickListener mItemClickListener;


    public MyHorizontalView(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public MyHorizontalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public MyHorizontalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public MyHorizontalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public void addItem(MyItem item) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(item);
    }

    public MyItem get(int i) {
        if (items != null) return items.get(i);
        return null;
    }



    public void build() {
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                final MyItem item = items.get(i);
                final int position = i;

//                if (position == 0) {
//                    doSelectItem(item);
//                }

                item.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mItemClickListener != null) {
//                            doSelectItem(item);
                            mItemClickListener.onItemClicked(items.get(position));
                        }
                    }
                });
                addView(item);
            }
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickedListener) {
        this.mItemClickListener = itemClickedListener;
    }







    public interface OnItemClickListener {

        /**
         * Called when a tab click.
         *
         * @param clickedItem
         */
        void onItemClicked(MyItem clickedItem);
    }
}
