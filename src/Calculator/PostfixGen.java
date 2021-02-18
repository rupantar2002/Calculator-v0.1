package Calculator;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixGen {

//    private ArrayList<String> infix = new ArrayList<String>();

//    private ArrayList<String> postfix = new ArrayList<>();

//    private Stack<String> stack = new Stack<String>();

    OperatorsCharacteristics operatorsCharacteristics = new OperatorsCharacteristics();




    /*-------Methods---------*/

    public ArrayList<String> postfixGen(ArrayList<String> infix) {

        ArrayList<String> postfix=new ArrayList<>();
        Stack<String> stack = new Stack<String>();

        String val;

        for (String s : infix) {
            val = s;

//            System.out.println("val "+val);

            if (operatorsCharacteristics.isNumeric(val)) {
                postfix.add(val);
            } else if (stack.empty()) {
                //System.out.println("Empty stack");
                stack.push(val);
            } else if (val.equals("(")) {
                stack.push(val);
            } else if (val.equals(")")) {
//                System.out.println("here");
                //adding the content up to opening bracket found
                while (!stack.peek().equals("(")) {
                    String temp = stack.pop();
                    postfix.add(temp);
                    //System.out.println("Popped: " + temp);
                }
                //for removing the "(" from the stack
                //stack.pop();
                System.out.println("Popped bracket" + stack.pop());

            } else if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'L') {

                move_operators_to_postfix_until_lower_precedence_occur(val,stack,postfix);
                stack.push(val);
            } else if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'H') {
                stack.push(val);
            } else if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'b') {
                stack.push(val);
            } else if (operatorsCharacteristics.checkAssociativity(val) == 'R') {
                stack.push(val);
            } else if(operatorsCharacteristics.checkAssociativity(val) == 'L') {
                move_operators_to_postfix_until_lower_precedence_occur(val,stack,postfix);
                stack.push(val);
            } else {
                System.out.println("undefined state: Error on line 66 :: PostfixCreater class");
            }
            //System.out.println(val);

        }
        while (!stack.empty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }


    private void move_operators_to_postfix_until_lower_precedence_occur(String val,Stack<String> stack,ArrayList<String> postfix) {
        while (!stack.empty()) {

            if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'L') {
                String x = stack.pop();
                postfix.add(x);
            }
            else if(operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'E'){
                String x = stack.pop();
                postfix.add(x);

            }
            else {
                break;
            }
        }

    }

}
