package com.example.sampleapplication
//
//import java.util.Scanner
//
//
//fun sum(a:Int,b:Int):Int{
//   return a + b
//}
//
//fun addNumbers(x:Int,y:Int,myLambdaFun:(Int,Int)->Int){
//    var res=myLambdaFun(x,y)
//    println(res)
//}
//
//
//fun main(){
//    println("Hello World")
//    println("Hi By")
//
//    // 1. using var & val implicitly
//    var language="My name is shubham and my age is:" //mutable can be reassigned
//    val age=21 //immutable cannot be reassigned.
//    val name="Shubh"
//    println(language+age)
//
//    //2. using var for explicitly declaring
//    var mystr:String="My name is shubham " //mutable can be reassigned
//    println(mystr)
//
//    //3.using string interpolation
//    println("My name is $name and my age is:$age")
//
//    //raw string
//    val text1 ="""
//             Welcome
//                 To
//           JavaTpoint
//    """
//    println(text1)
//    var value1:Int = 10
//    val value2: Long = value1.toLong()
//    println(value2)
//
//    val marks = arrayOf(80,85,60,90,70)
//    //traditional
//    for(item in marks)
//        print(item )
//
//    var c:Int=sum(3,4);
//    println("sum is:"+c);
//
//    var myLambdaFun: (Int,Int)->Int={a,b->a+b}
//    addNumbers(5,6,myLambdaFun);
//
//    var namestr:String?= null
//    //? is null safety operator
//    println(namestr?.length)
//    //!! is non null assertion operator
//
//
//     var data :Any="ansari"
//    var dataStr=data as String //unsafe cast
//    println(dataStr)
//
//    var dataInt:Int? = data as? Int //safe casting
//    println(dataInt)
//
//
//    println("Enter age")
//
//    val read = Scanner(System.`in`)
//    var myvar=read.nextInt()
//    println("your age is $myvar")
//
//    /* exception
//     handling*/
//    try {
//        var result=10/0
//        println(result)
//    }
//    catch (e:Exception){
//        println(e)
//    }
//    finally{
//        println("inside finally block")
//    }
//
//    //we also use throw key word instead of try-catch
//
//
//
//
//
//
//}

//classes,objects and constructors
//primary constructor and secondary constructor
//PRIMARY
class MyClass(var age:Int) {

    init{
        this.age=age;
        println("my age is :${this.age}")
    }



    var name="ansari"
    fun m1(name:String){
        println("my name:$name and age is:${this.age}")
    }
}
//SECONDARY with Primary
class DemoClass(var age:Int ){
    constructor():this(22){
    println("constructor without paramas")
    }

    constructor(name:String,age:Int):this(22){
        println("my new name is $name and age is $age");
    }
}
//Nested class Demo
//class outerClass{
//    private var name: String = "Ashu"
//    class nestedClass{
//        var description: String = "code inside nested class"
//        private var id: Int = 101
//        fun foo(){
//            //  print("name is ${name}") // cannot access the outer class member
//            println("Id is ${id}")
//        }
//    }
//}

//Inner Class Demo
class outerClass{
    private  var name: String = "Ashu"
    inner class  innerClass{
        var description: String = "code inside inner class"
        private var id: Int = 101
        fun foo(){
            println("name is ${name}") // access the outer class member even private
            println("Id is ${id}")
        }
    }
}


fun main(){
//    var obj = MyClass(33)
//    print(obj.name)
//    obj.m1("hello");
//    var obj =DemoClass()
//    var obj1 =DemoClass("Ansari",33)

    //Nested class Demo
//    println(outerClass.nestedClass().description) // accessing property
//    var obj = outerClass.nestedClass() // object creation
//    obj.foo() // access member function

    //Inner Class Demo
    println(outerClass().innerClass().description) // accessing property
    var obj = outerClass().innerClass() // object creation
    obj.foo() // access member function



}