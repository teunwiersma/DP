package P2;

import java.util.Date;

public class Reiziger {

	private Date gbdatum;
	private int id;
	private int reizigerid;
	private String voorletter;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;
	
	
	public Reiziger( int id, String voorletter, String tussenvoegsel, String achternaam, Date gbdatum) {
		this.tussenvoegsel = tussenvoegsel;
		this.gbdatum = gbdatum;
		this.id = id;
		this.voorletter = voorletter;
		this.achternaam = achternaam;
	}




	public String getNaam() {
		String volenaam = "";
		if( this.tussenvoegsel == null || this.tussenvoegsel == " " ) {
			volenaam = this.voorletter + " " + this.achternaam;
		}else { volenaam =  this.voorletter + " " + this.tussenvoegsel + " " + this.achternaam;
		}
		return volenaam;
	}
	
	public void setNaam(String naam) {
		this.voorletter = voorletter;
	}
	
	
	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public int getId() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "[ " + id +  ", Naam: " + voorletter + " met geboortedatum: " + gbdatum + "]";
	}
	
	public boolean equals(Object obj){
        if (obj instanceof Reiziger){
            Reiziger r = (Reiziger) obj;
            return r.getId() == id;
        }
        return false;
    }
	
	public String getVoorletter() {
		return voorletter;
	}
	
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	public Date getGBdatum() {
		return gbdatum;
	}
}
