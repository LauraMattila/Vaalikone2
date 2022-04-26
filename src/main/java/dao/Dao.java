package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Questions;
import data.Candidates;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Questions> readAllQuestions() {
		ArrayList<Questions> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				Questions q=new Questions();
				q.setId(RS.getInt("KYSYMYS_ID"));
				q.setQuestion(RS.getString("KYSYMYS"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Questions> updateQuestions(Questions q) {
		try {
			String sql="update kysymykset set KYSYMYS=? where KYSYMYS_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getQuestion());
			pstmt.setInt(2, q.getId());
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Questions> deleteQuestions(String id) {
		try {
			String sql="delete from kysymykset where KYSYMYS_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public Questions readQuestions(String id) {
		Questions q=null;
		try {
			String sql="select * from kysymykset where KYSYMYS_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				q=new Questions();
				q.setId(RS.getInt("KYSYMYS_ID"));
				q.setQuestion(RS.getString("KYSYMYS"));
			}
			return q;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Questions> addQuestions(String q) {
		try {
			String sql="insert into kysymykset (KYSYMYS) values (?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q);
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Candidates> readAllCandidates() {
        ArrayList<Candidates> list=new ArrayList<>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
            while (RS.next()){
                Candidates q=new Candidates();
                q.setId(RS.getInt("EHDOKAS_ID"));
                q.setLastName(RS.getString("SUKUNIMI"));
                q.setFirstName(RS.getString("ETUNIMI"));
                q.setParty(RS.getString("PUOLUE"));
                q.setDomicile(RS.getString("KOTIPAIKKAKUNTA"));
                q.setAge(RS.getInt("IKA"));
                q.setParliament(RS.getString("MIKSI_EDUSKUNTAAN"));
                q.setImprovement(RS.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
                q.setJob(RS.getString("AMMATTI"));
                list.add(q);
            }
            return list;
        }
        catch(SQLException e) {
            return null;
        }
    }
}
