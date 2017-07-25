package com.torkuds.linechat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.torkuds.linechat.adapter.MonthAdapter;

import java.util.List;

/**
 * Des:折线图
 * Created by wangtianchao
 * on 2017/7/19.
 */

public class LineChart extends View {

    XAxis xAxis;
    YAxis yAxis;
    Line line;

    private int max;    //最大值

    private int min;    //最小值

    private int xCount; //x轴数据个数

    private int yCount = 5; //y轴数据个数

    private int xInterval = 150;  //x轴刻度长度

    private int yInterval = 150;  //y轴刻度长度

    private int yStepValue;     //y轴一个刻度表示的值

    private List<Integer> datas;    //折线数据集合

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

        //计算view的宽高
        int width = measureDimension(xCount * xInterval, widthMeasureSpec);
        int height = measureDimension(2000, heightMeasureSpec);
        setMeasuredDimension(width, height);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        xAxis = new XAxis(measuredWidth, measuredHeight, xCount);
        xAxis.setAdapter(new MonthAdapter(7));
        yAxis = new YAxis(measuredWidth, measuredHeight, yCount);
        yAxis.setBottomHeight(xAxis.getBottomHeight());
        line = new Line(measuredWidth, measuredHeight, yStepValue, xInterval, yInterval, xAxis.getBottomHeight());
//        line.setValue(1, 4);
//        line.setValue(2, 1);
//        line.setValue(3, 3);
//        line.setValue(4, 2);
//        line.setValue(5, 6);
        line.setDatas(datas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        yAxis.drawSelf(canvas);

        xAxis.drawSelf(canvas);

        line.drawSelf(canvas);

    }

    public int measureDimension(int defaultSize, int measureSpec){
        int result;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = defaultSize;   //UNSPECIFIED
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getxCount() {
        return xCount;
    }

    public void setxCount(int xCount) {
        this.xCount = xCount;
    }

    public int getyCount() {
        return yCount;
    }

    public void setyCount(int yCount) {
        this.yCount = yCount;
    }

    public List<Integer> getDatas() {
        return datas;
    }

    public void setDatas(List<Integer> datas) {
        this.datas = datas;
        xCount = datas != null ? datas.size() : 0;
        invalidate();
    }

    public void setValues(int yInterval, int yStepValue, int yCount, List<Integer> datas){
        this.yInterval = yInterval;
        this.yStepValue = yStepValue;
        this.yCount = yCount;
        this.datas = datas;
        xCount = datas != null ? datas.size() : 0;
        invalidate();
    }

    public int getBottomHeight(){
        return xAxis.getBottomHeight();
    }
}
