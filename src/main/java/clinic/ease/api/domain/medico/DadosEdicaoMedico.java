package clinic.ease.api.domain.medico;

import clinic.ease.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
