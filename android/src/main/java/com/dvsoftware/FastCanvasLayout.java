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

    public void lineTo(double x, double y) {
        this.fastCanvas.lineTo(x, y);
    }
    public void moveTo(double x, double y) {
        this.fastCanvas.moveTo(x, y);
    }

    public void stroke() {
        this.fastCanvas.stroke();
    }

    public void setStrokeStyle(String color) {
        this.fastCanvas.setStrokeStyle(color);
    }

    public void lineWidth(double width) {
        this.fastCanvas.lineWidth(width);
    }

    public void setLineCap(String cap) {
        this.fastCanvas.setLineCap(cap);
    }
}
