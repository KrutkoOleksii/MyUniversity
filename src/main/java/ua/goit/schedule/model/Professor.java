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
@Table(name="professor")
public class Professor implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @OneToOne
    @JoinColumn(name="person_id")
    private  Person person;

}
