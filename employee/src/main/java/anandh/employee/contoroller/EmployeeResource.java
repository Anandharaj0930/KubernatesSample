package anandh.employee.contoroller;

import anandh.employee.types.EmployeeRequest;
import anandh.employee.types.EmployeeResponse;
import anandh.employee.types.GetEmployeeResponse;
import anandh.employee.types.core.IEmployeeFinder;
import anandh.employee.types.core.IEmployeeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private IEmployeeProcessor employeeProcessor;

    private IEmployeeFinder employeeFinder;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse response = employeeProcessor.createEmployee(employeeRequest);

        return response;
    }

    @GetMapping(path = "/{code}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public GetEmployeeResponse getEmployee(@PathVariable("code") String code) {
        GetEmployeeResponse response = employeeFinder.getEmployee(code);

        return response;
    }

    @Autowired
    public void setEmployeeProcessor(IEmployeeProcessor employeeProcessor) {
        this.employeeProcessor = employeeProcessor;
    }

    @Autowired
    public void setEmployeeFinder(IEmployeeFinder employeeFinder) {
        this.employeeFinder = employeeFinder;
    }
}
