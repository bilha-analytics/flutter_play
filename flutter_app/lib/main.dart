import 'package:flutter/material.dart';
import 'package:flutter_app/app_screens/first_screen.dart';

import 'app_screens/grid_screen.dart';

void main() =>
  runApp(
    new MyFlutterApp()
  );


class MyFlutterApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new MaterialApp(
      debugShowCheckedModeBanner: false,
        title: "some App",
        home: Home()
    );
  }
}

class Defaulted extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
        appBar: AppBar(title: Text("Titilating 67"),),
        body: FirstScreen()
    );
  }

}