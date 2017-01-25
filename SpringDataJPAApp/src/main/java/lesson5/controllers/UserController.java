package lesson5.controllers;

import lesson5.dao.UserDao;
import lesson5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<User> getUsersBySurname(@RequestParam String surname) {
        return userDao.findBySurname(surname, new Sort(Sort.Direction.DESC, "age"));
    }

    @GetMapping("/findbyname")
    public List<User> getUsersByName(@RequestParam String name) {
        return userDao.findBy(name);
    }


    @GetMapping("/userscontainingall")
    public List<User> getUsersBySurnameBContainingall(@RequestParam String surname) {
        return userDao.findBySurnameContaining(surname);

    }

    @GetMapping("/userscontaining")
    public Page<User> getUsersBySurnameBContaining(@RequestParam String surname) {
        Pageable pageable = new PageRequest(0, 10, Sort.Direction.ASC, "name");
        Page<User> page = null;

        return userDao.findBySurnameContaining(surname, pageable);

    }

    @PostMapping("/updateuser")
    public void updateUser(@RequestBody User user) {
        userDao.save(user);
    }


    /*
    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @GetMapping("/geteuser/{id}")
    public User getUser(@PathVariable int id) {
        return userDao.findUserById(id);
    }

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userDao.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateuser")
    public void updateUser(@RequestBody User user) {
        userDao.update(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void User(@PathVariable int id) {
        userDao.remove(id);
    }*/
}
