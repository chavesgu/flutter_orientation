package com.chavesgu.flutter_orientation;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;

/** FlutterOrientationPlugin */
public class FlutterOrientationPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "chavesgu/orientation");
    channel.setMethodCallHandler(this);
  }
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "chavesgu/orientation");
    channel.setMethodCallHandler(new FlutterOrientationPlugin());
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    activity = binding.getActivity();
  }
  @Override
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
    activity = binding.getActivity();
  }
  @Override
  public void onDetachedFromActivity() {
  }
  @Override
  public void onDetachedFromActivityForConfigChanges() {
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("setOrientation")) {
      if (activity==null) {
        Log.i("Orientation", "activity is null");
      }
      Object arguments = call.arguments;
      String orientation = (String) arguments;
      if (orientation.equals("DeviceOrientation.portraitUp")) {
//        Log.i("Orientation", "portraitUp");
        activity.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
      } else if (orientation.equals("DeviceOrientation.portraitDown")) {
//        Log.i("Orientation", "portraitDown");
        activity.setRequestedOrientation(SCREEN_ORIENTATION_REVERSE_PORTRAIT);
      } else if (orientation.equals("DeviceOrientation.landscapeLeft")) {
//        Log.i("Orientation", "landscapeLeft");
        activity.setRequestedOrientation(SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
      } else if (orientation.equals("DeviceOrientation.landscapeRight")) {
//        Log.i("Orientation", "landscapeRight");
        activity.setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
      } else {
//        Log.i("Orientation", "other");
        activity.setRequestedOrientation(SCREEN_ORIENTATION_UNSPECIFIED);
      }
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
