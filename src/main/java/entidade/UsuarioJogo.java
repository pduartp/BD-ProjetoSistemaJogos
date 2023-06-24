/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package entidade;

import java.time.LocalDate;

/**
 * Relacao: Usuário: {CPF, paísUsuário, email*, nomeUsuário, idade,
 * dataNascimento}
 *
 * @author patri
 */
public class UsuarioJogo {

    private String nome;
    private String cpf;
    private Integer idade;
    private String dataNascimento;
    private String pais;
    private String email;

    //<editor-fold defaultstate="collapsed" desc="Construtores">    
    public UsuarioJogo() {
    }

    public UsuarioJogo(String nome, String cpf, Integer idade, String dataNascimento, String pais, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.pais = pais;
        this.email = email;
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//</editor-fold>

    @Override
    public String toString() {
        return  '\n'
                + "Usuario{"
                + "cpf=" + cpf
                + ", nome=" + nome
                + ", idade=" + idade
                + ", dataNascimento=" + dataNascimento
                + ", pais=" + pais
                + ", email=" + email
                + '}';
    }
}
