package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Client;
import br.com.rasmoo.restaurant.entity.ClientId;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {

  private EntityManager entityManager;

  public ClientDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final Client client) {
    this.entityManager.persist(client);
  }

  public Client consultarPorId(final ClientId id) {
    return this.entityManager.find(Client.class, id);
  }

  public List<Client> consultarTodos() {
    String sql = "SELECT c FROM Client c";
    return this.entityManager.createQuery(sql, Client.class).getResultList();
  }

  public List<Client> consultarPorNome(final String name) {
    String jpql = "SELECT c FROM Client c WHERE LOWER(c.name) LIKE LOWER(:name)";
    return this.entityManager.createQuery(jpql, Client.class).setParameter("name", "%"+ name +"%").getResultList();
  }

  public void atualizar(final Client client) {
    this.entityManager.merge(client);
  }

  public void excluir(final Client client) {
    this.entityManager.remove(client);
  }
}
