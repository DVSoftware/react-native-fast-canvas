/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
} from 'react-native';

import Color from 'color';

import FastCanvas from 'react-native-fast-canvas';

console.log('fastcanvaslog',FastCanvas);

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' +
    'Cmd+D or shake for dev menu',
  android: 'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  render() {
    return (
      <View 
      style={
        {
          borderWidth:1,
          height: 260,
        }
      }
      >
        <FastCanvas
          ref={c => {
            let hue = 0;
            setInterval(
              () => {
               
               c.strokeStyle = Color('#FF0000').hue(hue % 255).hex();
                c.lineWidth = 10;
                c.lineCap = 'round';
                {/* ;
                c.beginPath();
                c.moveTo(10, 10);
                c.lineTo(10, 20);
                c.lineTo(20, 30); */}
                c.lineTo(200 * Math.random()|0, 200*Math.random()|0);
                c.stroke();
                hue += 1;
              },16
            );
            
          }}
          style={{
           flex: 1,
          }}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
