package com.dvsoftware;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by dvsoftware on 2/24/18.
 */

public class FastCanvas extends View {
    private Canvas fastCanvas;
    private Bitmap bitmap;
    private Paint paint;

    public FastCanvas(Context context) {
        super(context);
        bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);
        fastCanvas = new Canvas(bitmap);
        paint = new Paint();

    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width, height);
        bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        fastCanvas.setBitmap(bitmap);


    }

    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    public void stroke(float[] points) {
        fastCanvas.drawLines(points, paint);
        this.invalidate();
    }

    public void setStrokeStyle(String color) {
        this.paint.setColor(Color.parseColor(color));
    }

    public void setLineWidth(int width) {
        this.paint.setStrokeWidth(width);
    }

    public void setLineCap(String cap) {
        if (cap.equals("round")) {
            this.paint.setStrokeCap(Paint.Cap.ROUND);
        } else if (cap.equals("square")) {
            this.paint.setStrokeCap(Paint.Cap.SQUARE);
        } else {
            this.paint.setStrokeCap(Paint.Cap.BUTT);
        }
    }


}
