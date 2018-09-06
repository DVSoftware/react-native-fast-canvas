package com.dvsoftware;

import android.support.annotation.Nullable;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.HashMap;

import java.util.Map;

/**
 * Created by dvsoftware on 2/24/18.
 */

public class FastCanvasViewManager extends ViewGroupManager<FastCanvasLayout> {

    public static final int COMMAND_FILL_STYLE = 0;
    public static final int COMMAND_FONT = 1;
    public static final int COMMAND_GLOBAL_ALPHA = 2;
    public static final int COMMAND_GLOBAL_COMPOSITE_OPERATION = 3;
    public static final int COMMAND_LINE_CAP = 4;
    public static final int COMMAND_LINE_DASH_OFFSET = 5;
    public static final int COMMAND_LINE_JOIN = 6;
    public static final int COMMAND_LINE_WIDTH = 7;
    public static final int COMMAND_MITER_LIMIT = 8;
    public static final int COMMAND_SHADOW_BLUR = 9;
    public static final int COMMAND_SHADOW_COLOR = 10;
    public static final int COMMAND_SHADOW_OFFX = 11;
    public static final int COMMAND_SHADOW_OFFY = 12;
    public static final int COMMAND_STROKE_STYLE = 13;
    public static final int COMMAND_TEXT_ALIGN = 14;
    public static final int COMMAND_TEXT_BASELINE = 15;

    public static final int COMMAND_ARC = 16;
    public static final int COMMAND_ARC_TO = 17;
    public static final int COMMAND_BEGIN_PATH = 18;
    public static final int COMMAND_BEZIER_CURVE_TO = 19;
    public static final int COMMAND_CLEAR_RECT = 20;
    public static final int COMMAND_CLIP = 21;
    public static final int COMMAND_CLOSE_PATH = 22;
    public static final int COMMAND_CREATE_IMAGE_DATA = 23;
    public static final int COMMAND_CREATE_LINEAR_GRADIENT = 24;
    public static final int COMMAND_CREATE_PATTERN = 25;
    public static final int COMMAND_CREATE_RADIAL_GRADIENT = 26;
    public static final int COMMAND_DRAW_IMAGE = 27;
    public static final int COMMAND_FILL = 28;
    public static final int COMMAND_FILL_RECT = 29;
    public static final int COMMAND_FILL_TEXT = 30;
    public static final int COMMAND_LINE_TO = 31;
    public static final int COMMAND_MEASURE_TEXT = 32;
    public static final int COMMAND_MOVE_TO = 33;
    public static final int COMMAND_PUT_IMAGE_DATA = 34;
    public static final int COMMAND_QUADRATIC_CURVE_TO = 35;
    public static final int COMMAND_RECT = 36;
    public static final int COMMAND_RESTORE = 37;
    public static final int COMMAND_ROTATE = 38;
    public static final int COMMAND_SAVE = 39;
    public static final int COMMAND_SCALE = 40;
    public static final int COMMAND_SET_LINE_DASH = 41;
    public static final int COMMAND_SET_TRANSFORM = 42;
    public static final int COMMAND_STROKE = 43;
    public static final int COMMAND_STROKE_RECT = 44;
    public static final int COMMAND_STROKE_TEXT = 45;
    public static final int COMMAND_TRANSFORM = 46;
    public static final int COMMAND_TRANSLATE = 46;


    @Override
    public String getName() {
        return "RNFastCanvas";
    }


    @Override
    protected FastCanvasLayout createViewInstance(ThemedReactContext reactContext) {
        return new FastCanvasLayout(reactContext);
    }

    @Override
    public LayoutShadowNode createShadowNodeInstance() {
        return new LayoutShadowNode();
    }

    @Override
    public Class<LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    @Override
    public Map<String,Integer> getCommandsMap() {
        HashMap<String, Integer> commands = new HashMap<String, Integer>();
        commands.put("stroke", COMMAND_STROKE);
        commands.put("strokeStyle", COMMAND_STROKE_STYLE);
        commands.put("lineWidth", COMMAND_LINE_WIDTH);
        commands.put("lineCap", COMMAND_LINE_CAP);
        commands.put("beginPath", COMMAND_BEGIN_PATH);
        commands.put("moveTo", COMMAND_MOVE_TO);
        commands.put("lineTo", COMMAND_LINE_TO);
        commands.put("textAlign", COMMAND_TEXT_ALIGN);
        commands.put("textBaseline", COMMAND_TEXT_BASELINE);
        commands.put("fillStyle", COMMAND_FILL_STYLE);
        commands.put("fillText", COMMAND_FILL_TEXT);
        commands.put("lineJoin", COMMAND_LINE_JOIN);
        commands.put("fill", COMMAND_FILL);
        commands.put("fillRect", COMMAND_FILL_RECT);
        commands.put("clearRect", COMMAND_CLEAR_RECT);
        commands.put("setLineDash", COMMAND_SET_LINE_DASH);
        commands.put("arc", COMMAND_ARC);
        commands.put("globalAlpha", COMMAND_GLOBAL_ALPHA);
        commands.put("measureText", COMMAND_MEASURE_TEXT);

        return commands;
    }

    public void stub(int commandType) {
        System.out.println(String.format("Unimplemented command type %d", commandType));
    }

    @Override
    public void receiveCommand(
            FastCanvasLayout view,
            int commandType,
            @Nullable ReadableArray args) {
        Assertions.assertNotNull(view);
        Assertions.assertNotNull(args);
        switch (commandType) {
            case COMMAND_MOVE_TO: {
                view.moveTo(args.getDouble(0), args.getDouble(0));
            }
            case COMMAND_LINE_TO: {
                view.lineTo(args.getDouble(0), args.getDouble(0));
            }
            case COMMAND_STROKE: {
               view.stroke();
                return;
            }
            case COMMAND_STROKE_STYLE: {
                view.setStrokeStyle(args.getString(0));
                return;
            }
            case COMMAND_LINE_WIDTH: {
                System.out.println(args);
                view.lineWidth(args.getDouble(0));
                return;
            }
            case COMMAND_LINE_CAP: {
                view.setLineCap(args.getString(0));
                return;
            }
            default:
                stub(commandType);
        }
    }
}
