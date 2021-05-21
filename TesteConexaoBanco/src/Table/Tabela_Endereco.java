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

import Model.Endereco;
import Model.Usuario;

public class Tabela_Endereco extends ConnectionClass 

{
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Usuario> lista = new ArrayList<Usuario>();

    public void insereRegistro(Endereco e) throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, password);
            String q = "INSERT INTO TB_Endereco (Numero, Bairro, Municipio, CEP) VALUES (?,?,?,?)";
            
            ps = con.prepareStatement(q);
            ps.setInt(1, e.getNumero());
            ps.setString(2, e.getBairro());
            ps.setString(3, e.getMunicipio());
            ps.setString(4, e.getCEP());
            ps.execute();

            System.out.println("Perfil cadastrado com sucesso!");
        } 
        
        catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void alterarRegistro(Endereco endereco, String end) throws SQLException{
            try
            {
                con = DriverManager.getConnection(url, user, password);
                String sql = "update TB_Endereco set Bairro = ? where Bairro = " + "'" + end + "'";
                ps = con.prepareStatement(sql);
			    ps.setString(1, endereco.getBairro());
			
			    ps.execute();

                System.out.println("Endereço editado com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                con.close();
            }
        }

        public ArrayList <Endereco> getListaNomeEndereco() throws SQLException {
			ArrayList<Endereco> ListadosEnderecos = new ArrayList<Endereco>();
			try {
			
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("select Bairro from TB_Endereco");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setBairro(rs.getString("Bairro"));
				ListadosEnderecos.add(endereco);
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
			return ListadosEnderecos;
			
		}	

        

		public void deletaRegistro(Endereco ende, String bairro) throws SQLException {

			try {
			
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement("delete from TB_Perfil where IdPerfil = " + bairro );
			
			    ps.execute();

                System.out.println("Endereço excluido com sucesso!");
			   
			
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

    
