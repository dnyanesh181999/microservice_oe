package com.cjc.loanapplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.loanapplication.model.Enquiry;
@Repository
public interface OeRepository extends CrudRepository<Enquiry, Integer>{

	public List<Enquiry> findAllByRemark(String string);

}
