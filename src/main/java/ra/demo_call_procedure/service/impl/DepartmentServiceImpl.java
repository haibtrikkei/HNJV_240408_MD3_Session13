package ra.demo_call_procedure.service.impl;

import ra.demo_call_procedure.model.entity.Department;
import ra.demo_call_procedure.repository.impl.DepartmentRepositoryImpl;
import ra.demo_call_procedure.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<Department> findAll() {
        return new DepartmentRepositoryImpl().findAll();
    }
}
