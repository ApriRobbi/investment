package com.invest.investment.produk.repository;

import com.invest.investment.produk.entity.ProdukEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<ProdukEntity, Long> {
}
