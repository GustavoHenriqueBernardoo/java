public class FizzBuzz {
    public static void main(String[] args) {

       // Task 1 – Make a for loop that counts from 0 to 18. 
       for(int i = 0 ; i <= 18; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println(i +" FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.println(i +" Fizz");
            }else if(i % 5 == 0){
                System.out.println(i +" Buzz");
            }
       }
       
       /* Task 2
             
            Beside each number:
                 if it's a multiple of three, mark it as Fizz.
                 if it's a multiple of five, mark it as Buzz.
                 if it's a multiple of three and five, mark it as FizzBuzz. 

         */

        /* Hints:
            If a number is a multiple of X, the remainder is zero when you divide that number by X. 
            There are three conditions for Fizz, Buzz, and FizzBuzz. Be careful about their order. If something is FizzBuzz, it can also be Fizz or Buzz. 
        */

    }

}
