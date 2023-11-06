package ru.anseranser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void cleanUpTest() {
        String str = "   Simple   \n Clean      Up      " +
                "    Test     \n\n";
        String expected = "SimpleCleanUpTest";
        assertEquals(expected, Utils.cleanUp(str));
    }

    @Test
    void isOnlyDigitsAndArithmeticTest() {
        String valid = "3.14+2*(5-3)/27";
        String invalid1 = "3,14+2*(5-3)/27";
        String invalid2 = "3.14+2x(5-3)/27";
        String invalid3 = "3.14+2*(5_3)/27";
        String invalid4 = "3.14+2*(5-3)%27";

        assertTrue(Check.isOnlyDigitsAndArithmetic(valid));
        assertFalse(Check.isOnlyDigitsAndArithmetic(invalid1));
        assertFalse(Check.isOnlyDigitsAndArithmetic(invalid2));
        assertFalse(Check.isOnlyDigitsAndArithmetic(invalid3));
        assertFalse(Check.isOnlyDigitsAndArithmetic(invalid4));

    }

    @Test
    void isValidArithmeticTest() {
        String valid = "3.14+2*(5-3)/27";
        String invalid1 = "3..14+2*(5-3)/27";
        String invalid2 = "3.14++2*(5-3)/27";
        String invalid3 = "3.14+2**(5-3)/27";
        String invalid4 = "3.14+2*(5--3)/27";
        String invalid5 = "3.14+2*(5-3)//27";
        String invalid6 = "3.14+*2*(5-3)/27";

        assertTrue(Check.isSingleArithmetic(valid));
        assertFalse(Check.isSingleArithmetic(invalid1));
        assertFalse(Check.isSingleArithmetic(invalid2));
        assertFalse(Check.isSingleArithmetic(invalid3));
        assertFalse(Check.isSingleArithmetic(invalid4));
        assertFalse(Check.isSingleArithmetic(invalid5));
        assertFalse(Check.isSingleArithmetic(invalid6));
    }

    @Test
    void isBalancedTest() {
        String valid1 = "3.14+2*(5-3)";
        String valid2 = "(3.14+(2*(5-3)))";
        String invalid1 = "3.14+2*((5-3)";
        String invalid2 = "3.14+2*((5-3)))";
        String invalid3 = "(3.14)+2)*((5-3)";
        assertTrue(Check.isBracketsBalanced(valid1));
        assertTrue(Check.isBracketsBalanced(valid2));
        assertFalse(Check.isBracketsBalanced(invalid1));
        assertFalse(Check.isBracketsBalanced(invalid2));
        assertFalse(Check.isBracketsBalanced(invalid3));
    }

    @Test
    void isSignNearBracketTest() {
        String valid = "3.14+2*(5-3)/27";
        String invalid1 = "3.14+2(5-3)/27";
        String invalid2 = "3.14+2*(5-3)27";
        assertTrue(Check.isSignNearBracket(valid));
        assertFalse(Check.isSignNearBracket(invalid1));
        assertFalse(Check.isSignNearBracket(invalid2));
    }

    @Test
    void isCorrectString() {
        String str = "3.14.47+2*(5-3)";
        Utils.splitArithmeticString(str);
    }

}