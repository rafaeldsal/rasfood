package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders_itens")
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "registration_value")
  private BigDecimal registrationValue;

  private Integer quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  private Menu menu;

  @ManyToOne(fetch = FetchType.LAZY)
  private Order order;

  public OrderItem() {
  }

  public OrderItem(Integer quantity, Menu menu, Order order) {
    this.quantity = quantity;
    this.menu = menu;
    this.order = order;
    this.registrationValue = menu.getValue();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getRegistrationValue() {
    return registrationValue;
  }

  public void setRegistrationValue(BigDecimal registrationValue) {
    this.registrationValue = registrationValue;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public String toString() {
    return "OrderItem{" +
        "id=" + id +
        ", registrationValue=" + registrationValue +
        ", quantity=" + quantity +
        ", menu=" + menu +
        '}';
  }
}
