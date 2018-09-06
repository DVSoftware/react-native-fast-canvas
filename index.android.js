import React, { Component } from 'react';
import { NativeModules, requireNativeComponent, ViewPropTypes, UIManager, findNodeHandle } from 'react-native';
import FastCanvas2DContext from './FastCanvas2DContext';

const { RNFastCanvas } = NativeModules;

class FastCanvas extends Component {
	constructor(props) {
		super(props);
	}

	getContext(contextType, contextAttributes) {
		if (contextType === '2d') {
			return new FastCanvas2DContext();
		}
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