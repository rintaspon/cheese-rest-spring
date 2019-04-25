package com.example.cheeserestspring.service;

/**
 * Created by Rintaspon on 25 April 2019
 */

import com.example.cheeserestspring.entity.Cheese;
import com.example.cheeserestspring.entity.Milk;
import org.springframework.stereotype.Service;

@Service
public class CheeseServiceImpl implements CheeseService {
    @Override
    public Cheese makeCheese(Milk milk) {
        Cheese cheese = null;
        if ("Cow's milk".equals(milk.getMilkType())) {
            cheese = Cheese.builder()
                    .cheeseId(Long.valueOf((int) (Math.random() * 100)))
                    .cheeseType("Cheddar")
                    .cheeseWeight(calculateCheeseWeight(milk.getMilkVolume()))
                    .build();
        } else if ("Goat's milk".equals(milk.getMilkType())) {
            cheese = Cheese.builder()
                    .cheeseId(Long.valueOf((int) (Math.random() * 100)))
                    .cheeseType("Gouda")
                    .cheeseWeight(calculateCheeseWeight(milk.getMilkVolume()))
                    .build();
        }
        return cheese;
    }

    private double calculateCheeseWeight(double milkVolume) {
        return milkVolume * 2.313; // Random magic number
    }
}
