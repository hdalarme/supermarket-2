
// ignore: file_names
import 'dart:convert' show json;
import 'dart:convert';


// ignore_for_file: public_member_api_docs, sort_constructors_first

class PurchaseListModel {
  final int id;
  final String name;
  final int user;
  PurchaseListModel({
    required this.id,
    required this.name,
    required this.user,
  });

  PurchaseListModel copyWith({
    int? id,
    String? name,
    int? user,
  }) {
    return PurchaseListModel(
      id: id ?? this.id,
      name: name ?? this.name,
      user: user ?? this.user,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'id': id,
      'name': name,
      'user': user,
    };
  }

  factory PurchaseListModel.fromMap(Map<String, dynamic> map) {
    return PurchaseListModel(
      id: map['id'] as int,
      name: map['name'] as String,
      user: map['user'] as int,
    );
  }

  String toJson() => json.encode(toMap());

  factory PurchaseListModel.fromJson(String source) => PurchaseListModel.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() => 'PurchaseListModel(id: $id, name: $name, user: $user)';

  @override
  bool operator ==(covariant PurchaseListModel other) {
    if (identical(this, other)) return true;
  
    return 
      other.id == id &&
      other.name == name &&
      other.user == user;
  }

  @override
  int get hashCode => id.hashCode ^ name.hashCode ^ user.hashCode;
}
