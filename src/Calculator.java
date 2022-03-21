package src;



public class Calculator<T> extends LinkedStack {
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

    public static int evaluatePostfix(String postfix){
        StackInterface<Integer> valueStack = new LinkedStack<>();

        for (int i = 0; i < postfix.length(); i++){
            char nextCharacter = postfix.charAt(i);
            
            int operandTwo = valueStack.pop();
            int operandOne = valueStack.pop();

            if (Character.isDigit(nextCharacter)){
                valueStack.push(nextCharacter - '0');
            }

            switch(nextCharacter){
                case ' ':
                break;

                case '+':
                valueStack.push(operandTwo + operandOne);
                break;
                 
                case '-':
                valueStack.push(operandTwo - operandOne);
                break;
                 
                case '/':
                valueStack.push(operandTwo / operandOne);
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
        System.out.println(valueStack.peek());
        return valueStack.peek();
    }
}
