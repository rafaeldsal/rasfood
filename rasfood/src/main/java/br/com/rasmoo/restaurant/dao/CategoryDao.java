package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

  private EntityManager entityManager;

  public CategoryDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final Category category) {
    this.entityManager.persist(category);
  }

  public Category consultarPorId(final Integer id) {
    return this.entityManager.find(Category.class, id);
  }

  public List<Category> consultarTodos() {
    String sql = "SELECT c FROM Category c";
    return this.entityManager.createQuery(sql, Category.class).getResultList();
  }

  public void atualizar(final Category category) {
    this.entityManager.merge(category);
  }

  public void excluir(final Category category) {
    this.entityManager.remove(category);
  }
}
