import java.util.Collection;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

/**
 * <VegetableController>  Controller of Vegetable  of Vegetable buying app
 *
 * @version    JDK 1.8.0_341 05_Sep_2022
 * @author     Ragul_V
 */

public class VegetableController {
    private Scanner scanner = new Scanner(System.in);
    private VegetableService vegetableService = new VegetableService();
    private View output = new View();

    /**
     * get Vegetable name from the user with the validation 
     */  
    public String getName() {
        String name;
        boolean check = true;
        do {
            System.out.println("Enter Vegetable name: ");
            name = scanner.nextLine();
            if(vegetableService.isValidName(name)) {
                check = false;
            } else {
                output.showInvalid(); 
            }
        } while(check);
        return name;
    }

    /**
     * get Vegetable price from the user with the validation 
     */      
    public float getPrice() {
        float price;
        boolean check = true;
        do {
            System.out.println("Enter Price(/kg):");
            price = scanner.nextFloat();
            if(vegetableService.isValidPrice(price)) {
                check = false;
            } else {
                output.showInvalid(); 
            }
        } while(check);
        return price;
    }

    /**
     * get Vegetable Discount from the user with the validation 
     */      
    public float getDiscount() {
        float discount;
        boolean check = true;
        do {
            System.out.println(("Enter Discount(%):"));
            discount = scanner.nextFloat();
            if(vegetableService.isValidDiscount(discount)) {
                check = false;
            } else {
                output.showInvalid(); 
            }
        } while(check);
        return discount;
    }

    /**
     * get Vegetable date of production from the user with the validation 
     */      
    public LocalDate getDateOfProduction() {
        LocalDate dateOfProduction;
        boolean check = true;
        do {
            System.out.println("Enter date of Production: (yyyy-mm-dd)");
            dateOfProduction = LocalDate.parse(scanner.next());
            if(vegetableService.isValidDate(dateOfProduction)) {
                check = false;
            } else {
                output.showInvalid(); 
            }
        } while(check);
        return dateOfProduction;
    }

    /**
     * get Vegetable date of production from the user with the validation 
     */          
    public LocalDate getDateOfExpiry() {
        LocalDate dateOfExpiry;
        boolean check = true;
        do {
            System.out.println("Enter date of Expiry: (yyyy-mm-dd)");
            dateOfExpiry = LocalDate.parse(scanner.next());
            if(vegetableService.isValidDate(dateOfExpiry)) {
                check = false;
            } else {
                output.showInvalid(); 
            }
        } while(check);
        return dateOfExpiry;
    }
    
    /**
     * Get the vegetable details to add in Vegetables collection
     */
    public void createVegetable() {       
        Vegetable vegetable = new Vegetable(getName(), getPrice(), 
                    getDiscount(),getDateOfExpiry(), getDateOfProduction());      
        if(vegetableService.createVegetable(vegetable)) {
            output.showSuccessfullyCreated();
        }
    }

    /**
     * Delete the vegetable from vegetables collection
     *
     * @param Vegetables
     * @param vegetable name
     */   
    public void deleteVegetable(Set<Vegetable> vegetables, String name) {
        for(Vegetable vegetable: vegetables) {
            if(vegetable.getName().equalsIgnoreCase(name)) {
                if (vegetableService.removeVegetable(vegetable)) {
                    output.showDeleted();
                }
            }    
        }
    }

    /**
     * pass the vegetable collection to controller
     *
     * @return vegetables as Set
     */        
    public Set<Vegetable> getVegetables() {
        return vegetableService.getVegetables();
    }   
    
    /**
     * add the products in cart 
     */
    public void addToCart() {
        float price;
        float discountedPrice;
        output.showVegetables(getVegetables());
        System.out.println("Enter Vegetable to Add in cart: ");
        String vegetableName = scanner.next();
        System.out.println("Enter the quantity: ");
        float quantity = scanner.nextFloat();
        ProductInCart product = new ProductInCart();
        for(Vegetable vegetable: getVegetables()) {
            if(vegetable.getName().equalsIgnoreCase(vegetableName)) {
                product.setVegetable(vegetable);
                product.setQuantity(quantity);
                price = vegetable.getPrice() * product.getQuantity();
                discountedPrice = price * (1 - (vegetable.getDiscount() / 100));
                product.setTotalPrice(discountedPrice);
            }
        }
        if(vegetableService.addToCart(product)) {
            output.showSuccessfullyAdded();
        } else {
            output.showInvalid();
        }
    }
    
    /**
     * view the vegetables added in cart
     */
    public void viewCart() {
        output.showCart(vegetableService.getCart());
    }
    
    /**
     * Removes the vegetable from cart
     */
    public void removeVegetableFromCart() {
        System.out.println("Enter Vegetable to Remove from cart: ");
        String vegetableName = scanner.next();
        for(ProductInCart product: vegetableService.getCart()) {
            if(product.getVegetable().getName().equalsIgnoreCase(vegetableName)) {
                if(vegetableService.removeFromCart(product))
                    output.showDeleted();
            }
        }
    }
    /**
     * Shows the menu options for Admin to add, remove, edit vegetables 
     */ 
    public void displayVegetableInnerMenu() {
        int option;
        boolean flag = true;
        do {   
            System.out.println("\n1. Create Vegetable\n2. Read Vegetable");
            System.out.println("3. Update Vegetable\n4. Delete Vegetable");
            System.out.println("0. Exit to back Menu");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    createVegetable();
                    break;
                
                case 2:
                    output.showVegetables(vegetableService.getVegetables());
                    break;
                
                case 3:
                    updateVegetable();
                    break;
                
                case 4:
                    deleteVegetable(vegetableService.getVegetables(),scanner.next());
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
     * Update the profile of the user
     *
     * @param userId 
     */
    public void updateVegetable() {
        for(Vegetable vegetable: vegetableService.getVegetables()) {
            String name = scanner.next();
            if(vegetable.getName().equalsIgnoreCase(name)) {
                int option = scanner.nextInt();
                switch(option) {
                    case 1:
                        vegetable.setName(getName());
                        break;
                        
                    case 2:
                        vegetable.setPrice(getPrice());
                        break;

                    case 3:
                        vegetable.setDiscount(getDiscount());
                        break;

                    case 4:
                        vegetable.setDateOfProduction(getDateOfProduction());
                        break;
                    
                    case 5:
                        vegetable.setDateOfExpiry(getDateOfExpiry());
                        break;

                    default:
                        output.showInvalid();
                }
                output.showSuccessfullyUpdated();
            }
        }
    }    
}