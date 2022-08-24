import models.Pants;
import models.Product;
import models.Shirt;

public class Main {

    static final String FILE_NAME = "products.txt";

    public static void main(String[] args) {

        Shirt shirt = new Shirt("Small", 20.00, "Black", "Nike");

        Pants pants = new Pants(32, 24.99, "Blue", "Java");

        Shirt shirt2 = new Shirt(shirt);
        Pants pants2 = new Pants(pants);

        shirt2.setColor("Green");
        System.out.println(shirt.equals(shirt2));
        System.out.println(pants.equals(pants2));
    }

    /**
     * Function Name: getData
     * 
     * @return Product[]
     * @throws FileNotFoundException
     * 
     *                               Inside the function:
     *                               1. Loads the data from products.txt
     */
}
