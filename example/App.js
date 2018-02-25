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
            setInterval(
              () => {
                c.strokeStyle = '#FF0000';
                c.lineWidth = 3;
                {/* ;
                c.beginPath();
                c.moveTo(10, 10);
                c.lineTo(10, 20);
                c.lineTo(20, 30); */}
                c.lineTo(200 * Math.random()|0, 200*Math.random()|0);
                c.stroke();
              },1000
            )
            
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
