package Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControlPerson {

    ConectaBanco conecta = new ConectaBanco();

    public void insert(ModelPessoa mod) {
        try{
            conecta.conexao();
        PreparedStatement prepStat = conecta.connection.prepareStatement("INSERT INTO pessoa (id, nome, sobrenome, cargo, data_nascimento) values (?,?,?,?,?)");
        prepStat.setInt(1, mod.getId());
        prepStat.setString(2, mod.getNome());
        prepStat.setString(3, mod.getSobrenome());
        prepStat.setString(4, mod.getDescription());
        prepStat.setString(5, mod.getDataNascimento());
        prepStat.executeUpdate();
        System.out.println("Dados de: " + mod.getNome()+ " cadastrados");
        conecta.desconecta();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
}
