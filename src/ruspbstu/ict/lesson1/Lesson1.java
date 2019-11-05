package ruspbstu.ict.lesson1;

import java.util.Random;
import java.util.Scanner;

public class Lesson1 {

    public static void main(String[] args) {

        final int GUESS_NUMBER = new Random().nextInt(100) + 1;
       // final int GUESS_NUMBER = (int)(Math.random() * 99) + 1;

       // System.out.println(GuessNumber);
        int triesCount = 0;

        System.out.println("Попробуйте угадать число от 1 до 100");

        int userNumber;
        boolean isGuessed = false;
        while(!isGuessed) {
            if(triesCount >= 9) {
                System.out.println("Количество попыток исчерпано \n загаданное число было: " + GUESS_NUMBER);
                break;
            }

            System.out.println("Введите число");
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            userNumber = Integer.parseInt(next); // число которое ввёл пользователь


            triesCount++;
            if(userNumber == GUESS_NUMBER) {
                System.out.println("Поздравляю вы угадали число " + GUESS_NUMBER + " число попыток: " + triesCount);
                isGuessed = true;
            }
            else if(userNumber < GUESS_NUMBER){
                System.out.println("Загаданное число БОЛЬШЕ предложенного");
            }
            else{
                System.out.println("Загаданное число МЕНЬШЕ предложенного");
            }
        }
// загадать число 1- 10-100 . Введите число. программа говорит больше или меньше от загаданого // использовать бинарный поиск
    }/*
    program arguments // settings
    int array[] = new int[Integer.MAX_VALUE/2 + 1000];
        for (int i = 0; i < array.length;i++){
        array[i] = i;
    }
    int toFind = args.length > 0 ? Integer.valueOf(args[0]) : array.length / 2;

    int index = Arrays.binarySearch(array, toFind);

        System.out.println("Index of" + toFind + "is" + index);

    Long startTime = System.currentTimeMillis();

    String accum = "";
        for(int i =0; i < Integer.MAX_VALUE/1000; ++i){
        accum += 'a';
    }

    Long startTime = System.currentTimeMillis();
    StringBuilder builder = new StringBuilder();
           for(int i = 0; i < Integer.MAX_VALUE / 2; i++){
        builder.append('a');
    }

    String s = builder.toString();
*/

//      Stack st = new Stack(7);
//      st.add(12.23);
//      st.add(4);
//      st.add(356785.23539);
//      st.add(2287);
//      st.add(452.13);
//      System.out.println(st.empty());
//
//      System.out.println(st.peek() + "\n");
//
//      st.pop();
//        for(Double i : st){
//            System.out.println(i);
//        }
//      st.show();

    //5+4*3/10


//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        System.out.println(str);
}
