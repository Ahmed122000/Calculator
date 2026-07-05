package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostfixEvaluatorTest {

    @Test
    void evaluateSimpleAddition(){
        Evaluator eval = new Evaluator("3 4 +");
        double answer = eval.evaluate();
        assertEquals(7, answer);
    }

    @Test
    void evaluateSimpleNegative(){
        Evaluator eval = new Evaluator("3 - 4 +");
        double answer = eval.evaluate();
        assertEquals(1, answer);
    }

    @Test
    void evaluateOperatorProcedures(){
        Evaluator eval = new Evaluator("3 4 + 2 ^ 12 9 - 3 / +");
        double answer = eval.evaluate();
        assertEquals(50, answer);
    }
}
