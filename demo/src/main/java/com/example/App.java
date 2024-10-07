package com.example;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person mihai=new Person(21, null);
        System.out.println(mihai.doubleAge());
    }
}
class Person{
    int age;
    String name;
    Person(int age, String name){
        this.age=age;
        this.name=name;
    }
    int doubleAge(){
        return 2*age;
    }
}