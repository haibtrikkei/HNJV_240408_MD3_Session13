package ra.demo_call_procedure.repository;

import ra.demo_call_procedure.model.entity.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findAll();
}
