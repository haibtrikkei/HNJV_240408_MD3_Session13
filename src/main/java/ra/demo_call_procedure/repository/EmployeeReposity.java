package ra.demo_call_procedure.repository;

import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.model.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeReposity {
    List<EmployeeDTO> findAll() throws SQLException;
    EmployeeDTO findById(Integer empId);
    boolean save(Employee emp);
    boolean update(Employee emp);
    boolean delete(Integer empId);
    List<EmployeeDTO> findByName(String empName);
}
