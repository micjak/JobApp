package com.mj.jobapp.domain.joboffer;

import lombok.Getter;


public enum JobOfferCategory {

    IT("IT"),
    FOOD_AND_DRINKS("Food & drinks"),
    OFFICE("Office"),
    COURIER("Courier"),
    SHOP_ASSISTANT("Shop assistant");

    @Getter
    String offerTypeName;

    JobOfferCategory(String offerTypeName) {
        this.offerTypeName = offerTypeName;
    }

}
