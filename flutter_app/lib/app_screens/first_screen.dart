import 'dart:math';

import 'package:flutter/material.dart';

class FirstScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Material(
      color: Colors.amberAccent,
      child:  Center(
          child: Text(
            generateLuckyNumber(),
            textDirection: TextDirection.ltr,
            style: TextStyle(color: Colors.blue, fontSize: 40.0),
          )
      ) ,
    );
  }



  String generateLuckyNumber(){
    var randz = Random();
    int lucky = randz.nextInt(10);
    return "Your lucky number is $lucky";
  }

}