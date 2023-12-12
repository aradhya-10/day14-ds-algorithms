import java.util.Scanner;
import java.util.Stack;

class ParenthesesChecker {
    
    static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Closing parenthesis without a corresponding opening parenthesis
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // Expression is balanced if the stack is empty at the end
    }
}

public class BalancedParentheses {
    public static void main(String[] args) {
       
        System.out.print("Enter an arithmetic expression: ");
        Scanner scanner = new Scanner(System.in);
        String arithmeticExpression = scanner.nextLine();

        // Check if the arithmetic expression has balanced parentheses
        boolean isBalanced = ParenthesesChecker.isBalanced(arithmeticExpression);

        if (isBalanced) {
            System.out.println("The arithmetic expression is balanced.");
        } else {
            System.out.println("The arithmetic expression is not balanced.");
        }

        scanner.close();
    }
}
