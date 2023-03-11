import 'package:flutter/material.dart';
import 'package:supermarket/app/core/ui/style/text_styles.dart';
import 'package:supermarket/app/core/ui/widgets/appbar.dart';
import 'package:supermarket/app/core/ui/widgets/button.dart';

class LoginPage extends StatelessWidget {

  const LoginPage({ super.key });

   @override
   Widget build(BuildContext context) {
       return Scaffold(
           appBar: Appbar(),
           body: CustomScrollView(
            slivers: [
              SliverToBoxAdapter(
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Form(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text('Login', style: context.textStyles.textTitle,),
                        const SizedBox(
                           height: 30,
                        ),
                        TextFormField(
                          decoration: const InputDecoration(labelText: 'E-mail'),
                        ),
                        const SizedBox(
                           height: 30,
                        ),
                        TextFormField(
                          decoration: const InputDecoration(labelText: 'Senha'),
                        ),
                        const SizedBox(
                           height: 50,
                        ),
                        Center(child: Button(
                          label: 'Entar',
                          width: double.infinity, 
                          onPressed: () {  },
                        ),),
                      ],
                    )
                  ),
                ),
              ),
              SliverFillRemaining(
                hasScrollBody: false,
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Align(
                    alignment: Alignment.bottomCenter,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Text(
                          'Não possui uma conta', 
                          style: context.textStyles.textBold
                        ),
                        TextButton(
                          onPressed: () {
                            Navigator.of(context).pushNamed('/auth/register');
                          }, 
                          child: Text(
                            'Cadastre-se',
                            style: context.textStyles.textBold.copyWith(color: Colors.blue),
                          )
                        )
                      ],
                    ),
                  ),
                ),
              )
            ],
           ),
       );
  }
}