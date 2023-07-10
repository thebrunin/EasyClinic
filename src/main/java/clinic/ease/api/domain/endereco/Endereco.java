package clinic.ease.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (!dados.logradouro().isBlank())
            this.logradouro = dados.logradouro();
        if (!dados.bairro().isBlank())
            this.bairro = dados.bairro();
        if (!dados.cep().isBlank())
            this.cep = dados.cep();
        if (!dados.numero().isBlank())
            this.numero = dados.numero();
        if (!dados.complemento().isBlank())
            this.complemento = dados.complemento();
        if (!dados.cidade().isBlank())
            this.cidade = dados.cidade();
        if (!dados.uf().isBlank())
            this.uf = dados.uf();
    }
}
