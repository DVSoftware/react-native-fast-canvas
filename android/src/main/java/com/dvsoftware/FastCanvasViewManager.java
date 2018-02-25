package com.dvsoftware;

import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;

import java.util.Map;

/**
 * Created by dvsoftware on 2/24/18.
 */

public class FastCanvasViewManager extends ViewGroupManager<FastCanvasLayout> {
    public static final int COMMAND_STROKE = 1;
    public static final int COMMAND_SET_STROKE_STYLE = 2;
    public static final int COMMAND_SET_LINE_WIDTH = 3;

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
        return MapBuilder.of(
                "stroke",
                COMMAND_STROKE,
                "setStrokeStyle",
                COMMAND_SET_STROKE_STYLE,
                "setLineWidth",
                COMMAND_SET_LINE_WIDTH
        );
    }


    @Override
    public void receiveCommand(
            FastCanvasLayout view,
            int commandType,
            @Nullable ReadableArray args) {
        Assertions.assertNotNull(view);
        Assertions.assertNotNull(args);
        switch (commandType) {
            case COMMAND_STROKE: {
               view.stroke(args.getArray(0));
                return;
            }
            case COMMAND_SET_STROKE_STYLE: {
                view.setStrokeStyle(args.getString(0));
                return;
            }
            case COMMAND_SET_LINE_WIDTH: {
                view.setLineWidth(args.getInt(0));
                return;
            }
            default:
                throw new IllegalArgumentException(String.format(
                        "Unsupported command %d received by %s.",
                        commandType,
                        getClass().getSimpleName()));
        }
    }
}
