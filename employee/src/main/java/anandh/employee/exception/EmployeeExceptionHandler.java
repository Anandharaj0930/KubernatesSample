package anandh.employee.exception;

import anandh.employee.types.EmployeeResponse;
import anandh.employee.types.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeCoreException.class)
    public EmployeeResponse employeePersistException() {
        EmployeeResponse response = new EmployeeResponse();
        Error error = new Error();
        error.setStatusMsg("KO");
        error.setStatusCode("400");
        response.setError(error);
        return response;
    }

    @ExceptionHandler(EmployeeGetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void employeeGetException() {

    }

    @ExceptionHandler(EmployeeExternalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void employeeExternalException() {
    }
}
