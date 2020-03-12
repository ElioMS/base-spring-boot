package com.elioms.cambioymoneda.models.response;

import com.elioms.cambioymoneda.models.entity.Beneficiary;
import lombok.Data;

@Data
public class MessageBodyResponse {
    private Beneficiary data;
}
