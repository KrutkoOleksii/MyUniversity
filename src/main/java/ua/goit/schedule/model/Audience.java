package ua.goit.schedule.model;

public class Audience implements BaseEntity<Long>{

    private Long id;

    private  String name;

    @Override
    public Long getId() {
        return id;
    }

}
