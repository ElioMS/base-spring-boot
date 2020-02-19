package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dto.BankDto;
import com.elioms.cambioymoneda.models.entity.Bank;
import com.elioms.cambioymoneda.models.dao.IBankDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private IBankDao IBankDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BankDto> findAll() {

        List<Bank> banks = (List<Bank>) IBankDao.findAll();

        return banks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BankDto save(Bank bank) {
        return convertToDto(IBankDao.save(bank));
    }

    @Override
    public BankDto findById(Long id) throws NotFoundException {
        return convertToDto(IBankDao.findById(id).orElseThrow(
                () -> new NotFoundException("Banco no encontrado")
        ));
//        return IBankDao.findById(id).orElseThrow(
//                () -> new NotFoundException("Banco no encontrado")
//        );
    }

    private BankDto convertToDto(Bank bank) {
        return modelMapper.map(bank, BankDto.class);
    }
}
