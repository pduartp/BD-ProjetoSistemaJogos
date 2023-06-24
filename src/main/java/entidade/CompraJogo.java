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
 * CompraJogo: {ID, nickNameConta_FK, dataCompra, quantidadeTotalProduto,
 * preçoTotalProduto}
 *
 * @author patri
 */
public class CompraJogo {

    private Integer id;
    private LocalDate dataCompra;
    private float quantTotal;
    private float precoTotal;
    // TODO implementar conta para chave estrangeira...
    ContaVinculoJogo contaVinculoJogo;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public CompraJogo() {
    }

    public CompraJogo(Integer id, LocalDate dataCompra, float quantTotal, float precoTotal, ContaVinculoJogo contaVinculoJogo) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.quantTotal = quantTotal;
        this.precoTotal = precoTotal;
        this.contaVinculoJogo = contaVinculoJogo;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public float getQuantTotal() {
        return quantTotal;
    }

    public void setQuantTotal(float quantTotal) {
        this.quantTotal = quantTotal;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public ContaVinculoJogo getContaVinculoJogo() {
        return contaVinculoJogo;
    }

    public void setContaVinculoJogo(ContaVinculoJogo contaVinculoJogo) {
        this.contaVinculoJogo = contaVinculoJogo;
    }

//</editor-fold>
    @Override
    public String toString() {
        return '\n'
                + "Compra{"
                + "id=" + id
                + "nickName=" + contaVinculoJogo.getNickName()
                + ", dataCompra=" + dataCompra
                + ", quantTotal=" + quantTotal
                + ", precoTotal=" + precoTotal
                + '}';
    }
}
