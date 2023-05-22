/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.jar.individual.augusto;

/**
 *
 * @author augustocosta
 */
public class Usuario {
      private String id_usuario;
    private String email;
    private String senha;
    private String fk_empresa;
    
    public Usuario(String email, String senha, String fk_empresa, String id_usuario){
        this.id_usuario = id_usuario;
        this.email = email;
        this.senha = senha;
        this.fk_empresa = fk_empresa;
    }
    
    public Usuario(){
        
    }

    @Override
    public String toString() {
        return "ObjetoUsuario{" +
                "id_usuario ='" + id_usuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", fk_empresa ='" + fk_empresa + '\'' +
                '}';
    }

    public String getEmailUsuario() {
        return email;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenhaUsuario() {
        return senha;
    }

    public String getFk_empresa() {
        return fk_empresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setFk_empresa(String fk_empresa) {
        this.fk_empresa = fk_empresa;
    }
}
