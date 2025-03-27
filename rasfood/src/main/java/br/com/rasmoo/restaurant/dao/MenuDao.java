package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Menu;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class MenuDao {

  private EntityManager entityManager;

  public MenuDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final Menu menu) {
    this.entityManager.persist(menu);
  }

  public Menu consultarPorId(final Integer id) {
    return this.entityManager.find(Menu.class, id);
  }

  public Menu consultarPorNome(final String name) {
    try {
      String jpql = "SELECT m FROM Menu m WHERE UPPER(m.name) = UPPER(:name)";

      return this.entityManager.createQuery(jpql, Menu.class).setParameter("name", name).getSingleResult();

    } catch (Exception e) {
      return null;
    }
  }

  public List<Menu> consultarTodos() {
    try {
      String jpql = "SELECT m FROM Menu m";

      return this.entityManager.createQuery(jpql, Menu.class).getResultList();

    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  public List<Menu> consultarPorPreco(final BigDecimal value) {
    try {
      String jpql = "SELECT m FROM Menu m WHERE m.value = :value";

      return this.entityManager.createQuery(jpql, Menu.class).setParameter("value", value).getResultList();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  public void atualizar(final Menu menu) {
    this.entityManager.merge(menu);
  }

  public void excluir(final Menu menu) {
    this.entityManager.remove(menu);
  }

}
