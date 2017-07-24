package com.torkuds.linechat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.torkuds.linechat.adapter.MonthAdapter;

import java.util.List;

/**
 * Des:X轴
 * Created by wangtianchao
 * on 2017/7/19.
 */

public class XAxis extends Axis {

    private int count = 16;

    private int interval = 150; //间隔长度

    private float scale = 20;

    private Rect rect = new Rect(); //文字区域

    private String label = "7/21";

    private MonthAdapter adapter;

    public XAxis(int width, int height, int count) {
        super(width, height);
        this.count = count;
        init();
    }

    private void init(){
        paint.getTextBounds(label, 0, label.length(), rect);
    }

    @Override
    public void drawSelf(Canvas canvas) {
        canvas.drawLine(0, height - rect.height(), width, height - rect.height(), paint);
        drawScale(canvas);
    }

    /**
     * 画刻度
     * @param canvas
     */
    private void drawScale(Canvas canvas){
        for (int i = 1; i <= count; i++){
            paint.setStrokeWidth(2);
            canvas.drawLine(interval * i, height - rect.height(), interval * i, height - rect.height() - scale, paint);
            if (adapter != null)
                canvas.drawText(adapter.getLabel(i), interval * i - rect.width() / 2, height, paint);
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAdapter(MonthAdapter adapter) {
        this.adapter = adapter;
    }
}
