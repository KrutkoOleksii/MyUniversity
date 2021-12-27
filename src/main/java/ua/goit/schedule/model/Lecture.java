package ua.goit.schedule.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="lecture")
public class Lecture implements BaseEntity<Long>{

    private static final long serialVersionUID = -536172524149661270L;
    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="audience_id")
    private Audience audience;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="day_schedule_id")
    private DaySchedule daySchedule;

    @Override
    public Long getId() {
        return id;
    }
}
