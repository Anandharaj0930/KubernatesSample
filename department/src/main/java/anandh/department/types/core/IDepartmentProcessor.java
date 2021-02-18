package anandh.department.types.core;

import anandh.department.types.DepartmentRequest;
import anandh.department.types.DepartmentResponse;

public interface IDepartmentProcessor {

    DepartmentResponse createDept(DepartmentRequest request);
}
