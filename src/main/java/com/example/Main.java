package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);

        
            System.out.println("Inserire IP Server:");
            String ip = myObj.nextLine();

            System.out.println("Inserire porta del server:");
            int porta = myObj.nextInt();
            myObj.nextLine();

            Socket mioSocket = new Socket(ip, porta);
            BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
            PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);

            System.out.println("Connesso al server; premere EXIT per uscire");

            while (true) {
                System.out.print("Inserire il messaggio: ");
                String messageToSend = myObj.nextLine();

                if (messageToSend.equalsIgnoreCase("EXIT")) {
                    out.println("!"); 
                    break;
                } else {
                    out.println(messageToSend);
                }

                String serverResponse = in.readLine();
                System.out.println("Risposta server: " + serverResponse);
            }

            in.close();
            out.close();
            mioSocket.close();
            myObj.close();
            System.out.println("Connessione terminata");
    }
}

