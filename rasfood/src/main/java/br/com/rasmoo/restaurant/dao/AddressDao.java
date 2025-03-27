package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Address;
import br.com.rasmoo.restaurant.vo.ClientVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class AddressDao {

  private EntityManager entityManager;

  public AddressDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final Address address) {
    this.entityManager.persist(address);
  }

  public Address consultaPorId(final Integer id) {
    return this.entityManager.find(Address.class, id);
  }

  public List<Address> consultarTodos() {
    try {
      String jpql = "SELECT a FROM Address a";
      return this.entityManager.createQuery(jpql, Address.class).getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public List<ClientVo> consultarClientes(final String state, final String city, final String street) {

    String jpql = "SELECT new br.com.rasmoo.restaurant.vo.ClientVo(a.client.clientId.cpf, a.client.name) " +
        "FROM Address a WHERE 1=1";

    if (Objects.nonNull(state)) {
      jpql = jpql.concat("AND UPPER(a.state) = UPPER(:state) ");
    }

    if (Objects.nonNull(city)) {
      jpql = jpql.concat("AND UPPER(a.city) = UPPER(:city) ");
    }

    if (Objects.nonNull(street)) {
      jpql = jpql.concat("AND UPPER(a.street) = UPPER(:street) ");
    }

    TypedQuery typedQuery = this.entityManager.createQuery(jpql, ClientVo.class);

    if (Objects.nonNull(state)) {
      typedQuery.setParameter("state", state);
    }

    if (Objects.nonNull(city)) {
      typedQuery.setParameter("city", city);
    }

    if (Objects.nonNull(street)) {
      typedQuery.setParameter("street", street);
    }

    return typedQuery.getResultList();
  }

  public List<ClientVo> consultarClientesUsandoCriteria(final String state, final String city, final String street) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<ClientVo> criteriaQuery = builder.createQuery(ClientVo.class);

    Root<Address> root = criteriaQuery.from(Address.class);
    criteriaQuery.multiselect(root.get("client").get("clientId").get("cpf"), root.get("client").get("name"));

    Predicate predicate = builder.and();

    if (Objects.nonNull(state)) {
      predicate = builder.and(predicate, builder.equal(builder.upper(root.get("state")), state.toUpperCase()));
    }

    if (Objects.nonNull(city)) {
      predicate = builder.and(predicate, builder.equal(builder.upper(root.get("city")), city.toUpperCase()));
    }

    if (Objects.nonNull(street)) {
      predicate = builder.and(predicate, builder.equal(builder.upper(root.get("street")), street.toUpperCase()));
    }

    criteriaQuery.where(predicate);

    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  public void atualizar(final Address address) {
    this.entityManager.merge(address);
  }

  public void excluir(final Address address) {
    this.entityManager.remove(address);
  }
}
