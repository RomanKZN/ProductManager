import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {



    Smartphone item1 = new Smartphone(01, "Nokia1", 2100, "Made in China");
    Smartphone item2 = new Smartphone(02, "Nokia2", 2200, "Made in Finland");
    Smartphone item3 = new Smartphone(03, "Nokia3", 2300, "Made in Sweden");
    Book item4 = new Book(04, "Book1", 21, "Author1");
    Book item5 = new Book(05, "Book2", 22, "Author2");
    Book item6 = new Book(06, "Book3", 23, "Author3");


    @Test
    public void shouldAddNewProducts() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        Product[] expected = {item1, item2, item3, item4, item5, item6};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddNewProductsAndRemove() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);


        Product[] expected = {item1,item2,item3};
        Product[] actual = manager.searchBy("Nokia");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void needToFindOneElement() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);


        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Nokia1");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void mustNotFindMoreThanOneElement() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);


        Product[] expected = {};
        Product[] actual = manager.searchBy("One");

        Assertions.assertArrayEquals(expected, actual);
    }

}

