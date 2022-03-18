/*
CS 2400
Project 2

Jose Gutierrez, Drew Higashigawa, Gabriel Bermudez
*/

public interface StackInterface<T>{
    // Add a new entry to the top of the stack
    public void push(T newEntry);

    // Removes the top entry of the stack and returns the new top entry
    public T pop();

    // Returns the stack's top entry
    public T peek();

    // Checks if the stack is empty
    public boolean isEmpty();

    // Clears the stack of all entries
    public void clear();
}