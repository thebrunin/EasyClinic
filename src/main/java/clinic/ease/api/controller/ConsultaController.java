package clinic.ease.api.controller;

import clinic.ease.api.domain.consulta.AgendaDeConsultasService;
import clinic.ease.api.domain.consulta.DadosAgendamentoConsulta;
import clinic.ease.api.domain.consulta.DadosCancelamentoConsulta;
import clinic.ease.api.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultasService agendaDeConsultasService;
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var dto = agendaDeConsultasService.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agendaDeConsultasService.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
