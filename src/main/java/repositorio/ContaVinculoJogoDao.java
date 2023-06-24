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

import entidade.ContaVinculoJogo;
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
 * CREATE TABLE contaVinculoJogo (
    nickName VARCHAR(15) NOT NULL,
    tipoConta VARCHAR(20),
    CONSTRAINT pk_nickNameCon PRIMARY KEY (nickName)
    );
 * </code>
 */
public class ContaVinculoJogoDao
        extends Dao<ContaVinculoJogo> {

    public static final String TABLE = "contaVinculoJogo";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (tipoConta, nickName)"
                + " values (?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set tipoConta = ?"
                + " where nickName = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, ContaVinculoJogo e) {
        try
        {
            pstmt.setString(1, e.getTipoConta());
            pstmt.setString(2, e.getNickName());

        } catch (SQLException ex)
        {
            Logger.getLogger(ContaVinculoJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByPkStatment() {
        return "delete from " + TABLE + " where nickName = ?";
    }

    @Override
    public void composeDeleteByPkStatement(PreparedStatement pstmt, ContaVinculoJogo e) {
        try
        {
            pstmt.setString(1, e.getNickName());
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaVinculoJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByPkStatment() {
        return "select tipoConta, nickName"
                + " from " + TABLE + " where nickName = ?";
    }

    @Override
    public void composeFindByPkStatement(PreparedStatement pstmt, ContaVinculoJogo e) {
        try
        {
            pstmt.setString(1, e.getNickName());
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaVinculoJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindAllStatment() {
        return "select tipoConta, nickName"
                + " from " + TABLE;
    }

    @Override
    public ContaVinculoJogo extractObject(ResultSet resultSet) {
        ContaVinculoJogo contaVinculo = null;

        try
        {
            contaVinculo = new ContaVinculoJogo();
            contaVinculo.setNickName(resultSet.getString("nickName"));
            contaVinculo.setTipoConta(resultSet.getString("tipoConta"));
        } catch (SQLException ex)
        {
            Logger.getLogger(ContaVinculoJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaVinculo;
    }

}
