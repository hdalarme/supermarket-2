import 'package:flutter/material.dart';
import 'package:supermarket/app/core/config/env/env.dart';
import 'package:supermarket/app/core/ui/widgets/button.dart';


class SplashPage extends StatelessWidget {

  const SplashPage({ super.key });

   @override
   Widget build(BuildContext context) {
       return Scaffold(
           appBar: AppBar(title: const Text('Splash'),),
           body: Column(
             children: [
               Container(),
               //ElevatedButton(onPressed: (){}, child: Text('Teste 001')),
               Button(
                width: 200,
                height: 200,
                label: Env.i['backend_base_url'] ?? '',//'Test Label 001',
                onPressed: (){},
               ),
               TextFormField(
                decoration: const InputDecoration(labelText: 'Text 001'),
               )
             ],
           ),
       );
  }
}