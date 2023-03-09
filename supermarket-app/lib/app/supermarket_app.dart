import 'package:flutter/material.dart';
import 'package:supermarket/app/core/ui/theme/theme_config.dart';
import 'package:supermarket/app/pages/splash/splash_page.dart';

class SupermarketApp extends StatelessWidget {

  const SupermarketApp({ super.key });

   @override
   Widget build(BuildContext context) {
       return MaterialApp(
        title: 'Supermarket',
        theme: ThemeConfig.theme,
        routes: {
          '/':(context) => const SplashPage(),
        },
       );
  }
}