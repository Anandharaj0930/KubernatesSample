package anandh.employee.core;

import anandh.employee.entity.Employee;
import anandh.employee.exception.EmployeeCoreException;
import anandh.employee.exception.EmployeeExternalException;
import anandh.employee.exception.EmployeeGetException;
import anandh.employee.types.Department;
import anandh.employee.types.DepartmentResponse;
import anandh.employee.types.EmployeeRequest;
import anandh.employee.types.EmployeeResponse;
import anandh.employee.types.core.IBuildCode;
import anandh.employee.types.core.IEmployeeProcessor;
import anandh.employee.types.entity.IEmployeeRepository;
import anandh.employee.types.external.IExternalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProcessor implements IEmployeeProcessor {

    private IBuildCode buildEmpCode;
    private IEmployeeRepository employeeRepository;
    private IExternalClient externalClient;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee;
        try {
            employee = buildEntity(request);
            employeeRepository.save(employee);
            saveDept(request.getDept());
            employeeResponse.setEmployeeCode(employee.getCode());
            employeeResponse.setDescription("Employee Persisted Successfully");
        } catch (Exception ex) {
            throw new EmployeeCoreException();
        }
        return employeeResponse;
    }

    private Employee buildEntity(EmployeeRequest employeeRequest) {
        Employee entity = new Employee();
        entity.setCode(buildEmpCode.buildCode());
        entity.setDob(employeeRequest.getEmpDob());
        entity.setName(employeeRequest.getEmployeeName());
        entity.setDeptName(employeeRequest.getDept().getName());
        return entity;
    }

    public void saveDept(Department request) {
        try {
            final String uri = "http://localhost:8083/dept";
            DepartmentResponse department = (DepartmentResponse) externalClient.postMethod(uri, request, DepartmentResponse.class);
            if (!"ok".equalsIgnoreCase(department.getStatus().getStatusMsg())) {
                throw new EmployeeGetException();
            }
        } catch (Exception ex) {
            throw new EmployeeExternalException();
        }

    }

    @Autowired
    public void setBuildEmpCode(IBuildCode buildEmpCode) {
        this.buildEmpCode = buildEmpCode;
    }

    @Autowired
    public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setExternalClient(IExternalClient externalClient) {
        this.externalClient = externalClient;
    }
}

