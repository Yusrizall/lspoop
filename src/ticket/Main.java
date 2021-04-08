/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.Scanner;

/**
 *
 * Kelas main berisi method main yang berfungsi untuk menjalankan program sejak awal.
 * Method method yang disiapkan tinggal dipanggil untuk dieksekusi di sini secara
 * urut sesuai antrian program oleh pengembang aplikasi
 * 
 * @author Yusrizal Abin Nabil
 */
public class Main {
    
    public static void main(String[] args) {
        /**
         * Create array list untuk tiket tiket
         * bertipe data interface tiket
         * 
         * lalu di deklarasi dengan tipe tiket  
         */
        Ticket[] tickets = {
            new Economy("Ekonomi"),
            new Business("Bisnis"),
            new Executive("Eksekutif")
        };
        
        /**
         * method mulai memulai aplikasi
         */
        mulai(tickets);
    }
    
    public static void mulai(Ticket[] tickets) {
       
        boolean berhenti = false;
        
        while (!berhenti) {
           
            cetakListTiket(tickets);

            Scanner input = new Scanner(System.in);
            int tiketPilihan, penumpang = 0, price;
            String again;

            // cetak pertanyaan input data
            System.out.println("Pilih nomor kelas kereta yang anda inginkan");
            System.out.print("Nomor = ");
                
                while (!input.hasNextInt()) {
                    System.out.println("Silahkan memasukkan nomor kelas yang tersedia!");
                   
                    System.out.print("Nomor = ");
                   
                    input.next();
                }

            tiketPilihan = input.nextInt();
            
            // Validasi
            if (tiketPilihan <= 0 || tiketPilihan > tickets.length) {
                System.out.println("=================");
                
                System.out.println("Tolong masukkan nomor tiket sesuai list!");
                
                continue;
            }
            
            while(penumpang <= 0) {
                System.out.print("Jumlah Penumpang = ");
                
                while (!input.hasNextInt()) {
                    System.out.println("Masukkan jumlah penumpang berupa angka!");
                    System.out.print("Jumlah Penumpang = ");
                   
                    input.next();
                }
                
                penumpang = input.nextInt();
            }

            int total = tickets[tiketPilihan - 1].getPrice() * penumpang;

            //mencetak total bayar 
            System.out.println("Total Bayar = " + total);
            
            System.out.println("=======================");
            
            //perulangan
            boolean stopAsk = false;
            
            while (!stopAsk) {
                System.out.println("Pesan Tiket Lagi? (Y/T) ");

                again = input.next();

                if (!again.toLowerCase().equals("y") && !again.toLowerCase().equals("t")) {
                    continue;
                }
                
                stopAsk = true;
                
                if (again.toLowerCase().equals("t")) {
                    berhenti = true;
                    System.out.println("===========================================");
                    System.out.println("-----  Yusrizal Abin Nabil RPL 2 / 35 -----");
                    System.out.println("----       LSP OOP - 10 April 2021     ----");
                    System.out.println("--- Asesor : Rodhi Nur Wulan Azis S.Pd  ---");
                    System.out.println("===========================================");
                }
            }
        }
    }
    
    public static void cetakListTiket(Ticket[] tickets) {
        System.out.println("=======================");
        System.out.println("Sistem Tiket Kereta Api");
        System.out.println("   Surabaya - Malang   ");
        System.out.println("=======================");
        
        for (int i = 0; i < tickets.length; i++) {
            System.out.println("| "+(i + 1) + ". " + tickets[i].getName() + " : " + tickets[i].getPrice());
        }
        
        System.out.println("=======================");
    }
    
}
