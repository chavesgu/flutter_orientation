
import 'dart:io';

import 'package:flutter/services.dart';

class FlutterOrientation {
  static const MethodChannel _channel =
      const MethodChannel('chavesgu/orientation');

  static Future<void> setOrientation(DeviceOrientation orientation) async {
    try {
      if (Platform.isIOS) {
        await SystemChrome.setPreferredOrientations([orientation]);
      }
      await _channel.invokeMethod('setOrientation', orientation.toString());
    } catch (e) {
      //
    }
  }
}
