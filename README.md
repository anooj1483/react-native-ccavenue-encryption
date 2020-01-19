# react-native-ccavenue-encryption

## Getting started

`$ npm install react-native-ccavenue-encryption --save`

### Mostly automatic installation

`$ react-native link react-native-ccavenue-encryption`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-ccavenue-encryption` and add `CcavenueEncryption.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libCcavenueEncryption.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.CcavenueEncryptionPackage;` to the imports at the top of the file
  - Add `new CcavenueEncryptionPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-ccavenue-encryption'
  	project(':react-native-ccavenue-encryption').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-ccavenue-encryption/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-ccavenue-encryption')
  	```


## Usage
```javascript
import CcavenueEncryption from 'react-native-ccavenue-encryption';

// TODO: What to do with the module?
CcavenueEncryption;
```
