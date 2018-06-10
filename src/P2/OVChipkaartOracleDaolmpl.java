package P2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDaolmpl extends oracleBaseDAO implements OVChipkaartDao {

	public OVChipkaartOracleDaolmpl() throws SQLException{
		getConnection();
	}
	
	@Override
	public List<OVChipkaart> findAll() {
		ArrayList<OVChipkaart> list = new ArrayList<OVChipkaart>();
		OVChipkaart ov = null;
		Reiziger reiziger = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ov_chipkaart o, reiziger r, where r.reizigerid = o.reizigerid");
			while (rs.next()) {
				ov = new OVChipkaart(rs.getInt(1), rs.getDate(2), rs.getInt(3),
						rs.getInt(4), reiziger);
				reiziger = new Reiziger(rs.getInt(5), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10));
				list.add(ov);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public OVChipkaart save(OVChipkaart ovchipkaart) {
		try {
			String query = "insert into OV_CHIPKAART(KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, ovchipkaart.getKaartnummer());
			stmt.setDate(2, ovchipkaart.getDate());
			stmt.setInt(3, ovchipkaart.getKlasse());
			stmt.setDouble(4, ovchipkaart.getSaldo());
			stmt.setInt(5, ovchipkaart.getReizigerID().getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ovchipkaart;
	}

	@Override
	public OVChipkaart update(OVChipkaart ovchipkaart) {
		try {
			String query = "update  OV_CHIPKAART(KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(query);
			 stmt.setInt(1, ovchipkaart.getKaartnummer());
	         stmt.setDate(2, ovchipkaart.getDate());
	         stmt.setInt(3, ovchipkaart.getKlasse());
	         stmt.setDouble(4, ovchipkaart.getSaldo());
	         stmt.setInt(5, ovchipkaart.getReizigerID().getId());
	         stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return ovchipkaart;
	}

	@Override
    public boolean delete(OVChipkaart ovchipkaart) {
        boolean deleted = false;
        try {
            String query = "delete from ov_chipkaart where kaartnummer = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, ovchipkaart.getKaartnummer());

            if(stmt.executeUpdate() == 1) {
                deleted = true;
            }
            stmt.executeUpdate();

        }catch(Exception e) {
            e.getMessage();
        }
        return deleted;
    }
	
	@Override
	public List<OVChipkaart> findByReiziger(Reiziger reiziger){
		ArrayList<OVChipkaart> findList = new ArrayList<>();
		OVChipkaart ovc = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet findReizigerid = stmt.executeQuery("Select * from ov_chipkaart where reizigerid = " + reiziger.getId());
			
			while (findReizigerid.next()) {
				ovc = new OVChipkaart(findReizigerid.getInt("kaartnummer"), findReizigerid.getDate("geldigtot"), findReizigerid.getInt("klasse"), findReizigerid.getDouble("saldo"), reiziger);
				findList.add(ovc);
			}
			findReizigerid.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return findList;
	}

}
