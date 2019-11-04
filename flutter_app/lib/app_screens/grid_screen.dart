import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Center(
      child: Container(
        alignment: Alignment.center,
        color:  Colors.deepPurple,
//        width: 200.0,
//        height: 100.0,
      margin: EdgeInsets.all(50.0),
        padding: EdgeInsets.only(left: 15.0, top: 30.0),
        child: Text(
          "Flight",
          textDirection: TextDirection.ltr,
          style: TextStyle(
              decoration: TextDecoration.none,
              fontSize: 55.0,
              fontStyle: FontStyle.italic

          ),
        ),
      ),
    );
  }
}
