# flutter_orientation

A flutter plugin for rotate device orientation.

## Getting Started

ios

you need add supported orientations you will use in future

```
<key>UISupportedInterfaceOrientations</key>
<array>
    <string>UIInterfaceOrientationPortrait</string>
    <string>UIInterfaceOrientationLandscapeRight</string>
</array>
```

## Usage
```yaml
flutter_orientation: ^newest
```

```dart
import 'package:flutter_orientation/flutter_orientation.dart';


FlutterOrientation.setOrientation(DeviceOrientation.portraitUp);
```
