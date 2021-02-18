package anandh.employee.types;

public class GetEmployeeResponse {
    private String empCode;
    private String empName;
    private String empDOB;
    private Department deptDetails;
    private Error error;

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(String empDOB) {
        this.empDOB = empDOB;
    }

    public Department getDeptDetails() {
        return deptDetails;
    }

    public void setDeptDetails(Department deptDetails) {
        this.deptDetails = deptDetails;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "GetEmployeeResponse{" +
                "empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                ", empDOB='" + empDOB + '\'' +
                ", deptDetails=" + deptDetails +
                ", error=" + error +
                '}';
    }
}
