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

    private static final long serialVersionUID = 346403790342788107L;
    @Id
    @Column(name="id")
    private Long id;

    @OneToOne
    @JoinColumn(name="person_id")
    private  Person person;

}
