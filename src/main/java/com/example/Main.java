package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");
        System.out.println("inserisci");
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter ip");

        String ip = myObj.nextLine();
        System.out.println("inserisci porta del server");
        int porta = myObj.nextInt();
        Socket mioSocket = new Socket(ip,porta);

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);
        
        
        String stringaDaInviare = myObj.nextLine();
        System.out.println("inserisci la stringa");
        String stringadainviare = myObj.nextLine();
        out.println(stringadainviare);

        String stringClient = in.readLine();

        System.out.println("la stringa ricevuta dal server e: " + stringClient);
   
   
    }

}