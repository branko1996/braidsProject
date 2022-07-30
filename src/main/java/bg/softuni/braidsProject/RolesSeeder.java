package bg.softuni.braidsProject;

import bg.softuni.braidsProject.model.entity.Role;
import bg.softuni.braidsProject.model.entity.enums.UserRole;
import bg.softuni.braidsProject.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolesSeeder implements CommandLineRunner {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesSeeder(RolesRepository rolesRepository){
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.rolesRepository.count() == 0){
            List<Role> roles = Arrays.stream(UserRole.values())
                    .map(Role::new)
                    .collect(Collectors.toList());

            this.rolesRepository.saveAll(roles);
        }
    }
}
