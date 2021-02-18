package anandh.department.types.core;

import anandh.department.types.GetDepartmentResponse;

public interface IDepartmentFinder {
    GetDepartmentResponse getDept(String name);
}
