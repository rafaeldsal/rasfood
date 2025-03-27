package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "total_value")
  private BigDecimal totalValue = BigDecimal.ZERO;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();

  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  public Order(Client client) {
    this.client = client;
  }

  public Order() {
  }

  public void addOrdersMenu(OrderItem orderItem) {
    orderItem.setOrder(this);
    this.orderItems.add(orderItem);

    this.totalValue = totalValue.add(orderItem.getRegistrationValue().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(BigDecimal totalValue) {
    this.totalValue = totalValue;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", totalValue=" + totalValue +
        ", createdAt=" + createdAt +
        ", client=" + client +
        ", orderItems=" + orderItems +
        '}';
  }
}
