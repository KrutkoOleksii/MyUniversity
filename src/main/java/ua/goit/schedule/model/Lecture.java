package ua.goit.schedule.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.DayOfWeek;

public class Lecture implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="day_of_week")
    private DayOfWeek dayOfWeek;

    @ManyToOne
    @JoinColumn(name="group_id")
    private  Group group;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private  Subject subject;

    @ManyToOne
    @JoinColumn(name="audience_id")
    private  Audience audience;

    @Override
    public Long getId() {
        return id;
    }
}
