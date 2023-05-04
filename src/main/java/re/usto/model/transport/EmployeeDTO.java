package re.usto.model.transport;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import re.usto.model.Employee;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String employeeIdentifier;

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@NotBlank
	private String phone;

	@NotBlank
	private String office;

	@NotNull
	private Double wage;

	private LocalDate admissionDate;

	@NotBlank
	private String companyName;

	public EmployeeDTO() {

	}

	public EmployeeDTO(Employee employee) {
		this.employeeIdentifier = employee.getEmployeeIdentifier();
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.office = employee.getOffice();
		this.wage = employee.getWage();
		this.admissionDate = employee.getAdmissionDate();
		this.companyName = employee.getCompanyName();
	}

	public String getEmployeeIdentifier() {
		return employeeIdentifier;
	}

	public void setEmployeeIdentifier(String employeeIdentifier) {
		this.employeeIdentifier = employeeIdentifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
