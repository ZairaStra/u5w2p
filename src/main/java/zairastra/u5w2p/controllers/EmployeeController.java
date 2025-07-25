package zairastra.u5w2p.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zairastra.u5w2p.entities.Employee;
import zairastra.u5w2p.exceptions.ValidationException;
import zairastra.u5w2p.payloads.NewEmployeeDTO;
import zairastra.u5w2p.payloads.NewEmployeeResponseDTO;
import zairastra.u5w2p.services.EmployeesService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeesService employeesService;

    //SAVE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewEmployeeResponseDTO createEmployee(@RequestBody @Validated NewEmployeeDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errors = validationResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException(errors);
        }

        Employee newEmployee = employeesService.saveEmployee(payload);
        return new NewEmployeeResponseDTO(newEmployee.getId());
    }


    //FINDALL
    @GetMapping
    public Page<Employee> getEmployees(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size) {
        return employeesService.findAll(page, size);
    }

    //FINDBYID
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable long employeeId) {
        return employeesService.findEmployeeById(employeeId);
    }

    //FINDBYIDANDUPDATE
    @PutMapping("/{employeeId}")
    public Employee getEmployeeByIdAndUpdate(@PathVariable Long employeeId, @RequestBody @Validated NewEmployeeDTO payload) {
        return employeesService.findEmployeeByIdAndUpdate(employeeId, payload);
    }

    //FINDBYIDANDDELETE
    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getEmployeeByIdAndDelete(@PathVariable Long employeeId) {
        employeesService.findEmployeeByIdAndDelete(employeeId);
    }
}
