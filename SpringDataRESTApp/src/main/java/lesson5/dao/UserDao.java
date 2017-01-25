package lesson5.dao;

import lesson5.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserDao extends CrudRepository<User, Integer> {

    List<User> findBySurname(String surname, Sort sort);

    Page<User> findBySurnameContaining(@Param("surname")String surname, Pageable pageable);

    @Query("select u from User u where u.name = :name")
    List<User> findBy(@Param("name")String name);

}
