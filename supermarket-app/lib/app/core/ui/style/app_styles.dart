import 'package:flutter/material.dart';
import 'package:supermarket/app/core/ui/style/colors_app.dart';
import 'package:supermarket/app/core/ui/style/text_styles.dart';

class AppStyles {
  static AppStyles? _instance;
  // Avoid self isntance
  AppStyles._();
  static AppStyles get i{
    _instance ??=  AppStyles._();
    return _instance!;
   }

  ButtonStyle get primaryButton => ElevatedButton.styleFrom(
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.circular(7)
    ),
    backgroundColor: ColorsApp.i.primary,
    textStyle: TextStyles.i.textButtonLabel
  );

}


extension AppStylesExtensions on BuildContext {
  AppStyles get appStyles => AppStyles.i;
}