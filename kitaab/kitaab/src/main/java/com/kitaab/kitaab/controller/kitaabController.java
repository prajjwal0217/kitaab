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
    
    @GetMapping({"/{kitaabId}"})
    public Kitaab getKitaabDetails(@PathVariable("kitaabId") String kitaabId){
        return KitaabService.getKitaab(kitaabId);
    }
    
    @GetMapping("/getall")
    public List<Kitaab> getAllKitaabDetails(){
        return KitaabService.getAllKitaab();
    }
    
    @PostMapping("/add")
    public String createKitaabDetails(@RequestBody Kitaab kitaab){
        return KitaabService.createKitaab(kitaab);
        //return "Kitaab created successfully";
    }
    
    @PutMapping("/updatekitaab")
    public String updateKitaabDetails(@RequestBody Kitaab kitaab){
       return KitaabService.updateKitaab(kitaab);
        //return "Kitaab updated Successfully";
    }
    
    @DeleteMapping("delete/{kitaabId}")
    public String deleteKitaabdetails(@PathVariable("kitaabId") String kitaabId){
        return KitaabService.deleteKitaab(kitaabId);
        //return " kitaab deleted successfully";
    }
}
