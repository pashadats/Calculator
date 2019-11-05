package ruspbstu.ict.lesson2.test;

import org.junit.jupiter.api.Test;
import ruspbstu.ict.lesson2.collection.Stack;
import ruspbstu.ict.lesson2.myexceptions.StackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private final double epsilon = 0.0000001d;

    @Test
    void shouldAdd() throws StackException {
        Stack stack = new Stack();
        assertTrue(stack.empty());
        stack.add(42d);
        assertFalse(stack.empty());
        assertEquals(42d, stack.pop(), epsilon);
    }

    @Test
    void shouldBeFILO() throws StackException {
        Stack stack = new Stack();
        stack.add(42d);
        stack.add(13d);
        assertEquals(13d, stack.pop(), epsilon);
        assertEquals(42d, stack.pop(), epsilon);
        assertTrue(stack.empty());
    }


}