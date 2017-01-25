package lesson5.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"UsersTable\"")
public class User {
    @Id
    @SequenceGenerator(name="UsersTable_seq",
            sequenceName="\"UsersTable_id_seq\"",
            allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="UsersTable_seq")
    private int id;
    private int age;
    private String name;
    private String surname;

    @Singular
    @ManyToMany
    @JoinTable(
            name="\"UserGroup\"",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="group_id", referencedColumnName="id"))
    private List<Group> groups;

    public static void main(String[] args) {
        User user = User.builder()
                .age(12).id(12).name("Vasya")
                .build();
    }
}
