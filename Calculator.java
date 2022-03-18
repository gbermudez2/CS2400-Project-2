

public class Calculator<T>{
    public static void main(String args[]){
        System.out.println("Initializing new infix expression");
            StackInterface<String> stack1 = new LinkedStack<>();
    }

    public T convertToPostfix(String infix){
        StackInterface<String> stack1 = new LinkedStack<>();
        String postfix = null;

        for (int i = 0; i < infix.length(); i++){
            char nextCharacter = infix.charAt(i);
            
            switch (nextCharacter){
                case ' ':
                    break;
                case 'a': case 'b': case 'c': case 'd':
                    postfix += infix.charAt(i);
                    break;
                
            }
        }
    }
}
