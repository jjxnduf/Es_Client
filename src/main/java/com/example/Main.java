package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci l'IP del server: ");
        String ip = scanner.nextLine();

        System.out.print("Inserisci la porta del server: ");
        int port = scanner.nextInt();
        scanner.nextLine();

        Socket socket = new Socket(ip, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        
        String serverVersion = in.readLine();
        System.out.println("Versione del server: " + serverVersion);


        System.out.println(
                "Connesso al server. Inserisci numeri e operazione (1=+, 2=-, 3=/, 4=*). Qualsiasi altro valore per uscire.");

        while (true) {
            System.out.print("Primo numero: ");
            int num1 = scanner.nextInt();

            System.out.print("Secondo numero: ");
            int num2 = scanner.nextInt();

            System.out.print("Operazione (1=+, 2=-, 3=/, 4=*): ");
            int op = scanner.nextInt();

            if (op < 1 || op > 4) {
                break;
            }

            out.println(num1);
            out.println(num2);
            out.println(op);

            String risposta = in.readLine();
            System.out.println("Risposta dal server: " + risposta);
        }

        out.close();
        in.close();
        socket.close();
        scanner.close();

        System.out.println("Connessione chiusa.");
    }
}
