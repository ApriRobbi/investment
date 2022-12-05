package com.invest.investment.produk.service;

import com.invest.investment.exception.PermintaanTidakDikabulkanException;
import com.invest.investment.exception.ServerError;
import com.invest.investment.exception.TidakKetemuException;
import com.invest.investment.produk.entity.ProdukEntity;
import com.invest.investment.produk.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    // MENCARI SEMUA PRODUK
    public List<ProdukEntity> cariSemua(){
        return produkRepository.findAll();
    }

    // MENCARI MELALUI ID
    public ProdukEntity cariDariId(Long id){
        return produkRepository.findById(id)
                .orElseThrow(() -> new TidakKetemuException("PRODUK DENGAN ID " + id + " TIDAK TERDETEKSI"));
    }

    // CREATE PRODUK
    public ProdukEntity menambahProduk(ProdukEntity produkEntity){
        // MELAKUKAN VALIDASI MANUAL

        if(!StringUtils.hasText(produkEntity.getNamaProduk())){ //KALAU DIA TIDAK PUNYA TEXT NAMA PRODUK, MAKA:
            throw new PermintaanTidakDikabulkanException("NAMA PRODUK TIDAK BOLEH KOSONG");
        }
        if (!StringUtils.hasText(produkEntity.getDeskripsi())){
            throw new PermintaanTidakDikabulkanException("DESKRIPSI PRODUK TIDAK BOLEH KOSONG");
        }
        if (!StringUtils.hasText(produkEntity.getHarga())){
            throw new PermintaanTidakDikabulkanException("HARGA PRODUK TIDAK BOLEH KOSONG");
        }

        return produkRepository.save(produkEntity);
        // kenapa ID tidak dilakukan validasi? karena ID memang sudah di set sebagai auto
    }

    // UPDATE PRODUK
    public ProdukEntity updateProduk(ProdukEntity produkEntity, Long produkId){
        // AMBIL PRODUK YANG MAU DI UPDATE DENGAN ID
        ProdukEntity produk = produkRepository.findById(produkId).get();

        //lakukan validasi
        if(produkEntity.getId() == null){ //KALAU DIA TIDAK PUNYA TEXT NAMA PRODUK, MAKA:
            throw new PermintaanTidakDikabulkanException("PRODUK ID YANG DI EDIT GABOLEH DIEDIT BLOK");
        }
        if(!StringUtils.hasText(produkEntity.getNamaProduk())){ //KALAU DIA TIDAK PUNYA TEXT NAMA PRODUK, MAKA:
            throw new PermintaanTidakDikabulkanException("NAMA PRODUK TIDAK BOLEH KOSONG");
        }
        if (!StringUtils.hasText(produkEntity.getDeskripsi())){
            throw new PermintaanTidakDikabulkanException("DESKRIPSI PRODUK TIDAK BOLEH KOSONG");
        }
        if (!StringUtils.hasText(produkEntity.getHarga())){
            throw new PermintaanTidakDikabulkanException("HARGA PRODUK TIDAK BOLEH KOSONG");
        }


        return produkRepository.save(produkEntity);

    }

    //DELETE

    public void deleteById(Long id){
        produkRepository.deleteById(id);
    }
}
