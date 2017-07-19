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

    float startX;
    float startY;
    float endX;
    float endY;

    protected Paint paint = new Paint();

    //间隔
    protected float interval;

    public Axis() {
        init();
    }

    private void init(){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
    }

    public abstract void drawSelf(Canvas canvas);

    public float getStartX() {
        return startX;
    }

    public void setLocation(float startX, float startY, float endX, float endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }
}
