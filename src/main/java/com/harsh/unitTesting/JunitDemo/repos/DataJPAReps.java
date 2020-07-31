package com.harsh.unitTesting.JunitDemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.unitTesting.JunitDemo.model.DataEntityExample;

public interface DataJPAReps extends JpaRepository<DataEntityExample, Integer> {

}
