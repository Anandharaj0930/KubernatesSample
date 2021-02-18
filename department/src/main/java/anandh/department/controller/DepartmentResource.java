package anandh.department.controller;

import anandh.department.types.DepartmentRequest;
import anandh.department.types.DepartmentResponse;
import anandh.department.types.GetDepartmentResponse;
import anandh.department.types.core.IDepartmentFinder;
import anandh.department.types.core.IDepartmentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DepartmentResource {
    private IDepartmentProcessor departmentProcessor;
    private IDepartmentFinder departmentFinder;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DepartmentResponse createDept(@RequestBody DepartmentRequest request) {
        DepartmentResponse response = departmentProcessor.createDept(request);
        return response;
    }

    @GetMapping(path = "/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public GetDepartmentResponse getDepartment(@PathVariable("name") String name) {
        GetDepartmentResponse response = departmentFinder.getDept(name);
        return response;
    }

    @Autowired
    public void setDepartmentProcessor(IDepartmentProcessor departmentProcessor) {
        this.departmentProcessor = departmentProcessor;
    }

    @Autowired
    public void setDepartmentFinder(IDepartmentFinder departmentFinder) {
        this.departmentFinder = departmentFinder;
    }
}
