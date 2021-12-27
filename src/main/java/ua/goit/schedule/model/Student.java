package ua.goit.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="student")
public class Student implements BaseEntity<Long>{

    private static final long serialVersionUID = 2103376223740044473L;
    @Id
    @Column(name="id")
    private Long id;

    @OneToOne
    @JoinColumn(name="person_id")
    private  Person person;

    @ManyToOne
    @JoinColumn(name="study_group_id")
    private StudyGroup studyGroup;

}
