package sptech.jar.individual.augusto;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 *
 * @author augustocosta
 */
public class Database {

    private JdbcTemplate connection;

    public Database() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://svr-projeto-easy.database.windows.net:1433;database=bd-projeto-easy;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("admin-projeto-easy@svr-projeto-easy");
        dataSource.setPassword("#Gfgrupo1");

        this.connection = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnection() {
        return connection;

    }

    public void update(String sql, String idUser, String idEmpresa) {
        connection.update(sql, idUser, idEmpresa);
    }

    public void insertI(String nome, String email, String senha, String cargo, Integer idGestor, Integer idEmpresa) {

        String sql = "INSERT INTO Usuario (nome, email, senha, cargo, fkGestor, fk_empresa) VALUES (?, ?, ?, ?, ?, ?)";

        connection.update(sql, nome, email, senha, cargo, idGestor, idEmpresa);
    }
}
