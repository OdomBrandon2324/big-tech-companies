package com.brandonodom.bigtechcompanies.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandonodom.bigtechcompanies.models.Company;
import com.brandonodom.bigtechcompanies.repositories.CompanyRepository;



@Service
public class CompanyService {
	@Autowired
	 private CompanyRepository companyRepository;

    // ----- FIND ALL -----
    public List<Company> allCompanys() {
        return companyRepository.findAll();
    }

    // ----- FIND ONE -----
    public Company findCompany(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            return optionalCompany.get();
        }
        return null;
    }

    // ----- CREATE -----
    public Company createCompany(Company newCompany) {
        return companyRepository.save(newCompany);
    }

    // ----- UPDATE -----
    public Company updateCompany(Company oneCompany) {
        return companyRepository.save(oneCompany);
    }

    // ----- DELETE -----
    public void removeCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
