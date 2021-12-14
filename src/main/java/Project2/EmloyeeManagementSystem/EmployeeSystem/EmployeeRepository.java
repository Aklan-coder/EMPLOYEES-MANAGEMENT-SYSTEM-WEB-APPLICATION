package Project2.EmloyeeManagementSystem.EmployeeSystem;

import Project2.EmloyeeManagementSystem.EmployeeSystem.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   EmployeeRepository extends JpaRepository<Employee, Long> {
}
