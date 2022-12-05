package com.invest.investment.produk.controller;

import com.invest.investment.produk.entity.ProdukEntity;
import com.invest.investment.produk.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    //METHOD CARI SEMUA PRODUK
    @GetMapping("/produk")
    public List<ProdukEntity> cariSemua(){
        return produkService.cariSemua();
    }

    // METHOD CARI BY ID
    @GetMapping("/produk/{id}")
    public ProdukEntity cariDariId(@PathVariable("id") Long id){
        return produkService.cariDariId(id);
    }

    // METHOD CREATE PRODUK
    @PostMapping("/produk")
    public ProdukEntity tambahProduk(@RequestBody ProdukEntity produkEntity){
        return produkService.menambahProduk(produkEntity);
    }

    //METHOD EDIT
    @PutMapping("/produk/{id}")
    public ProdukEntity editProduk(@PathVariable("id") Long produkId, @RequestBody ProdukEntity produkEntity){
        return produkService.updateProduk(produkEntity, produkId);
    }

    @DeleteMapping("/produk/{id}")
    public void deleteDariId(@PathVariable("id") Long produkId){
        produkService.deleteById(produkId);
    }
}

