package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.State;

public class PersonDAO {

    public PersonDAO() {
    }

    //get all persons
    public ArrayList<Person> getAll(){
        //init list
        ArrayList<Person> personnes = new ArrayList<Person>();

        //connect to db
        Connection con = Database.connect();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM personnes");

            while (rs.next()){
                Person person = new Person(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getInt("age"));
                personnes.add(person);
            }
            //closing
            stmt.close();
            rs.close();
            return personnes;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //get Person by name and lastname
    public Person getPerson(String nom, String prenom){
        Connection con = Database.connect();
        try{
            String query = "SELECT * FROM personnes WHERE nom=? and prenom=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Person person = new Person(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"));
                return person;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
        return null;
    }
    
    public Person getPerson(int id) {
    	Connection con = Database.connect();
    	Person person = null;
    	  try{
    		  String sql = "SELECT * FROM personnes WHERE id="+id;
    		  Statement statement = con.createStatement();
    		  ResultSet rs = statement.executeQuery(sql);
    		  
    		  if(rs.next()) {
    			  String nom = rs.getString("nom");
    			  String prenom = rs.getString("prenom");
    			  int age = rs.getInt("age") ;
    			  
    			  person = new Person(id, nom, prenom, age);
    		  }
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return person;
    }

    //adding person;
    public void addPerson(Person person){
        Connection con = Database.connect();
        try {
           Statement statmenet = con.createStatement();
           statmenet.executeUpdate("INSERT INTO personnes(nom,prenom,age) VALUES('"+person.getName()+"','"+person.getLast_name()+"',"+person.getAge()+")");

 
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person){
        Connection con = Database.connect();
        try{
            String query = "UPDATE `personnes` SET `nom` = '"+ person.getName() +"' , `prenom` = '"+ person.getLast_name() +"', `age` = "+person.getAge()+" WHERE id = "+person.getId()+"";
            Statement statement = con.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void deletePerson(int id) {
        Connection con = Database.connect();
        try {
        	Statement statement = con.createStatement();
        	String sql = "DELETE FROM personnes WHERE id="+id; 
        	statement.executeUpdate(sql);
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        }
    }
    
    
}
