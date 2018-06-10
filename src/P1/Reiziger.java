package P1;

import java.util.Date;

public class Reiziger {

	private String naam;
	private Date gbdatum;
	private int id;
	
	public Reiziger() {
		
	}
	
	public Reiziger(String naam, Date gbdatum, int id) {
		super();
		this.naam = naam;
		this.gbdatum = gbdatum;
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public Date getGBdatum() {
		return gbdatum;
	}
	
	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "[ " + id +  ", Naam: " + naam + " met geboortedatum: " + gbdatum + "]";
	}
	
	public boolean equals(Object obj){
        if (obj instanceof Reiziger){
            Reiziger r = (Reiziger) obj;
            return r.getid() == id;
        }
        return false;
    }
}
