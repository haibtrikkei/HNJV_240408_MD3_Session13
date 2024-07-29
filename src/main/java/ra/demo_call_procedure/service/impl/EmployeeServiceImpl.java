package ra.demo_call_procedure.service.impl;

import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.model.entity.Employee;
import ra.demo_call_procedure.repository.impl.EmployeeReposityImpl;
import ra.demo_call_procedure.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<EmployeeDTO> findAll() {
        return new EmployeeReposityImpl().findAll();
    }

    @Override
    public EmployeeDTO findById(Integer empId) {
        return new EmployeeReposityImpl().findById(empId);
    }

    @Override
    public boolean save(Employee emp) {
        return new EmployeeReposityImpl().save(emp);
    }

    @Override
    public boolean update(Employee emp) {
        return new EmployeeReposityImpl().update(emp);
    }

    @Override
    public boolean delete(Integer empId) {
        return new EmployeeReposityImpl().delete(empId);
    }

    @Override
    public List<EmployeeDTO> findByName(String empName) {
        return new EmployeeReposityImpl().findByName(empName);
    }
}
