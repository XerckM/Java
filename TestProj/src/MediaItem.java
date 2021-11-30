public abstract class MediaItem extends Item{
    private double runtime;
    public MediaItem(){
        super();
        runtime = 0;
    }
    public MediaItem(String i, String t, int c, double r){
        super(i, t, c);
        runtime = r;
    }
    public void setRuntime(double r){
        runtime = r;
    }
    public double getRuntime(){
        return runtime;
    }
    public String toString(){
        return "This Media Item's Information\n" + "ID: " + getId() + "\nTITLE: " + getTitle() + "\nRUNTIME: "+ runtime + " minutes" +"\nNUMBER OF COPIES: " + getCopies() + "\n";
    }
    public void print(){
        System.out.println("Display info about a Media Item" + "\nID: " + getId() + "\nTITLE: " + getTitle() + "\nRUNTIME: "+ runtime + " minutes" +"\nNUMBER OF COPIES: " + getCopies() + "\n");
    }
    public boolean equals(Item i){
        if(i instanceof MediaItem){
            MediaItem mi = (MediaItem) i;
            return super.equals(mi) && runtime == mi.runtime;
        }
        else{
            return false;
        }
    }
}
