import { UIManager, findNodeHandle } from 'react-native';


export default class FastCanvas2DContext {
    constructor(view) {
        this.view = view;

        
    }

    set strokeStyle(color) {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.view),
            UIManager.RNFastCanvas.Commands.strokeStyle,
            [color],
        );
    }

    set lineWidth(width) {
        console.log(UIManager.RNFastCanvas.Commands);
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.view),
            UIManager.RNFastCanvas.Commands.lineWidth,
            [width],
        );
    }

    set lineCap(cap) {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.view),
            UIManager.RNFastCanvas.Commands.lineCap,
            [cap],
        );
    }

    beginPath() {
        // this.view.points = [0, 0];
    }

    moveTo(x, y) {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.view),
            UIManager.RNFastCanvas.Commands.moveTo,
            [x, y],
        );
    }

    lineTo(x, y) {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.view),
            UIManager.RNFastCanvas.Commands.lineTo,
            [x, y],
        );
    }

    stroke() {
        // const length = this.view.points.length;
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.view),
            UIManager.RNFastCanvas.Commands.stroke,
            null,
        );

        // this.view.points = [this.view.points[length - 2], this.view.points[length - 1]]; // Keep the last position
    }
}