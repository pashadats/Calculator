package ruspbstu.ict.lesson2.calculator.operations;

import ruspbstu.ict.lesson2.calculator.Operation;
import ruspbstu.ict.lesson2.collection.Stack;
import ruspbstu.ict.lesson2.myexceptions.StackException;

public class PowerOperation implements Operation {
    @Override
    public double apply(Stack stack) throws StackException {
        return Math.pow(stack.pop(), stack.pop());
    }

    @Override
    public String getName() {
        return "^";
    }
}
