package clinic.ease.api.infra.exception;

import clinic.ease.api.domain.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogErrorRepository extends JpaRepository<LogError, Long> {
}
