package br.com.rasmoo.restaurant.service.test;


import br.com.rasmoo.restaurant.dao.AddressDao;
import br.com.rasmoo.restaurant.dao.ClientDao;
import br.com.rasmoo.restaurant.entity.ClientId;
import br.com.rasmoo.restaurant.utils.CargaDeDadosUtils;
import br.com.rasmoo.restaurant.utils.JPAUtil;

import javax.persistence.EntityManager;

public class OrderService {

  public static void main(String[] args) {
    EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
    entityManager.getTransaction().begin();
    CargaDeDadosUtils.cadastrarCategorias(entityManager);
    CargaDeDadosUtils.cadastrarProdutosCardapio(entityManager);
    CargaDeDadosUtils.cadastrarClientes(entityManager);
    CargaDeDadosUtils.cadastrarOrdensClientes(entityManager);

    AddressDao addressDao = new AddressDao(entityManager);
    System.out.println(addressDao.consultarClientesUsandoCriteria(null, null, "lapa"));

    ClientDao clientDao = new ClientDao(entityManager);

    System.out.println(clientDao.consultarPorId(new ClientId("111111111111")));

    entityManager.getTransaction().commit();
    entityManager.close();
  }
}
