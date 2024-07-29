package ra.demo_call_procedure.model.entity;

public class Department {
    private String depId;
    private String depName;
    private Boolean status;

    public Department() {
    }

    public Department(String depId, String depName, Boolean status) {
        this.depId = depId;
        this.depName = depName;
        this.status = status;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
