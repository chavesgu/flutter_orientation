#import "FlutterOrientationPlugin.h"
//#import <CoreMotion/CoreMotion.h>

@implementation FlutterOrientationPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"chavesgu/orientation"
            binaryMessenger:[registrar messenger]];
  FlutterOrientationPlugin* instance = [[FlutterOrientationPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"setOrientation" isEqualToString:call.method]) {
    id orientation = call.arguments;
    if ([orientation isEqualToString:@"DeviceOrientation.portraitUp"]) {
        [[UIDevice currentDevice] setValue:@(UIInterfaceOrientationPortrait) forKey:@"orientation"];
    } else if ([orientation isEqualToString:@"DeviceOrientation.portraitDown"]) {
        [[UIDevice currentDevice] setValue:@(UIInterfaceOrientationPortraitUpsideDown) forKey:@"orientation"];
    } else if ([orientation isEqualToString:@"DeviceOrientation.landscapeLeft"]) {
        [[UIDevice currentDevice] setValue:@(UIInterfaceOrientationLandscapeLeft) forKey:@"orientation"];
    } else if ([orientation isEqualToString:@"DeviceOrientation.landscapeRight"]) {
        [[UIDevice currentDevice] setValue:@(UIInterfaceOrientationLandscapeRight) forKey:@"orientation"];
    } else {
        [[UIDevice currentDevice] setValue:@(UIInterfaceOrientationUnknown) forKey:@"orientation"];
    }
  } else {
    result(FlutterMethodNotImplemented);
  }
}

@end
