
// ignore: file_names
import 'dart:convert' show json;
import 'dart:convert';

import 'package:supermarket/app/models/user_model.dart';

// ignore_for_file: public_member_api_docs, sort_constructors_first

class PurchaseListModel {
  final int id;
  final String name;
  final UserModel userId;
  PurchaseListModel({
    required this.id,
    required this.name,
    required this.userId,
  });

  PurchaseListModel copyWith({
    int? id,
    String? name,
    UserModel? userId,
  }) {
    return PurchaseListModel(
      id: id ?? this.id,
      name: name ?? this.name,
      userId: userId ?? this.userId,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'id': id,
      'name': name,
      'userId': userId.toMap(),
    };
  }

  factory PurchaseListModel.fromMap(Map<String, dynamic> map) {
    return PurchaseListModel(
      id: map['id'] as int,
      name: map['name'] as String,
      userId: UserModel.fromMap(map['userId'] as Map<String,dynamic>),
    );
  }

  String toJson() => json.encode(toMap());

  factory PurchaseListModel.fromJson(String source) => PurchaseListModel.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() => 'PurchaseListModel(id: $id, name: $name, userId: $userId)';

  @override
  bool operator ==(covariant PurchaseListModel other) {
    if (identical(this, other)) return true;
  
    return 
      other.id == id &&
      other.name == name &&
      other.userId == userId;
  }

  @override
  int get hashCode => id.hashCode ^ name.hashCode ^ userId.hashCode;
}
