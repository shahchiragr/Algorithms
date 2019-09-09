package org.cshah.algorithms.polymorphism;

public class C  extends  B{
    public void print() {
        System.out.println("C");
    }


    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        ((B)c).print();
        ((A)c).print();
        ((A)b).print();

    }
}
