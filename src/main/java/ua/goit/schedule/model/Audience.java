package ua.goit.schedule.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="audience")
public class Audience implements BaseEntity<Long>{

    @Column(name="id")
    private Long id;

    @Column(name="name")
    private  String name;

    @Override
    public Long getId() {
        return id;
    }

}
