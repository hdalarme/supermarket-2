

import 'package:flutter/material.dart';
// ignore: depend_on_referenced_packages
import 'package:provider/provider.dart';
import 'package:supermarket/app/pages/purchase_list/purchase_list_controller.dart';
import 'package:supermarket/app/pages/purchase_list/purchase_list_page.dart';
import 'package:supermarket/app/repositories/purchase_list/purchase_list_repository.dart';
import 'package:supermarket/app/repositories/purchase_list/purchase_list_repository_impl.dart';

class PurchaseListRouter {
  PurchaseListRouter._();

  static Widget get page => MultiProvider(
    providers: [
      Provider<PurchaseListRepository>(
        create: (context) => PurchaseListRepositoryImpl(
          dio: context.read(),
        ),
      ),
      Provider(
        create: (context) => PurchaseListController(
          context.read(),
        ),
      )
    ],
    child: const PurchaseListPage(),
  );
}