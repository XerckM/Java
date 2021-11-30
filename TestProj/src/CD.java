public class CD extends MediaItem{
    private String artist;
    private String genre;
    public CD(){
        super();
        artist = null;
        genre = null;
    }
    public CD(String i, String t, int c, double r, String d, String g){
        super(i, t, c, r);
        artist = d;
        genre = g;
    }
    public void setArtist(String d){
        artist = d;
    }
    public void setGenre(String g){
        genre = g;
    }
    public String getArtist(){
        return artist;
    }
    public String getGenre(){
        return genre;
    }
    public String toString(){
        return "This CD's Information\n" + "ID: " + getId() + "\nTITLE: " + getTitle() + "\nARTIST: " + artist + "\nGENRE: " + genre + "\nRUNTIME: "+ getRuntime() + " minutes" +"\nNUMBER OF COPIES: " + getCopies() + "\n";
    }
    public void print(){
        System.out.println("Display info about a CD" + "\nID: " + getId() + "\nTITLE: " + getTitle() + "\nARTIST: " + artist + "\nGENRE: " + genre + "\nRUNTIME: "+ getRuntime() + " minutes" +"\nNUMBER OF COPIES: " + getCopies() + "\n");
    }
    public void checkIn(){
        System.out.println("CD checked-in.");
    }
    public void checkOut(){
        System.out.println("CD checked-out.");
        super.checkOut();
    }
    public void addItem(){
        System.out.println("CD added.");
        super.addItem();
    }
    public boolean equals(Item i){
        if(i instanceof CD){
            CD c= (CD) i;
            return super.equals(c) && artist.equals(c.artist) && genre.equals(c.genre);
        }
        else{
            return false;
        }
    }
}
