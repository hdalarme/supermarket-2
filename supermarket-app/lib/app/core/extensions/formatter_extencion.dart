// ignore: depend_on_referenced_packages
import 'package:intl/intl.dart';

extension FormatterExtencion on double {
  String get currencyPTBR {
    final currencyFormat = 
      NumberFormat.currency(locale: 'pt_BR', symbol: r'R$');
    return currencyFormat.format(this);
  }
}