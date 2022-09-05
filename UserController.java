import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <UserController> Controller class of User of Vegetables buying app
 *
 * @version         JDK 1.8.0_341 05_Sep_2022
 * @author          Ragul_V
 */
public class UserController {
    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserService();
    private View output = new View();
    private VegetableController vegetableController = new VegetableController();

    /**
     * Get user name from the user with the validation 
     */
    public String getUserName() {
        String userName;
        String firstName;
        String lastName;
        boolean check = true;
        do {
            System.out.println("Enter First name: ");
            firstName = scanner.next();
			System.out.println("Enter Last name: ");
			lastName = scanner.next();
			userName = firstName.concat(lastName);
            if(userService.isValidUserName(userName)) {
                check = false;
            } else {
                output.showInvalid();  
            }
        } while(check);
        return userName;
    }
    
    /**
     * Get user mailId from the user with the validation 
     */  
    public String getMailId() {
        boolean check = true;
        String mailId;
        do {
            System.out.println("Enter E-mail Id: ");
            mailId = scanner.next();
            if(userService.isValidMailId(mailId))
                check = false;
            else
                output.showInvalid();    
        } while(check);
        return mailId;
    }
    
    /**
     * Get user Phone Number from the user with the validation 
     */     
    public String getPhoneNo() {
        boolean check = true;
        String phoneNo;
        do {
            System.out.println("Enter Phone Number: ");
            phoneNo = scanner.next();
            if(userService.isValidPhoneNo(phoneNo))
                check = false;
            else
                output.showInvalid();    
        }while(check);
        return phoneNo;
    }

    /**
     * Get user Location from the user with the validation 
     */     
    public String getLocation() {
        boolean check = true;
        String location;
        do {
            System.out.println("Enter Location: ");
            location = scanner.next();
            if(userService.isValidLocation(location))
                check = false;
            else
                output.showInvalid();    
        } while(check);
        return location;
    }

    /**
     * Get user pincode from the user with the validation 
     */     
    public int getPincode() {
        boolean check = true;
        int pincode;
        do {
            System.out.println("Enter Pincode: ");
            pincode = Integer.parseInt(scanner.next());
            if(userService.isValidPincode(pincode))
                check = false;
            else
                output.showInvalid();    
        } while(check);
        return pincode;
    }

    /**
     * Get user role from the user with choice which entered
     *
     * @param choice
     *
     * @return if choice 2 Admin else Customer String
     */ 
    public String getRole(String choice) {
        return (choice.equals("2"))?"Admin":"Customer";    
    } 

    /**
     * Get user Id from the user with the validation 
     */     
    public String getUserId() {
        boolean check = true;
        String userId;
        do {
            System.out.println("Enter your ID: ");
            userId = scanner.next();
            if(userService.isValidUserId(userId))
                check = false;
            else
                output.showInvalid();
        } while(check);
        return userId;
    }

    /**
     * Get user password from the user with the validation 
     */     
    public String getPassword() {
        boolean check = true;
        String password;
        do {
            System.out.println("Enter Password: ");
            password = scanner.next();
            if(userService.isValidPassword(password))
                check = false;
            else 
                output.showInvalid();    
        } while(check);
        return password;
    }
    
    /**
     * Create the user details to add in Users collection
     *
     * @param  choice character 
     */
    public void createUserDetails(String choice) {        
        User user = new User(getUserName(), getMailId(), getPhoneNo(),
                  getLocation(), getPincode(), getRole(choice), getUserId(), getPassword());
        if(userService.createUser(user.getUserId(), user)) { 
            output.showSuccessfullyCreated();
        }
    }

    /**
     * Delete the user details from Users collection
     */   
    public void deleteUserDetail(
            Map<String, User> Users, String userId) {
        if(Users.containsKey(userId)) {
            if (userService.removeUser(userId)) {
                output.showDeleted();
            }
        } else {
            System.out.println("User Id doesn't exist");
        }
    }
    /**
     * Sign in operation of user with password check
     */
    public void customerSignin() {
        System.out.println("Enter your ID: ");
        String userId = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        if(userService.isValidCustomer(userId,password)) {
           System.out.println("\n\2 Welcome User \2");
           displayUserInnerMenu(userId);
        } else {
            output.showInvalid();
        }       
    }

    /**
     * Sign in operation of admin with password check
     */
    public void adminSignin() {
        System.out.println("Enter your ID: ");
        String userId = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        if(userService.isValidAdmin(userId,password)) {
            System.out.println("\n\2 Welcome Admin \2");
            displayAdminInnerMenu();        
        } else {
            output.showInvalid();
        }
    }

    /**
     * Update the profile of the user
     *
     * @param userId 
     */
    public void updateUser(String userId) {
        for(User user: userService.getUsers().values()) {                                                                                                                            
            if(userId.equals(user.getUserId())) {
                String option = scanner.next();
                switch(option) {
                    case "1":
                        user.setUserName(getUserName());
                        break;
                        
                    case "2":
                        user.setMailId(getMailId());
                        break;
                        
                    case "3":
                        user.setPhoneNo(getPhoneNo());
                        break;

                    case "4":
                        user.setLocation(getLocation());
                        break;

                    case "5":
                        user.setPincode(getPincode());
                        break;
                    
                    default:
                        output.showInvalid();
                }
                output.showSuccessfullyUpdated();
            }
        }
    }
    
    /**
     * Shows the menu options for Customer
     *
     * @param choice character
     */
    public void displayCustomerMenu(String choice) {
        int option;
        boolean flag = true;
        do {
            System.out.println("\n Hello Customer \2");
            System.out.println("1. Sign in\n2. Sign up\n0. Exit to back Menu");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    customerSignin();
                    break;
                            
                case 2:
                    createUserDetails(choice);
                    break;    

                case 0:
                    flag = false;
                    break;
                        
                default:
                    output.showInvalid();
            }
        }while(flag);
    }
    
    /**
     * Shows the menu options for Admin
     *
     * @param choice character
     */    
    public void displayAdminMenu(String choice) {
        int option;
        boolean flag = true;
        do {
            System.out.println("\n Hello Admin \2");
            System.out.println("1. Sign in\n2. Sign up\n0. Exit to back Menu");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    adminSignin();
                    break;
                            
                case 2:
                    createUserDetails(choice);
                    break;    

                case 0:
                    flag = false;
                    break;
                        
                default:
                    output.showInvalid();
            }
        }while(flag);
    } 
    
    /**
     * Shows the menu options for Admin to view details
     */ 
    public void displayUserDetails() {
        int option;
        boolean flag = true;
        do {    
        System.out.println("\n View Details:\n1. Users ");
        System.out.println("2. All Customers\n3. All Admins");
        System.out.println("0. Exit to back Menu");
        option = scanner.nextInt();
        switch(option) {
            case 1:
                System.out.println("Enter ID to view");
                output.showUser(userService.getUsers(), scanner.next());
                break;
                            
            case 2:
                output.showAllCustomers(userService.getUsers());
                break;    

            case 3:
                output.showAllAdmins(userService.getUsers());
                break;

            case 0:
                flag = false;
                break;
                        
            default:
                output.showInvalid();
        }
         }while(flag);
   }

    /**
     * Shows the menu options for Admin to add vegetables and view details
     */ 
    public void displayAdminInnerMenu() {
        int option;
        boolean flag = true;
        do {    
            System.out.println("\n1. Vegetable\n2. View user Details");
            System.out.println("3. Delete User\n0. Exit to back Menu");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    vegetableController.displayVegetableInnerMenu();
                    break;
                            
                case 2:
                    displayUserDetails();
                    break;    

                case 3:
                    System.out.println("Enter ID to Delete: ");
                    deleteUserDetail(userService.getUsers(),scanner.next());
                    break;    

                case 0:
                    flag = false;
                    break;
                        
                default:
                    output.showInvalid();
            }
        }while(flag);
    }    

    /**
     * Shows the menu options of Cart to add, remove vegetables 
     */ 
    public void displayVegetableCartMenu() {
        int option;
        boolean flag = true;
        do {    
            System.out.println("\n1. Add Vegetable to cart\n2. View your cart");
            System.out.println("3. Remove Vegetable from cart\n0. Exit");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    vegetableController.addToCart();
                    break;
                    
                case 2:
                    vegetableController.viewCart();
                    break;
                    
                case 3:
                    vegetableController.removeVegetableFromCart();
                    break;
                    
                case 0:
                    flag = false;
                    break;
                    
                default:
                    output.showInvalid();
            }
        }while(flag);
    }
    /**
     * Shows the menu options for User to see vegetables and view their details
     */ 
    public void displayUserInnerMenu(String userId) {
        int option;
        boolean flag = true;
        do {    
            System.out.println("\n1. Vegetable\n2. View and Edit your profile");
            System.out.println("0. Exit to back Menu");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    output.showVegetables(vegetableController.getVegetables());
                    displayVegetableCartMenu();
                    break;
                            
                case 2:
                    System.out.println("Your Profile: ");        
                    output.showUser(userService.getUsers(), userId);
                    System.out.println("1. To edit your profile ");
                    System.out.println("0. Exit");
                    int choice = scanner.nextInt();
                    if(choice == 1) {
                        System.out.println("Enter s.no of which to edit: ");
                        updateUser(userId);
                    } else if(choice == 0) {
                        output.showInvalid();
                    } 
                    break;    

                case 0:
                    flag = false;
                    break;
                        
                default:
                    output.showInvalid();
            }
        }while(flag);
    }    
}