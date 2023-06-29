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

/**
 * Relação: ContaPrincipalJogo: {nickNameContaPrincipal, CPF_FK, login, senha,
 perguntaSegurança, respostaSegurança}
 *
 * @author patri
 */
public class ContaPrincipalJogo
        extends ContaVinculoJogo {

    private String login;
    private String senha;
    private String perguntaSeguranca;
    private String respostaSeguranca;
    UsuarioJogo usuario;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ContaPrincipalJogo() {
    }

    public ContaPrincipalJogo(String login, String senha, 
            String perguntaSeguranca, String respostaSeguranca, 
            UsuarioJogo usuario, String nickName, String tipoConta) {
        
        super(nickName, tipoConta);
        this.login = login;
        this.senha = senha;
        this.perguntaSeguranca = perguntaSeguranca;
        this.respostaSeguranca = respostaSeguranca;
        this.usuario = usuario;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerguntaSeguranca() {
        return perguntaSeguranca;
    }

    public void setPerguntaSeguranca(String perguntaSeguranca) {
        this.perguntaSeguranca = perguntaSeguranca;
    }

    public String getRespostaSeguranca() {
        return respostaSeguranca;
    }

    public void setRespostaSeguranca(String respostaSeguranca) {
        this.respostaSeguranca = respostaSeguranca;
    }

    public UsuarioJogo getUsuarioJogo() {
        return usuario;
    }

    public void setUsuarioJogo(UsuarioJogo usuario) {
        this.usuario = usuario;
    }

//</editor-fold>
    @Override
    public String toString() {
        return '\n'
                + "ContaPrincipal{"
                + "nickName=" + getNickName()
                + ", cpf=" + usuario.getCpf()
                + ", login=" + login
                + ", senha=" + senha
                + ", perguntaSeguranca=" + perguntaSeguranca
                + ", respostaSeguranca=" + respostaSeguranca
                + '}';
    }

}
