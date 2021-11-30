import java.util.Scanner;
import java.util.Random;
public class SecretTwoDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String prompt = "Your guess: ";
        int secretTwo = initRand();
        for (int i = 1; i <= 10; i++){
            System.out.print(prompt);
            int guess = getInt(in, prompt);
            if (secretTwo == guess) {
                System.out.println("You guessed my number in " + i + " tries");
                System.exit(0);
            }
            int spos1 = secretTwo / 10;
            int spos2 = secretTwo % 10;
            int gpos1 = guess / 10;
            int gpos2 = guess % 10;
            int match = 0;
            if (spos1 == gpos1 || spos1 == gpos2){
                match++;
            }
            if (spos2 == gpos1 || spos2 == gpos2){
                match++;
            }
            System.out.println("Incorrect (hint: " + match + " digits match)");
        }
        System.out.println("You lost all attempts. The secret number was " + secretTwo);
    }
    public static int initRand() {
        Random rand = new Random();
        int num = 10 + rand.nextInt(90);
        return num;
    }
    public static int getInt(Scanner input, String prompt){
        while(!input.hasNextInt()) {
            input.next();
            System.out.print("Not an integer! Try again. " + prompt);
        }
        return input.nextInt();
    }
}