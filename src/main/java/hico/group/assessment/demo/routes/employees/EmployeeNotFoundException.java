package hico.group.assessment.demo.routes.employees;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(Long id) {
        super(String.format("Employee with ID %d could not be found.", id));
    }
}
