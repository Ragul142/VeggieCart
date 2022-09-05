import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * <View> view class of Vegetables buying app
 *
 * @version  JDK 1.8.0_341 05_Sep_2022
 * @author   Ragul_V
 */
public class View {
    
    /**
     * Shows invalid as output to user
     */
    public void showInvalid() {
        System.out.println("Invalid...");
    }

    /**
     * Shows successfully created as output to user
     */
    public void showSuccessfullyCreated() {
        System.out.println("Successfully created...");
    }
    
    /**
     * Shows successfully updated as output to user
     */
    public void showSuccessfullyUpdated() {
        System.out.println("Successfully Updated...");
    }

    /**
     * Shows successfully Added as output to user
     */
    public void showSuccessfullyAdded() {
        System.out.println("Successfully Added...");
    }

    /**
     * Shows deleted as output to user
     */
    public void showDeleted() {
        System.out.println("Deleted...");
    }

    /**
     * Shows all the customers to user
     *
     * @param users 
     */
    public void showAllCustomers(Map<String, User> users) {
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        System.out.printf(" %-20s %-20s ", "Name", "ID");
        System.out.printf("%-30s %-13s ", "Mail Id", "Phone No.");
        System.out.printf("%-20s %-6s\n", "Location","Pincode");
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        for(User user: users.values()) {
            if(user.getRole().equals("Customer")) {
                System.out.printf(" %-20s ", user.getUserName());
                System.out.printf("%-20s ", user.getUserId());
                System.out.printf("%-30s ", user.getMailId());
                System.out.printf("%-13d ", user.getPhoneNo());
                System.out.printf("%-20s ", user.getLocation());
                System.out.printf("%-6d\n", user.getPincode());
            }
        }
        System.out.print("============================================");    
        System.out.print("============================================");    
        System.out.println("============================================");    
    }
    
    /**
     * Shows all the admins to user
     *
     * @param users 
     */
    public void showAllAdmins(Map<String, User> users) {
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        System.out.printf(" %-20s %-20s ", "Name", "ID");
        System.out.printf("%-30s %-13s ", "Mail Id", "Phone No.");
        System.out.printf("%-20s %-6s\n", "Location","Pincode");
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        for(User user: users.values()) {
            if(user.getRole().equals("Admin")) {
            System.out.printf(" %-20s ", user.getUserName());
            System.out.printf("%-20s ", user.getUserId());
            System.out.printf("%-30s ", user.getMailId());
            System.out.printf("%-13d ", user.getPhoneNo());
            System.out.printf("%-20s ", user.getLocation());
            System.out.printf("%-6d\n", user.getPincode());
            }
        }
        System.out.print("============================================");    
        System.out.print("============================================");    
        System.out.println("============================================");    
    }
  
    /**
     * Shows the user details 
     *
     * @param users 
     */
    public void showUser(Map<String, User> users, String userId) {
        if(users.containsKey(userId)) {
            System.out.println(users.get(userId));
        } else {
            System.out.println("User ID doesn't exist!");
        }
    }
    
    /**
     * Shows the vegetables to user 
     *
     * @param vegetables as Set
     */    
    public void showVegetables(Set<Vegetable> vegetables) {
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        System.out.printf(" %-20s %-10s %-10s","Name","Price","Discount");
        System.out.printf(" %-12s %-12s\n","Prod. Date","Expiry Date");
        System.out.print("============================================");    
        System.out.print("============================================");    
        System.out.println("============================================");  
        for(Vegetable vegetable: vegetables) {  
            System.out.printf(" %-20s ", vegetable.getName());
            System.out.printf("%-10.2f ", vegetable.getPrice());
            System.out.printf("%-10.2f ", vegetable.getDiscount());
            System.out.printf("%-12s ", vegetable.getDateOfProduction());
            System.out.printf("%-12s\n", vegetable.getDateOfExpiry());
        }
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
    
    }

    /**
     * Shows the vegetables added in cart to user with amount calculation
     *
     * @param cart as Set
     */        
    public void showCart(Collection<ProductInCart> cart) {
        float totalAmountToPay = 0;
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        System.out.printf(" %-20s %-10s %-10s","Name","Quantity","Price/kg");
        System.out.printf(" %-10s ","Discount");
        System.out.printf(" %-13s %-13s","Prod. Date","Expiry Date");
        System.out.printf(" %-7s\n","Amount to Pay");
        System.out.print("============================================");    
        System.out.print("============================================");    
        System.out.println("============================================");  
        for(ProductInCart product: cart) {  
            System.out.printf(" %-20s ", product.getVegetable().getName());
            System.out.printf("%-10.2f ", product.getQuantity());
            System.out.printf("%-10.2f ", product.getVegetable().getPrice());
            System.out.printf("%-10.2f ", product.getVegetable().getDiscount());
            System.out.printf("%-13s ", product.getVegetable().getDateOfProduction());
            System.out.printf("%-13s ", product.getVegetable().getDateOfExpiry());
            System.out.printf("%-7.2f\n", product.getTotalPrice());            
            totalAmountToPay += product.getTotalPrice();
        }
        System.out.print("============================================");
        System.out.print("============================================");
        System.out.println("============================================");
        System.out.println("Total Amount to Pay: ");
        System.out.println(totalAmountToPay);
    }
}