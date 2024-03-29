package org.prog.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Exceptions {

    public static void main(String[] args) {
        try {
            readFile1();
        } catch (Throwable t) {
            System.out.println("OOPS");
        }
        System.out.println("test");
    }

    public static void readFile1(){
        try {
            readFile2();
        } catch (Throwable t) {
            System.out.println(t);
        }
    }

    public static void readFile2() {
        readFile3();
    }


    public static void readFile3() {

        try {
            readFile4();
        } catch (Throwable t) {
            System.out.println("OOPS");
            throw new RuntimeException(t);
        }
    }

    public static void readFile4() {
        try {
            readFile5();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile5() throws FileNotFoundException {
        File f = new File("abc.txt");
        FileReader fileReader = new FileReader(f);
        f.setReadable(true);
    }

    public static void readStaticException(int age ) {
        if (age < 18) {
            throw new
                    ArithmeticException("Access denied-You must be at least 18 years old.");
        } else {
            System.out.println("Access granted-You are old enought!");
        }

    }
    public static void readStaticException1() {
        try {
            readStaticException(1);
        } catch (ArithmeticException a) {
            System.out.println(a);
        }
    }

}
