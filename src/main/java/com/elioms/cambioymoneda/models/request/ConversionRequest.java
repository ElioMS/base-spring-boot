package com.elioms.cambioymoneda.models.request;

import lombok.Data;

@Data
public class ConversionRequest {
    private String fromCurrency;
    private String toCurrency;
}
