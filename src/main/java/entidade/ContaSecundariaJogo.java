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
 * Relação: ContaSecundária: {nickNameContaSecundária, CPF_FK,
 * nickNameContaPrincipal_FK, permissãoCartãoCrédito, permisãoConteúdoImpróprio,
 * login, senha, perguntaSegurança, respostaSegurança}
 *
 * @author patri
 */
public class ContaSecundariaJogo
        extends ContaVinculoJogo {

    private String login;
    private String senha;
    private String perguntaSeguranca;
    private String respostaSeguranca;
    private Integer permissaoCardCredito;
    private Integer permissaoContImproprio;
    UsuarioJogo usuario;
    ContaPrincipalJogo contaPrincipal;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ContaSecundariaJogo() {
    }

    public ContaSecundariaJogo(
            String login, String senha, String perguntaSeguranca, 
            String respostaSeguranca, Integer permissaoCardCredito, 
            Integer permissaoContImproprio, UsuarioJogo usuario, 
            ContaPrincipalJogo contaPrincipal, String nickName, 
            String tipoConta) {
        super(nickName, tipoConta);
        this.login = login;
        this.senha = senha;
        this.perguntaSeguranca = perguntaSeguranca;
        this.respostaSeguranca = respostaSeguranca;
        this.permissaoCardCredito = permissaoCardCredito;
        this.permissaoContImproprio = permissaoContImproprio;
        this.usuario = usuario;
        this.contaPrincipal = contaPrincipal;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public Integer getPermissaoCardCredito() {
        return permissaoCardCredito;
    }

    public void setPermissaoCardCredito(Integer permissaoCardCredito) {
        this.permissaoCardCredito = permissaoCardCredito;
    }

    public Integer getPermissaoContImproprio() {
        return permissaoContImproprio;
    }

    public void setPermissaoContImproprio(Integer permissaoContImproprio) {
        this.permissaoContImproprio = permissaoContImproprio;
    }

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

    public void setUsuarioJogo(UsuarioJogo usuarioJogo) {
        this.usuario = usuarioJogo;
    }

    public ContaPrincipalJogo getContaPrincipalJogo() {
        return contaPrincipal;
    }

    public void setContaPrincipalJogo(ContaPrincipalJogo contaPrincipalJogo) {
        this.contaPrincipal = contaPrincipalJogo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

//</editor-fold>
    @Override
    public String toString() {
        return '\n'
                + "ContaSecundariaJogo{"
                + "nickName=" + getNickName()
                + ", cpf=" + usuario.getCpf()
                + ", nickNamePrincipal=" + contaPrincipal.getNickName()
                + ", login=" + login
                + ", senha=" + senha
                + ", perguntaSeguranca=" + perguntaSeguranca
                + ", respostaSeguranca=" + respostaSeguranca
                + ", permissaoCardCredito=" + permissaoCardCredito
                + ", permissaoContImproprio=" + permissaoContImproprio
                + '}';
    }

}
