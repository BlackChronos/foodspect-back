package com.github.blackchronos.foodspect_back.core.product.model;

public record Nutrition(
        Float energyCCal,
        Float protein,
        Float fat,
        Float saturatedFat,
        Float carbs,
        Float sugars,
        Float fibre,
        Float sodium
) {}
