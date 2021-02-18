package Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class OperatorsCharacteristics {

    /*---HashMap for Precedence-----*/

    public static final HashMap<String, Integer> precedence_Map = new HashMap<>() {
        {
            put("^", 3);
            put("/", 2);
            put("*", 2);
            put("-", 1);
            put("+", 1);
        }
    };

    /*---HashMap for Associativity--*/

    public static final HashMap<String, Character> associativity_Map = new HashMap<>() {
        {
            put("^", 'R');
            put("/", 'L');
            put("*", 'L');
            put("-", 'L');
            put("+", 'L');
        }


    };

    /*---Method to check Precedence of a given operator with respect to a another operator*/

    public char checkPrecedence(String input, String stack_top) {

        int p1 = precedence_Map.get(input);
        int p2 = precedence_Map.get(stack_top);

        if (p1 > p2) {
            return 'H';

        } else if (p1 < p2) {

            return 'L';

        } else return 'E';
    }

    /*-----Method to check Associativity of given Input----*/

    public char checkAssociativity(String input) {
        return associativity_Map.get(input);
    }

    /*-----Method to check a String is Numeric or not*/

    public boolean isNumeric(String str) {
        if (str.equals(".")) {
            return true;
        } else {
            try {
                Double.parseDouble(str);
            } catch (NumberFormatException n) {
                return false;
            }
            return true;
        }
    }

    public boolean isPoint(String str)
    {
        return str.equals(".");
    }

    /*-----Methods for Evaluation of Postfix---*/

    public String evaluate(ArrayList<String> postfix) {

        int i;
        Stack<String> stack = new Stack<String>();

        int size = postfix.size();

        for (i = 0; i < size; i++) {
            if (isNumeric(postfix.get(i))) {
                stack.push(postfix.get(i));
            } else {
                String operator = postfix.get(i);
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = calculate(operand1, operand2, operator);
                stack.push(result);
//

            }
        }

        return stack.pop();
    }

    private String calculate(String operand1, String operand2, String operator) {
        double v1 = Double.parseDouble(operand1);
        double v2 = Double.parseDouble(operand2);
        double result = 0;

        switch (operator) {
            case "+" -> result = v1 + v2;
            case "-" -> result = v1 - v2;
            case "*" -> result = v1 * v2;
            case "/" -> result = v1 / v2;
            case "^" -> result = Math.pow(v1, v2);
            default -> System.out.println("Exception");
        }

        return String.valueOf(result);

    }


}
