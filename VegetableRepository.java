import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collection;
import java.util.LinkedList;
/**
 * <VegetableRepository>  Repository of Vegetable  of Vegetable buying app
 *
 * @version    JDK 1.8.0_341 05_Sep_2022
 * @author     Ragul_V
 */
public class VegetableRepository {
    private Set<Vegetable> vegetables = new LinkedHashSet<>();
    private Collection<ProductInCart> cart = new LinkedList<>();
    
    /**
     * add the vegetable object in the vegetables collection
     *
     * @param vegetable  Vegetable class object
     *
     * @return true if added else false
     */    
    public boolean saveVegetable(Vegetable vegetable) {
        return vegetables.add(vegetable);
    }

    /**
     * remove the vegetable object in the vegetables collection
     *
     * @param vegetable  Vegetable class object
     *
     * @return true if removed else false
     */    
    public boolean deleteVegetable(Vegetable vegetable) {
        return vegetables.remove(vegetable);
    }

    /**
     * add the vegetable object in the vegetables collection
     *
     * @param vegetable  Vegetable class object
     *
     * @return true if added else false
     */    
    public boolean saveToCart(ProductInCart product) {
        return cart.add(product);
    }

    /**
     * remove the vegetable object in the vegetables collection
     *
     * @param vegetable  Vegetable class object
     *
     * @return true if removed else false
     */    
    public boolean removeFromCart(ProductInCart product) {
        return cart.remove(product);
    }
        
    /**
     * pass the vegetables collections
     *
     * @return vegetables as Set 
     */        
    public Set<Vegetable> getVegetables() {
        return vegetables;
    }

    /**
     * pass the cart collections
     *
     * @return vegetables as Set 
     */        
    public Collection<ProductInCart> getCart() {
        return cart;
    }
}