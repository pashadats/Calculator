package ruspbstu.ict.lesson2.calculator.operations;


import ruspbstu.ict.lesson2.calculator.Operation;
import ruspbstu.ict.lesson2.collection.Stack;
import ruspbstu.ict.lesson2.myexceptions.StackException;

public class DivOperation implements Operation {

    @Override
    public double apply(Stack stack) throws StackException {
        return 1d/stack.pop() * stack.pop();
    }

    @Override
    public String getName() {
        return "/";
    }


}
