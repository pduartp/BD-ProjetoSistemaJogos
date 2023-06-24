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
 * CREATE TABLE usuario (
 * cpf VARCHAR(14) NOT NULL,
 * nome VARCHAR(80),
 * idade NUMBER,
 * dataNascimento VARCHAR(10),
 * pais VARCHAR(50),
 * email VARCHAR(30)
 * CONSTRAINT pk_CPFur PRIMARY KEY (cpf)
 * );
 * </code>
 */
public class UsuarioJogoDao
        extends Dao<UsuarioJogo> {

    public static final String TABLE = "usuarioJogo";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (nome, idade, dataNascimento, pais, email, cpf)"
                + " values (?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set nome = ?, idade = ?, dataNascimento = ?, pais = ?, email = ?"
                + " where cpf = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, UsuarioJogo e) {
        try
        {
            pstmt.setString(1, e.getNome());
            pstmt.setInt(2, e.getIdade());
            pstmt.setString(3, e.getDataNascimento());
            pstmt.setString(4, e.getPais());
            pstmt.setString(5, e.getEmail());
            pstmt.setString(6, e.getCpf());

        } catch (SQLException ex)
        {
            Logger.getLogger(UsuarioJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByPkStatment() {
        return "delete from " + TABLE + " where cpf = ?";
    }

    @Override
    public void composeDeleteByPkStatement(PreparedStatement pstmt, UsuarioJogo e) {
        try
        {
            pstmt.setString(1, e.getCpf());
        } catch (SQLException ex)
        {
            Logger.getLogger(UsuarioJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByPkStatment() {
        return "select nome, idade, dataNascimento, pais, email, cpf"
                + " from " + TABLE + " where cpf = ?";
    }

    @Override
    public void composeFindByPkStatement(PreparedStatement pstmt, UsuarioJogo e) {
        try
        {
            pstmt.setString(1, e.getCpf());
        } catch (SQLException ex)
        {
            Logger.getLogger(UsuarioJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindAllStatment() {
        return "select nome, idade, dataNascimento, pais, email, cpf"
                + " from " + TABLE;
    }

    @Override
    public UsuarioJogo extractObject(ResultSet resultSet) {
        UsuarioJogo usuario = null;

        try
        {
            usuario = new UsuarioJogo();
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setIdade(resultSet.getInt("idade"));
            usuario.setDataNascimento(resultSet.getString("dataNascimento"));
            usuario.setPais(resultSet.getString("pais"));
            usuario.setEmail(resultSet.getString("email"));
        } catch (SQLException ex)
        {
            Logger.getLogger(UsuarioJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
