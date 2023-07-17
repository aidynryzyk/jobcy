package kz.aidyninho.jobcy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs_users")
@Data
@NoArgsConstructor
public class JobsUsers implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "jobs_id")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    private String message;

}
