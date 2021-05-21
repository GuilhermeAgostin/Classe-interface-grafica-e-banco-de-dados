package Table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import Conexao.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;

import Model.Perfil;

public class Tabela_Perfil extends ConnectionClass {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Perfil> lista = new ArrayList<Perfil>();

    public void insereRegistro(Perfil p) throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, password);
            String q = "INSERT INTO TB_Perfil (Nome) VALUES (?)";
            ps = con.prepareStatement(q);
            ps.setString(1, p.getNome());

            ps.execute();
            System.out.println("Perfil cadastrado com sucesso!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void alterarRegistro(Perfil perfil) throws SQLException{
            try
            {
                con = DriverManager.getConnection(url, user, password);
                String sql = "update TB_Perfil set Nome = ? where IdPerfil = ?;";
                ps = con.prepareStatement(sql);
			    ps.setString(1, perfil.getNome());
                ps.setInt(2, perfil.getIdPerfil());
			
			    ps.execute();

                System.out.println("Perfil editado com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                con.close();
            }
        }

        public ArrayList <Perfil> getLista() throws SQLException {
			ArrayList<Perfil> ListadosPerfis = new ArrayList<Perfil>();
			try {
			
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("select * from TB_Perfil");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(rs.getInt("IdPerfil"));
				perfil.setNome(rs.getString("Nome"));
				ListadosPerfis.add(perfil);
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
			return ListadosPerfis;
			
		}	

        public ArrayList <Perfil> getListaIds() throws SQLException {
			ArrayList<Perfil> ListaIdPerfis = new ArrayList<Perfil>();
			try {
			
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("select IdPerfil from TB_Perfil");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(rs.getInt("IdPerfil"));
				ListaIdPerfis.add(perfil);
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
			return ListaIdPerfis;
			
		}	


		public String getNomePerfil(String num) throws SQLException {

			String NomePerfil = "";
			try {
			
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("select Nome from TB_Perfil where IdPerfil = " + num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Perfil perfil = new Perfil();
				perfil.setNome(rs.getString("Nome"));
				NomePerfil = perfil.getNome();
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
			return NomePerfil;
			
		}	

		public void deletaRegistro(Perfil p, String num) throws SQLException {

			try {
			
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement("delete from TB_Perfil where IdPerfil = " + num );
			
			    ps.execute();

                System.out.println("Perfil excluido com sucesso!");
			   
			
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
