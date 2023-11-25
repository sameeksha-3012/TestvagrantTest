import java.util.ArrayList;

class Product {
    String productName;
    double unitCost;
    double gstRate;
    int quantity;

    public Product(String productName, double unitCost, double gstRate, int quantity) {
        this.productName = productName;
        this.unitCost = unitCost;
        this.gstRate = gstRate;
        this.quantity = quantity;
    }

    public double calculateTotalCost() {
        return unitCost * quantity;
    }

    public double calculateGSTAmount() {
        return calculateTotalCost() * (gstRate / 100.0);
    }
}

public class Test{
    public static void main(String[] args) {

        ArrayList<Product> basket = new ArrayList<>();
        basket.add(new Product("Leather Wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));


        Product maxGSTProduct = basket.get(0);
        double maxGSTAmount = maxGSTProduct.calculateGSTAmount();

        for (Product product : basket) {
            double currentGSTAmount = product.calculateGSTAmount();
            if (currentGSTAmount > maxGSTAmount) {
                maxGSTAmount = currentGSTAmount;
                maxGSTProduct = product;
            }
        }

        System.out.println("\n\n\tProduct with Maximum GST Amount: " + maxGSTProduct.productName);

       
        double totalAmountToPay = 0;
        for (Product product : basket) {
            totalAmountToPay += product.calculateTotalCost();
        }

        System.out.println("\n\n\tTotal Amount to be Paid: " + totalAmountToPay);
    }
}
