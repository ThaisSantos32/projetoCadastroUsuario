package br.com.aula.projetoCadastroUsuario.model;

import br.com.aula.projetoCadastroUsuario.dto.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;


@Entity
    @Table(name = "usuarios",
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = "email"),
                    @UniqueConstraint(columnNames = "nomeUsuario")
            })
    public class UsuarioModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String nome;

        @NotBlank
        private String nomeUsuario;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String senha;

        @NotBlank
        @Pattern(regexp = "^\\d+$")
        private String telefoneCelular;

        private LocalDateTime dataCriacao;

        private LocalDateTime dataAtualizacao;

        public UsuarioModel() {
        }

        public UsuarioModel(String nome, String nomeUsuario, String email,
                            String senha, String telefoneCelular) {
            this.nome = nome;
            this.nomeUsuario = nomeUsuario;
            this.email = email;
            this.senha = senha;
            this.telefoneCelular = telefoneCelular;
            this.dataCriacao = LocalDateTime.now();
            this.dataAtualizacao = LocalDateTime.now();
        }
    public UsuarioModel(UsuarioDTO dto, String senhaHash) {
        this.nome = dto.getNome();
        this.nomeUsuario = dto.getNomeUsuario();
        this.email = dto.getEmail();
        this.senha = senhaHash;
        this.telefoneCelular = dto.getTelefoneCelular();
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public LocalDateTime getDataCriacao() {
            return dataCriacao;
        }

        public void setDataCriacao(LocalDateTime dataCriacao) {
            this.dataCriacao = dataCriacao;
        }

        public LocalDateTime getDataAtualizacao() {
            return dataAtualizacao;
        }

        public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
        }


        @PrePersist
        public void prePersist() {
            this.dataCriacao = LocalDateTime.now();
            this.dataAtualizacao = LocalDateTime.now();
        }

        @PreUpdate
        public void preUpdate() {
            this.dataAtualizacao = LocalDateTime.now();
        }
    }
