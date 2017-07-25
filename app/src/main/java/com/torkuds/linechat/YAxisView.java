package com.torkuds.linechat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Des:
 * Created by wangtianchao
 * on 2017/7/24.
 */

public class YAxisView extends View {

    private int count = 5;

    private int max;

    private int min;

    private int stepValue;

    private int interval = 150;   //刻度长度

    private int bottom = 10;    //底部边距

    private float scale = 20;   //左侧

    private Rect rect = new Rect(); //文字区域

    private Paint paint;

    private String label = "1000";

    private int realHeight;

    private OnMeasureSuccessListener listener;

    public YAxisView(Context context) {
        this(context, null, 0);
    }

    public YAxisView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YAxisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

    }

    public void setDatas(int max, int count){
        if (max > min && min >= 0 && count > 0){
            this.max = max;
            this.count = count;
            stepValue = max / count;
            paint.getTextBounds(String.valueOf(max), 0, String.valueOf(max).length(), rect);
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = measureDimension(2000, widthMeasureSpec);
        int height = measureDimension(2000, heightMeasureSpec);
        setMeasuredDimension(width, height);

        realHeight = getMeasuredHeight() - rect.height();
        interval = (realHeight - 100) / count;

        if (listener != null){
            listener.onMeasureSucceess();
        }

        Log.i("折线", "interval:" + interval + ",stepValue:" + stepValue + "<--y轴");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);

        canvas.drawLine(getMeasuredWidth(), 0, getMeasuredWidth(), realHeight, paint);
//        canvas.drawLine(scale, 0, scale, getMeasuredHeight(), paint);

        //画刻度
        drawScale(canvas);

        //画标签
    }

    /**
     * 画刻度
     * @param canvas
     */
    private void drawScale(Canvas canvas){
        for (int i = 1; i <= count; i++){
            paint.setStrokeWidth(2);
            //画刻度
            canvas.drawLine(getMeasuredWidth(), realHeight - (interval * i), getMeasuredWidth() - scale, realHeight - (interval * i), paint);
            //画格子线
//            paint.setStrokeWidth(1);
//            canvas.drawLine(0, height - (interval * i), width, height - (interval * i), paint);
            //画标签
            paint.setTextSize(30);
            canvas.drawText(stepValue * i + "", getMeasuredWidth() - scale - rect.width(), realHeight - (interval * i) + (rect.height() / 2), paint);
        }
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

    public int getStepValue() {
        return stepValue;
    }

    public int getCount() {
        return count;
    }

    public int getInterval() {
        return interval;
    }

    public interface OnMeasureSuccessListener{
        void onMeasureSucceess();
    }

    public void setOnMeasureSuccessListener(OnMeasureSuccessListener listener){
        this.listener = listener;
    }
}
