public abstract class WrittenItem extends Item{
    private String author;
    public WrittenItem(){
        super();
        author = null;
    }
    public WrittenItem(String id, String title, int copies, String a){
        super(id, title, copies);
        author = a;
    }
    public void setAuthor(String a){
        author = a;
    }
    public String getAuthor(){
        return author;
    }
    public String toString(){
        return "\nID: " + getId() + "\nTITLE: " + getTitle() + "\nAUTHOR: "+ author +"\nNUMBER OF COPIES: " + getCopies() + "\n";
    }
    public void print(){
        System.out.println("ID: " + getId() + "\nTITLE: " + getTitle() + "\nAUTHOR: "+ author +"\nNUMBER OF COPIES: " + getCopies() + "\n");
    }
    public boolean equals(Item i){
        if(i instanceof WrittenItem){
            WrittenItem item = (WrittenItem) i;
            return super.equals(item) && author.equals(item.author);
        }
        else{
            return false;
        }
    }
}