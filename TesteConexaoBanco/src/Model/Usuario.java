package Model;

public class Usuario {

    public int IdUsuario;
    public String Nome;
	public int  IdPerfil;
    public String CPF;
    public boolean Removido;
    public String Sexo;


    public Usuario() 
    {

	}

    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String sexo) {
        Sexo = sexo;
    }
    public int getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public int getIdPerfil() {
        return IdPerfil;
    }
    public void setIdPerfil (int idPerfil) {
        IdPerfil = idPerfil;
    }
  
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    
    public boolean isRemovido() {
        return Removido;
    }
    public void setRemovido(boolean removido) {
        Removido = removido;
    }

    
}
