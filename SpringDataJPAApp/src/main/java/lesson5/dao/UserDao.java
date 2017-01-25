package lesson5.dao;

import lesson5.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserDao extends Repository<User, Integer> {
    
    List<User> findBySurname(String surname, Sort sort);

    Page<User> findBySurnameContaining(String surname, Pageable pageable);

    List<User> findBySurnameContaining(String surname);

    @Query("select u from User u where u.name = :name")
    List<User> findBy(@Param("name")String name);

    User save(User user);
}
