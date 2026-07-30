package com.agencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Cliente da agência de turismo. Herda id, nome, cpf e telefone de Pessoa
 * e acrescenta atributos específicos de cliente.
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @Column(length = 150)
    private String email;

    @Column(name = "destino_preferido", length = 100)
    private String destinoPreferido;

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String telefone, String email, String destinoPreferido) {
        super(nome, cpf, telefone);
        this.email = email;
        this.destinoPreferido = destinoPreferido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDestinoPreferido() {
        return destinoPreferido;
    }

    public void setDestinoPreferido(String destinoPreferido) {
        this.destinoPreferido = destinoPreferido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + email + '\'' +
                ", destinoPreferido='" + destinoPreferido + '\'' +
                '}';
    }
}
