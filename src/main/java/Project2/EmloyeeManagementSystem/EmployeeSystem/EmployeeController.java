package Project2.EmloyeeManagementSystem.EmployeeSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    //METHOD TO DISPLAY THE LIST OF EMPLOYEE
    @Autowired
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "home";
    }
    @GetMapping(path= "/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        // CREATE NEW FORM TO BIND EMPLOYEE DATA (id, name, firstname, Email, lastname)
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
    @PostMapping(path = "/saveEmployee")
    public  String saveEmployee(@ModelAttribute("employee") Employee employee){
        //SAVE EMPLOYEE TO THE DATABASE
        employeeService.SaveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping(path = "/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable (value = "id") long id, Model model){
        //GET EMPLOYEE FROM THE SERVICE
        Employee employee= employeeService.getEmployeeById(id);
        //SET EMPLOYEE AS A MODEL ATTRIBUTE TO UPDATE AND PRE POPULATE THE FORM
        model.addAttribute("employee", employee);
        return "update_employee";

    }
    @GetMapping(path = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        //CALL DELETE EMPLOYEE METHOD.
    this.employeeService.deleteEmployeeById(id);
        return "redirect:/";



    }

}