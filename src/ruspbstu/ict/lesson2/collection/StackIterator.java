package ruspbstu.ict.lesson2.collection;

import java.util.Iterator;

class StackIterator implements Iterator<Double> {
    private final Stack stack;
    private int index;

    StackIterator(Stack stack) {
        this.stack = stack;
    }

    @Override
    public boolean hasNext() {
        return index < stack.size;
    }

    @Override
    public Double next() {
        return stack.stack[index++];
    }
}
