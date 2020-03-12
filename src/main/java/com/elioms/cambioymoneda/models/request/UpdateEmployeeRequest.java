package com.elioms.cambioymoneda.models.request;

import com.elioms.cambioymoneda.models.entity.Privilege;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateEmployeeRequest {

    @NotEmpty(message = "El campo email es requerido")
    private String email;

    @NotEmpty(message = "El campo celular 1 es requerido")
    private String firstCellphone;

    private String secondCellphone;

    @NotEmpty(message = "El campo teléfono es requerido")
    private String phoneNumber;

    @NotNull
    private Boolean status;

    @NotEmpty(message = "El campo privilegios es requerido")
    private List<Privilege> privileges;

    private Integer companyId;

}
