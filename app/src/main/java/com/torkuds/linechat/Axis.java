package com.torkuds.linechat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Des:
 * Created by wangtianchao
 * on 2017/7/19.
 */

public abstract class Axis {

    protected int width;
    protected int height;

    protected Paint paint = new Paint();

    public Axis(int width, int height) {
        init();
        this.width = width;
        this.height = height;
    }

    private void init(){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setTextSize(30);
    }

    public abstract void drawSelf(Canvas canvas);

}
