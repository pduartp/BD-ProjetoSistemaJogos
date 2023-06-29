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
package repositorio;

import entidade.ContaPrincipalJogo;
import entidade.ContaSecundariaJogo;
import entidade.UsuarioJogo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 *
 * <code>
 * CREATE TABLE contaSecundariaJogo (
 * nickNameSecundaria VARCHAR(15) NOT NULL,
 * cpf VARCHAR(14),
 * nickNamePrincipal VARCHAR(15),
 * login VARCHAR(20),
 * senha VARCHAR(20),
 * perguntaSeguranca VARCHAR(60),
 * respostaSeguranca VARCHAR(60),
 * permCardCred NUMBER(1) DEFAULT 0,
 * permContImp NUMBER(1) DEFAULT 0,
 * CONSTRAINT pk_nickNameCs PRIMARY KEY (nickNameSecundaria),
 * CONSTRAINT fk_nickNameCs FOREIGN KEY (nickNameSecundaria) REFERENCES contaVinculoJogo(nickName),
 * CONSTRAINT fk_nickNameCp2 FOREIGN KEY (nickNamePrincipal) REFERENCES contaPrincipalJogo(nickNamePrincipal),
 * CONSTRAINT fk_cpfUr2 FOREIGN KEY (cpf) REFERENCES usuarioJogo(cpf)
 * );
 * </code>
 *
 */
public class ContaSecundariaJogoDao
        extends Dao<ContaSecundariaJogo> {

    public static final String TABLE = "contaSecundariaJogo";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (cpf, nickNamePrincipal, login, senha, perguntaSeguranca, "
                + "respostaSeguranca, permCardCred, permContImp, nickNameSecundaria)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set cpf = ?, nickNamePrincipal = ?, login = ?, senha = ?, "
                + "perguntaSeguranca = ?, respostaSeguranca = ?, "
                + "permCardCred = ?, permContImp = ?"
                + " where nickNameSecundaria = ?";

    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, ContaSecundariaJogo e) {
        try
        {
            pstmt.setString(1, e.getUsuarioJogo().getCpf());
            pstmt.setString(2, e.getContaPrincipalJogo().getNickName());
            pstmt.setString(3, e.getLogin());
            pstmt.setString(4, e.getSenha());
            pstmt.setString(5, e.getPerguntaSeguranca());
            pstmt.setString(6, e.getRespostaSeguranca());
            pstmt.setInt(7, e.isPermissaoCardCredito());
            pstmt.setInt(8, e.isPermissaoContImproprio());
            pstmt.setString(9, e.getNickName());

        } catch (SQLException ex)
        {
            Logger.getLogger(ContaSecundariaJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByPkStatment() {
        return "delete from " + TABLE + " where nickNameSecundaria = ?";
    }

    @Override
    public void composeDeleteByPkStatement(PreparedStatement pstmt, ContaSecundariaJogo e) {
        try
        {
            pstmt.setString(1, e.getNickName());
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaSecundariaJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByPkStatment() {
        return "select cpf, nickNamePrincipal, login, senha, perguntaSeguranca, "
                + "respostaSeguranca, permCardCred, permContImp, nickNameSecundaria"
                + " from " + TABLE + " where nickNameSecundaria = ?";
    }

    @Override
    public void composeFindByPkStatement(PreparedStatement pstmt, ContaSecundariaJogo e) {
        try
        {
            pstmt.setString(1, e.getNickName());
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaSecundariaJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindAllStatment() {
        return "select cpf, nickNamePrincipal, login, senha, perguntaSeguranca, "
                + "respostaSeguranca, permCardCred, permContImp, nickNameSecundaria"
                + " from " + TABLE;
    }

    @Override
    public ContaSecundariaJogo extractObject(ResultSet resultSet) {
        ContaSecundariaJogo contaSecundaria = null;

        UsuarioJogo usuario = null;
        UsuarioJogoDao usuarioDao = null;

        ContaPrincipalJogo contaPrincipal = null;
        ContaPrincipalJogoDao contaPrincipalDao = null;
        try
        {
            usuario = new UsuarioJogo();
            usuario.setCpf(resultSet.getString("cpf"));
            usuarioDao = new UsuarioJogoDao();
            usuario = usuarioDao.findByPk(usuario);

            contaPrincipal = new ContaPrincipalJogo();
            contaPrincipal.setNickName(resultSet.getString("nickNamePrincipal"));
            contaPrincipalDao = new ContaPrincipalJogoDao();
            contaPrincipal = contaPrincipalDao.findByPk(contaPrincipal);

            contaSecundaria = new ContaSecundariaJogo();

            contaSecundaria.setNickName(resultSet.getString("nickNameSecundaria"));
            contaSecundaria.setUsuarioJogo(usuario);
            contaSecundaria.setContaPrincipalJogo(contaPrincipal);
            contaSecundaria.setLogin(resultSet.getString("login"));
            contaSecundaria.setSenha(resultSet.getString("senha"));
            contaSecundaria.setPerguntaSeguranca(resultSet.getString("perguntaSeguranca"));
            contaSecundaria.setRespostaSeguranca(resultSet.getString("respostaSeguranca"));
            contaSecundaria.setPermissaoCardCredito(resultSet.getInt("permCardCred"));
            contaSecundaria.setPermissaoContImproprio(resultSet.getInt("permContImp"));
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaSecundariaJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex)
        {
            Logger.getLogger(ContaSecundariaJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaSecundaria;
    }
}
