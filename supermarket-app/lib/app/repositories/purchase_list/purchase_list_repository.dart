import 'package:supermarket/app/models/purchase_list_model.dart';

abstract class PurchaseListRepository {
  Future<List<PurchaseListModel>> findAll();
}