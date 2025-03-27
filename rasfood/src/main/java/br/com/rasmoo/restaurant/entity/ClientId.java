package br.com.rasmoo.restaurant.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

public class ClientId  implements Serializable {

  private String cpf;

  public ClientId() {
  }

  public ClientId(String cpf) {
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "ClientId{" +
        "cpf='" + cpf + '\'' +
        '}';
  }
}
