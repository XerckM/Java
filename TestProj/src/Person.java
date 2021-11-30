public class Person {
  
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        this.firstName = "";
        this.lastName = "";
    }   
    public String getFirstName() {
        return firstName;
    }   
    public String getLastName() {
        return lastName;
    }

    public void setName(String fName, String lName){
        firstName = fName;
        lastName = lName;
    }

    public void printLastFirst(){
        System.out.println(lastName + ", " + firstName);
    }

    public void print(){
        System.out.println(firstName + " " + lastName);
    }

    public String toString(){
        return firstName + " " + lastName;
    }

    public boolean equals(Person p){
        return firstName.equalsIgnoreCase(p.firstName) && lastName.equals(p.lastName);
    }

    public void copy(Person p){
        p.firstName = firstName;
        p.lastName = lastName;
    }

    public Person getCopy(){
        Person p = new Person();
        copy(p);
        return p;
    }
}