package ua.goit.schedule.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="audience")
public class Student implements BaseEntity<Long>{

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
