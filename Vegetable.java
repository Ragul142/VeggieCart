import java.time.LocalDate;

/**
 * <Vegetable> POJO Class of Vegetable  
 *
 * @version    JDK 1.8.0_341 05_Sep_2022
 * @author     Ragul_V
 */
public class Vegetable {
    private float price;
    private float discount;
    private String name;
    private LocalDate dateOfExpiry;
    private LocalDate dateOfProduction;
    
    Vegetable(String name, float price, float discount,
               LocalDate dateOfExpiry, LocalDate dateOfProduction) {
        this.price = price ;
        this.discount = discount;
        this.name = name;
        this.dateOfExpiry = dateOfExpiry;
        this.dateOfProduction = dateOfProduction;
    }
    
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }
    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
    
    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }
    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n1. Name: ").append(name) 
                .append("\n2. Price: ").append(price)
                .append("\n3. Discount: ").append(discount) 
                .append("\n4. Date of Production: ").append(dateOfProduction)
                .append("\n5. Date of Expiry: ").append(dateOfExpiry);
        return stringBuilder.toString();
    }
}