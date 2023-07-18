package kz.aidyninho.jobcy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
public class Job implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
    @ManyToOne
    private Experience experience;
    private String location;
    private Integer salary;
    private String qualification;
    private LocalDateTime postDate;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private JobType type;
    @OneToOne
    private Industry industry;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Keyword> keywords = new ArrayList<>();
    @OneToMany(mappedBy = "job", targetEntity = JobsUsers.class)
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

}
