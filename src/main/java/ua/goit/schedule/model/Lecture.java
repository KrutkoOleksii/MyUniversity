package ua.goit.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="lecture")
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
