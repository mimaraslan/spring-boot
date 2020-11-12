package com.mimaraslan.controller;

import com.mimaraslan.config.DBConfig;
import com.mimaraslan.exception.ResourceNotFoundException;
import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.AcceptLanguage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

   // @Autowired
   // private DBConfig dbConfig;

    // LIST ALL
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("employees/all")
    public ResponseEntity<List<Employee>> getAllEmployees2() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    // ADD
    @PostMapping("employees")
    public Employee createEmployee (@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PostMapping("employees/add")
    public ResponseEntity<Employee> createEmployee2 (@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    // LIST ID
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ id));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("employees/get/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeId2(@PathVariable long id){
       Optional<Employee> empObj = employeeRepository.findById(id);
        if(empObj.isPresent()){
            return ResponseEntity.ok(empObj);
        }else{
            throw new ResourceNotFoundException("Employee not exist with id: "+ id);
        }
    }


    // HATEOAS (Hypermedia as the Engine of Application State)
    @GetMapping("employees/all/{id}")
    public EntityModel<Optional<Employee>> getEmployeeId3(@PathVariable long id){
        Optional<Employee> empObj = employeeRepository.findById(id);
        if(empObj==null){
            throw new ResourceNotFoundException("Employee not exist with id: "+ id);
        }
        EntityModel<Optional<Employee>> model = EntityModel.of(empObj);

        WebMvcLinkBuilder linkToEmployees = linkTo(methodOn(this.getClass()).getAllEmployees());
        model.add(linkToEmployees.withRel("all-emoloyees"));

        return model;
    }


    // UPDATE
    @PutMapping("/employees/{id}")
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
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @Autowired
    private MessageSource messageSource;

    //  http://localhost:8082/api/v1/employees/i18n/v1
    @GetMapping(path = "employees/i18n/v1")
    public String getInfoInternationalization1(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage(
                "welcome.message", null,
                "Default message",
                locale);
         }

    //  http://localhost:8082/api/v1/employees/i18n/v2
    @GetMapping(path = "employees/i18n/v2")
    public String getInfoInternationalization2() {
        return messageSource.getMessage(
                "welcome.message", null,
                "Default message",
                LocaleContextHolder.getLocale());
    }
}
