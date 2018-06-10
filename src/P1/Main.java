package P1;

import java.sql.Date;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Reiziger r1 = new Reiziger();
		Reiziger r2 = new Reiziger();
		Reiziger r3 = new Reiziger();
		Reiziger r0update = new Reiziger();
		
		r1.setNaam("Henk");
		r1.setGBdatum(Date.valueOf("1997-05-31"));
		r1.setid(0);
		
		r2.setNaam("piet");
		r2.setGBdatum(Date.valueOf("1970-06-23"));
		r2.setid(1);
		
		r3.setNaam("jaap");
		r3.setGBdatum(Date.valueOf("1902-01-02"));
		r3.setid(2);
		
		r0update.setNaam("sjon");
		r0update.setGBdatum(Date.valueOf("1996-04-25"));
		r0update.setid(0);
		
		ReizigerOracleDaolmpl dao = new ReizigerOracleDaolmpl();

		dao.save(r1);
		dao.save(r2);
		dao.save(r3);
		
		
		System.out.println("Opgeslagen:");
		
		List<Reiziger> list = dao.findAll();
		for (Reiziger x : list) {
			System.out.println(x);
		}
		
		
		dao.update(r0update);
		
		System.out.println("na update:");
		for (Reiziger x : list) {
			System.out.println(x);
		}
		
		dao.delete(r3);
		
		System.out.println("Na delete:");
		for (Reiziger x : list) {
			System.out.println(x);
		}
		
	}
	
}
