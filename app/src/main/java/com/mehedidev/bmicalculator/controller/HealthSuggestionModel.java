package com.mehedidev.bmicalculator.controller;

public class HealthSuggestionModel {
//    constant field
    public static final double correctWeightMinVal = 18.5d;
    public static final double correctWeightMaxVal = 24.9d;
    public static final double highWeightMinVal = 25d;
    public static final double highWeightMaxVal = 29.9d;
/*
* Note: if bmi is less than correctWeightMinVal then person has low weight
* if bmi is greater than highWeightMaxVal then person has very high weight means
* the person is very fat
*  */
// array index constant
    public static final int badHealth = 0;
    public static final int goodHealth = 1;
    public static final int fatHealth = 2;
    public static final int veryFattyHealth = 3;

    public static final String[] suggestion = {
            "You have very low weight. You should eat more.",
            "You have right weight. You are healthy.",
            "Your weight is bigger than correct weight. You should maintain diet.",
            "Buhh! You are very fat. You are not healthy. Please contact with a doctor and maintain diet.",
    };

}
