package br.com.aula.projetoCadastroUsuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UsuarioDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[\\d\\W]).+$", message = "A senha deve conter pelo menos um número ou um caractere especial")
    private String senha;

    @NotBlank
    @Pattern(regexp = "^\\d+$", message= "O telefone celular deve conter apenas dígitos")
    private String telefoneCelular;


    public UsuarioDTO() {
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
}
