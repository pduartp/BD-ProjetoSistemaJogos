/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package io.github.pduartp.bdprojeto3;

import entidade.CompraJogo;
import entidade.ContaPrincipalJogo;
import entidade.ContaSecundariaJogo;
import entidade.ContaVinculoJogo;
import entidade.UsuarioJogo;
import java.time.LocalDate;
import java.util.List;
import repositorio.CompraJogoDao;

/**
 *
 * @author patri
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Objetos">
        UsuarioJogo usuario = new UsuarioJogo(
                "Pedrinho", "123", 18, "08/09/2006", "Japan", "pedro123@hot.com");
        UsuarioJogo usuario2 = new UsuarioJogo(
                "João", "456", 22, "08/01/2004", "Brasil", "joão@pet.com");
        UsuarioJogo usuario3 = new UsuarioJogo(
                "Bruninho rebenta correntes", "789", 30,
                "08/07/2001", "Tailandia", "bru@gmail.com");

//        TODO: IMPLEMENTAR ENUM PARA tipoConta
        ContaVinculoJogo contaVinculo = new ContaVinculoJogo(
                "maleniaBOM", "secundária");
        ContaVinculoJogo contaVinculo2 = new ContaVinculoJogo(
                "feijaozinho1", "primária");
        ContaVinculoJogo contaVinculo3 = new ContaVinculoJogo(
                "apaixonadh1", "secundária");

        ContaPrincipalJogo contaPrincipal = new ContaPrincipalJogo(
                "pedroa", "111", "Nome da Mae", "Maria",
                usuario, contaVinculo2.getNickName(), contaVinculo2.getTipoConta());

        ContaSecundariaJogo contaSecundaria = new ContaSecundariaJogo("joa",
                "23231", "Irmao", "Pedro", (int) 0, (int) 0, usuario2,
                contaPrincipal, contaVinculo.getNickName(),
                contaVinculo.getNickName());

        ContaSecundariaJogo contaSecundaria2 = new ContaSecundariaJogo("brbruno1",
                "32r3", "-", "-", (int) 1, (int) 1, usuario3,
                contaPrincipal, contaVinculo3.getNickName(),
                contaVinculo3.getNickName());

        CompraJogo compra = new CompraJogo(
                (int) 1, LocalDate.now(), 300, 500, contaVinculo
        );

        CompraJogo compra2 = new CompraJogo(
                (int) 2, LocalDate.now(), 33300, 2500, contaVinculo
        );
        
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CRUD UsuarioJogo (OK)">
//        // SALVA UM USUARIO
//        new UsuarioDao().saveOrUpdate(usuario, true);
//        new UsuarioDao().saveOrUpdate(usuario2, true);
//        new UsuarioDao().saveOrUpdate(usuario3, true);
//          
//        // PROCURA UM ID DE USUARIO
//        UsuarioJogo usuarioAux = new UsuarioDao().findByPk(usuario);
//        System.out.println("> Usuario encontrado: " + usuarioAux);
//
//        // PROCURA TODOS OS USUARIOS
//        List<Usuario> usuarios = new UsuarioDao().findAll();
//        System.out.println("> Usuarios encontrados:\n" + usuarios);
//
//        // ATUALIZA UM USUARIO
//        usuario3.setNome("Bruna novos horizontes");
//        new UsuarioDao().saveOrUpdate(usuario3, false);
//        
//        // DELETA UM USUARIO
//        new UsuarioDao().deleteByPk(usuario2);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ContaVinculoJogo (OK)">
//        new ContaVinculoJogoDao().saveOrUpdate(contaVinculo, true);
//        new ContaVinculoJogoDao().saveOrUpdate(contaVinculo2, true);
//        new ContaVinculoJogoDao().saveOrUpdate(contaVinculo3, true);
//
//        ContaVinculoJogo contaVinculoAux = 
//                new ContaVinculoJogoDao().findByPk(contaVinculo);
//        System.out.println("> Conta Vinculo encontrada: " + contaVinculoAux);
//
//        List<ContaVinculo> contaVinculos = new ContaVinculoJogoDao().findAll();
//        System.out.println("> Contas Vinculos ecnontradas: " + contaVinculos);
//
//        contaVinculo.setTipoConta("primária");
//        new ContaVinculoJogoDao().saveOrUpdate(contaVinculo, false);
//
//        new ContaVinculoJogoDao().deleteByPk(contaVinculo3);
//
//        new ContaVinculoJogoDao().deleteByPk(contaVinculo3);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ContaPrincipalJogo (OK)">
//        new ContaPrincipalJogoDao().saveOrUpdate(contaPrincipal, true);
//        
//        ContaPrincipalJogo contaPrincipalAux = 
//                new ContaPrincipalJogoDao().findByPk(contaPrincipal);
//        System.out.println("> ContaPrincipal encontrada: " + contaPrincipalAux);
//        
//        List<ContaPrincipalJogo> contasPrincipais = new ContaPrincipalJogoDao().findAll();
//        System.out.println("> ContasPrincipais encontradas: " + contasPrincipais);
//        
//        contaPrincipal.setPerguntaSeguranca("Nome do pai");
//        new ContaPrincipalJogoDao().saveOrUpdate(contaPrincipal, false);
//        
//        new ContaPrincipalJogoDao().deleteByPk(contaPrincipal);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ContaSecundariaJogo (OK)">
//        new ContaSecundariaJogoDao().saveOrUpdate(contaSecundaria, true);
//        new ContaSecundariaJogoDao().saveOrUpdate(contaSecundaria2, true);
//        ContaSecundariaJogo contaSecundariaAux
//                = new ContaSecundariaJogoDao().findByPk(contaSecundaria);
//        System.out.println("> ContaSecundaria encontrada: " + contaSecundariaAux);
//        
//        List<ContaSecundariaJogo> contasSecundarias = new ContaSecundariaJogoDao().findAll();
//        System.out.println("> ContasSecundarias encontradas: " + contasSecundarias);
//        
//        contaSecundaria.setLogin("bolachinhaAzeda");
//        new ContaSecundariaJogoDao().saveOrUpdate(contaSecundaria, false);
//          
//          new ContaSecundariaJogoDao().deleteByPk(contaSecundaria);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ContaJogo (OK)">
//        new CompraJogoDao().saveOrUpdate(compra, true);
//        new CompraJogoDao().saveOrUpdate(compra2, true);
//        
//        CompraJogo compraAux = new CompraJogoDao().findByPk(compra);
//        System.out.println("> Compra encontrada: " + compraAux);
//        
//        List<CompraJogo> compras = new CompraJogoDao().findAll();
//        System.out.println("> Compras encontradas" + compras);
//        
//        compra.setContaVinculoJogo(contaVinculo3);
//        new CompraJogoDao().saveOrUpdate(compra, false);
//        
//        new CompraJogoDao().deleteByPk(compra);
//</editor-fold>
    }
}
