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
import entidade.ContaVinculoJogo;
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
 * CREATE TABLE contaPrincipalJogo (
 * nickName VARCHAR(15) NOT NULL,
 * cpf VARCHAR(14),
 * login VARCHAR(20),
 * senha VARCHAR(20),
 * perguntaSeguranca VARCHAR(60),
 * respostaSeguranca VARCHAR(60),
 * CONSTRAINT pk_nickNameCp PRIMARY KEY (nickName),
 * CONSTRAINT fk_nickNameCp FOREIGN KEY (nickName) REFERENCES contaVinculoJogo(nickName),
 * CONSTRAINT fk_cpfUr FOREIGN KEY (cpf) REFERENCES usuarioJogo(cpf)
 * )
 * </code>
 */
public class ContaPrincipalJogoDao
        extends Dao<ContaPrincipalJogo> {

    public static final String TABLE = "contaPrincipalJogo";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (cpf, login, senha, perguntaSeguranca, respostaSeguranca, nickNamePrincipal)"
                + " values (?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set cpf = ?, login = ?, senha = ?, perguntaSeguranca = ?, respostaSeguranca = ?"
                + " where nickNamePrincipal = ?";

    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, ContaPrincipalJogo e) {
        try
        {
            pstmt.setString(1, e.getUsuarioJogo().getCpf());
            pstmt.setString(2, e.getLogin());
            pstmt.setString(3, e.getSenha());
            pstmt.setString(4, e.getPerguntaSeguranca());
            pstmt.setString(5, e.getRespostaSeguranca());
            pstmt.setString(6, e.getNickName());

        } catch (SQLException ex)
        {
            Logger.getLogger(ContaPrincipalJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByPkStatment() {
        return "delete from " + TABLE + " where nickNamePrincipal = ?";
    }

    @Override
    public void composeDeleteByPkStatement(PreparedStatement pstmt, ContaPrincipalJogo e) {
        try
        {
            pstmt.setString(1, e.getNickName());
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaPrincipalJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByPkStatment() {
        return "select cpf, login, senha, perguntaSeguranca, respostaSeguranca, nickNamePrincipal"
                + " from " + TABLE + " where nickNamePrincipal = ?";
    }

    @Override
    public void composeFindByPkStatement(PreparedStatement pstmt, ContaPrincipalJogo e) {
        try
        {
            pstmt.setString(1, e.getNickName());
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaPrincipalJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindAllStatment() {
        return "select cpf, login, senha, perguntaSeguranca, respostaSeguranca, nickNamePrincipal"
                + " from " + TABLE;
    }

    @Override
    public ContaPrincipalJogo extractObject(ResultSet resultSet) {
        ContaPrincipalJogo contaPrincipal = null;

        UsuarioJogo usuario = null;
        UsuarioJogoDao usuarioDao = null;

        try
        {
            usuario = new UsuarioJogo();
            usuario.setCpf(resultSet.getString("cpf"));
            usuarioDao = new UsuarioJogoDao();
            contaPrincipal = new ContaPrincipalJogo();

            contaPrincipal.setNickName(resultSet.getString("nickNamePrincipal"));
            contaPrincipal.setUsuarioJogo(usuarioDao.findByPk(usuario));
            contaPrincipal.setLogin(resultSet.getString("login"));
            contaPrincipal.setSenha(resultSet.getString("senha"));
            contaPrincipal.setPerguntaSeguranca(resultSet.getString("perguntaSeguranca"));
            contaPrincipal.setRespostaSeguranca(resultSet.getString("respostaSeguranca"));
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaPrincipalJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex)
        {
            Logger.getLogger(ContaPrincipalJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaPrincipal;
    }

}
