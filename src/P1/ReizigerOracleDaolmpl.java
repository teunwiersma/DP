package P1;

import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaolmpl implements ReizigerDao  {
	
	private ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();

	@Override
	
	public List<Reiziger> findAll() {
		return alleReizigers;
	}
	
	@Override
	public List<Reiziger> findByGBdatum(String GBdatum){
		ArrayList<Reiziger> List = new ArrayList<>();
		for(Reiziger r : alleReizigers) {
			if(r.getGBdatum().toString().equals(GBdatum)) {
				List.add(r);
			}
		}
		return null;
	}
	
	@Override
	public Reiziger save(Reiziger reiziger) {
		alleReizigers.add(reiziger);
		return reiziger;
	}
	
	@Override
	public Reiziger update(Reiziger reiziger) {
		
		int index = alleReizigers.indexOf(reiziger);
		
		if (index == -1) {
			return null;
		}
		
		alleReizigers.set(index, reiziger);
		
		return reiziger;
	}
	
	@Override
	public boolean delete(Reiziger reiziger) {
		return alleReizigers.remove(reiziger);
	}
}

