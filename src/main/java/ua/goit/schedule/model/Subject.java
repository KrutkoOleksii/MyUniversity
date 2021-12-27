package ua.goit.schedule.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="subject")
public class Subject implements BaseEntity<Long>{

    private static final long serialVersionUID = -4085477669876137690L;
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private  String name;

    @Override
    public Long getId() {
        return id;
    }
}
