import java.util.Stack;

public class prefix {
    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        // Scan the expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                // If the character is a digit, push it onto the stack
                stack.push(ch - '0');
            } else {
                // If the character is an operator, pop the top two operands from the stack,
                // perform the operation, and push the result back onto the stack
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        // The result of the prefix expression will be at the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixExpression = "+*23*549"; // Example prefix expression: + * 2 3 * 5 4 9
        int result = evaluatePrefix(prefixExpression);
        System.out.println("Result of the prefix expression is: " + result);
    }
}