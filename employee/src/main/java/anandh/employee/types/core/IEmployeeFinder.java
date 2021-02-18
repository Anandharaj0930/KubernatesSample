package anandh.employee.types.core;

import anandh.employee.types.GetEmployeeResponse;

public interface IEmployeeFinder {

    GetEmployeeResponse getEmployee(String code);
}
