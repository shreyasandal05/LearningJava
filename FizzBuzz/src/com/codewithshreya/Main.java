package com.codewithshreya;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Number: ");
        int value=scanner.nextInt();
        if(value%3 == 0 && value%5 ==0){
            System.out.println("FizzBuzz");
        }
        else if(value%5 ==0)
            System.out.println("Fizz");
        else if(value%3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(value);
    }
}
