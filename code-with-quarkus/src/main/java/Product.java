import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

// We have to annotate this class with @ManagedBean so that the object can be accessed in index.html file
// This ManagedBean creates an object of product and the name of that object will be "obj", but we can use any over name
@Named("obj")
// The scope of the object is through the session ( qusetion: what does it mean? )
@SessionScoped
// This class is responsible for adding our data into the DB
public class Product implements Serializable {

    private String name;
    private int quantity;
    private double price;

    // Constructor
    public Product(){
    }

    // Getters and setters
    // -------------------

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    // -------------------

    // This method is used to add data into DB, but for now we just print it
    public String add(){
        System.out.println("Product inserted");
        System.out.println(name + " " + this.quantity + " " + price);

        // Here we return success.xhtml as result
        return "success";
    }
}
