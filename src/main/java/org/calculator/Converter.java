package org.calculator;

import java.util.HashMap;
import java.util.Stack;

public class Converter {

    private final String exp;
    private final HashMap<Character, Integer> degree = new HashMap<>();


    public Converter(String exp){
        this.exp = exp;
        this.degree.put('+', 1);
        this.degree.put('-', 1);
        this.degree.put('*', 2);
        this.degree.put('/', 2);
        this.degree.put('^', 3);
    }

    public String infixToPostfix() {

        StringBuilder post = new StringBuilder(); //string to hold the last expression
        Stack<Character> stack = new Stack<>(); //new stack to use it
        StringBuilder numbBuffer = new StringBuilder();

        for(char ch: this.exp.toCharArray()) {

            if(Character.isSpaceChar(ch)) continue;

            //if the char is letter throw Error immediately!
            if (Character.isLetter(ch)) throw new CalculatorException("Invalid character: " + ch);

            //if the char is digit add it to the new expression
            if (Character.isDigit(ch) || (ch == '.')) numbBuffer.append(ch);

            //handle operators
            else {
                if (!numbBuffer.isEmpty()) {
                    post.append(numbBuffer).append(" ");
                    numbBuffer.setLength(0);
                }
                //other chars push them to the stack
                if (ch == '(') stack.push(ch);

                else if (ch == ')') {
                    //if we get closing bracket start to pop up the sign we already pushed it to the stack
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        post.append(stack.pop()).append(" ");
                    }

                    if (stack.isEmpty()) {
                        throw new CalculatorException("Mismatched parentheses: extra ')' "); //return error in case there was ending bracket without opening one
                    }
                    stack.pop();
                } else if (degree.containsKey(ch)) {
                    int currentPrecedence = degree.get(ch);
                    //if the new sign is lower degree than last sign was pushed to the stack then take all higher degree out
                    while (!stack.isEmpty() && stack.peek() != '(' && currentPrecedence <= degree.get(stack.peek())) {
                        post.append(stack.pop()).append(" ");
                    }
                    stack.push(ch); //push the new sign
                }
                else{
                    throw new CalculatorException("Invalid Operator: " + ch);
                }
            }
        }
        if(!numbBuffer.isEmpty()) post.append(numbBuffer).append(" ");
        //pop all the remaining signs in the stack
        while(!stack.isEmpty())
        {
            if(stack.peek() == '(')
            {
                throw new CalculatorException("Mismatched parentheses extra: '(' "); //return error in case there was opening bracket without ending one
            }
            post.append(stack.pop()).append(" ");
        }
        return post.toString().trim();
    }
}
