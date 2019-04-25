package com.example.cheeserestspring.entity;

/**
 * Created by Rintaspon on 25 April 2019
 */

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MilkDTO {
    private String milkType;
    private String milkVolume;
}
