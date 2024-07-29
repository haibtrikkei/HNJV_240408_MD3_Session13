package ra.demo_call_procedure.model.entity;

import java.util.Date;

public class Employee {
    private Integer empId;
    private String fullName;
    private Boolean gender;
    private Date birthday;
    private String address;
    private String depId;

    public Employee() {
    }

    public Employee(Integer empId, String fullName, Boolean gender, Date birthday, String address, String depId) {
        this.empId = empId;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.depId = depId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
