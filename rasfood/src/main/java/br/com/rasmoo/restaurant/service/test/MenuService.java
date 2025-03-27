package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.MenuDao;
import br.com.rasmoo.restaurant.utils.CargaDeDadosUtils;
import br.com.rasmoo.restaurant.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MenuService {

  public static void main(String[] args) {

    EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
    entityManager.getTransaction().begin();
    CargaDeDadosUtils.cadastrarCategorias(entityManager);
    CargaDeDadosUtils.cadastrarProdutosCardapio(entityManager);
    MenuDao menuDao = new MenuDao(entityManager);
    System.out.println("Lista de produtos por valor: " + menuDao.consultarPorPreco(BigDecimal.valueOf(59.00)));
    System.out.println("Produto pesquisado foi: " + menuDao.consultarPorNome("moqueca"));
    entityManager.close();
  }
}
