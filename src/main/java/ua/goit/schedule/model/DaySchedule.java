package ua.goit.schedule.model;

import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="day_schedule")
public class DaySchedule implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="day_of_week")
    private DayOfWeek dayOfWeek;

    @ManyToOne
    @JoinColumn(name="study_group_id")
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "daySchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Lecture> lectures;

    @Override
    public Long getId() {
        return id;
    }
}
