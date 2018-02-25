
# react-native-fast-canvas

## Getting started

`$ npm install react-native-fast-canvas --save`

### Mostly automatic installation

`$ react-native link react-native-fast-canvas`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-fast-canvas` and add `RNFastCanvas.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNFastCanvas.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.dvsoftware.RNFastCanvasPackage;` to the imports at the top of the file
  - Add `new RNFastCanvasPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-fast-canvas'
  	project(':react-native-fast-canvas').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-fast-canvas/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-fast-canvas')
  	```


## Usage
```javascript
import RNFastCanvas from 'react-native-fast-canvas';

// TODO: What to do with the module?
RNFastCanvas;
```
  