import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            System.out.println("first number: ");
            int n1 = scanner.nextInt();
            System.out.println("second number: ");
            int n2 = scanner.nextInt();
            System.out.println("choose (+, -, *, /): ");
            String action = scanner.next();
            double result = 0;
            boolean valid = true;

            switch (action) {
                case "+":
                   result = n1 + n2;
                    break;
                case "-":
                   result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    if (n2 != 0) {
                       result = n1 / n2;
                    } else {
                        System.out.println("Error: division by zero");
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("please write correct action");
                    valid = false;
            }
            if (valid){
                System.out.println(result);
            }
            System.out.println("continue ? ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("no")){
                cont = false;
                System.out.println("Good bye");
            }if (answer.equalsIgnoreCase("yes")){
                cont = true;
            }
        }
        scanner.close();
    }
}


