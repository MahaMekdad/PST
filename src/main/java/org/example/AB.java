package org.example;

public class AB {

    String a;
    int b;

    public AB() {}

    public AB(String a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "AB{{" + "a='" + a + '\'' + ", b=" + b + '}';
    }
}
