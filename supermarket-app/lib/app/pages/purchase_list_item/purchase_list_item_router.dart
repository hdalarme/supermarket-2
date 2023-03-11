
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:supermarket/app/pages/purchase_list_item/purchase_list_item_page.dart';

class PurchaseListItemRouter {
  PurchaseListItemRouter._();

  static Widget get page => MultiProvider(
    providers: [
      Provider(create: (context) => Object(),)
    ],
    child: const PurchaseListItemPage(),
  );
}