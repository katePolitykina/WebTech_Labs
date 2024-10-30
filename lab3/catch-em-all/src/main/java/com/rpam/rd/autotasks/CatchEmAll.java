package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();  // вызов метода, который может выбросить разные исключения
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);  // оборачиваем в IllegalArgumentException с соответствующим сообщением
        }  catch (ArithmeticException | NumberFormatException e) {
            System.err.println(e.getMessage());  // выводим сообщение об ошибке в поток ошибок
        }catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);  // оборачиваем в IllegalArgumentException с соответствующим сообщением
        }

    }
}
