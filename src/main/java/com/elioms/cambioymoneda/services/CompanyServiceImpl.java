package com.elioms.cambioymoneda.services;

import com.elioms.cambioymoneda.models.entity.Company;
import com.elioms.cambioymoneda.models.dao.CompanyRepository;
import com.elioms.cambioymoneda.models.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
