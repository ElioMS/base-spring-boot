package com.elioms.cambioymoneda.models;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CountryCSV {

    @CsvBindByName
    private String name;
}
