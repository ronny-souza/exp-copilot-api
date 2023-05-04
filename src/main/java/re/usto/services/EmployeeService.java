package re.usto.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import re.usto.model.Employee;
import re.usto.model.transport.EmployeeDTO;
import re.usto.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public EmployeeDTO register(EmployeeDTO employeeDTO) {
		LOGGER.info("Starting employee registration...");
		Employee employee = new Employee(employeeDTO);
		this.employeeRepository.save(employee);

		employeeDTO.setAdmissionDate(employee.getAdmissionDate());
		employeeDTO.setEmployeeIdentifier(employee.getEmployeeIdentifier());
		return employeeDTO;
	}

	public Set<EmployeeDTO> listAllEmployees() {
		List<Employee> employees = this.employeeRepository.findAll();

		if (employees.isEmpty()) {
			return new HashSet<>();
		}

		return employees.stream().map(EmployeeDTO::new).collect(Collectors.toSet());
	}

}
