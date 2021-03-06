package com.torkuds.linechat;

import android.graphics.Canvas;
import android.util.Log;

/**
 * Des:Y轴
 * Created by wangtianchao
 * on 2017/7/19.
 */

public class YAxis extends Axis {

    private int count = 5;

    private int interval = 150; //间隔长度

    private float scale = 20;

    private int realHeight;

    public YAxis(int width, int height, int count) {
        super(width, height);
        this.count = count;
    }

    @Override
    public void drawSelf(Canvas canvas) {

//        canvas.drawLine(scale, 0, scale, height, paint);

        drawScale(canvas);
    }

    /**
     * 画刻度
     * @param canvas
     */
    private void drawScale(Canvas canvas){
        for (int i = 1; i <= count; i++){
            paint.setStrokeWidth(2);
            //画刻度
//            canvas.drawLine(0, height - (interval * i), scale, height - (interval * i), paint);
            //画格子线
            paint.setStrokeWidth(1);
            canvas.drawLine(0, realHeight - (interval * i), width, realHeight - (interval * i), paint);
        }
    }

    public void setDatas(int interval, int count){
        this.interval = interval;
        this.count = count;
    }

    public void setBottomHeight(int bottomHeight){
        realHeight = height - bottomHeight;
        interval = (realHeight - 100) / count;
    }

}
