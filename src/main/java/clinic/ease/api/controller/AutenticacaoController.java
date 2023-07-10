package clinic.ease.api.controller;

import clinic.ease.api.domain.usuario.DadosAutenticacao;
import clinic.ease.api.domain.usuario.Usuario;
import clinic.ease.api.infra.security.DadosTokenJWT;
import clinic.ease.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity efetuaLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
           var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
           var authentication = manager.authenticate(authToken);

           var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
           return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

}
