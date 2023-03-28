/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.ctr;

/**
 *
 * @author Aluno
 */

import java.sql.ResultSet;
import br.com.projeto_1.dto.ClienteDTO;
import br.com.projeto_1.dao.ClienteDAO;
import br.com.projeto_1.dao.ConexaoDAO;


public class ClienteCTR {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public String inserirCliente(ClienteDTO clienteDTO){
        try {
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente cadastrado com Sucesso!!!";
            }
            else{
                return "Cliente NÂO Cadastrado";
            }
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÂO Cadastrado";
        }//fecha catch
        
    }//fecha metado inserirCliente
    
    public  ResultSet consultarCliente(ClienteDTO clienteDTO,int opcao){
        ResultSet rs= null;
        
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        
        return  rs;
    }// fecha metado consultarCliente
    
    public  void CloseDB(){
        ConexaoDAO.CloseDB();
        
    }//fecha metada closeDB
    
    public  String alterarCliente(ClienteDTO clienteDTO){
        try {
            if(clienteDAO.alterarCliente(clienteDTO)){
                return  "Cliente Alterado com Sucesso!!!";
            }else{
                return  "Cliente NÂO alterado!!!";
            }
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return  "Cliente NAO alterado!!!";
        }//fecha catch
    
    }//fecha alterarcliente
    
    public String excluirCliente(ClienteDTO clienteDTO){
        try {
            if(clienteDAO.excluirCliente(clienteDTO)){
                return  "Cliente Excluído com Sucesso!!!";
            }else{
                return "Cliente NÂO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÂO Excluído!!!";
        }
    }//fecha o metado excluirCliente
    
}//fecha geral


