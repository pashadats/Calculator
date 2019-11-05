package ruspbstu.ict.lesson2.calculator;

import ruspbstu.ict.lesson2.Main;

import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RPN {
    public static Logger log = Logger.getLogger(RPN.class.getName());

    public static String expressionToRPN(String tokens){
        log.logp(Level.INFO, RPN.class.getName(), "expressionToRPN", "В метод передана строка" + tokens);
        StringBuilder current = new StringBuilder(); // строка операндов
        Stack<Character> stack = new Stack<>(); // стек операций

        int priority;
        for(int i = 0; i < tokens.length(); i++){

            priority = getPriority(tokens.charAt(i));

            if(priority == 0) current.append(tokens.charAt(i));
            if(priority == 1) stack.push(tokens.charAt(i));

            if(priority > 1){
                current.append(" ");
                while (!stack.empty()){
                    if(getPriority(stack.peek()) >= priority)
                        current.append(stack.pop());
                    else break;
                }
                stack.push(tokens.charAt(i));
            }
            if (priority == -1){
                current.append(" ");
                while (getPriority(stack.peek()) != 1) {
                    current.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty())
            current.append(" ").append(stack.pop());

        log.logp(Level.INFO, RPN.class.getName(), "expressionToRPN", "Строка в RPN: " + current.toString());
        return current.toString();
    }

    private static int getPriority(char token){
        if(token == '^') return 4;
        if(token == '*' || token == '/') return 3;
        else if(token == '+' || token == '-') return 2;
        else if(token == '(') return 1;
        else if(token == ')') return -1;
        else return 0;
    }
}

