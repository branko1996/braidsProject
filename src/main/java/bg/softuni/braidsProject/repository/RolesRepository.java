package bg.softuni.braidsProject.repository;

import bg.softuni.braidsProject.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
}
