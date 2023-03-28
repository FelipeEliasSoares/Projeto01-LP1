/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_1.dao;

//** Essa classe contém os metodos para abrir  e fechar o banco de dados... **//
import java.sql.*;
/**
 *
 * @author Aluno
 */
public class ConexaoDAO {
    
    //Criando um atributo dp tipo Connecntion que servira para guardar a conexão com banco de dados 
    
    public  static  Connection con = null;
    
    //** Métado construtor da classe..5 linhas*/
    
    public ConexaoDAO(){
        
    
    }
    
    public  static void ConectDB(){
        try {
            //Dados para conectar com o banco de dados Postgres
            String dsn = "projeto_01";
            String user = "postgres";
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url= "jdbc:postgresql://localhost:5432/" + dsn;
            
            //jdbc:postgresql://localhost:5432/
            con = DriverManager.getConnection(url, user , senha);
            
            con.setAutoCommit(false);
            if(con == null){
                System.out.println("erro ao abrir o banco");
            }
        }//fecha try
        catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados: " + e.getMessage());
        }//fecha catch
    
    }//Fecha o métado ConectDB
    
    
    public static void CloseDB(){
        try {
            con.close();
        }//fecha try
        catch (Exception e) {
            System.out.println("Problema ao abir a base de dados!" + e.getMessage());
        }
        
    }
}

