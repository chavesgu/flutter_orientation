
import 'package:flutter/services.dart';

class FlutterOrientation {
  static const MethodChannel _channel =
      const MethodChannel('chavesgu/orientation');

  static void setOrientation(DeviceOrientation orientation) {
    _channel.invokeMethod('setOrientation', orientation.toString());
  }
}
