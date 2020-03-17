package com.elioms.cambioymoneda.services.transference;

import java.util.List;

import com.elioms.cambioymoneda.models.dto.TransferenceDto;
import com.elioms.cambioymoneda.models.entity.Transference;
import com.elioms.cambioymoneda.models.request.CreateTransferRequest;
import com.elioms.cambioymoneda.models.request.UpdateTransferenceRequest;
import org.springframework.data.domain.Page;

public interface TransferenceService {
	
	List<Transference> findAll();

	Page<Transference> history(int page, int size, String sortDir, String sort);

	List<Transference> lastTenTransference();
	
	TransferenceDto findById(Long id);
	
    Transference create(CreateTransferRequest transference);
    Transference update(UpdateTransferenceRequest transference, Long id);

}
