public class HelloWorld{
    public static void main(String[] args){
        System.out.print(f(12, 14));
        
    }
    public static void z(int num){
        try{
           if (num < 0)
               throw new IllegalArgumentException();
           else if(num == 1)
               System.out.print("1");
           else{
               z(num-1);
               System.out.print(", "+ num);
           } 
        }
        catch(IllegalArgumentException e){
           System.out.println("Number should not be negative.");
        }      
    }
    public static int f(int i, int j){
        if (i < 11)
            if (j < 11)
                return i + j;
            else
                return j + f(i, j - 2);
        else
            return i + f(i - 1, j);
    }
    public static int[] divisor(int num){
        int[] poss = new int[101];
        int ctr = 0;
        int temp = 0;
        int[] div = new int[ctr];
        for (int i = 0; i < poss.length; i++) {
            if (poss[i] != 0){
                temp = num % poss[i];
            }
            if (temp == 0){
                ctr += 1;
                div[i] = poss[i];
            }
        }
        return div;
    }
}