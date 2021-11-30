public class ItemClient{
   public static void main(String[] args){
        Book mockingBird = new Book("123456", "To Kill a Mocking Bird", 5, "Harper Lee");
        CD randomSong = new CD("1234567", "Some Random Song", 3, 2.75, "Anonymous", "Rock");
        JournalPaper newJP = new JournalPaper("12345678", "I am Journaling", 4, "Anonymous Guy", 2021);
        Video randomVid = new Video("123456789", "SomeVideo", 200, 40.0, "Some Guy", "Horror", 2021);
        Item[] items = new Item[4];
        items[0] = mockingBird;
        items[1] = randomSong;
        items[2] = newJP;
        items[3] = randomVid;
        for(int i = 0; i < items.length; i++){
            items[i].print();
            System.out.println();
            items[i].checkOut();
            System.out.println();
            items[i].print();
            System.out.println();
            items[i].checkIn();
            System.out.print("");
            items[i].addItem();
            System.out.println();
            items[i].print();
        }
    }
}
