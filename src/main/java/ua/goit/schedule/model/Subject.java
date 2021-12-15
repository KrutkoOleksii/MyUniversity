package ua.goit.schedule.model;

public class Subject implements BaseEntity<Long>{

    private Long Id;
    private String name;

    @Override
    public Long GetId() {
        return Id;
    }
}
