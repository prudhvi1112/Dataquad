package com.dataquad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataquad.model.AdminModel;

@Repository
public interface AdminDao extends JpaRepository<AdminModel, String>
{

}
