package com.kitaab.kitaab.controller;

import com.kitaab.kitaab.entity.Kitaab;
import org.springframework.web.bind.annotation.*;
import com.kitaab.kitaab.service.kitaabservice;

import java.util.List;

@RestController
@RequestMapping("/kitaab")
public class kitaabController {
    
    kitaabservice KitaabService;
    
    @Autowired
    public kitaabController(kitaabservice kitaabService) {
        this.KitaabService = kitaabService;
    }
    @GetMapping("/{kitaabId}")
    public Kitaab getKitaabDetails(@PathVariable("kitaabId") String kitaabId){
        return KitaabService.getKitaab(kitaabId);
    }
    @GetMapping()
    public List<Kitaab> getAllKitaabDetails(){
        return KitaabService.getAllKitaab();
    }
    @PostMapping
    public String createKitaabDetails(@RequestBody Kitaab kitaab){
        KitaabService.createKitaab(kitaab);
        return "Kitaab created successfully";
    }
    @PutMapping
    public String updateKitaabDetails(@RequestBody Kitaab kitaab){
        KitaabService.updateKitaab(kitaab);
        return "Kitaab updated Successfully";
    }
    @DeleteMapping("{kitaabId}")
    public String deleteKitaabdetails(@PathVariable("kitaabId")String kitaabId){
        KitaabService.deleteKitaab(kitaabId);
        return " kitaab deleted successfully";
    }
}
