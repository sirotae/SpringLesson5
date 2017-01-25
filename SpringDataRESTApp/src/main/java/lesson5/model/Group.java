package lesson5.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"GroupsTable\"")
public class Group {
    @Id
    @SequenceGenerator(name="GroupsTable_seq",
            sequenceName="\"GroupsTable_id_seq\"",
            allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="GroupsTable_seq")
    private int id;
    private String name;

    @Singular
    @ManyToMany(mappedBy = "groups")
    private List<User> users;
}