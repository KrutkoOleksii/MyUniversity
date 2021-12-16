package ua.goit.schedule.model;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Table(name="subject")
public class Subject implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private  String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Lecture> lectures;

    @Override
    public Long getId() {
        return id;
    }
}
