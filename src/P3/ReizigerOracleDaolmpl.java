package P3;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaolmpl extends oracleBaseDAO implements ReizigerDao {

	public ReizigerOracleDaolmpl() throws SQLException{
		getConnection();
	}
	


	@Override
	public List<Reiziger> findAll() {
		ArrayList<Reiziger> list = new ArrayList<Reiziger>();
		Reiziger rr = null;

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reiziger");	

			while (rs.next()) {
				rr = new Reiziger(rs.getInt("reizigerid"), rs.getString("voorletters"), rs.getString("tussenvoegsel"),
						rs.getString("achternaam"), rs.getDate("gebortedatum"));
				list.add(rr);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> findList = new ArrayList<>();
		Reiziger rr = null;
				
				try {
					Statement stmt = connection.createStatement();
					ResultSet findGB = stmt.executeQuery("Select * from reiziger where gebortedatum = '" + GBdatum + "'");
					
					while(findGB.next()) {
						rr = new Reiziger(findGB.getInt("reizigerid"), findGB.getString("voorletters"), findGB.getString("tussenvoegsel"), findGB.getString("achternaam"), findGB.getDate("gebortedatum"));
						findList.add(rr);
					}
					findGB.close();
					stmt.close();
				}catch(Exception e) {
					System.out.println(e);
				}
				return findList;
	}

	@Override
	public Reiziger save(Reiziger reiziger) {
		try {
			String query = "insert into reiziger(reizigerid, voorletters, tussenvoegsel, achternaam, gebortedatum) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, reiziger.getId());
			stmt.setString(2, reiziger.getVoorletter());
			stmt.setString(3, reiziger.getTussenvoegsel());
			stmt.setString(4, reiziger.getAchternaam());
			stmt.setDate(5, (Date) reiziger.getGBdatum());

			stmt.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			System.out.println(e);
		}
		return reiziger;
	}

	@Override
	public Reiziger update(Reiziger reiziger) {
		try {
			String query = "update reiziger(reizigerid, voorletters, tussenvoegsel, achternaam, gebortedatum) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, reiziger.getId());
			stmt.setString(2, reiziger.getVoorletter());
			stmt.setString(3, reiziger.getTussenvoegsel());
			stmt.setString(4, reiziger.getAchternaam());
			stmt.setDate(5, (Date) reiziger.getGBdatum());

			stmt.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			System.out.println(e);
		}
		return reiziger;
	}


	@Override
	public boolean delete(Reiziger reiziger) {
		   boolean deleted = false;
	        try {
	            String query = "delete from ov_chipkaart where kaartnummer = ?";
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setInt(1, reiziger.getId());

	            if(stmt.executeUpdate() == 1) {
	                deleted = true;
	            }
	            stmt.executeUpdate();

	        }catch(Exception e) {
	            System.out.println(e);
	        }
	        return deleted;
	    }

}
