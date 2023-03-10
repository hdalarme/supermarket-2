// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'purchase_list_state.dart';

// **************************************************************************
// MatchExtensionGenerator
// **************************************************************************

extension PurcheseListStateStatusMatch on PurcheseListStateStatus {
  T match<T>(
      {required T Function() initial,
      required T Function() loading,
      required T Function() loaded,
      required T Function() error}) {
    final v = this;
    if (v == PurcheseListStateStatus.initial) {
      return initial();
    }

    if (v == PurcheseListStateStatus.loading) {
      return loading();
    }

    if (v == PurcheseListStateStatus.loaded) {
      return loaded();
    }

    if (v == PurcheseListStateStatus.error) {
      return error();
    }

    throw Exception(
        'PurcheseListStateStatus.match failed, found no match for: $this');
  }

  T matchAny<T>(
      {required T Function() any,
      T Function()? initial,
      T Function()? loading,
      T Function()? loaded,
      T Function()? error}) {
    final v = this;
    if (v == PurcheseListStateStatus.initial && initial != null) {
      return initial();
    }

    if (v == PurcheseListStateStatus.loading && loading != null) {
      return loading();
    }

    if (v == PurcheseListStateStatus.loaded && loaded != null) {
      return loaded();
    }

    if (v == PurcheseListStateStatus.error && error != null) {
      return error();
    }

    return any();
  }
}
