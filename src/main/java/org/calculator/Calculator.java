package org.calculator;

public class Calculator {

    private static final int SUCCESS = 0;
    private static final int ERROR = 1;
    private static final int MIN_EXPRESSION_LENGTH = 3;

    public static void main(String[] args){
        //read the expression from the command line
        if(args.length== 0){
           printUsage();
            System.exit(ERROR);
        }


        String exp = String.join("", args);

        if(exp.length() < MIN_EXPRESSION_LENGTH) {
            System.out.println("Expression should be at least 2 operands and operator");
            System.exit(1);
        }

        try{
            double result = evaluateExpression(exp);
            System.out.println(result);
            System.exit(SUCCESS);
        }catch (CalculatorException e){
            System.err.println("Error: " + e.getMessage());
            System.exit(ERROR);
        }
        catch(Exception e){
            System.err.println("Unexpected error: " + e.getMessage());
            System.err.println("Please check your expression and try again.");
            System.exit(ERROR);
        }
    }

    private static double evaluateExpression(String expression){
        Converter converter = new Converter(expression);
        String postfixExp = converter.infixToPostfix();
        Evaluator evaluator = new Evaluator(postfixExp);
        return evaluator.evaluate();
    }
    private static void printUsage() {
        System.out.println("Simple CLI Calculator");
        System.out.println("Usage: java -jar calculator.jar \"expression\"");
        System.out.println();
        System.out.println("Supported operators:");
        System.out.println("  +   Addition");
        System.out.println("  -   Subtraction (also supports unary minus)");
        System.out.println("  *   Multiplication");
        System.out.println("  /   Division");
        System.out.println("  ^   Power/Exponent");
        System.out.println("  ( ) Parentheses for grouping");
        System.out.println();
        System.out.println("Examples:");
        System.out.println("  java -jar calculator.jar \"2 + 3 * 4\"");
        System.out.println("  java -jar calculator.jar \"(2 + 3) * 4\"");
        System.out.println("  java -jar calculator.jar \"10 / 2 + 3\"");
        System.out.println("  java -jar calculator.jar \"2 ^ 3 + 4\"");
        System.out.println("  java -jar calculator.jar \"-3 + 5 * 2\"");
        System.out.println();
        System.out.println("Note: Use quotes around expressions with spaces.");
    }
}
