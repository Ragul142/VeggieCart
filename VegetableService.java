import java.util.Collection;
import java.time.LocalDate;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * <VegetableService>  Service of Vegetable  of Vegetable buying app
 *
 * @version    JDK 1.8.0_341 05_Sep_2022
 * @author     Ragul_V
 */
public class VegetableService {
    private VegetableRepository vegetableRepository = new VegetableRepository();
    
    /**
     * pass the vegetable object to add in repository
     *
     * @param vegetable Vegetable object
     */    
    public boolean createVegetable(Vegetable vegetable) {
        return vegetableRepository.saveVegetable(vegetable);
    }

    /**
     * pass the vegetable object to remove in repository
     *
     * @param vegetable Vegetable object
     */    
    public boolean removeVegetable(Vegetable vegetable) {
        return vegetableRepository.deleteVegetable(vegetable);
    } 

    /**
     * pass the product object to add in repository
     *
     * @param product ProductInCart object
     */    
    public boolean addToCart(ProductInCart product) {
        return vegetableRepository.saveToCart(product);
    }

    /**
     * pass the product object to remove in repository
     *
     * @param product ProductInCart object
     */    
    public boolean removeFromCart(ProductInCart product) {
        return vegetableRepository.removeFromCart(product);
    } 

    /**
     * pass the vegetable collection to controller
     *
     * @return vegetables as Set
     */        
    public Set<Vegetable> getVegetables() {
        return vegetableRepository.getVegetables();
    }  

    /**
     * pass the cart collection to controller
     *
     * @return vegetables as Set
     */        
    public Collection<ProductInCart> getCart() {
        return vegetableRepository.getCart();
    }  

    /**
     * Check the Vegetable name whether in valid format which matches pattern
     *
     * @param vegetable name
     *
     * @return true if name is valid with pattern else false  
     */    
    public boolean isValidName(String name){
        return Pattern.matches("^[A-Z][a-zA-Z\\s]{3,30}$", name);
    }

    /**
     * Check the price whether price is greater than 0
     *
     * @param vegetable price 
     *
     * @return true if the price is greater than 0 else false
     */    
    public boolean isValidPrice(float price) {
        return (price > 0);
    }

    /**
     * Check the discount whether price is greater than or equal to 0 and also
     * less than or equal to 100
     *
     * @param vegetable discount
     *
     * @return true if condition satisfied else false
     */      
    public boolean isValidDiscount(float discount) {
        return (discount >= 0 && discount <= 100);
    }

    /**
     * Check the date whether in valid format which matches pattern
     *
     * @param date
     *
     * @return true if the date satisfied with pattern else false
     */        
    public boolean isValidDate(LocalDate date) {
        return Pattern.matches("^[2][0-2][0-9][0-9][-][0-1][0-9][-][0-3][0-9]$", date.toString());
    }
}