package com.example.cheeserestspring.entity;

/**
 * Created by Rintaspon on 25 April 2019
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Milk {
    private Long milkId;
    private String milkType;
    private double milkVolume;
}
