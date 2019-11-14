package Model;

public class Person {
    private int id;
    private String name;
    private String last_name;
    private int age;

    public Person(int id, String name ,String last_name, int age){
    	this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
    }
  
    public Person(String name ,String last_name, int age){
        this.name = name;
        this.last_name = last_name;
        this.age = age;
    }
  

    //getters
    public String getName(){
        return this.name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public int getAge(){
        return this.age;
    }
    public int getId(){
        return this.id;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
	public void setAge(int age){
        this.age = age;
    }

    
    @Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", last_name=" + last_name + ", age=" + age + "]";
	}

  
}
