package com.example.springbootwebsocket.entity;

import javax.persistence.*;

@Entity
@Table(name = "all_products")
public class ProductEntity {

  private Long prodId;
  private String prodName;
  private String ProdDesc;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getProdId() {
    return prodId;
  }

  public void setProdId(Long prodId) {
    this.prodId = prodId;
  }

  @Column
  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  @Column
  public String getProdDesc() {
    return ProdDesc;
  }

  public void setProdDesc(String prodDesc) {
    ProdDesc = prodDesc;
  }
}
