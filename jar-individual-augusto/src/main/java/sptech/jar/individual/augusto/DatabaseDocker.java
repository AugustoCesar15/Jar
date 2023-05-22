/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.individual.augusto;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author augustocosta
 */
public class DatabaseDocker {

    private JdbcTemplate connection;

    public DatabaseDocker() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://174.129.59.121:3306/banco1?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");

        this.connection = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnection() {
        return connection;
    }

    public void insertDocker(String nome, String sobrenome, String email, String senha, String cargo, Integer idGestor, Integer idEmpresa) {

        try {

            DatabaseDocker databaseDocker = new DatabaseDocker();

            JdbcTemplate connection = databaseDocker.getConnection();

            String sql = "INSERT INTO Usuario (nome, sobrenome, email, senha, cargo, fkGestor, fk_empresa) values (?, ?, ?, ?, ?, ?, ?)";

            connection.update(sql, nome, sobrenome, email, senha, cargo, idGestor, idEmpresa);

            System.out.println("Seus dados foram cadastrados com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu uma falha no cadastro " + e.getMessage());
        }
    }
}
