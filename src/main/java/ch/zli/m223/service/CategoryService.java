package ch.zli.m223.service;

import ch.zli.m223.model.Category;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    public List<Category> findAll() {
        return entityManager.createQuery("FROM Category", Category.class).getResultList();
    }

    @Transactional
    public Category updateCategory(Category category) {
        return entityManager.merge(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
    }
}
