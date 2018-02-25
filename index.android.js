import React, { Component } from 'react';
import { NativeModules, requireNativeComponent, ViewPropTypes, UIManager, findNodeHandle } from 'react-native';

const { RNFastCanvas } = NativeModules;

class FastCanvas extends Component {
	constructor(props) {
		super(props);
		this.points = [0, 0]; // Investigate behavior when moveTo is not called before
	}

	set strokeStyle(color) {
		UIManager.dispatchViewManagerCommand(
			findNodeHandle(this),
			UIManager.RNFastCanvas.Commands.setStrokeStyle,
			[color],
		);
	}

	set lineWidth(width) {
		UIManager.dispatchViewManagerCommand(
			findNodeHandle(this),
			UIManager.RNFastCanvas.Commands.setLineWidth,
			[width],
		);
	}

	beginPath() {
		this.points = [0, 0];
	}

	moveTo(x, y) {
		const length = this.points.length;
		console.log(this);
		if (length % 2 === 0) { // lineTo was last call
			this.points.push(x, y);
		} else {
			this.points[length - 2] = x;
			this.points[length - 1] = y;
		}
	}

	lineTo(x, y) {
		this.points.push(x, y, x, y); // Simulate another moveTo
	}

	stroke() {
		// const length = this.points.length;
		UIManager.dispatchViewManagerCommand(
			findNodeHandle(this),
			UIManager.RNFastCanvas.Commands.stroke,
			[[...this.points]],
		);

		// this.points = [this.points[length - 2], this.points[length - 1]]; // Keep the last position
	}

	render() {
		return (
			<RNFastCanvasView {...this.props} />
		)
	}
}

FastCanvas.propTypes = {
	...ViewPropTypes,
}

const RNFastCanvasView = requireNativeComponent('RNFastCanvas', FastCanvas);

export default FastCanvas;