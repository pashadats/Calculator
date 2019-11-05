package ruspbstu.ict.lesson2.calculator;

import ruspbstu.ict.lesson2.collection.Stack;
import ruspbstu.ict.lesson2.myexceptions.StackException;

public interface Operation {
    double apply(Stack stack) throws StackException;
    String getName();
}
