package Products;

import java.io.Serializable;

public class ProductQuantity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Product product;
    private int quantity;

    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getDetails() {
        return this.product.getDetails() + '\n' +
                "Quantity: " + this.getQuantity();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }    
}