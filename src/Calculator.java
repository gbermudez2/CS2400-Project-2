package src;



public class Calculator<T> {
    public static void main(String args[]){
        System.out.println("Initializing new infix expression");
        convertToPostfix("a*b/(c-a)+d*e");
        System.out.println("Evaluating postfix expression");
        evaluatePostfix("23*42-/56*+");
    }

    public static int Precedence(char ch){
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

    public static String convertToPostfix(String infix){
        StackInterface<Character> operatorStack = new LinkedStack<>();
        String postfix = "";

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

        System.out.println(postfix);
        return postfix;
    }

    public static int evaluatePostfix(String prePostfix){
        StackInterface<Integer> valueStack = new ResizeableArrayStack<>();
        char[] postfix = new char[prePostfix.length()];

        for (int j = 0; j < prePostfix.length(); j++){
            postfix[j] = prePostfix.charAt(j);
        }

        for (int i = 0; i < postfix.length; i++){
            char nextCharacter = postfix[i];

            if (Character.isDigit(nextCharacter)){
                valueStack.push((int)nextCharacter - '0');
            }
            else {
                int operandTwo = valueStack.pop();
                int operandOne = valueStack.pop();

                switch(nextCharacter){
                    case ' ':
                    break;

                    case '+':
                    valueStack.push(operandTwo + operandOne);
                    break;
                 
                    case '-':
                    valueStack.push(operandOne - operandTwo);
                    break;
                 
                    case '/':
                    valueStack.push(operandOne / operandTwo);
                    break;
                 
                    case '*':
                    valueStack.push(operandTwo * operandOne);
                    break;

                    case '^':
                    valueStack.push((int)Math.pow(operandTwo, operandOne));
                    break;

                    default: break;
                }
            }
 
            
        }

        System.out.println(valueStack.peek());
        return valueStack.peek();
    }
}
