package Calculator;


import java.util.ArrayList;

public class Calculator {

    /*-------Member Variables------*/


    private ArrayList<String> inputs = new ArrayList<>();
    private ArrayList<String> infix = new ArrayList<>();
    private ArrayList<String> postfix = new ArrayList<>();

    String result = "0";


    /*-------Used Classes----------*/

    InfixGenerator ig = new InfixGenerator();
    PostfixGen pg = new PostfixGen();

    OperatorsCharacteristics oc = new OperatorsCharacteristics();


    /*---------Methods---------*/
    public void add(String str) {

        infix.clear();
        syntaxChecker(str);
        infix = ig.createInfix(inputs);
        postfix = pg.postfixGen(infix);
        if (oc.isNumeric(inputs.get(inputs.size() - 1))) {
            result = oc.evaluate(postfix);
        }
//        System.out.println("the result::" + result);
    }

    private void syntaxChecker(String str) {

        if (oc.isPoint(str)) {

            if (inputs.isEmpty())                                       // if input is a decimal point and list is empty
            {
                str = 0 + str;
            } else if (!oc.isNumeric(inputs.get(inputs.size() - 1))) {  // if input is a decimal point
                str = 0 + str;

            }
        }


        if (inputs.isEmpty())                                   // input list is empty
        {
            inputs.add(str);

        } else                                                 // input list is not empty
        {
            String pre_input = inputs.get(inputs.size() - 1);

            if (oc.isNumeric(pre_input) && oc.isNumeric(str)) // Pre_input and post input both numeric
            {
                inputs.add(str);
            } else if (!oc.isNumeric(pre_input) && !oc.isNumeric(str)) // Pre input and post input both are operators
            {
                inputs.remove(inputs.size() - 1);
                inputs.add(str);

            } else {
                inputs.add(str);
            }

        }

    }

    public void clear() {
        inputs.remove(inputs.size() - 1);
    }

    public void allClear() {
        inputs.clear();
    }


    public void showInput() {

        if (inputs.isEmpty()) {
            System.out.println("No Input is Given !!");

        }
        System.out.println("The given Expression is :-");

        System.out.print("[ ");
        for (String s : inputs) {
            System.out.print(s + " >> ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    public void showInfix() {
        if (inputs.isEmpty()) {
            System.out.println("No Input is Given !!");

        }
        System.out.println("The Infix is :-");

        System.out.print("[ ");
        for (String s : infix) {
            System.out.print(s + " >> ");
        }
        System.out.print(" ]");
        System.out.println();

    }

    public void showPostfix() {
        if (inputs.isEmpty()) {
            System.out.println("No Infix is Given !!");

        }
        System.out.println("The Postfix is :-");

        System.out.print("[ ");
        for (String s : postfix) {
            System.out.print(s + " >> ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    public String getInput() {
        return inputs.toString();
    }

    public String getResult() {
        return result;
    }


}
