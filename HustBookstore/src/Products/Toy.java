package Products;

public class Toy extends Product{
	
    private static final long serialVersionUID = 1L;
    private String brand;

    public Toy(String name, double price, String description, String brand) {
        super(name, price, description);
        this.brand = brand != null ? brand : "";
    }
    @Override
    public String getDetails() {
        return "Toy [" + this.getProductID() + "] :\n" + 
                "Name: " + this.getName() + '\n' + 
                "Price: " + this.getPrice() + '\n' + 
                "Description: " + this.getDescription() + '\n' + 
                "Brand: " + this.getBrand()
                ;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public boolean equals(Object otherobj) {
        if (this == otherobj) return true; // the same reference
        if (otherobj == null || getClass() != otherobj.getClass()) return false; // null or different class
        Toy othertoy = (Toy) otherobj; //
        return this.getProductID() == othertoy.getProductID() && 
				this.getName().equals(othertoy.getName()) && 
				this.getPrice() == othertoy.getPrice() && 
				this.getDescription().equals(othertoy.getDescription()) && 
                this.getBrand().equals(othertoy.getBrand())
                ;
    }
}