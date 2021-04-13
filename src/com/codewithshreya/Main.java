package com.codewithshreya;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR=12;
    final static byte PERCENT=100;

    public static void main(String[] args) {
        int principle=(int)readNumber("Principle: ",1000,1_000_000);
        float rateOfInterest=(float)readNumber("Annual interest rate: ",0,30);
        byte years=(byte)readNumber("Period(years): ",1,30);

        double mortgage=calculateMortgage(principle,rateOfInterest,years);
        String mortgageFormatted=NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments: "+mortgageFormatted);

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(short month=1;month<=years*MONTHS_IN_YEAR;month++){
            double balance=calculateBalance(principle,rateOfInterest,years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt,double min,double max){
        System.out.print(prompt);
        Scanner scanner=new Scanner(System.in);
        double value;
        while(true){
            value=scanner.nextFloat();
            if(min<value && value<=max)
                break;
            System.out.println("Enter a value between "+min+"and "+max);
        }
        return value;
    }

    public static double calculateBalance(int principle,float rateOfInterest,byte years,short noOfPaymentsMade){
        short noOfPayments=(short)(years*MONTHS_IN_YEAR);
        float monthlyInterest=rateOfInterest/MONTHS_IN_YEAR/PERCENT;
        int value=(int) (Math.pow((1+monthlyInterest),noOfPayments));

        double balance=principle*((value-Math.pow((1+monthlyInterest),noOfPaymentsMade))/value-1);
        return balance;
    }

    public static double calculateMortgage(int principle,float rateOfInterest,byte years){
        short noOfPayments=(short)(years*MONTHS_IN_YEAR);
        float monthlyInterest=rateOfInterest/MONTHS_IN_YEAR/PERCENT;

        double mortgage=principle*(monthlyInterest*Math.pow((1+monthlyInterest),noOfPayments))/(Math.pow((1+monthlyInterest),noOfPayments)-1);
        return mortgage;
    }
}

