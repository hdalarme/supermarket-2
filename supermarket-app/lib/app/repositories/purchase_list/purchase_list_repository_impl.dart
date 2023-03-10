import 'dart:developer';
// ignore: depend_on_referenced_packages
import 'package:dio/dio.dart';
import 'package:supermarket/app/core/rest_client/custom_dio.dart';
import 'package:supermarket/app/models/purchase_list_model.dart';

import '../../core/exceptions/repository_exception.dart';
import './purchase_list_repository.dart';

class PurchaseListRepositoryImpl implements PurchaseListRepository {

  final CustomDio dio;
  PurchaseListRepositoryImpl({
    required this.dio,
  });

  @override
  Future<List<PurchaseListModel>> findAll() async {
    try {
  final result = await dio.unauth().get('/lists');
  return result.data
    .map<PurchaseListModel>(
      (l) => PurchaseListModel.fromMap(l)
    )
    .toList();
} on DioError catch (e, s) {
    log('Erro ao buscar listas', error: e, stackTrace: s);
    throw RepositoryException(message: 'Erro ao buscar listas');
}
    //throw UnimplementedError();
  }

}
