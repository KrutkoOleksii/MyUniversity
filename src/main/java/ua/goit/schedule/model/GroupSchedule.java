package ua.goit.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"daySchedules"})
@Table(name="group_schedule")
public class GroupSchedule implements BaseEntity<Long>{

    private static final long serialVersionUID = -3234857685302651832L;
    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="study_group_id")
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "groupSchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<DaySchedule> daySchedules;
}
