package hico.group.assessment.demo.routes.employees;

import org.json.JSONObject;

import hico.group.assessment.demo.routes.employees.Employees.Gender;
import hico.group.assessment.demo.routes.employees.Employees.ProfileColor;
import hico.group.assessment.demo.routes.employees.Employees.Salutation;

public class EmployeeServices {

    public Employees addEmployee(JSONObject employeeData, EmployeeRepository employeeRepository) {
        Employees employees = new Employees();
        employees.setFirstName(employeeData.getString("firstName"));
        employees.setLastName(employeeData.getString("lastName"));
        employees.setEmployeeCode(employeeData.getInt("employeeCode"));
        employees.setGender(employeeData.getEnum(Gender.class, "gender"));
        employees.setSalutation(employeeData.getEnum(Salutation.class, "salutation"));
        employees.setProfileColor(employeeData.getEnum(ProfileColor.class, "profileColor"));
        employees.setGrossSalary(employeeData.getDouble("grossSalary"));

        return employeeRepository.save(employees);
    }

    public Employees updateEmployee(Long id, JSONObject updatedEmployeeData, EmployeeRepository employeeRepository) {
        Employees employeeFoundById = employeeRepository.getReferenceById(id);
        employeeFoundById.setFirstName(updatedEmployeeData.getString("firstName"));
        employeeFoundById.setLastName(updatedEmployeeData.getString("lastName"));
        employeeFoundById.setEmployeeCode(updatedEmployeeData.getInt("employeeCode"));
        employeeFoundById.setGender(updatedEmployeeData.getEnum(Gender.class, "gender"));
        employeeFoundById.setSalutation(updatedEmployeeData.getEnum(Salutation.class, "salutation"));
        employeeFoundById.setProfileColor(updatedEmployeeData.getEnum(ProfileColor.class, "profileColor"));
        employeeFoundById.setGrossSalary(updatedEmployeeData.getDouble("grossSalary"));

        return employeeRepository.save(employeeFoundById);
    }

    public void deleteEmployee(Long id, EmployeeRepository employeeRepository) {
        employeeRepository.deleteById(id);
    }

}