import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    public Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = Stack.create(2);
    }

    @Test
    public void checkStack(){
        sizeShouldEqual(0);

        assertIsEmpty();
    }

    @Test
    public void whenOneIsPushed_SizeShouldEqualOne() {
        stack.push(0);

        sizeShouldEqual(1);
        assertNotEmpty();
    }

    @Test
    public void whenOneIsPushedAndOneIsPopped_SizeShouldEqualZero() {
        stack.push(0);
        stack.pop();

        sizeShouldEqual(0);
        assertIsEmpty();
    }

    @Test(expected = Stack.Underflow.class)
    public void shouldUnderflow_WhenPoppedPassedZero() {
        stack.pop();
    }

    @Test(expected = Stack.Overflow.class)
    public void shouldUnderflow_WhenPushedPassedCapacity() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test(expected = Stack.IllegalCapacity.class)
    public void shouldThrowIllegalCapacity_WhenCreateWithCapacityLessThanOne() {
        Stack.create(0);
    }

    @Test
    public void whenOneIsPushed_OneShouldBePopped() {
        stack.push(1);

        assertPopped(1);
    }

    @Test
    public void whenOneAndTwoArePushed_TwoAndOneShouldBePopped() {
         stack.push(1);
         stack.push(2);

        assertPopped(2);
        assertPopped(1);
    }

    @Test
    public void whenOneAndTwoArePushed_TwoShouldBeAtTheTop() {
         stack.push(1);
         stack.push(2);

        assertPeek(2);
    }

    private void assertPeek(int expected) {
        assertEquals(expected, stack.peek());
    }

    @Test
    public void whenThreeAndFourArePushed_FourShouldBeAtTheTop() {
        stack.push(3);
        stack.push(4);

        assertPeek(4);
    }

    @Test(expected = Stack.Empty.class)
    public void whenYouPeekAnEmptyStack_ShouldThrowEmpty() {
       stack.peek();
    }

    @Test
    public void whenOneAndTwoArePushed_ShouldFindTheOneAndTwo() {
         stack.push(1);
         stack.push(2);

        assertEquals(1, stack.search(1).intValue());
        assertEquals(0, stack.search(2).intValue());
    }

    @Test
    public void whenOneIsNotPresent_SearchShouldReturnNull() {
         assertNull(stack.search(1));
    }

    private void assertPopped(int expected) {
        assertEquals(expected, stack.pop());
    }

    private void assertNotEmpty() {
        assertFalse(stack.isEmpty());
    }

    private void assertIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    private void sizeShouldEqual(int expected) {
        assertEquals("size of stack", expected, stack.size());
    }
}
