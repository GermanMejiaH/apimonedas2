package monedas.api.dominio.dtos;

import monedas.api.dominio.entidades.Usuario;

public class UsuarioLoginDto {
    private Usuario usuario;
    private String token;
    private String username;
    private String password;

    public UsuarioLoginDto() {
    }

    public UsuarioLoginDto(Usuario usuario) {
        this.usuario = usuario;
        this.token = "";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
