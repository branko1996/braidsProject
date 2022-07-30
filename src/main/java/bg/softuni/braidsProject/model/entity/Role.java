package bg.softuni.braidsProject.model.entity;

import bg.softuni.braidsProject.model.entity.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private UserRole userRole;

    public Role() {
        this.userRole = UserRole.USER;
    }

    public Role(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }
    public Role setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }
}
