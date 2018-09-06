package com.dvsoftware;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;
/**
 * Created by dvsoftware on 2/24/18.
 */

public class FastCanvas extends View {

    public static final int PATH_COMMAND_MOVE_TO = 1;
    public static final int PATH_COMMAND_LINE_TO = 2;

    private Canvas fastCanvas;
    private Bitmap bitmap;
    private Paint paint;
    private ArrayList<PathCommand> commands; 


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

    public void moveTo(double x, double y) {
        this.commands.add(new PathCommand(PATH_COMMAND_MOVE_TO, new double[]{x, y}));
    }
    
    public void lineTo(double x, double y) {
        this.commands.add(new PathCommand(PATH_COMMAND_LINE_TO, new double[]{x, y}));
    }

    public void stroke() {
        double[] pos = {0f, 0f};

        for (PathCommand command : commands)
            switch (command.commandType) {
                case PATH_COMMAND_LINE_TO: {
                    pos = command.params;
                    break;
                }
                case PATH_COMMAND_MOVE_TO: {
                    fastCanvas.drawLine((float) pos[0], (float) pos[1], (float) command.params[0], (float) command.params[1], this.paint);
                    pos = command.params;
                    break;
                }
            }
        this.invalidate();
    }

    public void setStrokeStyle(String color) {
        this.paint.setColor(Color.parseColor(color));
    }

    public void lineWidth(double width) {
        System.out.println(this.paint);
        System.out.println(width);
        this.paint.setStrokeWidth((float)width);
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
