import java.util.EmptyStackException;

/*
CS 2400
Project 2

Jose Gutierrez, Drew Higashigawa, Gabriel Bermudez
*/

public class LinkedStack<T> implements StackInterface<T>{

    // references the first node
    private Node topNode;

    public LinkedStack(){
        topNode = null;
    }

    public void push(T newEntry){
        // Makes the top node the node just created
        topNode = new Node(newEntry, topNode);
    }

    public T pop(){
        T top = peek();
        topNode = topNode.getNextNode();
        return top;
    }

    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return (T) topNode.getData();
    }

    public boolean isEmpty()
    {
        return topNode == null;
    }
    
    public void clear()
    {
        topNode = null;
    }

    private class Node<T>{
        // Get the data of the chosen node
        private T data;

        // Get the next linked node
        private Node next;

        private Node(T dataPortion){
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }

        private T getData(){
            return data;
        }

        private void setData(T newData){
            data = newData;
        }

        private Node getNextNode(){
            return next;
        }

        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }
}
