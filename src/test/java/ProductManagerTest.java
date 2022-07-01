import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {


    Product item1 = new Product(01, "Book1", 10);
    Product item2 = new Product(02, "Book2", 15);
    Product item3 = new Product(03, "Book3", 20);
    Product item4 = new Product(04, "Nokia", 2000);
    Product item5 = new Smartphone(04,"Nokia",2000, "Made in China");
    Product item6 = new Book (04,"Book1",20, "Author1");



    @Test
    public void shouldAddNewProducts() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addProducts(item1);
        manager.addProducts(item2);
        manager.addProducts(item3);
        manager.addProducts(item4);
        manager.addProducts(item5);
        manager.addProducts(item6);
        Product[] expected = {item1,item2, item3,item4,item5,item6};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddNewProductsAndRemove() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addProducts(item1);
        manager.addProducts(item2);
        manager.addProducts(item3);
        manager.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfItemIsPresent () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addProducts(item1);
        manager.addProducts(item2);
        manager.addProducts(item3);
        manager.searchBy("Book2");

        Product [] expected = {item2};
        Product [] actual = manager.searchBy("Book2");

        Assertions.assertArrayEquals(expected, actual);
    }

}

