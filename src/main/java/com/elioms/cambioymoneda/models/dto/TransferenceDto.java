package com.elioms.cambioymoneda.models.dto;

import java.io.Serializable;
import java.util.List;

import com.elioms.cambioymoneda.models.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class TransferenceDto {
	
	private Long id;
	private Float totalAmount;

	@JsonIgnoreProperties({"transference"})
	private List<BeneficiaryTransferDetail> beneficiaryTransferDetails;
	
	@JsonIgnoreProperties({"transference"})
	private List<CurrencyTransference> currencyTransferences; 

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BankAccount bankAccount;

}
