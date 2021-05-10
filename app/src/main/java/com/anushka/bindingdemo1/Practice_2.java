package com.mynotes.notes;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

abstract public class Practice_2 extends AppCompatActivity implements Practic_Intercace {
    String ankur = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        //  main();
        // ankur = "patel";

        return super.onCreateView(name, context, attrs);
    }

    abstract void main();

    @Override
    public void interface_method() {

    }

    public void stringRevese() {
        String reverse = "ankur patel";
        String print = "";
        char[] chars = reverse.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            print = print + chars[i];
        }
        Log.d("Revese", print);

    }

    public void arrayRevese() {
        String[] ar = {"ankur", "patel"};
        String print = "";
        for (int i = ar.length - 1; i >= 0; i--) {
            print = print + ar[i];
            ;

        }
        Log.d("Revese", print);
    }

    public void numberInteger() {
        int[] reverse = {1, 2, 3, 41, 5};
        int print = 0;
        for (int i = reverse.length - 1; i >= 0; i--) {
            // print = print +reverse[i];
            Log.d("Revese", String.valueOf(reverse[i]));
            System.out.print(String.valueOf(reverse[i]));
        }

    }

    public void bigestValueFromArray() {
        int[] reverse = {1, 2, 3, 41, 5};
        int tem = 2;
        int min = 2;
        for (int i = 0; i < reverse.length; i++) {
            int value = reverse[i];
            if (reverse[i] > tem) {
                tem = reverse[i];
            } else if (reverse[i] < min) {
                min = reverse[i];
            }
        }
        Log.d("max", String.valueOf(tem));
        Log.d("min", String.valueOf(min));
    }

    public void primeNumber() {
        int number = 445;

        if (number % 2 == 0) {
            Log.d("Prime number", String.valueOf(number));
        } else {
            Log.d("Not a Prime number", String.valueOf(number));
        }

    }

    public void reverseInbuiltFuction() {
        String reverse = "ankur";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reverse);
        stringBuilder = stringBuilder.reverse();
        Log.d("reverse_inbuilt", stringBuilder.toString());
    }

    public void reveseUsingDynamice_Input() {
        String reverse;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your name to revese");
        reverse = scanner.nextLine();
        char[] chars = reverse.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            Log.d("print", String.valueOf(chars[i]));
        }

    }

    public void swipingTwoNumberWithThird() {
        int x, y, texp;
        x = 10;
        y = 20;
        texp = x;
        x = y;
        Log.d("swping_number", String.valueOf("x value is =" + x + "\ny values is =" + texp));

    }

    public void swipingTwoNumberWitout_Third() {
        int x, y;
        x = 10;
        y = 15;
        Log.d("swping_number_befor", String.valueOf("x value is =" + x + "\ny values is =" + y));
        x = x + y;
        y = x - y;
        x = x - y;
        Log.d("swping_number_after", String.valueOf("x value is =" + x + "\ny values is =" + y));
    }

    public void palindrome() {
        ////palindrome means the reverse string is equal to orginal string
        String orginal = "101";
        String reverse = "";
        char[] chars = orginal.toCharArray();
        for (int i = orginal.length() - 1; i >= 0; i--) {
            reverse = reverse + chars[i];
        }
        if (reverse.equals(orginal)) {
            Log.d("palindrome", "this is palindrome");
        } else {
            Log.d("not palindrome", "this is not palindrome");
        }
    }

    public void fibonaci_Series(){
        ////write program to print fibonaci series
        int num = 10;
        int a = 0 , b = 0 , c= 1;
        for (int i = 0 ; i<num;i++){
            a = b ;
            b = c;
            c  = a+b;
            Log.d("fibonaci_serires",String.valueOf(c));

        }

    }
}
