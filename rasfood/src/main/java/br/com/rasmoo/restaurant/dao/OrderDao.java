package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Order;
import br.com.rasmoo.restaurant.vo.MainItemsVo;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDao {

  private EntityManager entityManager;

  public OrderDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final Order order) {
    this.entityManager.persist(order);
  }

  public Order consultarPorId(final Integer id) {
    return this.entityManager.find(Order.class, id);
  }

  public List<Order> consultarTodos() {
    String jpql = "SELECT c FROM Order c";
    return this.entityManager.createQuery(jpql, Order.class).getResultList();
  }

  public Order joinFetchClient(final Integer id) {
    String jpql = "SELECT o FROM Order o JOIN FETCH o.client WHERE o.id = :id";
    return this.entityManager.createQuery(jpql, Order.class).setParameter("id", id).getSingleResult();
  }

  public List<MainItemsVo> consultarItensMaisVendidos() {
    String jpql = "SELECT new br.com.rasmoo.restaurant.vo.MainItemsVo(" +
        "m.name, SUM(oi.quantity)) FROM Order o " +
        "JOIN OrderItem oi ON o.id = oi.menu.id " +
        "JOIN oi.menu m " +
        "GROUP BY m.name " +
        "ORDER BY SUM(oi.quantity) DESC";
    return this.entityManager.createQuery(jpql, MainItemsVo.class).getResultList();
  }

  public void atualizar(final Order order) {
    this.entityManager.merge(order);
  }

  public void excluir(final Order order) {
    this.entityManager.remove(order);
  }
}
