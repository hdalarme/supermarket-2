import 'package:flutter/material.dart';
import 'package:supermarket/app/supermarket_app.dart';

import 'app/core/config/env/env.dart';

Future<void> main() async {
  await Env.i.load();
  runApp(const SupermarketApp());
}
