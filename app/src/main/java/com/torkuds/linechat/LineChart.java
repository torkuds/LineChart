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

    XAxis xAxis;
    YAxis yAxis;
    Line line;

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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        xAxis = new XAxis(measuredWidth, measuredHeight);
        yAxis = new YAxis(measuredWidth, measuredHeight);
        line = new Line(measuredWidth, measuredHeight);
        line.setValue(1, 4);
        line.setValue(2, 1);
        line.setValue(3, 3);
        line.setValue(4, 2);
        line.setValue(5, 6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        yAxis.drawSelf(canvas);

        xAxis.drawSelf(canvas);

        line.drawSelf(canvas);

    }
}
