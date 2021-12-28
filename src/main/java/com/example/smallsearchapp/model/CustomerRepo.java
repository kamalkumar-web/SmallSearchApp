package com.example.smallsearchapp.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<CustomerDetails, Long> {
	public List<CustomerDetails> findByfirstName(String firstName);

	public List<CustomerDetails> findBylastName(String lastName);

	@Query("from myentity where lower(first_name) like lower(concat(:firstName,'%'))")
	public List<CustomerDetails> findByFirstNameCustomized(@Param("firstName") String firstName);

	@Query("from myentity where lower(last_name) like lower(concat(:lastName,'%'))")
	public List<CustomerDetails> findByLastNameCustomized(@Param("lastName") String lastName);
	
	@Query("from myentity where lower(first_name) like lower(concat(:firstName,'%')) and lower(last_name) like lower(concat(:lastName,'%'))")
	public List<CustomerDetails> findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}