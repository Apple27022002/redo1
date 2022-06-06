package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductServiceimpl implements ProductService {
    List<Product> products;

    public ProductServiceimpl(List<Product> products) {
        this.products = products;
    }

    public ProductServiceimpl() {
        products = new ArrayList<>();
        products.add(new Product(1,"manh"));
        products.add(new Product(2,"huy"));
        products.add(new Product(3,"bic"));
        products.add(new Product(4,"hoa"));
        products.add(new Product(5,"long"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);

    }

    @Override
    public int findIndexById(int id) {
        int indexOf =-1;
        for(int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                return i;
            }
        }return indexOf;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList =new ArrayList<>();
        for (int i=0;i<products.size();i++){
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                productList.add(products.get(i));
            }
         }return productList;
    }

    @Override
    public void update(int id, Product product) {
        int indexOf =findIndexById((id));
        products.set(indexOf,product);

    }

    @Override
    public void delete(int id) {
        int indexOf =findIndexById(id);
        products.remove(id);

    }

    @Override
    public void update(Product product) {

    }

}

