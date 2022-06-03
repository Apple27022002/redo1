package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    public void add(Category category);

    public Category findById(int id);

    public List<Category> findAll();

    public boolean delete(int id);

    public boolean update(Category category) throws SQLException;

    List<Category> findByName(String name);
}
