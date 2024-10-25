package com.dataquad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataquad.model.ExcelDataModel;

@Repository
public interface ExcelDataDao extends JpaRepository<ExcelDataModel, String>
{

}
