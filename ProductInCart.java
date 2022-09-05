/**
 * <User>      POJO Class of Product In cart
 *
 * @version    JDK 1.8.0_341 05_Sep_2022
 * @author     Ragul_V
 */
public class ProductInCart {
    private float quantity;
    private float totalPrice;
    private Vegetable vegetable;
    
    public Vegetable getVegetable() {
        return vegetable;
    }
    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }
    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}