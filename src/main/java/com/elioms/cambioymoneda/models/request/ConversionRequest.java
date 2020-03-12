package com.elioms.cambioymoneda.models.request;

import lombok.Data;

@Data
public class ConversionRequest {

    private Float inAmmount;
    private String fromCurrency;
    private String toCurrency;
    private Float currencyValue;


}
