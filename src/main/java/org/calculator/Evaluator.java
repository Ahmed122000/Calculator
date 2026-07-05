package org.calculator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Evaluator{

    private final String exp;
    private final HashSet<Character> operators = new HashSet<>();
    public Evaluator(String exp){
        this.exp=exp;
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('^');

    }

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     * @return the expression evaluated value
     */

    public double evaluate() {

        Stack<Double> stack = new Stack<>(); //new stack to use it in the evaluation
        String[] expression = this.exp.split(" ");

        //go through the expression to do all operation
        for (String str : expression) {
            if (operators.contains(str.charAt(0)) && str.length() == 1) {
                switch (str) {
                    case "-":
                        if (stack.size() < 2)
                            stack.push(stack.pop() * -1);
                        else {
                            double temp = stack.pop();
                            stack.push(stack.pop()-temp);
                        }
                        break;

                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;

                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;

                    case "/":
                        try {
                            double divisor = stack.pop();
                            if(divisor == 0.0){
                                throw new CalculatorException("Division by Zero");
                            }
                            stack.push(stack.pop()/divisor);
                        } catch (ArithmeticException e) {
                            e.printStackTrace();
                        }
                        break;

                    case "^":
                        double power = stack.pop();
                        stack.push(Math.pow(stack.pop(), power));
                        break;

                    default:
                        throw new RuntimeException("Invalid operator");
                }

            } else {
                stack.push(Double.parseDouble(str));
            }

        }

        if(stack.size()!= 1)
            throw new CalculatorException("Invalid Expression");

        return stack.pop(); //return the last value after all operation
    }
}
