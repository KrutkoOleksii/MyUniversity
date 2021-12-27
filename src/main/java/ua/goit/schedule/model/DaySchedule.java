package ua.goit.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"lectures"})
@Table(name="day_schedule")
public class DaySchedule implements BaseEntity<Long>{

    private static final long serialVersionUID = -7076114547164440731L;
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="day_of_week")
    private DayOfWeek dayOfWeek;

    @ManyToOne
    @JoinColumn(name="group_schedule_id")
    private GroupSchedule groupSchedule;

    @OneToMany(mappedBy = "daySchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Lecture> lectures;

}
