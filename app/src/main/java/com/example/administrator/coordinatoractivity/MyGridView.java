package com.example.administrator.coordinatoractivity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class MyGridView extends GridView{
    public MyGridView(Context context) {
        super(context);
    }
    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
