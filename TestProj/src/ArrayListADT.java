public interface ArrayListADT {
    public boolean isEmpty();
    public boolean isFull();
    public int listSize(); 
    public int maxListSize();
    public void print(); 
    public boolean isItemAtEqual(int location, int item); 
    public void insertAt(int location, int insertItem); 
    public void insertEnd(int insertItem);
    public void removeAt(int location);
    public int retrieveAt(int location); 
    public void replaceAt(int location, int repItem); 
    public void clearList();
    public int search(int searchItem); 
    public void remove(int removeItem); 
}
