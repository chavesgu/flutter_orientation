import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_orientation/flutter_orientation.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: ElevatedButton(
            child: Text('rotate'),
            onPressed: () {
              if (MediaQuery.of(context).orientation == Orientation.portrait) {
                FlutterOrientation.setOrientation(DeviceOrientation.landscapeRight);
              } else {
                FlutterOrientation.setOrientation(DeviceOrientation.portraitUp);
              }
            },
          ),
        ),
      ),
    );
  }
}
