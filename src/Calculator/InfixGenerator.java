package Calculator;

import java.util.ArrayList;

public class InfixGenerator {

    /*------Global Variables---*/

    private ArrayList<String> infix = new ArrayList<>();


    /*--------Used Classes----*/

    OperatorsCharacteristics oc = new OperatorsCharacteristics();

    /*--------Methods---------*/

    public ArrayList<String> createInfix(ArrayList<String> inputs) {

        int pos = 0;
        int flag= 0;

        ArrayList<String> infix = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {

            if (oc.isNumeric(inputs.get(i))) {

                if (flag==0) {
                    infix.add(inputs.get(i));
                    flag++;

                } else {
                    String val = infix.get(pos) + inputs.get(i);
                    infix.remove(pos);
                    infix.add(val);
                }
            } else {
                flag=0;
                pos++;
                infix.add(inputs.get(i));
                pos++;

            }
        }
        if (!oc.isNumeric(infix.get(0))) {
            infix.add(0, "0");
        }
        pos=0;

        return infix;


    }


}
