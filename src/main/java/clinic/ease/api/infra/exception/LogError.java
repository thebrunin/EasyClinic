package clinic.ease.api.infra.exception;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "logerror")
@Entity(name = "LogError")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class LogError {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String method;
    private String message;
    @Column(name = "stacktrace")
    private String stackTrace;
}
