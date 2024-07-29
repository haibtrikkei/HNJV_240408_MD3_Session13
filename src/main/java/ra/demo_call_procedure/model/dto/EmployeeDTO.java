package ra.demo_call_procedure.model.dto;

import ra.demo_call_procedure.model.entity.Employee;

import java.util.Date;

public class EmployeeDTO extends Employee {
    private String depName;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer empId, String fullName, Boolean gender, Date birthday, String address, String depId, String depName) {
        super(empId, fullName, gender, birthday, address, depId);
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
