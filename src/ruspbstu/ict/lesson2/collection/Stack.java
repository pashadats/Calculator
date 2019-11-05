package ruspbstu.ict.lesson2.collection;

import ruspbstu.ict.lesson2.myexceptions.StackException;

import java.util.Iterator;

public class Stack implements Iterable<Double> {

    double[] stack;
    int size;

    public Stack() {
        this.stack = new double[10];
    }

    public Stack(int size) {
        if (size <= 0) {
            size = 10;
        }
        this.stack = new double[size];
    }

    public void add(double x) {
        if (size == stack.length) {
            double[] newStack = new double[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[size] = x;
        size++;
    }

    public double pop() throws StackException {
        if (stack.length == 0) throw new StackException("Невозможно удалить элемент из пустого стека");
        double temp = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return temp;
    }

    public double peek() {
        return stack[size - 1];
    }

    public boolean empty() {
        return (size == 0);
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(stack[i]);
        }
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<Double> iterator() {
        return new StackIterator(this);
    }
}
