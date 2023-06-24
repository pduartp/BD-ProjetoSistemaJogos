package entidade;

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
/**
 * Relação: ContaVínculo: {nickNameConta, tipoConta}
 *
 * @author patri
 */
public class ContaVinculoJogo {

    String nickName;
    private String tipoConta;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ContaVinculoJogo() {
    }

    public ContaVinculoJogo(String nickName, String tipoConta) {
        this.nickName = nickName;
        this.tipoConta = tipoConta;
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

//</editor-fold>
    @Override
    public String toString() {
        return  '\n'
                + "ContaVinculo{"
                + "nickName=" + nickName
                + ", tipoConta=" + tipoConta
                + '}';
    }

}
