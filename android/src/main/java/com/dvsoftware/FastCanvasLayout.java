package com.dvsoftware;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;

import com.dvsoftware.FastCanvas;
import com.facebook.react.bridge.ReadableArray;

/**
 * Created by dvsoftware on 2/24/18.
 */

public class FastCanvasLayout extends LinearLayout {
    FastCanvas fastCanvas;

    public FastCanvasLayout(Context context) {
        super(context);
        this.fastCanvas = new FastCanvas(context);
        this.addView(this.fastCanvas);
    }

    public void stroke(ReadableArray points) {
        float[] pts = new float[points.size()];
        for (int i = 0; i < points.size(); i++) {
            pts[i] = points.getInt(i);
        }
        this.fastCanvas.stroke(pts);
    }

    public void setStrokeStyle(String color) {
        this.fastCanvas.setStrokeStyle(color);
    }

    public void setLineWidth(int width) {
        this.fastCanvas.setLineWidth(width);
    }

    public void setLineCap(String cap) {
        this.fastCanvas.setLineCap(cap);
    }
}
