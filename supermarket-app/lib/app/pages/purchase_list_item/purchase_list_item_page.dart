import 'package:flutter/material.dart';
import 'package:supermarket/app/core/ui/helpers/size_extensions.dart';
import 'package:supermarket/app/core/ui/style/text_styles.dart';
import 'package:supermarket/app/core/ui/widgets/appbar.dart';
import 'package:auto_size_text/auto_size_text.dart';

class PurchaseListItemPage extends StatelessWidget {
  const PurchaseListItemPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Appbar(),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            width: context.screenWidth,
            height: context.percentHeight(.3),
            decoration: const BoxDecoration(
                image: DecorationImage(
                    image: NetworkImage(
                        'https://thumbs.dreamstime.com/b/check-list-18910583.jpg'),
                    fit: BoxFit.cover)),
          ),
          const SizedBox(
            height: 10,
          ),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 10),
            child: Text(
              'Nome da Lista',
              style: context.textStyles.textExtraBold.copyWith(fontSize: 22),
            ),
          ),
          const SizedBox(
            height: 10,
          ),
          Expanded(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 10),
              child: SingleChildScrollView(
                child: Text(
                  'Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista Itens da Lista ',
                  style:
                      context.textStyles.textExtraBold.copyWith(fontSize: 16),
                ),
              ),
            ),
          ),
          const Divider(),
          Row(
            children: [
              SizedBox(
                width: context.percentWidth(.85),
                child: const Text('Base')
              ),
              Container(
                width: context.percentWidth(.15),
                //height: 68,
                padding: const EdgeInsets.all(8),
                child: ElevatedButton(
                  onPressed: () {}, 
                    child: Row(
                      //mainAxisAlignment: MainAxisAlignment.center,
                      //crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        Expanded(
                          child: AutoSizeText(
                            '+', 
                            maxFontSize: 20,
                            minFontSize: 5,
                            maxLines: 1,
                            style: context.textStyles.textExtraBold,
                          ),
                        ),
                      ],
                    ),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
