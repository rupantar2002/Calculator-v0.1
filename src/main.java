import Calculator.Calculator;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();

        char ch = 'y';


        System.out.println("----Welcome to calculator----");


        do {
            String input = "";
            input = scanner.nextLine();
            calculator.add(input);
            System.out.println(calculator.getInput());
            System.out.println(calculator.getResult());

        } while (true);


    }
}
