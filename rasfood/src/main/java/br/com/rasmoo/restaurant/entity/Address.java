package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String cep;
  private String street;
  private String complement;
  private String city;
  private String state;

  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;

  public Address() {
  }

  public Address(String cep, String street, String complement, String city, String state) {
    this.cep = cep;
    this.street = street;
    this.complement = complement;
    this.city = city;
    this.state = state;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "Address{" +
        "id=" + id +
        ", cep='" + cep + '\'' +
        ", street='" + street + '\'' +
        ", complement='" + complement + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        '}';
  }
}
