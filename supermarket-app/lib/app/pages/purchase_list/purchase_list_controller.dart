import 'dart:developer';
import 'package:bloc/bloc.dart';
import 'package:supermarket/app/pages/purchase_list/purchase_list_state.dart';
import 'package:supermarket/app/repositories/purchase_list/purchase_list_repository.dart';

class PurchaseListController extends Cubit<PurchaseListState> {
  final PurchaseListRepository _repository;

  PurchaseListController(
    this._repository,
  ) : super(const PurchaseListState.initial());

  Future<void> loadPurchaseLists() async {
    emit(state.copyWith(status: PurcheseListStateStatus.loading));
      try {
        final purchaseLists = await _repository.findAll();
        emit(state.copyWith(status: PurcheseListStateStatus.loaded, purchase_list: purchaseLists));
      } catch (e, s) {
        log('Erro ao buscar listas', error: e, stackTrace: s);
        emit(
          state.copyWith(
            status: PurcheseListStateStatus.error, 
            errorMessage: 'Erro ao buscar as listas',
          )
        );
      }
  }
}
