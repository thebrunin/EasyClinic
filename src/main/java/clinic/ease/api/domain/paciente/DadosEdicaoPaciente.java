package clinic.ease.api.domain.paciente;

import clinic.ease.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosEdicaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid
        DadosEndereco endereco) {
}
