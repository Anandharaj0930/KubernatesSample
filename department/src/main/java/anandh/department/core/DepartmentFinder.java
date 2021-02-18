package anandh.department.core;

import anandh.department.entity.Department;
import anandh.department.types.GetDepartmentResponse;
import anandh.department.types.Status;
import anandh.department.types.core.IDepartmentFinder;
import anandh.department.types.entity.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DepartmentFinder implements IDepartmentFinder {

    private IDepartmentRepository departmentRepository;

    @Override
    public GetDepartmentResponse getDept(String name) {
        GetDepartmentResponse response = new GetDepartmentResponse();
        Department department = null;
        try {
            department = departmentRepository.getByName(name);
            response.setLocation(department.getLocation());
            response.setName(department.getName());
            response.setProcess(department.getProcess());
            Status status = buildSuccessStatus();
            response.setStatus(status);
        } catch (Exception ex) {

        }
        if (department == null) {
            buildDefaultResponse(response);
            Status status = buildSuccessStatus();
            response.setStatus(status);
        }
        return response;
    }

    Status buildSuccessStatus() {
        Status status = new Status();
        status.setStatusCode(String.valueOf(HttpStatus.OK.value()));
        status.setStatusMsg(HttpStatus.OK.getReasonPhrase());
        return status;
    }

    private void buildDefaultResponse(GetDepartmentResponse response) {
        response.setProcess("Accountant");
        response.setName("CASH");
        response.setLocation("Chennai");
    }

    @Autowired
    public void setDepartmentRepository(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
