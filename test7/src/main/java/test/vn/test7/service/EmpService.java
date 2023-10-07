package test.vn.test7.service;

import test.vn.test7.entity.EmployeeEntity;

import java.util.List;

public interface EmpService  {
    public EmployeeEntity saveEmp(EmployeeEntity employeeEntity);
    public List<EmployeeEntity> getAllEmp();
    public EmployeeEntity getEmpById(int id);
    public boolean deleteEmp(int id);
}
