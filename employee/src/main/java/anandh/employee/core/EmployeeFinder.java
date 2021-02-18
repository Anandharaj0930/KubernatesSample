package anandh.employee.core;

import anandh.employee.entity.Employee;
import anandh.employee.exception.EmployeeExternalException;
import anandh.employee.exception.EmployeeGetException;
import anandh.employee.types.Department;
import anandh.employee.types.GetDepartmentResponse;
import anandh.employee.types.GetEmployeeResponse;
import anandh.employee.types.core.IEmployeeFinder;
import anandh.employee.types.entity.IEmployeeRepository;
import anandh.employee.types.external.IExternalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeFinder implements IEmployeeFinder {

    private IExternalClient externalClient;
    private IEmployeeRepository employeeRepository;

    @Override
    public GetEmployeeResponse getEmployee(String code) {
        GetEmployeeResponse employeeResponse = new GetEmployeeResponse();
        try {
            Employee employee = employeeRepository.getByCode(code);
            GetDepartmentResponse dept = getDept(employee.getDeptName());
            Department department = buildDept(dept);
            employeeResponse.setEmpCode(employee.getCode());
            employeeResponse.setEmpDOB(employee.getDob());
            employeeResponse.setEmpName(employee.getName());
            employeeResponse.setDeptDetails(department);
        } catch (Exception ex) {
            buildDefaultResponse(employeeResponse);
            GetDepartmentResponse dept = getDept("Admin");
            Department department = buildDept(dept);
            employeeResponse.setDeptDetails(department);
        }
        return employeeResponse;
    }

    private void buildDefaultResponse(GetEmployeeResponse response) {
        response.setEmpName("Anandh");
        response.setEmpDOB("12/11/2020");
        response.setEmpCode("Emp1");
    }

    private Department buildDept(GetDepartmentResponse dept) {
        Department department = new Department();
        department.setLocation(dept.getLocation());
        department.setName(dept.getName());
        department.setProcess(dept.getProcess());
        return department;
    }


    public GetDepartmentResponse getDept(String name) {
        GetDepartmentResponse department = null;
        try {
            final String uri = "http://localhost:8083/dept/{name}";
            Map<String, String> params = new HashMap();
            params.put("name", name);
            department = (GetDepartmentResponse) externalClient.getMethod(uri, GetDepartmentResponse.class, params);
            if (!"ok".equalsIgnoreCase(department.getStatus().getStatusMsg())) {
                throw new EmployeeGetException();
            }
        } catch (Exception ex) {
            throw new EmployeeExternalException();
        }
        return department;
    }

    @Autowired
    public void setExternalClient(IExternalClient externalClient) {
        this.externalClient = externalClient;
    }

    @Autowired
    public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
