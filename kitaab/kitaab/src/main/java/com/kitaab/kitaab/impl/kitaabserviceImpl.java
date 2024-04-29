package com.kitaab.kitaab.impl;

import com.kitaab.kitaab.entity.Kitaab;
import org.springframework.stereotype.Service;
import com.kitaab.kitaab.repository.kitaabRepository;
import com.kitaab.kitaab.service.kitaabservice;

import java.util.List;

@Service
public class kitaabserviceImpl implements kitaabservice {
    kitaabRepository KitaabRepository;

    public kitaabserviceImpl(kitaabRepository KitaabRepository){
        this.KitaabRepository = KitaabRepository;
    }
    @Override
    public String createKitaab(Kitaab kitaab){

        KitaabRepository.save(kitaab);
        return"Success";
    }
    @Override
    public String updateKitaab(Kitaab kitaab) {
        KitaabRepository.save(kitaab);
        return"Success";
    }
    @Override
    public String deleteKitaab(String kitaabId) {
        KitaabRepository.deleteById(kitaabId);
        return"success";
    }
    @Override
    public Kitaab getKitaab(String kitaabId){
        return KitaabRepository.findById(kitaabId).get();
    }
    @Override
    public List<Kitaab> getAllKitaab(){
        return (List<Kitaab>) KitaabRepository.findAll();
    }
}
