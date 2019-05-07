package samina.example.JPAView.data;

import org.springframework.data.jpa.repository.JpaRepository;

import samina.example.JPAView.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
