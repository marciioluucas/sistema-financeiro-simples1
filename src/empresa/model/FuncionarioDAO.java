package empresa.model;

import empresa.controller.Funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Marcio on 02/12/2016.
 */
public class FuncionarioDAO {

    public static boolean create(Funcionario f) throws Exception {
        Statement stm = BancoDados.createConnection().createStatement();
        try {
            String sql = "insert into funcionarios (fk_cargo, nome, cpf)" +
                    "VALUES (" + f.getFk_cargo() + ", '" + f.getNome() + "','" + f.getCpf() + "')";
            ResultSet rs = stm.getGeneratedKeys();
            f.setPk_funcionario(rs.getInt(1));
            if (stm.execute(sql)) {
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao executar query: " + e.getMessage());
        }
        return false;
    }

    public static boolean update(Funcionario f) throws Exception {
        Statement stm = BancoDados.createConnection().createStatement();
        try {
            String sql = "update funcionarios set nome='" + f.getNome() + "', " +
                    "cpf='" + f.getCpf() + "'" +
                    "where pk_funcionario=" + f.getPk_funcionario();

            stm.execute(sql);
        } catch (Exception e) {
            throw new Exception("Erro ao executar query: " + e.getMessage());
        }
        return false;
    }

    public static Funcionario retreave(int pk_funcionario) {
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();

            String sql = "select * from funcionarios where pk_funcionario =" + pk_funcionario;

            ResultSet rs = stm.executeQuery(sql);
            rs.next();


            return new Funcionario(pk_funcionario,
                    rs.getInt("fk_cargo"),
                    rs.getString("nome"),
                    rs.getString("cpf"));
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return null;
    }

    public static ArrayList<Funcionario> retreaveAll() {
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();

            String sql = "SELECT * FROM funcionarios";

            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Funcionario> cs = new ArrayList<>();
            while (rs.next()) {
                cs.add(new Funcionario(rs.getInt("pk_funcionario"),
                        rs.getInt("fk_cargo"),
                        rs.getString("nome"),
                        rs.getString("cpf")));
            }

            return cs;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(Funcionario f) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "delete from funcionarios where pk_funcionario =" + f.getPk_funcionario();
        stm.execute(sql);
        return false;
    }
}
