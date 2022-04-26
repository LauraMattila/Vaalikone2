package data;

public class Questions {
	
	private int KYSYMYS_ID;
	private String KYSYMYS;
	
	public Questions(String id, String question) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.KYSYMYS=question;
	}
	public Questions() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		
		return KYSYMYS_ID;
	}
	public void setId(int id) {
		
		this.KYSYMYS_ID = id;
	}
	public void setId(String id) {
		
		try {
			
			this.KYSYMYS_ID = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getQuestion() {
		
		return KYSYMYS;
	}
	public void setQuestion(String question) {
		
		this.KYSYMYS = question;
	}
}
