package anandh.department.core;

import anandh.department.entity.Department;
import anandh.department.exception.DepartmentCoreException;
import anandh.department.types.DepartmentRequest;
import anandh.department.types.DepartmentResponse;
import anandh.department.types.Status;
import anandh.department.types.core.IDepartmentProcessor;
import anandh.department.types.entity.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DepartmentProcessor implements IDepartmentProcessor {

    private IDepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDept(DepartmentRequest request) {
        DepartmentResponse response = new DepartmentResponse();
        Department departmentEntity = buildEntity(request);
        try {
            Department department = departmentRepository.save(departmentEntity);
            response.setDeptName(department.getName());
            response.setDescription("Department Persisted Successfully");
        } catch (Exception ex) {
            throw new DepartmentCoreException();
        }
        Status status = buildSuccessStatus();
        response.setStatus(status);
        return response;
    }

    private Department buildEntity(DepartmentRequest request) {
        Department entity = new Department();
        entity.setLocation(request.getLocation());
        entity.setName(request.getName());
        entity.setProcess(request.getProcess());
        return entity;
    }

    Status buildSuccessStatus() {
        Status status = new Status();
        status.setStatusCode(String.valueOf(HttpStatus.OK.value()));
        status.setStatusMsg(HttpStatus.OK.getReasonPhrase());
        return status;
    }

    @Autowired
    public void setDepartmentRepository(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
