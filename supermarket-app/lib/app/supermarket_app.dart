import 'package:flutter/material.dart';

import 'package:supermarket/app/core/provider/application_binding.dart';
import 'package:supermarket/app/core/ui/theme/theme_config.dart';
import 'package:supermarket/app/pages/auth/login/login_router.dart';
import 'package:supermarket/app/pages/auth/register/register_router.dart';
import 'package:supermarket/app/pages/purchase_list/purchase_list_router.dart';
import 'package:supermarket/app/pages/purchase_list_item/purchase_list_item_router.dart';
import 'package:supermarket/app/pages/splash/splash_page.dart';

class SupermarketApp extends StatelessWidget {
  const SupermarketApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ApplicationBinding(
      child: MaterialApp(
        title: 'Supermarket',
        theme: ThemeConfig.theme,
        routes: {
          '/': (context) => const SplashPage(),
          '/home': (context) => PurchaseListRouter.page,
          '/listItem': (context) => PurchaseListItemRouter.page,
          '/auth/login': (context) => LoginRouter.page,
          '/auth/register': (context) => RegisterRouter.page,
        },
      ),
    );
  }
}
