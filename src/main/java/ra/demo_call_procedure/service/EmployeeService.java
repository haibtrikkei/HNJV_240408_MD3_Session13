package ra.demo_call_procedure.service;

import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(Integer empId);
    boolean save(Employee emp);
    boolean update(Employee emp);
    boolean delete(Integer empId);
    List<EmployeeDTO> findByName(String empName);
}
