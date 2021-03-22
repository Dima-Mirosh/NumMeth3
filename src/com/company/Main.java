package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double e = 0.0001;
        Scanner in = new Scanner(System.in);
        double tmp1, tmp2, b, x, equation;
        System.out.println("Enter in which diapason we are going to search roots");
        double start = in.nextDouble();
        double end =  in.nextDouble();
        int iter = 1;
        equation = equationResult(start);
        for (double i = start+0.1; i < end; i += 0.1) {
            tmp1 = equation;
            equation = equationResult(i);
            if((tmp1*equation) < 0){
                b = i-0.1;
                x = i;
                System.out.printf("%d interval is [%.2f;%.2f]\n", iter, b, x);
                do{
                    if(equationResult(b)*equationResult((b+x)/2) < 0){
                        x = (b+x)/2;
                    } else b = (b+x)/2;
                    tmp2 = Math.abs(b-x);
                    if(tmp2 < 2*e){
                        System.out.printf("X%d is %.7f, result of equation is %.3f\n",
                                iter++, (b+x)/2, equationResult((b+x)/2));
                    }
                }while(tmp2 > 2*e);
            }
        }
    }

    public static double equationResult(double x){
        return ((1.8*Math.pow(x, 3))+(0.4*Math.pow(x, 2))-(0.3*x)-1.7);
    }
}
