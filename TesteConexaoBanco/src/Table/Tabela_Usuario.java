package Table;

import Conexao.ConnectionClass;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.xdevapi.Statement;
import java.sql.DriverManager;


public class Tabela_Usuario extends ConnectionClass
{
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    public static List<Usuario> listarUsuarios = new ArrayList<>();

    public void insereRegistro(Usuario u) throws SQLException
		{
		try {
			con = DriverManager.getConnection(url, user, password);
			String q="INSERT INTO TB_Usuario (CPF, Nome, IdPerfil, Sexo) VALUES (?,?,?,?)";
	     	ps = con.prepareStatement(q);
            ps.setString(1, u.getCPF());
            ps.setString(2, u.getNome());
            ps.setInt(3, u.getIdPerfil());
            ps.setString(4, u.getSexo());
			ps.execute();
			System.out.println("Usuário cadastrado com sucesso!");
			} catch (SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally
			{
				con.close();
			}
	        
	    
	        
		}


        public ArrayList <Usuario> getListaUsuarios() throws SQLException {
			ArrayList<Usuario> ListaNomeUsuario = new ArrayList<Usuario>();
			try {
			
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("select Nome from TB_Usuario");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usua = new Usuario();
				usua.setNome(rs.getString("Nome"));
				ListaNomeUsuario.add(usua);
			}
			   rs.close();
			   ps.close();
			   
			
			} catch (SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally
			{
				con.close();
				
			}
			return ListaNomeUsuario;
			
		}
        
        public int getIdUsuario(String nomeDoUsuario) throws SQLException {

			int IdUsuario1 = 0;
			try {
			
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("select IdUsuario from TB_Usuario where Nome = " + nomeDoUsuario);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario4 = new Usuario();
				usuario4.setIdUsuario(rs.getInt("IdUsuario"));
				IdUsuario1 = usuario4.getIdUsuario();
				//ListaNomePerfis.add(perfil);
			}
			   rs.close();
			   ps.close();
			   
			
			} catch (SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally
			{
				con.close();
				
			}
			return IdUsuario1;
			
		}
        
        
        public void alterarRegistro(Usuario usuario, String usu) throws SQLException{
            try
            {
                con = DriverManager.getConnection(url, user, password);
                String sql = "update TB_Usuario set Nome = ? where Nome = " + "'" + usu + "'";
                ps = con.prepareStatement(sql);
			    ps.setString(1, usuario.getNome());
			
			    ps.execute();

                System.out.println("Usuário editado com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                con.close();
            }
        }


        public void deletaRegistro(Usuario u, String nome) throws SQLException {

			try {
			
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement("delete from TB_Usuario where Nome = " + "'" + nome + "'");
                
			    ps.execute();

                System.out.println("Usuário excluido com sucesso!");
			   
			
			} catch (SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally
			{
				con.close();
				
			}
			
		}	
    
}
