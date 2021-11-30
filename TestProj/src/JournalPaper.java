public class JournalPaper extends WrittenItem{
    private int year;
    public JournalPaper(){
        super();
        year = 0;
    }
    public JournalPaper(String i, String t, int c, String a, int y){
        super(i, t, c, a);
        year = y;
    }
    public void setYear(int y){
        year = y;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return "This Journal Paper's Information" + super.toString();
    }
    public void print(){
        System.out.println("Display info about a Journal Paper");
        super.print();
    }
    public void checkIn(){
        System.out.println("Journal Paper checked-in.");
    }
    public void checkOut(){
        System.out.println("Journal Paper checked-out.");
        super.checkOut();
    }
    public void addItem(){
        System.out.println("Journal Paper added.");
        super.addItem();
    }
    public boolean equals(Item i){
        if(i instanceof JournalPaper){
            JournalPaper jp = (JournalPaper) i;
            return super.equals(jp) && year == jp.year;
        }
        else{
            return false;
        }
    }
}
