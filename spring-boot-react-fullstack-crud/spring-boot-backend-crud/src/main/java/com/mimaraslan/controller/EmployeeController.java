package com.mimaraslan.controller;

import com.mimaraslan.config.DBConfig;
import com.mimaraslan.exception.ResourceNotFoundException;
import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

   // @Autowired
   // private DBConfig dbConfig;

    // LIST
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees2() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    // ADD
    @PostMapping
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee2 (@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    // LIST ID
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ id));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeId2(@PathVariable long id){
       Optional<Employee> empObj = employeeRepository.findById(id);
        if(empObj.isPresent()){
            return ResponseEntity.ok(empObj);
        }else{
            throw new ResourceNotFoundException("Employee not exist with id: "+ id);
        }
    }

    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+ id));
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmailId(employee.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
