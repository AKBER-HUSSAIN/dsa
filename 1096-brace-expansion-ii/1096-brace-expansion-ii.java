import java.util.*;

public class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Set<String>> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '{') {
                if (i > 0 && (Character.isLetter(expression.charAt(i - 1)) || expression.charAt(i - 1) == '}')) {
                    addOperator('*', operandStack, operatorStack);
                }
                operatorStack.push(c);
            } else if (c == '}') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '{') {
                    evaluate(operandStack, operatorStack.pop());
                }
                operatorStack.pop();
            } else if (c == ',') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '{') {
                    evaluate(operandStack, operatorStack.pop());
                }
                operatorStack.push(',');
            } else {
                if (i > 0 && (Character.isLetter(expression.charAt(i - 1)) || expression.charAt(i - 1) == '}')) {
                    addOperator('*', operandStack, operatorStack);
                }

                Set<String> set = new HashSet<>();
                set.add(String.valueOf(c));
                operandStack.push(set);
            }
        }

        while (!operatorStack.isEmpty()) {
            evaluate(operandStack, operatorStack.pop());
        }

        List<String> result = new ArrayList<>(operandStack.pop());
        Collections.sort(result);
        return result;
    }

    private void addOperator(char op, Stack<Set<String>> operandStack, Stack<Character> operatorStack) {
        while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(op)) {
            evaluate(operandStack, operatorStack.pop());
        }
        operatorStack.push(op);
    }

    private int precedence(char op) {
        if (op == '*') return 2;
        if (op == ',') return 1;
        return 0;
    }

    private void evaluate(Stack<Set<String>> operandStack, char op) {
        Set<String> set2 = operandStack.pop();
        Set<String> set1 = operandStack.pop();
        Set<String> res = new HashSet<>();

        if (op == '*') {
            for (String s1 : set1) {
                for (String s2 : set2) {
                    res.add(s1 + s2);
                }
            }
        } else if (op == ',') {
            res.addAll(set1);
            res.addAll(set2);
        }

        operandStack.push(res);
    }
}