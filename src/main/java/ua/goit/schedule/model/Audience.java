package ua.goit.schedule.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="audience")
public class Audience implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private  String name;

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Lecture> lectures;

    @Override
    public Long getId() {
        return id;
    }

}
