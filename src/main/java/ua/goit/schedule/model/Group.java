package ua.goit.schedule.model;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Table(name="audience")
public class Group implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private  String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Student> students;

    @Override
    public Long getId() {
        return id;
    }

}
