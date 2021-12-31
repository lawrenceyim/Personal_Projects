
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Lawrence Yim
 */
public class Product {
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    
    Product() {
        
    }
    
    Product(String name, double price) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }
    
    public void setPrice(double price) {
        this.price.set(price);
        return;
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public String getName() {
        return name.get();
    }
}
