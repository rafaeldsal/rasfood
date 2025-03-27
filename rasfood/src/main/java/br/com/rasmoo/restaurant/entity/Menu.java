package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String description;

  private Boolean available;

  @Column(name = "price")
  private BigDecimal value;

  @Column(name = "registration_date")
  private LocalDateTime registrationDate = LocalDateTime.now();

  /*
    ManyToOne
    ManyToMany
    OneToMany
    OneToOne

    esquerda = classe que você está To direta = Classe na qual você está relacionando
   */

  @ManyToOne(fetch = FetchType.LAZY)
  private Category categories;


  public Menu() {
  }

  public Menu(Integer id, String name, String description, Boolean available, BigDecimal value, LocalDateTime registrationDate) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.available = available;
    this.value = value;
    this.registrationDate = registrationDate;
  }

  public Menu(String name, String description, Boolean available, BigDecimal value, Category categories) {
    this.categories = categories;
    this.value = value;
    this.available = available;
    this.description = description;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public Category getCategories() {
    return categories;
  }

  public void setCategories(Category categories) {
    this.categories = categories;
  }

  @Override
  public String toString() {
    return "Menu{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", available=" + available +
        ", value=" + value +
        ", registrationDate=" + registrationDate +
        ", categories=" + categories +
        '}';
  }
}
