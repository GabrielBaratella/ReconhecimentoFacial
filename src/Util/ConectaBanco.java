package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaBanco {
        
    public Statement stm;
    
    public ResultSet rs;
    
    public Connection connection;
    
    private final String driver = "org.mysql.Driver";
    
    private String root = "jdbc:mysql://127.0.0.1/facial_recognition";
           
    private String user = "root";
    
    private String pass = "";
    

    
    public void conexao(){
        try{
            System.setProperty("jdbc.Driver", driver);
            connection = DriverManager.getConnection(root, user, pass);
            System.out.println("Conexão bem sucedida !");
        }catch(Exception e){
            System.out.println("Error" + e);
        }
        
    }
    
    public void desconecta(){
        try{
            connection.close();
        }catch(SQLException e){
            System.out.println("Error " + e);
        }
    }
    
    public void executaSQL(String SQL){
        try{
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        }catch(Exception e){
            System.out.println("Error " + e);
        }
    }
    public static void main(String[] args) {
        ConectaBanco conecta = new ConectaBanco();
        conecta.conexao();
    }
}
