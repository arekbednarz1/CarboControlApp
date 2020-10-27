package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.arekbednarz.dietcontrolapp.entity.Recipe;
import pl.arekbednarz.dietcontrolapp.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);

    User findUserByPasswordBefore(String password);

    User findUserById(Long id);

}
