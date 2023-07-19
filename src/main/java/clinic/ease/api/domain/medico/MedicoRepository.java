package clinic.ease.api.domain.medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m FROM Medicos m " +
            "WHERE m.ativo = 1 " +
            "AND m.especialidade = :especialidade " +
            "AND m.id NOT IN (" +
            "   SELECT c.medico.id FROM Consulta c " +
            "   WHERE c.data = :data" +
            ") " +
            "ORDER BY RAND()" +
            "LIMIT 1"
    )
    Optional<Medico> escolherMedicoAutomaticamenteLivreNaData(Especialidade especialidade, LocalDateTime data);
}
