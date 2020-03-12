package com.elioms.cambioymoneda.models.dto;

import com.elioms.cambioymoneda.models.entity.City;
import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.entity.Country;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
public class BeneficiaryListDto implements Serializable {

    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Country Country;

}
