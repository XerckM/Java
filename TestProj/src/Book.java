public class Book extends WrittenItem{
    public Book(){
        super();
    }
    public Book(String id, String title, int copies, String a){
        super(id, title, copies, a);
    }
    public String toString(){
        return "This Book's information" + super.toString();
    }
    public void print(){
        System.out.println("Display info about a Book");
        super.print();
    }
    public void checkIn(){
        System.out.println("Book checked-in.");
    }
    public void checkOut(){
        System.out.println("Book checked-out.");
        super.checkOut();
    }
    public void addItem(){
        System.out.println("Book added.");
        super.addItem();
    }
}
