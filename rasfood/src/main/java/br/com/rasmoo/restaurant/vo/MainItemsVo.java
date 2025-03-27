package br.com.rasmoo.restaurant.vo;

public class MainItemsVo {

  private String name;
  private Long quantity;


  public MainItemsVo(String name, Long quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "MainItemsVo{" +
        "name='" + name + '\'' +
        ", quantity=" + quantity +
        '}';
  }
}
