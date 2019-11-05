package ruspbstu.ict.lesson2;

import ruspbstu.ict.lesson2.calculator.Calculator;
import ruspbstu.ict.lesson2.myexceptions.StackException;

// TODO LOGGING
public class Main {

    public static void main(String[] args) throws Exception {

        try {
            String str = "((4*(a^2))+((B-6)/2))";
            Calculator calc = new Calculator();
            calc.define("a", 6d);
            calc.define("B", 8.9023d);
            calc.exp(str);
            calc.print();
        } catch (StackException e) {
            e.printStackTrace();
        }
    }
}
