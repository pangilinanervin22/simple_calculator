package com.example.project;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class MathLogic {

    // I use "–" em dash for negative value and "-" hyphen for negative
    private static final String[] CHAR_OPERATION_ORDER = {"×", "÷", "+", "–"};
    private static String currentText; // for return text when result is syntax error

    public static String setNumberCalculate(String string) {
        StringBuilder temp = new StringBuilder();
        char[] listString = string.toCharArray();
        int openParenthesis = 0;

        for (int i = 0; i < listString.length; i++) {
            // recursion for parentheses
            if (listString[i] == '(' && openParenthesis == 0) {
                temp.append(setNumberCalculate(string.replaceFirst("[(]", "").substring(i, string.length() - 1)));
                openParenthesis++;
                continue;
            } else if (listString[i] == ')' && openParenthesis == 0) {
                break;
            } else if (listString[i] == ')' && openParenthesis > 0) {
                openParenthesis--;
                continue;
            } else if (openParenthesis > 0) {
                if (listString[i] == '(')
                    openParenthesis++;
                continue;
            }

            temp.append(listString[i]);
        }

        return numberToCalculate(temp.toString());
    }

    // set the operations
    private static String numberToCalculate(String string) {
        MathLogic.currentText = string.replaceAll("[ ()]", "");
        ArrayList<String> numberList = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();

        Collections.addAll(numberList, currentText.split("[×÷+–]"));

        for (String sign : currentText.split("[%1234567890.-]"))
            if (sign.matches("[×÷+–]"))
                operators.add(sign);


        return mathEquation(numberList, operators);
    }

    // calculate the given operation
    private static String mathEquation(ArrayList<String> numberList, ArrayList<String> operators) {
        try {
            String temp;
            while (!operators.isEmpty() || numberList.size() > 2)
                // for MDAS RULE
                for (String ch : CHAR_OPERATION_ORDER)
                    for (int i = 0; i < operators.size(); i++) {
                        String sign = operators.get(i);
                        if (sign.equals(ch)) {
                            temp = mathEquation(numberList.remove(i), numberList.remove(i), operators.remove(i));
                            numberList.add(i, String.valueOf(temp));
                        }
                    }

            return getRoundOffNum(BigDecimal.valueOf(Double.parseDouble(numberList.remove(0))));
        } catch (Exception syntaxError) {
            return currentText;
        }
    }

    private static String mathEquation(String firstNum, String secondNum, String operator) {
        BigDecimal firstBig = new BigDecimal(BigInteger.ZERO), secondBig = new BigDecimal(BigInteger.ZERO), resultBig;
        try {
            firstBig = BigDecimal.valueOf(Double.parseDouble(firstNum));
            secondBig = BigDecimal.valueOf(Double.parseDouble(secondNum));

        } catch (Exception syntaxError) {
            firstBig = BigDecimal.valueOf(Double.parseDouble(firstNum.replaceFirst("%", "")));
            secondBig = BigDecimal.valueOf(Double.parseDouble(secondNum.replaceFirst("%", "")));
            if (firstNum.contains("%") && secondNum.contains("%")) {
                secondBig = secondBig.divide(BigDecimal.valueOf(100));
                firstBig = firstBig.divide(BigDecimal.valueOf(100)).multiply(secondBig);
            } else if (firstNum.contains("%")) {
                firstBig = firstBig.divide(BigDecimal.valueOf(100)).multiply(secondBig);
            } else if (secondNum.contains("%")) {
                firstBig = BigDecimal.valueOf(Double.parseDouble(firstNum));
                secondBig = secondBig.divide(BigDecimal.valueOf(100)).multiply(secondBig);
            }

        }

        switch (operator) {
            case "+":
                resultBig = firstBig.add(secondBig);
                break;
            case "–":
                resultBig = firstBig.subtract(secondBig);
                break;
            case "÷":
                resultBig = firstBig.divide(secondBig, 6, RoundingMode.CEILING);
                break;
            case "×":
                resultBig = firstBig.multiply(secondBig);
                break;
            default:
                return null;
        }

        return resultBig.toString();
    }

    public static String getRoundOffNum(BigDecimal number) {
        DecimalFormat df = new DecimalFormat("#.########");
        if (number.remainder(new BigDecimal(BigInteger.ONE)).equals(new BigDecimal(BigInteger.ZERO)))
            return number.toBigInteger().toString();

        return df.format(number);
    }

}
