package com.mehedidev.bmicalculator.controller;

public class HealthSuggestionModel {
//    constant field
    public static final double CORRECT_WEIGHT_MIN_VAL = 18.5d;
    public static final double CORRECT_WEIGHT_MAX_VAL = 24.9d;
    public static final double HIGH_WEIGHT_MAX_VAL = 29.9d;
/*
* Note: if bmi is less than correctWeightMinVal then person has low weight
* if bmi is greater than highWeightMaxVal then person has very high weight means
* the person is very fat
*  */
// array index constant
    public static final int BAD_HEALTH = 0;
    public static final int GOOD_HEALTH = 1;
    public static final int FAT_HEALTH = 2;
    public static final int VERY_FATTY_HEALTH = 3;

    public static final String[] suggestions = {
            "You have very low weight. You are not healthy person. You should eat more.",
            "You have right weight. You are healthy.",
            "Your weight is bigger than correct weight. You should maintain diet.",
            "Buhh! You are very fat. You are not healthy. Please contact with a doctor and maintain diet.",
    };

}
