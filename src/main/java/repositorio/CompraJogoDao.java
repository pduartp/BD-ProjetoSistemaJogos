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

import entidade.CompraJogo;
import entidade.ContaVinculoJogo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 * 
 * <code>
 * CREATE TABLE compraJogo (
   id NUMBER NOT NULL,
   nickName VARCHAR(15),
   dataCompra Date,
   quantTotal NUMBER,
   precoTotal NUMBER,
   CONSTRAINT pk_idCom PRIMARY KEY (id),
   CONSTRAINT fk_nickNameCon FOREIGN KEY (nickName) REFERENCES contaVinculoJogo(nickName)
   );
 * </code>
 * 
 */
public class CompraJogoDao
        extends Dao<CompraJogo> {

    public static final String TABLE = "compraJogo";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + " (nickName, dataCompra, quantTotal, precoTotal, id)"
                + " values (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set nickName = ?, dataCompra = ?, quantTotal = ?, precoTotal = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, CompraJogo e) {
        try
        {
            pstmt.setString(1, e.getContaVinculoJogo().getNickName());
            pstmt.setObject(2, e.getDataCompra(), java.sql.Types.DATE);
            pstmt.setFloat(3, e.getQuantTotal());
            pstmt.setFloat(4, e.getPrecoTotal());
            pstmt.setFloat(5, e.getId());

        } catch (SQLException ex)
        {
            Logger.getLogger(CompraJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByPkStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeDeleteByPkStatement(PreparedStatement pstmt, CompraJogo e) {
        try
        {
            pstmt.setInt(1, e.getId());
        } catch (SQLException ex)
        {
            Logger.getLogger(CompraJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByPkStatment() {
        return "select nickName, dataCompra, quantTotal, precoTotal, id"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public void composeFindByPkStatement(PreparedStatement pstmt, CompraJogo e) {
        try
        {
            pstmt.setInt(1, e.getId());
        } catch (SQLException ex)
        {
            Logger.getLogger(CompraJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindAllStatment() {
        return "select nickName, dataCompra, quantTotal, precoTotal, id"
                + " from " + TABLE;
    }

    @Override
    public CompraJogo extractObject(ResultSet resultSet) {
        CompraJogo compra = null;

        ContaVinculoJogo contaVinculo = null;
        ContaVinculoJogoDao contaVinculoDao = null;

        try
        {
            compra = new CompraJogo();
            
            contaVinculo = new ContaVinculoJogo();
            contaVinculo.setNickName(resultSet.getString("nickName"));
            contaVinculoDao = new ContaVinculoJogoDao();
            
            compra.setId(resultSet.getInt("id"));
            compra.setContaVinculoJogo(contaVinculoDao.findByPk(contaVinculo));
            compra.setDataCompra(
                    resultSet.getObject(
                            "dataCompra", LocalDate.class));
            compra.setQuantTotal(resultSet.getInt("quantTotal"));
            compra.setPrecoTotal(resultSet.getInt("precoTotal"));
        } catch (SQLException ex)
        {
            Logger.getLogger(CompraJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex)
        {
            Logger.getLogger(CompraJogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compra;
    }

}
