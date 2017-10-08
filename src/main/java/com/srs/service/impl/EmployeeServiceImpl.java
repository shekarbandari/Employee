package com.srs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srs.bean.EmployeeBean;
import com.srs.dao.EmployeeDAO;
import com.srs.model.EmployeeDO;
import com.srs.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void addEmployeeInfo(EmployeeBean empBean) {
		EmployeeDO empDO=new EmployeeDO();
		empDO.setEmpId(empBean.getEmpId());
		
		empDO.setFirstName(empBean.getFirstName());
		empDO.setLastName(empBean.getLastName());
		empDO.setMiddleName(empBean.getMiddleName());
		empDO.setLocation(empBean.getLocation());
		empDO.setDesignation(empBean.getDesignation());
		
		employeeDAO.addEmployeeInfo(empDO);
		
		
		
		
		// TODO Auto-generated method stub
		
	}

}
