package sptech.jar.individual.augusto;

import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author augustocosta
 */
public class IndividualJar {

    public static void main(String[] args) {
        System.out.println("Olá, seja bem-vindo!");
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);

        Integer escolha;

        DatabaseDocker conexaoBancoLocal = new DatabaseDocker();
        Database conexaoBanco = new Database();
        JdbcTemplate conexao = conexaoBanco.getConnection();
        JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();

        SelectUser select = new SelectUser();

        do {
            System.out.println("Acessando nosso banco de dados...");
            System.out.println("...".repeat(5));
            System.out.println("Você deseja: 1 - Cadastro ou 2 - Login? ");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("------------------Cadastro------------------");
                    System.out.println("Nome: ");
                    String sNome = leitor2.next();

                    System.out.println("Sobrenome: ");
                    String sSobrenome = leitor2.next();

                    System.out.println("Email: ");
                    String sEmail = leitor2.next();

                    System.out.println("Senha: ");
                    String sSenha = leitor2.next();

                    System.out.println("Cargo: ");
                    String sCargo = leitor2.next();

                    System.out.println("ID Gestor: ");
                    Integer sIdGestor = leitor2.nextInt();

                    System.out.println("ID Empresa: ");
                    Integer sIdEmpresa = leitor2.nextInt();

                    System.out.println("Finalizando seu cadastro");
                    System.out.println("_".repeat(10));

                    conexaoBanco.insertI(sNome, sEmail, sSenha, sCargo, sIdGestor, sIdEmpresa);
                    conexaoBancoLocal.insertDocker(sNome, sSobrenome, sEmail, sSenha, sCargo, sIdGestor, sIdEmpresa);

                    break;
                case 2:
                    System.out.println("------------------Login------------------");
                    System.out.println("Email: ");
                    String lEmail = leitor2.next();

                    System.out.println("Senha: ");
                    String lSenha = leitor2.next();

                    System.out.println("Verificando no banco...");
                    System.out.println(".".repeat(15));

                    select.selectAndInsert(lEmail, lSenha);
                    break;
                default:
                    System.out.println("Opção inválida \nEscolha outra opção");
            }
        } while (escolha == 0);

    }
}
