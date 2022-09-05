import java.util.Scanner;

/**
 * <Main>    Main class of Vegetables buying app
 *
 * @version  JDK 1.8.0_341 05_Sep_2022
 * @author   Ragul_V
 */
 public class VeggieCart {
     
    /**
     * Calls the methods via controller object
     *
     * @param args[] Command Line Arguments which allows String
     */
    public static void main(String args[]) {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \3 Veggies Online Shopping \3 ");    
        String choice;
        boolean flag = true;
        do{
            System.out.println("1. Customer\n2. Admin\n0. Exit");
            choice = scanner.next();
            switch(choice) {
                case "1":
                    userController.displayCustomerMenu(choice);
                    break;
                    
                case "2":
                    userController.displayAdminMenu(choice);
                    break;
                
                case "0":
                    flag = false;
                    break;
                    
                default:
                    System.out.println("Invalid input...");
                    System.out.println("Please give 0,1,2");
            }
        }while(flag);
    }
 }