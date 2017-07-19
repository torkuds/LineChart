package com.torkuds.linechat;

import android.graphics.Canvas;

/**
 * Des:
 * Created by wangtianchao
 * on 2017/7/19.
 */

public class XAxis extends Axis {

    public XAxis() {
        super();
    }

    @Override
    public void drawSelf(Canvas canvas) {
        canvas.drawLine(startX, startY, endX, endY, paint);
    }
}
