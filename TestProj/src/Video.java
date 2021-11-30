public class Video extends MediaItem{
    private String director;
    private String genre;
    private int year;
    public Video(){
        super();
        director = null;
        genre = null;
        year = 0;
    }
    public Video(String i, String t, int c, double r, String d, String g, int y){
        super(i, t, c, r);
        director = d;
        genre = g;
        year = y;
    }
    public void setDirector(String d){
        director = d;
    }
    public void setGenre(String g){
        genre = g;
    }
    public void setYear(int y){
        year = y;
    }
    public String getDirector(){
        return director;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return "This Video's Information\n" + "ID: " + getId() + "\nTITLE: " + getTitle() + "\nDIRECTOR: " + director + "\nGENRE: " + genre + "\nRELEASE YEAR: " + year + "\nRUNTIME: "+ getRuntime() + " minutes" +"\nNUMBER OF COPIES: " + getCopies() + "\n";
    }
    public void print(){
        System.out.print("\nDisplay info about a Video" + "\nID: " + getId() + "\nTITLE: " + getTitle() + "\nDIRECTOR: " + director + "\nGENRE: " + genre + "\nRELEASE YEAR: " + year + "\nRUNTIME: "+ getRuntime() + " minutes" +"\nNUMBER OF COPIES: " + getCopies() + "\n");
    }
    public void checkIn(){
        System.out.println("Video checked-in.");
    }
    public void checkOut(){
        System.out.println("Video checked-out.");
        super.checkOut();
    }
    public void addItem(){
        System.out.println("Video added.");
        super.addItem();
    }
    public boolean equals(Item i){
        if(i instanceof Video){
            Video v= (Video) i;
            return super.equals(v) && director.equals(v.director) && genre.equals(v.genre) && year == v.year;
        }
        else{
            return false;
        }
    }
}
