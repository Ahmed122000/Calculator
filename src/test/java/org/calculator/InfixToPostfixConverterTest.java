package org.calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class InfixToPostfixConverterTest {

    @Test
    void ConvertSimpleAddition(){
        Converter converter = new Converter("3+4");
        String postfixExp = converter.infixToPostfix();
        assertEquals("3 4 +", postfixExp);
    }

    @Test
    void ConvertSimpleNegative(){
        Converter converter = new Converter("-3+4");
        String postfixExp = converter.infixToPostfix();
        assertEquals("3 - 4 +", postfixExp);

    }

    @Test
    void convertOperatorProcedures(){
        Converter converter = new Converter("(3+4)^2+(12-9)/3");
        String postfixExp = converter.infixToPostfix();
        assertEquals("3 4 + 2 ^ 12 9 - 3 / +", postfixExp);

    }
}
