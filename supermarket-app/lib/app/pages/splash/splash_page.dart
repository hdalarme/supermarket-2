import 'package:flutter/material.dart';
// ignore: unused_import
import 'package:supermarket/app/core/config/env/env.dart';
import 'package:supermarket/app/core/ui/helpers/size_extensions.dart';
import 'package:supermarket/app/core/ui/widgets/button.dart';


class SplashPage extends StatelessWidget {

  const SplashPage({ super.key });

   @override
   Widget build(BuildContext context) {
       return Scaffold(
           body: ColoredBox(
            color: const Color(0XFF140e0e),
            child: Stack(
              children: [
                Align(
                  alignment: Alignment.bottomCenter,
                  child: SizedBox(
                    width: context.screenWidth,
                    child: Image.asset(
                      'assets/images/lista.jpg',
                      fit: BoxFit.cover,
                      )
                    ),
                ),
                Center(
                  child: Column(
                    children: [
                      SizedBox(
                        height: context.percentHeight(.15),
                      ),
                      Image.asset('assets/images/logo.png'),
                      const SizedBox(
                        height: 80,
                      ),
                      Button(
                        width: context.percentWidth(.75),
                        height: 40,
                        label: 'Acessar', 
                        onPressed: (){
                          Navigator.of(context).popAndPushNamed('/home');
                        }
                      )
                    ],
                  ),
                )
              ],
            ),
            ),
       );
  }
}