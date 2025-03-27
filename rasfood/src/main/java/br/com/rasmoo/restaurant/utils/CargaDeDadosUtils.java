package br.com.rasmoo.restaurant.utils;

import br.com.rasmoo.restaurant.dao.*;
import br.com.rasmoo.restaurant.entity.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtils {

  private CargaDeDadosUtils() {}

  public static void cadastrarCategorias(EntityManager entityManager) {
    Category entrada = new Category("Entradas");
    Category salada = new Category("Saladas");
    Category principal = new Category("Pratos Principais");

    CategoryDao categoryDao = new CategoryDao(entityManager);

    categoryDao.cadastrar(entrada);
    entityManager.flush();
    categoryDao.cadastrar(salada);
    entityManager.flush();
    categoryDao.cadastrar(principal);
    entityManager.flush();
    entityManager.clear();
  }

  public static void cadastrarProdutosCardapio(EntityManager entityManager) {

    MenuDao menuDao = new MenuDao(entityManager);
    CategoryDao categoryDao = new CategoryDao(entityManager);

    List<Category> categorias = categoryDao.consultarTodos();

    Menu moqueca = new Menu("Moqueca", "Peixe branco, banana da terra, arroz e farofa",
        true, BigDecimal.valueOf(95.00), categorias.get(2));
    Menu spaguetti = new Menu("Spaguetti", "Spagatti ao molho de parmesão e cogumelos",
        true, BigDecimal.valueOf(68.00), categorias.get(2));
    Menu bife = new Menu("Bife", "Bife acebolado com arroz branco, farofa e batata frita",
        true, BigDecimal.valueOf(59.00), categorias.get(2));
    Menu cordeiro = new Menu("Cordeiro", "Cordeiro com risoto de funghi",
        true, BigDecimal.valueOf(88.00), categorias.get(2));
    Menu burrata = new Menu("Burrata", "Tomates queimados, rúcula e torrada",
        true, BigDecimal.valueOf(15.00), categorias.get(0));
    Menu bruschetta = new Menu("Bruschetta", "Tomate, mucarela e manjericao",
        true, BigDecimal.valueOf(20.00), categorias.get(0));
    Menu scappeta = new Menu("Scappeta", "Ragu de linguica e torradinhas",
        true, BigDecimal.valueOf(25.00), categorias.get(0));
    Menu caprese = new Menu("Caprese", "Mini rucula e mucarela",
        true, BigDecimal.valueOf(47.00), categorias.get(1));
    Menu caesar = new Menu("Caesar", "Salada de franco com molho ceasar",
        true, BigDecimal.valueOf(40.00), categorias.get(1));
    Menu chevre = new Menu("Chevre", "Mix de folhas, mostarda e mel",
        true, BigDecimal.valueOf(59.00), categorias.get(1));


    menuDao.cadastrar(moqueca);
    menuDao.cadastrar(spaguetti);
    menuDao.cadastrar(bife);
    menuDao.cadastrar(cordeiro);
    menuDao.cadastrar(burrata);
    menuDao.cadastrar(bruschetta);
    menuDao.cadastrar(scappeta);
    menuDao.cadastrar(caprese);
    menuDao.cadastrar(caesar);
    menuDao.cadastrar(chevre);

    entityManager.flush();
    entityManager.clear();
  }

  public static void cadastrarClientes(EntityManager entityManager) {
    ClientDao clientDao = new ClientDao(entityManager);
    AddressDao addressDao = new AddressDao(entityManager);

    Address augusta = new Address("0000000", "augusta", "casa 43", "Sao Paulo", "SP");
    Client felipe = new Client("12345678901","Felipe Ribeiro");
    felipe.addClientAddress(augusta);

    Address rioVermelho = new Address("000000001","Lapa","apto 1001","Salvador","BA");
    Client cleber = new Client("111111111111","Cleber Machado");
    cleber.addClientAddress(rioVermelho);

    Address leblon = new Address("000000002","Lapa","apto 203","Rio de Janeiro","RJ");
    Client calvin = new Client("09876543210","Calvin Coelho");
    calvin.addClientAddress(leblon);

    Address heitorPenteado = new Address("000000000","Heitor Penteado","apto 101","Santos","SP");
    Client tayane = new Client("111111111123","Tayane Lopes Costa");
    tayane.addClientAddress(heitorPenteado);

    Address consolacao = new Address("000000000","Lapa","apto 1001","Sao Paulo","SP");
    Client denise = new Client("111111111145","Denise Costa");
    denise.addClientAddress(consolacao);

    Address nacoesUnidas = new Address("000000000","NacoesUnidas","casa 27","Sao Paulo","SP");
    Client claudia = new Client("111111111345","Claudia Rosa");
    claudia.addClientAddress(nacoesUnidas);

    addressDao.cadastrar(augusta);
    clientDao.cadastrar(felipe);
    addressDao.cadastrar(rioVermelho);
    clientDao.cadastrar(cleber);
    addressDao.cadastrar(leblon);
    clientDao.cadastrar(calvin);
    addressDao.cadastrar(heitorPenteado);
    clientDao.cadastrar(tayane);
    addressDao.cadastrar(consolacao);
    clientDao.cadastrar(denise);
    addressDao.cadastrar(nacoesUnidas);
    clientDao.cadastrar(claudia);

    entityManager.flush();
    entityManager.clear();
  }

  public static void cadastrarOrdensClientes(EntityManager entityManager) {
    ClientDao clientDao = new ClientDao(entityManager);
    MenuDao menuDao = new MenuDao(entityManager);
    OrderDao orderDao = new OrderDao(entityManager);
    List<Client> clients = clientDao.consultarTodos();
    List<Menu> menus = menuDao.consultarTodos();

    Order ordemFelipe = new Order(clients.get(0));
    ordemFelipe.addOrdersMenu(new OrderItem(2, menus.get(0), ordemFelipe));
    ordemFelipe.addOrdersMenu(new OrderItem(3, menus.get(5), ordemFelipe));

    Order ordemCleber = new Order(clients.get(1));
    ordemCleber.addOrdersMenu(new OrderItem(1, menus.get(0), ordemCleber));
    ordemCleber.addOrdersMenu(new OrderItem(2, menus.get(1), ordemCleber));
    ordemCleber.addOrdersMenu(new OrderItem(3, menus.get(6), ordemCleber));

    Order ordemCalvin = new Order(clients.get(2));
    ordemCalvin.addOrdersMenu(new OrderItem(2, menus.get(2), ordemCalvin));
    ordemCalvin.addOrdersMenu(new OrderItem(3, menus.get(9), ordemCalvin));

    Order ordemTayane = new Order(clients.get(3));
    ordemTayane.addOrdersMenu(new OrderItem(2, menus.get(0), ordemTayane));
    ordemTayane.addOrdersMenu(new OrderItem(3, menus.get(2), ordemTayane));

    Order ordemDenise = new Order(clients.get(4));
    ordemDenise.addOrdersMenu(new OrderItem(2, menus.get(4), ordemDenise));
    ordemDenise.addOrdersMenu(new OrderItem(1, menus.get(3), ordemDenise));

    Order ordemClaudia = new Order(clients.get(5));
    ordemClaudia.addOrdersMenu(new OrderItem(2, menus.get(3), ordemClaudia));
    ordemClaudia.addOrdersMenu(new OrderItem(3, menus.get(5), ordemClaudia));

    orderDao.cadastrar(ordemFelipe);
    orderDao.cadastrar(ordemCleber);
    orderDao.cadastrar(ordemCalvin);
    orderDao.cadastrar(ordemTayane);
    orderDao.cadastrar(ordemDenise);
    orderDao.cadastrar(ordemClaudia);

    entityManager.flush();
    entityManager.clear();
  }

}
