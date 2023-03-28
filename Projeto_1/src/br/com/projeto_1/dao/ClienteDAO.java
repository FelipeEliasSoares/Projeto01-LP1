/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_1.dao;

/**
 *
 * @author Aluno
 */

import java.sql.*;
import br.com.projeto_1.dto.ClienteDTO;

public class ClienteDAO {
   
    public  ClienteDAO(){
    }
    
    //Atributo do ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    public  boolean inserirCliente(ClienteDTO clienteDTO){
        try {
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, " 
                    + "bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values ( " 
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getLogradouro_cli() + "', "
                    + clienteDTO.getNumero_cli()+ ", "
                    + "'" + clienteDTO.getBairro_cli() + "', "
                    + "'" + clienteDTO.getCidade_cli() + "', "
                    + "'" + clienteDTO.getEstado_cli() + "', "
                    + "'" + clienteDTO.getCep_cli() + "', " 
                    + "'" + clienteDTO.getCpf_cli() + "', "
                    + "'" + clienteDTO.getRg_cli() + "') ";
                     
            //Executa o comando SQL o banco de Dados
            
            stmt.execute(comando.toUpperCase());
            
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            
            return true;
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return  false;
        }
        
        finally{
            //Chama o metado da clase ConexaoDAO para fechar o banco de Dados
            ConexaoDAO.CloseDB();
        }
        
    }//fecha metado inserir;
    
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        try {
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "";
            
            switch(opcao){
                case  1:
                    comando = "Select c.* "+
                            "from cliente c " +
                            "where nome_cli like '" + clienteDTO.getNome_cli() + "%' "+
                            "order by c.nome_cli";
                break;
                
                case 2:
                    comando = "Select c.* "+
                            "from cliente c " + 
                            "where c.id_cli = " + clienteDTO.getId_cli();
                break;
                
                case 3:
                    comando  ="Select c.id_cli, c.nome_cli " +
                            "from cliente c ";
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return  rs;
        }//fehca try 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return  rs;
        }//fecha catch
    }//fecha metado consultarCliente
    
    public boolean alterarCliente(ClienteDTO clienteDTO){
        try {
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Update cliente set "
            + "nome_cli = '" + clienteDTO.getNome_cli()+ "', "
            + "logradouro_cli = '" + clienteDTO.getLogradouro_cli()+ "', "
            + "numero_cli = " + clienteDTO.getNumero_cli() + ", "
            + "bairro_cli = '" + clienteDTO.getBairro_cli() + "', "
            + "cidade_cli = '" + clienteDTO.getCidade_cli() + "', "
            + "estado_cli = '" + clienteDTO.getEstado_cli() + "', "
            + "cep_cli = '" + clienteDTO.getCep_cli()+ "', "
            + "cpf_cli = '" + clienteDTO.getCpf_cli()+ "', "
            + "rg_cli = '"  + clienteDTO.getRg_cli() + "' "
            + "where id_cli = " +clienteDTO.getId_cli();
            
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            return true;
            }//fecha try
        catch (Exception e) {
                System.out.println(e.getMessage());
                return  false;
        }//fecha catch
        finally{
            ConexaoDAO.CloseDB();
        }
    }//fecha alterarCliente
    
    public boolean excluirCliente(ClienteDTO clienteDTO){
        try {
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from cliente where id_cli = "
                            + clienteDTO.getId_cli();
            
            stmt.execute(comando);
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
                 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  false;
        }//fecha catch
        finally{
            ConexaoDAO.CloseDB();
        }
        
    }//fecha excluirCliente
}//
