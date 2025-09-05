package br.com.aula.projetoCadastroUsuario.controller;
import br.com.aula.projetoCadastroUsuario.dto.UsuarioDTO;
import br.com.aula.projetoCadastroUsuario.model.UsuarioModel;
import br.com.aula.projetoCadastroUsuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody @Valid UsuarioDTO dto) {
        try {
            // Chama o service para criar o usuário
            UsuarioModel novoUsuario = usuarioService.criarUsuario(dto);

            // Retorna a resposta com o status 201 Created e o usuário criado
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}