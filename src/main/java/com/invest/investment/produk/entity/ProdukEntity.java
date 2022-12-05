package com.invest.investment.produk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "produk")
public class ProdukEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_produk", nullable = false)
    private String namaProduk;

    @Column(name = "deskripsi_produk", nullable = false)
    private String deskripsi;

    @Column(name = "harga_produk_string", nullable = false)
    private String harga;
}
