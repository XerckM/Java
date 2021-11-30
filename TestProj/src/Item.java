public abstract class Item{
    private String id;
    private String title;
    private int copies;
    
    public Item(){
        id = null;
        title = null;
        copies = 0;
    }
    public Item(String i, String t, int c){
        id = i;
        title = t;
        copies = c;
    }
    public void setId(String i){
        id = i;
    }
    public void setTitle(String t){
        title = t;
    }
    public void setCopies(int c){
        copies = c;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getCopies(){
        return copies;
    }
    public String toString(){
        return "ID: " + id + "\nTITLE: " + title + "\nNUMBER OF COPIES: " + copies + "\n";
    }
    public void print(){
        System.out.print("ID: " + id + "\nTITLE: " + title + "\nNUMBER OF COPIES: " + copies + "\n");
    }
    public boolean equals(Item i){
        return id.equals(i.id) && title.equals(i.title) && copies == i.copies;
    }
    public void checkIn(){
        copies++;
    }
    public void checkOut(){
        copies--;
    }
    public void addItem(){
        copies++;
    }
}