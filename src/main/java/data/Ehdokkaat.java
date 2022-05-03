package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ehdokkaat")
public class Ehdokkaat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int EHDOKAS_ID;
	private String SUKUNIMI;
	private String ETUNIMI;
	private String PUOLUE;
	private String KOTIPAIKKAKUNTA;
	private int IKA;
	private String MIKSI_EDUSKUNTAAN;
	private String MITA_ASIOITA_HALUAT_EDISTAA;
	private String AMMATTI;
	
	public Ehdokkaat(String id, String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksi_eduskuntaan, String mita_asioita_haluat_edistaa, String ammatti) {
		// TODO Auto-generated constructor stub
		setEHDOKAS_ID(id);
		this.SUKUNIMI=sukunimi;
		this.ETUNIMI=etunimi;
		this.PUOLUE=puolue;
		this.KOTIPAIKKAKUNTA=kotipaikkakunta;
		this.IKA=ika;
		this.MIKSI_EDUSKUNTAAN=miksi_eduskuntaan;
		this.MITA_ASIOITA_HALUAT_EDISTAA=mita_asioita_haluat_edistaa;
		this.AMMATTI=ammatti;
	}
	public Ehdokkaat() {
		// TODO Auto-generated constructor stub
	}
	public int getEHDOKAS_ID() {
		return EHDOKAS_ID;
	}
	public void setEHDOKAS_ID(String id) {
		try {
			
			this.EHDOKAS_ID = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
		
	}
	public String getSUKUNIMI() {
		return SUKUNIMI;
	}
	public void setSUKUNIMI(String sUKUNIMI) {
		SUKUNIMI = sUKUNIMI;
	}
	public String getETUNIMI() {
		return ETUNIMI;
	}
	public void setETUNIMI(String eTUNIMI) {
		ETUNIMI = eTUNIMI;
	}
	public String getPUOLUE() {
		return PUOLUE;
	}
	public void setPUOLUE(String pUOLUE) {
		PUOLUE = pUOLUE;
	}
	public String getKOTIPAIKKAKUNTA() {
		return KOTIPAIKKAKUNTA;
	}
	public void setKOTIPAIKKAKUNTA(String kOTIPAIKKAKUNTA) {
		KOTIPAIKKAKUNTA = kOTIPAIKKAKUNTA;
	}
	public int getIKA() {
		return IKA;
	}
	public void setIKA(String age) {
		try {
			
			this.IKA = Integer.parseInt(age);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getMIKSI_EDUSKUNTAAN() {
		return MIKSI_EDUSKUNTAAN;
	}
	public void setMIKSI_EDUSKUNTAAN(String mIKSI_EDUSKUNTAAN) {
		MIKSI_EDUSKUNTAAN = mIKSI_EDUSKUNTAAN;
	}
	public String getMITA_ASIOITA_HALUAT_EDISTAA() {
		return MITA_ASIOITA_HALUAT_EDISTAA;
	}
	public void setMITA_ASIOITA_HALUAT_EDISTAA(String mITA_ASIOITA_HALUAT_EDISTAA) {
		MITA_ASIOITA_HALUAT_EDISTAA = mITA_ASIOITA_HALUAT_EDISTAA;
	}
	public String getAMMATTI() {
		return AMMATTI;
	}
	public void setAMMATTI(String aMMATTI) {
		AMMATTI = aMMATTI;
	}

}