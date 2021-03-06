package P2;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        OVChipkaartDao ovDAO = new OVChipkaartOracleDaolmpl();
        ReizigerDao rDAO = new ReizigerOracleDaolmpl();
        

        Reiziger r1 = new Reiziger(6, "H", "van", "Boom", Date.valueOf("1997-05-31"));
        OVChipkaart ov1 = new OVChipkaart( 5000, Date.valueOf("2020-02-06"), 1, 500, r1);

        //rDAO.save(r1);
        //rDAO.delete(r1);
        
        //ovDAO.save(ov1);
        //ovDao.delete(ov1);

        System.out.println("OVCHIPKAART FIND ALL");

        for(OVChipkaart listOVChipkaart : ovDAO.findAll()) {
            System.out.println(listOVChipkaart);
        }
        
        System.out.println(" ");
        System.out.println("REIZIGER FIND ALL");

        for(Reiziger listReiziger : rDAO.findAll()) {
            System.out.println(listReiziger);
        }
        
        System.out.println(" ");
        System.out.println("REIZIGER BY GB DATUM");

        for(Reiziger listGBDatum : rDAO.findByGBdatum("31-MAY-97")) {
            System.out.println(listGBDatum);
        }

        System.out.println(" ");
        System.out.println("OVCHIPKAART BY REIZIGER");

        for(OVChipkaart listID : ovDAO.findByReiziger(r1)) {
        	System.out.println(listID);
        }
        
        }
}