package hico.group.assessment.demo.routes.employees;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private final EmployeeServices employeeServices = new EmployeeServices();

    @ResponseBody
    @GetMapping(value = "/employees", produces = "application/json")
    public Iterable<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/employees", produces = "application/json")
    public Employees addEmployee(@RequestBody String employeeData) {
        return employeeServices.addEmployee(new JSONObject(employeeData), employeeRepository);
    }

    @ResponseBody
    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public Employees getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @ResponseBody
    @PatchMapping(value = "/employee/{id}", produces = "application/json")
    public Employees updateEmployee(@RequestBody String updatedEmployeeData, @PathVariable Long id) {
        return employeeServices.updateEmployee(id, new JSONObject(updatedEmployeeData), employeeRepository);
    }

    @ResponseBody
    @DeleteMapping(value = "/employee/{id}", produces = "application/json")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
