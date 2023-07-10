package clinic.ease.api.domain.medico;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade, boolean ativo) {

    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.isAtivo());
    }
}
