import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//JDBC Driver  -> .jar


public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Vai teste!");
		Connection conexao;
		try {
			//String de conecção com timezone + user, e senha
			conexao = DriverManager.getConnection(
			        "jdbc:mysql://localhost/ftt?serverTimezone=GMT-3", "root", "senha1CAr1993@");
			System.out.println("Vai conectado!"+ new Date());
			
			PreparedStatement stmt = conexao.
                    prepareStatement("select now() agora from dual");
            ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String agora =rs.getString("agora");
				System.out.println("Data do banco de dados: "+ agora);
			}
            
			stmt = conexao.
                    prepareStatement("select *  from ftt.person");
             rs = stmt.executeQuery();
			while (rs.next()) {
				String name =rs.getString("name");
				System.out.println("Nome da pessoa: "+ name);
			}
            //System.out.println(rs.findColumn("agora"));
			
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de conecção!" + new Date());
			e.printStackTrace();
		}
    System.out.println("fim!");
    

	}

}
