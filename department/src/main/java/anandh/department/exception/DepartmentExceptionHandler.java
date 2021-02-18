package anandh.department.exception;

import anandh.department.types.DepartmentResponse;
import anandh.department.types.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DepartmentExceptionHandler {

    @ExceptionHandler(DepartmentCoreException.class)
    public DepartmentResponse deptPersistException() {
        DepartmentResponse response = new DepartmentResponse();
        Error error = new Error();
        error.setStatusMsg("KO");
        error.setStatusCode("400");
        response.setError(error);
        return response;
    }

    @ExceptionHandler(DepartmentGetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deptGetException() {

    }

    @ExceptionHandler(DepartmentExternalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void deptExternalException() {
    }
}
