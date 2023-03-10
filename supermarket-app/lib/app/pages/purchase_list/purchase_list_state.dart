// ignore_for_file: public_member_api_docs, sort_constructors_first
// ignore: depend_on_referenced_packages
import 'package:equatable/equatable.dart';
import 'package:match/match.dart';

import 'package:supermarket/app/models/purchase_list_model.dart';

part 'purchase_list_state.g.dart';

@match
enum PurcheseListStateStatus {
  initial,
  loading,
  loaded,
  error,
}

class PurchaseListState extends Equatable {
  final PurcheseListStateStatus status;
  // ignore: non_constant_identifier_names
  final List<PurchaseListModel> purchase_list;
  final String? errorMessage;
  
  const PurchaseListState({
    required this.status,
    // ignore: non_constant_identifier_names
    required this.purchase_list,
    this.errorMessage,
  });

  const PurchaseListState.initial() 
    : status = PurcheseListStateStatus.initial, 
    purchase_list = const [],
    errorMessage = null;

  @override
  List<Object?> get props => [status, purchase_list, errorMessage];
  

  PurchaseListState copyWith({
    PurcheseListStateStatus? status,
    // ignore: non_constant_identifier_names
    List<PurchaseListModel>? purchase_list,
    String? errorMessage,
  }) {
    return PurchaseListState(
      status: status ?? this.status,
      purchase_list: purchase_list ?? this.purchase_list,
      errorMessage: errorMessage ?? this.errorMessage,
    );
  }
}
