package com.radenmas.educationtrip.rpl;

public class BankSoalRPL {
    private String textQuestions1 [] = {
            "Seluruh perintah yang digunakan untuk memproses informasi?",
            "Memfokuskan pada karakteristik  obyek adalah?",
            "Membagi sistem yang rumit  menjadi bagian-bagian yang lebih kecil?",
            "Di bawah ini merupakan bagian-bagian dari class diagram, kecuali?",
            "Class diagram dalam notasi UML digambarkan dengan?"
    };
    private String textQuestions2 [] = {
            "Class yang tidak mempunyai induk disebut?",
            "Pada UML, informasi yang unik disebut?",
            "Pada tahun berapakah publikasi awal tentang IT Infrastructure Library dilakukan?",
            "Di bawah ini yang bukan merupakan keuntungan dari spring adalah?",
            "Bagian dari arsitektur spring yang bertugas untuk pengaksesan database adalah?"
    };
    private String textQuestions3 [] = {
            "Berikut adalah software yang membundel aplikasi webserver, skrip server, dan database server, kecuali?",
            "Untuk menjalankan servis mysql pada linux debian digunakan perintah?",
            "Secara default database mysql pada linux Ubuntu dipasang di folder?",
            "Tipe data pascal untuk karakter adalah?",
            "Kapan terbentuknya pascal?"
    };
    private String textQuestions4 [] = {
            "Tipe bilangan bulat dalam bahasa pascal dikenal sebagai?",
            "Istilah” perulangan “ dalam pemograman pascal dikenal dengan?",
            "Perintah untuk menutup program dalam pascal adalah?",
            "Menggambarkan program secara logika merupakan fungsi dari?",
            "Deklarasi yang digunakan untuk mengidentifikasikan data yang nilainya sudah ditentukan dan tidak dapat dirubah disebut?"
    };
    private String textQuestions5 [] = {
            "Tipe data yang cocok untuk menyimpan data nama siswa adalah?",
            "Suatu program terpisah dalam blok sendiri yang berfungsi sebagai subprogram (program bagian), disebut?",
            "Suatu indentifier non standar yang nilainya tidak tetap atau nilainya merupakan hasil dari suatu proses,disebut?",
            "Bentuk dari suatu statment IF berada di dalam lingkungan statmean IF yang lainya,disebut IF dalam kondisi?",
            "Array terdiri dari berbagai tipe kecuali?"
    };

    private String multipleChoice1 [][] = {
            {"Perangkat Lunak", "Aplikasi", "Desain", "Analisa"},
            {"Enkapsulasi", "Abstraksi", "Modularitas", "Hirarki"},
            {"Abstraksi", "Hirarki", "Enkapsulasi", "Modularitas"},
            {"Attribute", "Operation", "Messages", "Method"},
            {"Segitiga", "Kotak", "Jajaran Genjang", "Lingkaran"}
    };
    private String multipleChoice2 [][] = {
            {"Leaf Class", "Root Class", "Child Class", "Parent Class"},
            {"Multiflier", "Amplifier", "Qualifier", "Identifier"},
            {"1988", "1989", "1990", "1991"},
            {"IoC", "AoP", "Lightweight container", "XoP"},
            {"Spring AoP", "Spring web", "Spring ORM", "Spring web MVC"}
    };
    private String multipleChoice3 [][] = {
            {"phpnuke", "phptriad", "lampp", "xampp"},
            {"/etc/mysql restart", "/etc/start", "/etc/init.d/mysql restart", "/etc/var/mysql start"},
            {"/var/lib/mysql", " /root/mysql", "/lib/mysql", "/var/mysql"},
            {"Char", "Boolean", "Integer", "Real"},
            {"1981", "1971", "1961", "1991"}
    };
    private String multipleChoice4 [][] = {
            {"Byte", "Integer", "Char", "String"},
            {"Repeating", "Again", "Replay", "Looping"},
            {"End.", "End;", "Uses crt;", "Finish"},
            {"Flowchart", "Dxdiag", "Begin", "Sistem operasi"},
            {"Deklarasi label", "Deklarasi konstanta", "Deklarasi tipe", "Deklarasi variabel"}
    };
    private String multipleChoice5 [][] = {
            {"Numeric", "Character", "Date/Time", "Array"},
            {"Variabel", "Tipe data", "Prosedur", "Deklarasi"},
            {"Variabel", "Ripe data", "Prosedur", "Array"},
            {"IF-THEN", "IF bercabang", "IF tunggal", "IF bersarang"},
            {"Array Dimensi Satu", "Array Dimensi Dua", "Array Multi-Dimensi", "Semua jawaban benar"}
    };

    private String mCorrectAnswers1 [] = {
            "Perangkat Lunak",
            "Abstraksi",
            "Modularitas",
            "Messages",
            "Kotak"
    };
    private String mCorrectAnswers2 [] = {
            "Root Class",
            "Qualifier",
            "1989",
            "XoP",
            "Spring ORM"
    };
    private String mCorrectAnswers3 [] = {
            "lampp",
            "/etc/var/mysql start",
            "/var/lib/mysql",
            "Char",
            "1971"
    };
    private String mCorrectAnswers4 [] = {
            "Integer",
            "Looping",
            "End.",
            "Flowchart",
            "Deklarasi konstanta"
    };
    private String mCorrectAnswers5 [] = {
            "Character",
            "Prosedur",
            "Variabel",
            "IF bersarang",
            "Array Multi-Dimensi"
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
