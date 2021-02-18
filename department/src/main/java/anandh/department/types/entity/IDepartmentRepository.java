package anandh.department.types.entity;

import anandh.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDepartmentRepository extends JpaRepository<Department, Long> {
    Department getByName(String name);
}
