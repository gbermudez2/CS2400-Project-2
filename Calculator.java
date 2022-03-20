

public class Calculator<T> extends LinkedStack {
    public static void main(String args[]){
        System.out.println("Initializing new infix expression");
            StackInterface<String> stack1 = new LinkedStack<>();
    }

    public int Precedence(char ch){
        switch (ch){
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String convertToPostfix(String infix){
        StackInterface<Character> operatorStack = new LinkedStack<>();
        String postfix = null;

        for (int i = 0; i < infix.length(); i++){
            char nextCharacter = infix.charAt(i);
            
            if (Character.isLetterOrDigit(nextCharacter)){
                postfix += nextCharacter;
            }

            switch (nextCharacter){
                case ' ':
                    break;
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+': case '-': case '*': case '/':
                    while ((!operatorStack.isEmpty()) && (Precedence(nextCharacter) <= Precedence(operatorStack.peek()))){
                        postfix += operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    Character topOperator = operatorStack.pop();

                    while (topOperator != '('){
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;
                default: break; // ignore nonstandard characters
            }
        }
        while (!operatorStack.isEmpty()){
            Character topOperator = operatorStack.pop();
            postfix += topOperator;
        }
        return postfix;
    }
}
