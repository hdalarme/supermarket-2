import 'package:flutter/material.dart';
import 'package:supermarket/app/core/ui/base_state/base_state.dart';
import 'package:supermarket/app/core/ui/style/colors_app.dart';
import 'package:supermarket/app/pages/purchase_list/purchase_list_controller.dart';
import 'package:supermarket/app/pages/purchase_list/purchase_list_state.dart';
import 'package:supermarket/app/pages/purchase_list/widgets/purchasee_list_tile.dart';
// ignore: depend_on_referenced_packages
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:shared_preferences/shared_preferences.dart';


import '../../core/ui/widgets/appbar.dart';

class PurchaseListPage extends StatefulWidget {
  const PurchaseListPage({super.key});

  @override
  State<PurchaseListPage> createState() => _PurchaseListPageState();
}

class _PurchaseListPageState extends BaseState<PurchaseListPage, PurchaseListController> {
  
  @override
  void onReady() {
    controller.loadPurchaseLists();
  } 

  Future<void> _goOrder(BuildContext context) async {
    final navigator = Navigator.of(context);
    final sp = await SharedPreferences.getInstance();
    if(!sp.containsKey('accessToken')){
      // envia para login
      final loginResult = await navigator.pushNamed('/auth/login');
    }

    //continue
    showSuccess('Sucesso ao criar conteudo');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Appbar(),
      floatingActionButton: FloatingActionButton(
        /*onPressed: () async {
          showLoader();
          await Future.delayed(const Duration(seconds: 2));
          hideLoader();
          showError('Erro ao criar conteudo');
          await Future.delayed(const Duration(seconds: 2));
          showInfo('Info ao criar conteudo');
          await Future.delayed(const Duration(seconds: 2));
          showSuccess('Sucesso ao criar conteudo');
        },*/
        onPressed: () {
          _goOrder(context);
        },
        backgroundColor: context.colors.primary,
        child: const Icon(Icons.play_circle_outline_sharp),
      ),
      body: BlocConsumer<PurchaseListController, PurchaseListState>(
        listener: (context, state) {
          state.status.matchAny(
            any: () => hideLoader(),
            loading: () => showLoader(),
            error: () {
              hideLoader();
              showError(state.errorMessage ?? 'Erro não informado');
            },
          );
        },
        buildWhen: (previous, current) => current.status.matchAny(
          any: () => false,
          initial: () => true,
          loaded: () => true,
        ),
        builder: (context, state) {
          return Column(
            children: [
              Expanded(
                child: ListView.builder(
                  itemCount: state.purchase_list.length,
                  itemBuilder: (context, index) {
                    final purchaseList = state.purchase_list[index];
                    return PurchaseeListTile(
                      purcheseList: purchaseList
                    );
                  },
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}
