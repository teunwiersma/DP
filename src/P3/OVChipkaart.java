package P3;

import java.sql.Date;

public class OVChipkaart {
	
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger reiziger;

	
	public OVChipkaart(int kN, Date gT, int K, double S, Reiziger reiziger){
		this.kaartNummer = kN;
		this.geldigTot = gT;
		this.klasse = K;
		this.saldo = S;
		this.reiziger = reiziger;
	}
	
	public String toString() {
		return kaartNummer +" - " +  geldigTot + " - " + klasse + " - " + saldo + " - " + reiziger;
	}

	public int getKaartnummer(){
		return this.kaartNummer;
	}
	
	public Date getDate() {
		return this.geldigTot;
	}
	
	public int getKlasse() {
		return klasse;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public Reiziger getReizigerID() {
		return this.reiziger;
	}
	
	public boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Reiziger) {
			Reiziger rr = (Reiziger) obj;
			if(rr.getId() == reiziger.getId()) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
}
