package com.torkuds.linechat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Des:折线图
 * Created by wangtianchao
 * on 2017/7/19.
 */

public class LineChart extends View {


    Paint axisPaint = new Paint();

    XAxis xAxis = new XAxis();
    YAxis yAxis = new YAxis();

    public LineChart(Context context) {
        super(context);
    }

    public LineChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        yAxis.setLocation(0, 0, 0, getHeight());
        yAxis.drawSelf(canvas);

        xAxis.setLocation(0, getHeight(), getWidth(), getHeight());
        xAxis.drawSelf(canvas);

    }
}
