package data;

public class Candidates {
	
	private int EHDOKAS_ID;
	private String SUKUNIMI;
	private String ETUNIMI;
	private String PUOLUE;
	private String KOTIPAIKKAKUNTA;
	private int IKA;
	private String MIKSI_EDUSKUNTAAN;
	private String MITA_ASIOITA_HALUAT_EDISTAA;
	private String AMMATTI;
	
	public Candidates(String id, String lastname, String firstname, String party, String domicile, int age, String parliament, String improvement, String job) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.SUKUNIMI=lastname;
		this.ETUNIMI=firstname;
		this.PUOLUE=party;
		this.KOTIPAIKKAKUNTA=domicile;
		this.IKA=age;
		this.MIKSI_EDUSKUNTAAN=parliament;
		this.MITA_ASIOITA_HALUAT_EDISTAA=improvement;
		this.AMMATTI=job;
	}
	public Candidates() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		
		return EHDOKAS_ID;
	}
	public void setId(int id) {
		
		this.EHDOKAS_ID = id;
	}
	public void setId(String id) {
		
		try {
			
			this.EHDOKAS_ID = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getLastName() {
		
		return SUKUNIMI;
	}
	public void setLastName(String lastname) {
		
		this.SUKUNIMI = lastname;
	}
	public String getFirstName() {
		
		return ETUNIMI;
	}
	public void setFirstName(String firstname) {
		
		this.ETUNIMI = firstname;
	}
	public String getParty() {
		
		return PUOLUE;
	}
	public void setParty(String party) {
		
		this.PUOLUE = party;
	}
	public String getDomicile() {
		
		return KOTIPAIKKAKUNTA;
	}
	public void setDomicile(String domicile) {
		
		this.KOTIPAIKKAKUNTA = domicile;
	}
	public int getAge() {
		
		return IKA;
	}
	public void setAge(int age) {
		
		this.IKA = age;
	}
	public void setAge(String age) {
		
		try {
			
			this.IKA = Integer.parseInt(age);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getParliament() {
		
		return MIKSI_EDUSKUNTAAN;
	}
	public void setParliament(String parliament) {
		
		this.MIKSI_EDUSKUNTAAN = parliament;
	}
	public String getImprovement() {
		
		return MITA_ASIOITA_HALUAT_EDISTAA;
	}
	public void setImprovement(String improvement) {
		
		this.MITA_ASIOITA_HALUAT_EDISTAA = improvement;
	}
	public String getJob() {
		
		return AMMATTI;
	}
	public void setJob(String job) {
		
		this.AMMATTI = job;
	}
}