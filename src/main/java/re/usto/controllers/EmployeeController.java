package re.usto.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import re.usto.model.transport.EmployeeDTO;
import re.usto.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeDTO> register(@Valid @RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO employeeRegistered = this.employeeService.register(employeeDTO);
		return new ResponseEntity<>(employeeRegistered, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Set<EmployeeDTO>> listAll() {
		Set<EmployeeDTO> employees = this.employeeService.listAllEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity<>(employees, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
