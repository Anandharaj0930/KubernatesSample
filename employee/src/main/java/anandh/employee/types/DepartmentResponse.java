package anandh.employee.types;

import java.lang.Error;

public class DepartmentResponse {
    private String deptName;
    private String description;
    private Status status;
    private Error error;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "DepartmentResponse{" +
                "deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", error=" + error +
                '}';
    }
}
