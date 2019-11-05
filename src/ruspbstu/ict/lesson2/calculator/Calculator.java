package ruspbstu.ict.lesson2.calculator;

import ruspbstu.ict.lesson2.collection.Stack;
import ruspbstu.ict.lesson2.myexceptions.CalcException;
import ruspbstu.ict.lesson2.myexceptions.StackException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ruspbstu.ict.lesson2.calculator.RPN.expressionToRPN;

public class Calculator {
    private static Logger log = Logger.getLogger(Calculator.class.getName());

    private final Stack stack = new Stack();
    private final Map<String, Operation> operations;
    private final Map<String, Double> constants = new HashMap<>();

    public Calculator() {
        this.operations = new HashMap<>();
        StaticOperationsLoader loader = new StaticOperationsLoader();
        for (final Operation op : loader.load()) { // загружаем операции
            operations.put(op.getName(), op);
            log.logp(Level.INFO, Calculator.class.getName(), "Constructor", "Загружена арифметическая операция: \"" + op.getName() + "\"");
        }
    }

    public void exp(String expression) throws Exception { // задаём выражение
        expression = defineAll(expression);
        List<String> tokens = new ArrayList<>(Arrays.asList(expressionToRPN(expression).split(" ")));
        doCalculations(tokens); //передать RPN
    }

    private void doCalculations(List<String> tokens) throws Exception {

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            if (isNumber(token)) {
                stack.add(Double.parseDouble(token));
            } else {
                try {
                    Operation operation = operations.get(token);
                    if (operation == null)
                        throw new CalcException(String.format("Невозмжно вычислить выражение '%s', unknown operation: '%s'", tokens, token));
                    stack.add(operation.apply(stack));
                    log.logp(Level.INFO, Calculator.class.getName(), "doCalculations", "В стек передана операция для вычисления: \"" + token + "\"");
                } catch (CalcException e) {
                    throw new CalcException("Can't eval expression: " + tokens, e);
                }
            }
        }
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            log.logp(Level.INFO, Calculator.class.getName(), "doCalculations", "Число: \"" + s + "\" добавлено в стек вычислений");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void define(String ch, double toNumber) {
        constants.put(ch, toNumber);
    }

    private String defineAll(String expression) {
        for (Map.Entry<String, Double> entry : constants.entrySet()) {
            expression = expression.replaceAll(entry.getKey(), Double.toString(entry.getValue()));
            log.logp(Level.INFO, Calculator.class.getName(), "defineAll", "Константа: \"" + entry.getKey() +
                    "\" изменена на " + entry.getValue());
        }
        return expression;
    }

    public void push(double num) {
        stack.add(num);
    }

    public double pop() throws StackException {
        return stack.pop();
    }

    public void print() throws StackException {
        if (stack.empty()) throw new StackException("стек пуст");
        System.out.println(stack.peek());
    }

}

