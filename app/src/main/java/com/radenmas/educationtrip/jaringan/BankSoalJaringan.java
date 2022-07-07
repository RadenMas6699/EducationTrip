package com.radenmas.educationtrip.jaringan;

public class BankSoalJaringan {
    private String textQuestions1 [] = {
            "Topologi jaringan komputer yang sangat mudah digunakan adalah topologi?",
            "Perangkat jaringan yang paling sederhana cara kerjanya adalah?",
            "Jaringan yang terbentuk dari beberapa jaringan local disebut jaringan?",
            "Keuntungan jaringan client-server yaitu?",
            "Perangkat keras (hardware) yang dibutuhkan untuk membangun sebuah jaringan, kecuali?"
    };
    private String textQuestions2 [] = {
            "Arsitektural jaringan di kembangkan oleh benua?",
            "OSI reference model di tujukan untuk mengembangkan?",
            "Untuk koneksi WIFI, ethernet yang sering digunakan berbasis teknologi IEEE?",
            "Agar 3 atau lebih komputer bisa membentuk suatu jaringan, maka diperlukan?",
            "Pada topologi Star, perangkat jaringan apa yang digunakan?"
    };
    private String textQuestions3 [] = {
            "Jaringan komunikasi satu perangkat lain dengan perangkat lainnya dalam jarak sangat dekat, dan hanya untuk pribadi disebut jaringan?",
            "Jaringan komputer yang jaringannya hanya mencakup wilayah kecil, seperti dalam 1 gedung atau 1 lab disebut dengan jaringan?",
            "Jaringan komputer yang ruang lingkupnya mencakup antar negara adalah?",
            "Untuk menghubungkan beberapa jaringan, diperlukan perangkat jaringan yaitu?",
            "Untuk koneksi LAN, ethernet yang sering digunakan berbasis teknologi IEEE?"
    };
    private String textQuestions4 [] = {
            "Jaringan yang bisa berfungsi sebagai client dan bisa berfungsi sebagai server disebut?",
            "Untuk menghubungkan 2 jaringan atau lebih jaringan yang berbeda disebut?",
            "Peralatan untuk menghubungkan antar komputer yang terdapat pada jaringan LAN adalah?",
            "Salah satu komputer dapat melayani, dan komputer yang lain sebagai client disebut?",
            "Berikut ini adalah Topologi jaringan yang menggunakan Hub sebagai pusat transimisi data, yaitu?"
    };
    private String textQuestions5 [] = {
            "Pemasangan kabel UTP dengan cara Straight digunakan untuk menghubungkan jenis perangkat yang?",
            "Untuk mengetahui apakah komputer dalam jaringan sudah terhubung dengan komputer lain, digunakan perintah?",
            "Komputer berjumlah banyak yang terpisah-pisah akan tetapi saling berhubungan dalam melaksanakan tugasnya merupakan pengertian?",
            "Aturan-aturan dan perjanjian yang mengatur pertukaran informasi antar komputer melalui suatu medium jaringan merupakan pengertian?",
            "Berikut ini perangkat yang umum digunakan ketika kita akan membuat jaringan LAN, kecuali?"
    };

    private String multipleChoice1 [][] = {
            {"Bus", "Tree", "Ring", "Star"},
            {"Router", "Switch", "Access Point", "Hub"},
            {"WAN", "LAN", "MAN", "TCP/IP"},
            {"Tidak tergantung server", "Biaya operasional murah", "Kecepatan akses tinggi", "Client terbatas"},
            {"Router", "Hub", "Switch", "Gateway"}
    };
    private String multipleChoice2 [][] = {
            {"Afrika", "Eropa", "Australia", "Amerika"},
            {"Protokol-protokol jaringan", "Internet", "OSI Layer", "DHCP"},
            {"802.3", "802.11", "802.21b", "804.3"},
            {"VGA Card", "Modem", "Repeater", "Hub"},
            {"Repeater", "Switch", "Terminator", "Amplifier"}
    };
    private String multipleChoice3 [][] = {
            {"PAN", "LAN", "MAN", "WAN"},
            {"PAN", "LAN", "MAN", "WAN"},
            {"PAN", "LAN", "MAN", "WAN"},
            {"Router", "Bridge", "Gateway", "Backbone"},
            {"802.3", "802.11", "802.11b", "804.3"}
    };
    private String multipleChoice4 [][] = {
            {"Peer to peer", "Client server", "LAN", "MAN"},
            {"Switch", "Ethernet Card", "RJ-45", "Router"},
            {"Switch", "Modem", "Router", "RJ-45"},
            {"Peer to peer", "Client server", "LAN", "MAN"},
            {"Topologi Star", "Topologi Bus", "Peer-to-peer", "Topologi Ring"}
    };
    private String multipleChoice5 [][] = {
            {"Sejaringan", "Berbeda Tingkat", "Berbeda Bentuk", "Setara"},
            {"Ping", "Commant prompt", "Ipconfig", "Cmd"},
            {"Jaringan komputer", "System komputer", "Jaringan dasar", "Manajemen komputer"},
            {"Internet", "Protocol", "IP", "OSI"},
            {"Repeater", "Antena", "Access Point", "Hub"}
    };

    private String mCorrectAnswers1 [] = {
            "Star",
            "Hub",
            "MAN",
            "Kecepatan akses yang tinggi",
            "Gateway"
    };
    private String mCorrectAnswers2 [] = {
            "Amerika",
            "Protokol-protokol jaringan",
            "802.11",
            "Hub",
            "Switch"
    };
    private String mCorrectAnswers3 [] = {
            "PAN",
            "LAN",
            "WAN",
            "Router",
            "802.3"
    };
    private String mCorrectAnswers4 [] = {
            "Peer to peer",
            "Router",
            "Switch",
            "Client server",
            "Topologi Star"
    };
    private String mCorrectAnswers5 [] = {
            "Berbeda Tingkat",
            "Ping",
            "Jaringan komputer",
            "OSI",
            "Antena"
    };

    public int getLength1(){
        return textQuestions1.length;
    }
    public int getLength2(){
        return textQuestions2.length;
    }
    public int getLength3(){
        return textQuestions3.length;
    }
    public int getLength4(){
        return textQuestions4.length;
    }
    public int getLength5(){
        return textQuestions5.length;
    }

    public String getQuestion1(int a) {
        String question1 = textQuestions1[a];
        return question1;
    }
    public String getQuestion2(int a) {
        String question2 = textQuestions2[a];
        return question2;
    }
    public String getQuestion3(int a) {
        String question3 = textQuestions3[a];
        return question3;
    }
    public String getQuestion4(int a) {
        String question4 = textQuestions4[a];
        return question4;
    }
    public String getQuestion5(int a) {
        String question5 = textQuestions5[a];
        return question5;
    }

    public String getChoice1(int index, int num) {
        String choice1 = multipleChoice1[index][num-1];
        return choice1;
    }
    public String getChoice2(int index, int num) {
        String choice2 = multipleChoice2[index][num-1];
        return choice2;
    }
    public String getChoice3(int index, int num) {
        String choice3 = multipleChoice3[index][num-1];
        return choice3;
    }
    public String getChoice4(int index, int num) {
        String choice4 = multipleChoice4[index][num-1];
        return choice4;
    }
    public String getChoice5(int index, int num) {
        String choice5 = multipleChoice5[index][num-1];
        return choice5;
    }

    public String getCorrectAnswer1(int a) {
        String answer1 = mCorrectAnswers1[a];
        return answer1;
    }
    public String getCorrectAnswer2(int a) {
        String answer2 = mCorrectAnswers2[a];
        return answer2;
    }
    public String getCorrectAnswer3(int a) {
        String answer3 = mCorrectAnswers3[a];
        return answer3;
    }
    public String getCorrectAnswer4(int a) {
        String answer4 = mCorrectAnswers4[a];
        return answer4;
    }
    public String getCorrectAnswer5(int a) {
        String answer5 = mCorrectAnswers5[a];
        return answer5;
    }
}
