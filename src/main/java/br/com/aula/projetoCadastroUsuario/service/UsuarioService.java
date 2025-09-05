package br.com.aula.projetoCadastroUsuario.service;

import br.com.aula.projetoCadastroUsuario.dto.UsuarioDTO;
import br.com.aula.projetoCadastroUsuario.model.UsuarioModel;
import br.com.aula.projetoCadastroUsuario.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel criarUsuario(UsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new CriacaoUsuarioException("Já existe um usuário com este email");
        }
        if (usuarioRepository.existsByNomeUsuario(dto.getNomeUsuario())) {
            throw new CriacaoUsuarioException("Já existe um usuário com este nome de usuário");
        }

        String senhaHash = BCrypt.hashpw(dto.getSenha(), BCrypt.gensalt());

        UsuarioModel usuario = new UsuarioModel(dto, senhaHash);

        return usuarioRepository.save(usuario);
    }
}
