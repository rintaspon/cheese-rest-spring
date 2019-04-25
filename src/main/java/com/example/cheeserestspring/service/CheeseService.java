package com.example.cheeserestspring.service;

/**
 * Created by Rintaspon on 25 April 2019
 */

import com.example.cheeserestspring.entity.Cheese;
import com.example.cheeserestspring.entity.Milk;

public interface CheeseService {
    Cheese makeCheese(Milk milk);
}
