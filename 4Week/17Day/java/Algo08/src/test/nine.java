package test;

import java.util.Scanner;

public class nine {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        Foo foo = new Foo();
        foo.print(a);
    }
}

class Foo{
    void print(){
        System.out.print("A");
}
    void print(Object object){
        System.out.print("B");
}
    void print(String s){
        System.out.print(s);
    }
}