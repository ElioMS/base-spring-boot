package com.elioms.cambioymoneda.models.request;

import lombok.Data;

@Data
public class FavoriteCurrencyTypeRequest {

    private Long purchaseCurrencyId;
    private Long salesCurrencyId;
    private Float value;

}
