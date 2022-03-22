package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void peekAtEmptyStack(){
        StackInterface<Character> testStack = new LinkedStack<>();
        assertThrows(EmptyStackException.class, 
        () -> {
            testStack.peek();
        });
    }

    @Test
    public void popAnEmptyStack(){
        StackInterface<Character> testStack = new LinkedStack<>();
        assertThrows(EmptyStackException.class, 
        () -> {
            testStack.pop();
        });
    }

    @Test
    public void emptyInput(){
        StackInterface<Character> testStack = new LinkedStack<>();
        testStack.push(null);
    }
}