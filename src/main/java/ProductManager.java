public class ProductManager {

    private final ProductRepository repository;
    private ProductRepository repo;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProducts (Product productAdd) {
        repository.addProducts(productAdd);
            }

    public void removeById (int id) {
        repository.removeById(id);
    }

    public Product [] getSavedProducts () {
        return repository.getSavedProducts();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getSavedProducts()) {
            if (matches(product, text)) {
               Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }

}