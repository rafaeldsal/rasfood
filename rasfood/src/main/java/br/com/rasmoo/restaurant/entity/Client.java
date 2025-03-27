package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

  @EmbeddedId
  private ClientId clientId;

  private String name;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  private List<Address> addressList = new ArrayList<>();

  public Client(String cpf, String name) {
    this.clientId = new ClientId(cpf);

    this.name = name;
  }

  public void addClientAddress(Address address) {
    address.setClient(this);
    this.addressList.add(address);
  }

  public Client() {
  }

  public String getCpf() {
    return clientId.getCpf();
  }

  public void setCpf(String cpf) {
    this.clientId.setCpf(cpf);
  }

  public String getName() {
    return name;
  }

  public List<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Client{" +
        ", cpf='" + clientId.getCpf() + '\'' +
        ", name='" + name + '\'' +
        ", addressList=" + addressList +
        '}';
  }
}
