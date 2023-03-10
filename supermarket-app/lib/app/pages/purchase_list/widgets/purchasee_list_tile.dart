import 'package:flutter/material.dart';
import 'package:supermarket/app/core/ui/style/colors_app.dart';
import 'package:supermarket/app/core/ui/style/text_styles.dart';
import 'package:supermarket/app/models/purchase_list_model.dart';

class PurchaseeListTile extends StatelessWidget {

  final PurchaseListModel purcheseList;

  const PurchaseeListTile({ super.key, required this.purcheseList });

   @override
   Widget build(BuildContext context) {
       return Padding(
         padding: const EdgeInsets.all(8.0),
         child: Row(
          children: [
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(bottom: 8.0),
                    child: Text(
                      purcheseList.name,
                      style: context.textStyles.textExtraBold.copyWith(fontSize: 16),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.only(bottom: 8.0),
                    child: Text(
                      purcheseList.userId as String,
                      style: context.textStyles.textMedium.copyWith(
                        fontSize: 12,
                        color: context.colors.secondary
                        ),
                    ),
                  ),
                ],
              ),
            ),
            FadeInImage.assetNetwork(
              placeholder: 'assets/images/loading2.gif', 
              image: 'https://thumbs.dreamstime.com/b/check-list-18910583.jpg',
              width: 50,
              height: 50,
              fit: BoxFit.contain,
            ),
          ],
         ),
       );
  }
}