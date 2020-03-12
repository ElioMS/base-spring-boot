package com.elioms.cambioymoneda.services.transference;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.*;
import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.dto.BeneficiaryDto;
import com.elioms.cambioymoneda.models.dto.TransferenceDto;
import com.elioms.cambioymoneda.models.entity.*;
import com.elioms.cambioymoneda.models.request.CreateTransferRequest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TransferenceServiceImpl implements TransferenceService {

	@Autowired
	private ITransferenceDao iTransferenceDao;

	@Autowired
	private IBeneficiaryDao iBeneficiaryDao;

	@Autowired
	private ICurrencyTransferenceDao iCurrencyTransferenceDao;

	@Autowired
	private IBeneficiaryTransferDetailDao iBeneficiaryTransferDetailDao;

	@Autowired
	private IUserDao iUserDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Transference create(CreateTransferRequest transference) {

		var beneficiaries = transference.getBeneficiaries();
//		beneficiaries.forEach(beneficiary -> {
//			iBeneficiaryDao.findById(beneficiary.getId())
//					.orElseThrow(() -> new NotFoundException("Beneficiario no existe"));
//		});

		var newTransfer = new Transference();
		newTransfer.setType(transference.getType());
		newTransfer.setTotalAmount(transference.getTotalAmount());
		newTransfer.setStep(transference.getStep());
		newTransfer.setStatus(transference.getStatus());
//		newTransfer.setBeneficiaryTransferDetails(beneficiaries);
//		newTransfer.setBeneficiaries(transference.getBeneficiaries());
		newTransfer.setBankAccount(transference.getBankAccount());
		newTransfer.setCompany(transference.getCompany());

		Transference transfer = iTransferenceDao.save(newTransfer);

		createBeneficiaryDetails(beneficiaries, transfer);
		createCurrencyValues(transference.getCurrencyValues(), transfer);

		return newTransfer;
	}

	private void createBeneficiaryDetails(List<BeneficiaryTransferDetail> values, Transference transfer) {
		values.forEach(val -> {
			val.setTransference(transfer);
			iBeneficiaryTransferDetailDao.save(val);
		});
	}

	private void createCurrencyValues(List<CurrencyTransference> values, Transference transfer) {
		values.forEach(e -> {
			e.setCode(RandomStringUtils.randomAlphanumeric(10));
			e.setTransference(transfer);
			iCurrencyTransferenceDao.save(e);
		});
	}

	@Override
	public TransferenceDto findById(Long id) {
		var transfer = iTransferenceDao.findById(id)
				.orElseThrow(() -> new NotFoundException("La transferencia no existe"));

		return convertToDto(transfer);
	}

	private TransferenceDto convertToDto(Transference model) {
		return modelMapper.map(model, TransferenceDto.class);
	}

	@Override
	public List<Transference> findAll() {
		// TODO Auto-generated method stub
		return iTransferenceDao.findAll();
	}

	@Override
	public Page<Transference> history(int page, int size, String sortDir, String sort) {
		var auth = SecurityContextHolder.getContext().getAuthentication().getName();
		var user = iUserDao.findByEmail(auth);

		List<Long> companies = user.getCompanies().stream()
				.map(Company::getId)
				.collect(Collectors.toList());

		PageRequest pageReq
				= PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

		return iTransferenceDao.findByCompanyList(companies, pageReq);
	}

	@Override
	public List<Transference> lastTenTransference() {
		var auth = SecurityContextHolder.getContext().getAuthentication().getName();
		var user = iUserDao.findByEmail(auth);

		List<Long> companies = user.getCompanies().stream()
				.map(Company::getId)
				.collect(Collectors.toList());

		PageRequest pageReq
				= PageRequest.of(0, 10, Sort.Direction.fromString("DESC"), "id");

		return iTransferenceDao.findByCompanyList(companies, pageReq).getContent();
	}
}
