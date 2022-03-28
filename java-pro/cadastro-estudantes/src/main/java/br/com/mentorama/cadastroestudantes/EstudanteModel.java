package br.com.mentorama.cadastroestudantes;

public class EstudanteModel {

  private Integer id;
  private String name;
  private String age;

  public EstudanteModel(Integer id, String name, String age) {
    this.id = id;
    this.name = name;
    this.age = age;
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

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}