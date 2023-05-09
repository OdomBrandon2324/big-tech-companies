package com.brandonodom.bigtechcompanies.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brandonodom.bigtechcompanies.models.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	List<Company> findAll();

}
