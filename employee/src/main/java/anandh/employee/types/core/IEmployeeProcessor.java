package anandh.employee.types.core;

import anandh.employee.types.EmployeeRequest;
import anandh.employee.types.EmployeeResponse;

public interface IEmployeeProcessor {
    EmployeeResponse createEmployee(EmployeeRequest request);
}
