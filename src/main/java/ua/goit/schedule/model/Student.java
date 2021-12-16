package ua.goit.schedule.model;

import javax.persistence.*;

@Table(name="audience")
public class Student implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private  String name;

    @ManyToOne
    @JoinColumn(name="group_id")
    private  Group group;

    @Override
    public Long getId() {
        return id;
    }

}
