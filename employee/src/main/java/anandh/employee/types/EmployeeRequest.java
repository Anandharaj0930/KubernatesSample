package anandh.employee.types;

import java.io.Serializable;

public class EmployeeRequest implements Serializable {

    private String employeeName;
    private String employeeAge;
    private String empDob;
    private Department dept;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmpDob() {
        return empDob;
    }

    public void setEmpDob(String empDob) {
        this.empDob = empDob;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeAge='" + employeeAge + '\'' +
                ", empDob='" + empDob + '\'' +
                ", dept=" + dept +
                '}';
    }
}
