package com.example.cheeserestspring.controller;

/**
 * Created by Rintaspon on 25 April 2019
 */

import com.example.cheeserestspring.entity.Cheese;
import com.example.cheeserestspring.entity.Milk;
import com.example.cheeserestspring.entity.MilkDTO;
import com.example.cheeserestspring.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheeseController {

    @Autowired
    CheeseService cheeseService;

    // =====================================================
    //              Post + @RequestBody Example
    // =====================================================
    //      Request Url: localhost:8080/post-cheese
    // -----------------------------------------------------
    //      Input milkDTO json format:
    // -----------------------------------------------------
    //        {
    //    	      "milkType": "Cow's milk",
    //    	      "milkVolume": "123.6"
    //        }
    // -----------------------------------------------------
    //        or
    // -----------------------------------------------------
    //        {
    //    	      "milkType": "Goat's milk",
    //    	      "milkVolume": "123.6"
    //        }

    @CrossOrigin
    @PostMapping("/post-cheese")
    public ResponseEntity<?> getCheese(@RequestBody MilkDTO milkDTO) {
        try {
            Milk milk = convertToEntity(milkDTO);
            Cheese cheese = cheeseService.makeCheese(milk);
            if (cheese == null) {
                return new ResponseEntity<>("Can't produce cheese because we don't know " + milk.getMilkType(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ResponseEntity.ok(cheese);
        } catch (NullPointerException n) {
            return new ResponseEntity<>("DTO contains null value", HttpStatus.BAD_REQUEST);
        } catch (NumberFormatException n) {
            return new ResponseEntity<>("Milk volume can't be non-numeric value", HttpStatus.BAD_REQUEST);
        }
    }

    private Milk convertToEntity(MilkDTO milkDTO) throws NullPointerException, NumberFormatException {
        Milk milkEntity = Milk
                .builder()
                .milkId(Long.valueOf((int) (Math.random() * 100)))
                .milkType(milkDTO.getMilkType())
                .milkVolume(Double.parseDouble(milkDTO.getMilkVolume()))
                .build();
        return milkEntity;
    }

}
