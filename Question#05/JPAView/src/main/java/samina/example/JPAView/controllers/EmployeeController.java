package samina.example.JPAView.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import samina.example.JPAView.data.EmployeeRepository;
import samina.example.JPAView.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeData;

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.POST)
	public String newEmployee(Employee employee) {

		employeeData.save(employee);
		return ("redirect:/listEmployees.html");

	}

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);

	}

	@RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
	public ModelAndView employees() {
		List<Employee> employee = employeeData.findAll();
		return new ModelAndView("allEmployees", "employee", employee);

	}

	@RequestMapping(value = "/clear.html", method = RequestMethod.GET)
	public String clearEmployee() {

		employeeData.deleteAll();
		return ("redirect:/listEmployees.html");

	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable long id) {
		employeeData.deleteById(id);
		return ("redirect:/listEmployees.html");
	}

}
