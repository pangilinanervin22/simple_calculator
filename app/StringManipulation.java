package com.example.project;

import java.util.Arrays;
import java.util.List;

public class StringManipulation {
    // This class is for preventing syntax error and improving inputting string

    // I use "–" em dash for negative value and "-" hyphen for negative
    private static final String[] OPERATION_ARRAY = {"×", "÷", "+", "–"};
    public static final List<String> OPERATION_LIST = Arrays.asList(OPERATION_ARRAY);
    private final String negativeSymbol = "-";
    private final String minusSign = "–";

    public String calculateText(String text) {
        text = cleanUpParenthesis(text);
        text = MathLogic.setNumberCalculate(text);
        return text;
    }

    public String updateCurrentString(String text, String input) {
        if (input.equals(""))
            return text;

        //for preventing syntax error
        boolean inputOperationTwice = !lastCharIsNumber(text) && isCharOperator(input);
        boolean inputWrongOperator = (text.endsWith(".") || text.endsWith("(")) && isCharOperator(input);
        boolean inputModuloWrong = !lastCharIsNumber(text) && input.equals("%");
        boolean inputMinusWithNegative = text.endsWith("-") && input.equals(" – ") || text.endsWith(" – ") && input.equals("-");
        boolean inputNegativeTwice = input.equals(negativeSymbol) &&
                (text.endsWith(negativeSymbol) || text.endsWith(minusSign) ||
                        lastCharIsNumber(text) && input.equals(negativeSymbol));
        boolean inputDecimalWithSpecial = text.endsWith(".") && (input.equals("(") || isCharOperator(input) || input.equals(negativeSymbol));

        if (inputOperationTwice || inputNegativeTwice || inputMinusWithNegative || inputModuloWrong ||
                inputWrongOperator || inputDecimalWithSpecial)
            return text;

        if (text.endsWith("(") && input.equals(")"))
            return text.substring(0, text.length() - 1);

        if (text.endsWith(")"))
            if (isCharOperator(input))
                return text + input;
            else if (!lastCharIsNumber(text) || input.equals("-"))
                return text + " × " + input;

        if (text.endsWith("%")) {
            if (isCharOperator(input) || input.equals(")") || input.equals(" × ("))
                return text + input;
            else if (input.equals("."))
                return text;

            return text + " × " + input;
        }

        return text + input;
    }

    public String removeLogic(String text) {
        if (text.length() == 1)
            return "";

        char[] arrayChar = text.toCharArray();
        int lastIndex = text.length() - 1;
        String beforeLast = String.valueOf(arrayChar[lastIndex - 1]);

        //for removing extra spaces in some operations
        if (arrayChar[lastIndex] == ' ' && OPERATION_LIST.contains(beforeLast) || text.endsWith(" ×("))
            text = text.substring(0, lastIndex - 2);
        else
            text = text.substring(0, lastIndex);

        return text;
    }

    public String addingParenthesis(String text) {
        text = text.replaceAll(" ", "");

        if (text.endsWith(".") || text.endsWith(negativeSymbol))
            return "";

        if (isInsideParenthesis(text)) {
            for (String operation : OPERATION_LIST)
                if (text.endsWith(operation))
                    return "(";

            return ")";
        }else if(lastCharIsNumber(text))
            return " × (";

        return "(";
    }

    public String addingDecimal(String text) {
        if (notHaveDecimal(text) && lastCharIsNumber(text))
            return ".";

        return "";
    }

    public String checkSyntaxAnswer(String text) {
        for (String wew : OPERATION_LIST)
            if (text.contains(wew) || text.contains("%") || text.contains("(") || text.contains(")"))
                return "";

        return text;
    }

    private boolean lastCharIsNumber(String text) {
        text = text.replace(" ", "");

        if (text.equals("") || text.endsWith(" ") || text.endsWith("(") || text.endsWith(")") ||
                text.endsWith(".") || text.endsWith(negativeSymbol))
            return false;

        for (String operator : OPERATION_ARRAY)
            if (text.endsWith(operator)) return false;

        return true;
    }

    private boolean notHaveDecimal(String text) {
        char[] stringChar = text.toCharArray();

        for (int i = stringChar.length - 1; i > 0; i--)
            if (stringChar[i] == '.')
                return false;
            else if (OPERATION_LIST.contains(stringChar[i] + ""))
                return true;

        return lastCharIsNumber(text);
    }

    private boolean isCharOperator(String input) {
        return OPERATION_LIST.contains(input.replaceAll(" ", ""));
    }

    private boolean isInsideParenthesis(String text) {
        boolean isInsideParenthesis = false;
        for (char ch : text.toCharArray())
            if (ch == '(')
                isInsideParenthesis = true;
            else if (ch == ')')
                isInsideParenthesis = false;

        return isInsideParenthesis;
    }

    public String cleanUpParenthesis(String text) {
        char[] charArray = text.toCharArray();
        int index = 0;

        for (char ch : charArray)
            if (ch == '(') {
                System.out.println("added");
                index++;
            } else if (ch == ')')
                index--;

        while (index > 0) {
            text = text + ")";
            index--;
            System.out.println(text);
        }

        return text;
    }

}
