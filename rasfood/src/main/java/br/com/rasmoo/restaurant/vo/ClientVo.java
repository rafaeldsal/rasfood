package br.com.rasmoo.restaurant.vo;

public class ClientVo {

  private String cpf;

  private String name;

  public ClientVo(String cpf, String name) {
    this.cpf = cpf;
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "ClientVo{" +
        "cpf='" + cpf + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
