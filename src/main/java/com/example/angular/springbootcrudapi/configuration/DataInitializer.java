import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.example.angular.springbootcrudapi.model.Employee;
import com.example.angular.springbootcrudapi.repository.EmployeeRepository;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Vérifiez si l'employé par défaut n'existe pas déjà
        if (!employeeRepository.existsByName("admin")) {
            // Créez l'employé par défaut
            Employee admin = new Employee();
            admin.setName("admin");
            admin.setMatricule(12304);
            admin.setPhone(58362749);
            admin.setEmail("rabii.benkhlifa@esprit.tn");
            admin.setDepartment("RH");
            // Enregistrez l'employé dans la base de données
            employeeRepository.save(admin);
        }
    }
}
