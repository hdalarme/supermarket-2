import 'package:flutter/material.dart';

// ignore: depend_on_referenced_packages
import 'package:provider/provider.dart';
import 'package:supermarket/app/core/rest_client/custom_dio.dart';

class ApplicationBinding extends StatelessWidget {

  final Widget child;

  const ApplicationBinding({ super.key, required this.child });

   @override
   Widget build(BuildContext context) {
       return MultiProvider(
        providers: [
          Provider(create: (context) => CustomDio()),
        ],
        child: child,
       );
  }
}