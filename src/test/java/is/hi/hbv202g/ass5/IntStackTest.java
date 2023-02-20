package is.hi.hbv202g.ass5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntStackTest {

    private IntStack intStack;

    @Before
    public void constructStackTestObjects() {
        intStack = new IntStack();
    }

    @Test
    public void testNewStackIsNotFull() {
        assertFalse(intStack.isFull());
    }

    @Test
    public void testFullStackIsFull() {
        int capacity = intStack.getCapacity();

        for (int i = 0; i < capacity; i++) {
            intStack.push(i);
        }
        assertTrue(intStack.isFull());
    }

    @Test
    public void testEmptyStackIsFull() {
        assertFalse(intStack.isFull());
    }

    @Test
    public void testOneBelowCapacityStackIsFull() {
        int capacity = intStack.getCapacity();

        for (int i = 0; i < capacity - 1; i++) {
            intStack.push(i);
        }
        assertFalse(intStack.isFull());
    }

    @Test
    public void  testPopReturnsPushedValue() {
        int i10 = 10;
        intStack.push(i10);

        assertEquals(i10, intStack.pop());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPopOnEmptyStackReturnsException() {
        intStack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPushOnFullStackReturnsException() {
        int capacity = intStack.getCapacity();

        for (int i = 0; i < capacity; i++) {
            intStack.push(i);
        }

        int a = 1;
        intStack.push(a);
    }

    @Test
    public void testEmptyStackIsEmpty() {
        assertTrue(intStack.isEmpty());
    }

    @Test
    public void testNotEmptyStackIsEmpty() {
        int a = 1;
        intStack.push(a);

        assertFalse(intStack.isEmpty());
    }
}
