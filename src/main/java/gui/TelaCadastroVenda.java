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
package gui;

import entidade.CompraJogo;
import entidade.ContaVinculoJogo;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import repositorio.CompraJogoDao;
import repositorio.ContaVinculoJogoDao;

/**
 *
 * @author patri
 */
public class TelaCadastroVenda extends javax.swing.JFrame {
    public static TelaCadastroVenda instance;
    
    /**
     * Creates new form CadastroVenda
     */
    private TelaCadastroVenda() {
        initComponents();

        try
        {
            // Istanciando os objetos contaVinculos como lista e seu dao (informações já encontrada no banco de dados)
            List<ContaVinculoJogo> contas = new ContaVinculoJogoDao().findAll();
            // Percorre um array de contas
            for (ContaVinculoJogo c : contas)
            {
                // Seta todos os nickNames no combo box
                cbxNomeUsuario.addItem(c.getNickName());
            }

        } catch (Exception ex)
        {
            Logger.getLogger(TelaCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static TelaCadastroVenda getInstance() {
        if(instance == null) {
            instance = new TelaCadastroVenda();
        }
        
        return instance;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jTextField1 = new javax.swing.JTextField();
        pnlPrincipal = new java.awt.Panel();
        lblCadastroCompra = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDataCompra = new javax.swing.JLabel();
        lblQuantTotalProd = new javax.swing.JLabel();
        lblPrecoTotalProd = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblPesquisarID = new javax.swing.JLabel();
        txtPesquisarID = new javax.swing.JTextField();
        btnPesquisarID = new javax.swing.JButton();
        txtPreencherID = new javax.swing.JTextField();
        cbxNomeUsuario = new javax.swing.JComboBox<>();
        txtPreencherQuantProd = new javax.swing.JTextField();
        txtPreencherPrecoProd = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        fmtDataCompra = new com.toedter.calendar.JDateChooser();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblCadastroCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblCadastroCompra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCadastroCompra.setForeground(new java.awt.Color(0, 0, 0));
        lblCadastroCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastroCompra.setText("CADASTRO DA COMPRA");
        lblCadastroCompra.setAutoscrolls(true);

        lblID.setBackground(new java.awt.Color(255, 255, 255));
        lblID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(0, 0, 0));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID:");
        lblID.setAutoscrolls(true);

        lblNomeUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNomeUsuario.setText("Nome do Usuário:");
        lblNomeUsuario.setAutoscrolls(true);

        lblDataCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblDataCompra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDataCompra.setForeground(new java.awt.Color(0, 0, 0));
        lblDataCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDataCompra.setText("Data da Compra:");
        lblDataCompra.setAutoscrolls(true);

        lblQuantTotalProd.setBackground(new java.awt.Color(255, 255, 255));
        lblQuantTotalProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantTotalProd.setForeground(new java.awt.Color(0, 0, 0));
        lblQuantTotalProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantTotalProd.setText("Quantidade Total de Produtos:");
        lblQuantTotalProd.setAutoscrolls(true);

        lblPrecoTotalProd.setBackground(new java.awt.Color(255, 255, 255));
        lblPrecoTotalProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrecoTotalProd.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecoTotalProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecoTotalProd.setText("Preço Total dos Produtos:");
        lblPrecoTotalProd.setAutoscrolls(true);

        lblPesquisarID.setBackground(new java.awt.Color(255, 255, 255));
        lblPesquisarID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPesquisarID.setForeground(new java.awt.Color(0, 0, 0));
        lblPesquisarID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPesquisarID.setText("Pesquisar ID:");
        lblPesquisarID.setAutoscrolls(true);

        txtPesquisarID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPesquisarID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPesquisarID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPesquisarID.setText("Pesquisar");
        btnPesquisarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarIDActionPerformed(evt);
            }
        });

        txtPreencherID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPreencherID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPreencherID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreencherIDActionPerformed(evt);
            }
        });

        cbxNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNomeUsuarioActionPerformed(evt);
            }
        });

        txtPreencherQuantProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPreencherQuantProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPreencherPrecoProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPreencherPrecoProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpar.setText("Limpar Campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnInserir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnListar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnApagar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        fmtDataCompra.setToolTipText("");
        fmtDataCompra.setDateFormatString("dd'/ 'MM'/' yy");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCadastroCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblPesquisarID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarID))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblNomeUsuario)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataCompra)
                                    .addComponent(lblID)))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecoTotalProd)
                                    .addComponent(lblQuantTotalProd))))
                        .addGap(24, 24, 24)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreencherPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPreencherQuantProd, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPreencherID, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbxNomeUsuario, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fmtDataCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))))
                .addGap(14, 14, 14))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(lblCadastroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisarID)
                    .addComponent(txtPesquisarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtPreencherID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeUsuario)
                            .addComponent(cbxNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblDataCompra))
                    .addComponent(fmtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantTotalProd)
                    .addComponent(txtPreencherQuantProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoTotalProd)
                    .addComponent(txtPreencherPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagar)
                    .addComponent(btnListar)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void btnPesquisarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarIDActionPerformed
        // Obter o ID digitado pelo usuário
        String idPesquisadoText = txtPesquisarID.getText();
        
        // Se o campo estiver vazio, exibe uma mensagem de erro
        if (idPesquisadoText.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Id não Fornecido", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer idPesquisado = Integer.valueOf(idPesquisadoText);

        // Cria uma instância de CompraJogo e CompraJogoDao
        CompraJogo compra = new CompraJogo();
        compra.setId(idPesquisado);

        CompraJogoDao compraDao = new CompraJogoDao();

        try
        {
            // Usa o DAO para obter a compra com base no ID
            compra = compraDao.findByPk(compra);

            if (compra != null)
            {
                // Preenche os campos da interface gráfica com as informações da compra
                txtPreencherID.setText(String.valueOf(compra.getId()));
                cbxNomeUsuario.setSelectedItem(compra.getContaVinculoJogo().getNickName());
                // Outros campos de preenchimento

                // Exemplo de conversão de LocalDate para Date
                Date dataCompra = Date.from(compra.getDataCompra().atStartOfDay(ZoneId.systemDefault()).toInstant());
                fmtDataCompra.setDate(dataCompra);

                txtPreencherQuantProd.setText(String.valueOf(compra.getQuantTotal()));
                txtPreencherPrecoProd.setText(String.valueOf(compra.getPrecoTotal()));

                JOptionPane.showMessageDialog(null, "Compra encontrada!");
            } else
            {
                JOptionPane.showMessageDialog(null, "Compra não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex)
        {
            Logger.getLogger(TelaCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarIDActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtPesquisarID.setText("");
        txtPreencherID.setText("");
        cbxNomeUsuario.setSelectedIndex(0);
        txtPreencherQuantProd.setText("");
        txtPreencherPrecoProd.setText("");
        fmtDataCompra.setDate(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        CompraJogo compra = new CompraJogo();
        ContaVinculoJogo conta = new ContaVinculoJogo();

        // Verificar se os campos estão preenchidos
        if (txtPreencherID.getText().isEmpty() || cbxNomeUsuario.getSelectedItem() == null
                || txtPreencherQuantProd.getText().isEmpty() || txtPreencherPrecoProd.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(
                    null, "Não foi possível salvar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método para evitar salvar dados inválidos
        }

        compra.setId(Integer.valueOf(txtPreencherID.getText()));
        conta.setNickName(cbxNomeUsuario.getSelectedItem().toString());
        compra.setContaVinculoJogo(conta);

        Date dataCompra = fmtDataCompra.getDate();
        LocalDate localDate = dataCompra.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        compra.setDataCompra(localDate);
        compra.setQuantTotal(Float.parseFloat(txtPreencherQuantProd.getText()));
        compra.setPrecoTotal(Float.parseFloat(txtPreencherPrecoProd.getText()));

        CompraJogoDao compraDao = new CompraJogoDao();
        try
        {
            compraDao.saveOrUpdate(compra, true);
            JOptionPane.showMessageDialog(
                    null, "Compra inserida com sucesso!");
        } catch (Exception ex)
        {
            Logger.getLogger(TelaCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // Verificar se os campos estão preenchidos
        if (txtPreencherID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "ID da compra não foi fornecido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se o ID não for fornecido
        }

        // Obter o ID da compra que será alterada
        int idCompra = Integer.parseInt(txtPreencherID.getText());

        // Cria uma instância do CompraJogoDao
        CompraJogo compra = new CompraJogo();
        CompraJogoDao compraDao = new CompraJogoDao();

        ContaVinculoJogo conta = new ContaVinculoJogo();

        compra.setId(idCompra);

        try
        {
            // Use o DAO para obter a compra com base no ID
            compra = compraDao.findByPk(compra);

            if (compra != null)
            {
                // Realize as alterações necessárias no objeto compra
                // Exemplo de alteração do campo quantidade de produtos

                String novoNomeUsuario = (String) cbxNomeUsuario.getSelectedItem();
                conta.setNickName(novoNomeUsuario);

                compra.setContaVinculoJogo(conta);

                Date novaData = fmtDataCompra.getDate();
                LocalDate localDate = novaData.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                compra.setDataCompra(localDate);

                float novaQuantidade = Float.parseFloat(txtPreencherQuantProd.getText());
                compra.setQuantTotal(novaQuantidade);

                // Exemplo de alteração do campo preço do produto
                float novoPreco = Float.parseFloat(txtPreencherPrecoProd.getText());
                compra.setPrecoTotal(novoPreco);

                // Salve as alterações no banco de dados
                compraDao.saveOrUpdate(compra, false);

                JOptionPane.showMessageDialog(null, "Compra alterada com sucesso!");
            } else
            {
                JOptionPane.showMessageDialog(null, "Compra não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex)
        {
            Logger.getLogger(TelaCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // Cria uma instância do CompraJogoDao
        CompraJogoDao compraDao = new CompraJogoDao();

        try
        {
            // Usa o DAO para obter a lista de todas as compras
            List<CompraJogo> compras = compraDao.findAll();

            // Verifica se existem compras no banco de dados
            if (compras != null && !compras.isEmpty())
            {
                // Cria um modelo de tabela para armazenar os dados
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Nickname");
                model.addColumn("Quantidade de Produtos");
                model.addColumn("Preço Total");
                model.addColumn("Data da Compra");

                // Adiciona os registros de compras ao modelo de tabela
                for (CompraJogo compra : compras)
                {
                    Object[] rowData =
                    {
                        compra.getId(),
                        compra.getContaVinculoJogo().getNickName(),
                        compra.getQuantTotal(),
                        compra.getPrecoTotal(),
                        compra.getDataCompra()
                    };
                    model.addRow(rowData);
                }

                // Cria o componente JTable com o modelo de tabela
                JTable table = new JTable(model);

                // Adiciona a tabela a um JScrollPane para permitir rolagem
                JScrollPane scrollPane = new JScrollPane(table);

                // Exibe a tabela em uma janela de diálogo
                JOptionPane.showMessageDialog(null, scrollPane, "Lista de Compras", JOptionPane.INFORMATION_MESSAGE);
            } else
            {
                JOptionPane.showMessageDialog(null, "Não existem registros de compras.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex)
        {
            Logger.getLogger(TelaCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // Verificar se o campo ID está preenchido
        if (txtPreencherID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "ID da compra não foi fornecido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se o ID não for fornecido
        }

        // Obter o ID da compra que será excluída
        int idCompra = Integer.parseInt(txtPreencherID.getText());

        // Crie uma instância do CompraJogoDao
        CompraJogo compra = new CompraJogo();
        CompraJogoDao compraDao = new CompraJogoDao();

        compra.setId(idCompra);

        try
        {
            // Use o DAO para obter a compra com base no ID
            compra = compraDao.findByPk(compra);

            if (compra != null)
            {
                // Exclua a compra do banco de dados
                compraDao.deleteByPk(compra);

                JOptionPane.showMessageDialog(null, "Compra excluída com sucesso!");
            } else
            {
                JOptionPane.showMessageDialog(null, "Compra não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex)
        {
            Logger.getLogger(TelaCadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtPreencherIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreencherIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreencherIDActionPerformed

    private void cbxNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNomeUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPesquisarID;
    private javax.swing.JComboBox<String> cbxNomeUsuario;
    private com.toedter.calendar.JDateChooser fmtDataCompra;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCadastroCompra;
    private javax.swing.JLabel lblDataCompra;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblPesquisarID;
    private javax.swing.JLabel lblPrecoTotalProd;
    private javax.swing.JLabel lblQuantTotalProd;
    private java.awt.Panel pnlPrincipal;
    private javax.swing.JTextField txtPesquisarID;
    private javax.swing.JTextField txtPreencherID;
    private javax.swing.JTextField txtPreencherPrecoProd;
    private javax.swing.JTextField txtPreencherQuantProd;
    // End of variables declaration//GEN-END:variables
}
