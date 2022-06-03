package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public class Categoryimpl implements CategoryService {

    @Override
    public void add(Category category) {

    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }
}
