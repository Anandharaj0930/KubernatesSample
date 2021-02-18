package anandh.employee.types;

public class EmployeeResponse {

    private String employeeCode;
    private String description;
    private Error error;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "employeeCode='" + employeeCode + '\'' +
                ", description='" + description + '\'' +
                ", error=" + error +
                '}';
    }
}
