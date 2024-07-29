package ra.demo_call_procedure.service;

import ra.demo_call_procedure.model.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
}
