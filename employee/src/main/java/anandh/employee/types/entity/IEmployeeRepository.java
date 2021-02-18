package anandh.employee.types.entity;

import anandh.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Employee getByCode(String code);
}
