package com.example.numis.services;

import com.example.numis.domain.models.Coin;
import com.example.numis.domain.repository.ICoinRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PictureService {
    private final ICoinRepository _coinRepo;

    public PictureService(ICoinRepository coinRepo){
        _coinRepo = coinRepo;
    }
    public void saveImage(MultipartFile file) throws IOException{
        Coin coin = new Coin();
        coin.setPicture(file.getBytes());
        _coinRepo.save(coin);
    }
    public byte[] getImageById(Long id){
        Optional<Coin> optionalCoin = _coinRepo.findById(id);
        return optionalCoin.map(Coin::getPicture).orElse(null);
    }
}
