package com.torkuds.linechat;

import android.graphics.Canvas;
import android.util.Log;

/**
 * Des:X轴
 * Created by wangtianchao
 * on 2017/7/19.
 */

public class XAxis extends Axis {

    private int count = 6;

    private int interval = 150; //间隔长度

    private float scale = 20;

    public XAxis(int width, int height) {
        super(width, height);
    }

    @Override
    public void drawSelf(Canvas canvas) {
        canvas.drawLine(scale, height, width, height, paint);
        drawScale(canvas);
    }

    /**
     * 画刻度
     * @param canvas
     */
    private void drawScale(Canvas canvas){
        for (int i = 1; i <= count; i++){
            Log.i("画刻度", i + "<--");
            paint.setStrokeWidth(2);
            canvas.drawLine(interval * i, height, interval * i, height - scale, paint);
        }
    }
}
