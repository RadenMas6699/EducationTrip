package com.radenmas.educationtrip.multimedia;

public class BankSoalMultimedia {
    private String textQuestions1 [] = {
            "Jika ingin memotong gambar hasil scan, maka tool yang digunakan adalah?",
            "Salah satu software pengolah audio adalah?",
            "Software yang digunakan untuk membuat animasi teks adalah?",
            "Untuk menutup program aplikasi photoshop bisa menggunakan shortcut?",
            "Dibawah ini software pengolah gambar vektor/digital illustrator adalah?"
    };
    private String textQuestions2 [] = {
            "Usaha untuk menggerakan sesuatu yang tidak bisa bergerak sendiri merupakan arti harfiah dari?",
            "Untuk memberikan efek transparan pada objek digunakan pengaturan color?",
            "Media Video menggunakan program?",
            "Animasi untuk mengubah posisi objek adalah?",
            "Salah satu program penyuting video adalah?"
    };
    private String textQuestions3 [] = {
            "Yang termasuk program berbasis vektor dalam kategori program modeling adalah?",
            "Kumpulan titik disebut dengan?",
            "Jumlah pixel persentimeter adalah?",
            "Painting tool di photoshop yang digunakan untuk menggambar menggunakan kuas yaitu?",
            "Suatu kegiatan yang dilakukan setelah proses shooting dan menata agar video yang dihasilkan menjadi lebih bagus disebut?"
    };
    private String textQuestions4 [] = {
            "Proses pemindahan video hasil shooting dari dvcamcoder ke personal computer disebut?",
            "Kartu yang terdiri atas port firewire yang digunakan untuk memindahkan video dari dvcomcoder ke komputer disebut?",
            "Dibawah ini merupakan standar yang digunakan dalam dunia broadcase terutama film atau video kecuali?",
            "Rasio perbandingan lebar terhadap tinggi setiap pixel penyusun frame disebut?",
            "Format kompresi file video yang digunakan dalam produksi video adalah?"
    };
    private String textQuestions5 [] = {
            "Untuk mengatur kecepatan dan durasi dari klip digunakan?",
            "Kumpulan angka hitungan mundur untuk mengawali sebuah tayangan film disebut?",
            "Klip yang digunakan untuk alat bantu kalibarsi dalam suatu tayangan klip digunakan?",
            "Property transparansi dari setiap klip disebut?",
            "Tempat untuk menyusun dan menenmpatkan footage/klip untuk kemudian diedit disebut?"
    };

    private String multipleChoice1 [][] = {
            {"Rotate", "Crop", "Brush", "Zoom"},
            {"Adobe Photoshop", "Adobe Audition", "Corel Draw", "Swis Max"},
            {"Corel Draw", "Adobe Flash", "Dreamweaver", "Swish Max"},
            {"CTRL + S ", "CTRL + O", "CTRL + Q", "CTRL + C "},
            {"Corel Draw", "Paint Brush", "Macromedia Flash", "Dreamweaver"}
    };
    private String multipleChoice2 [][] = {
            {"Flowchart", "Story board", "Zeotrope", "Animasi"},
            {"Easeout", "Alpha", "Beta", "Omega"},
            {"Adobe Audition", "Interactivity", "Adobe Premier", "CorelDraw"},
            {"Shape tween", "Motion tween", "Tweening", "Animation"},
            {"Corel Draw", "Swis Max", "Adobe Flash", "Ulead"}
    };
    private String multipleChoice3 [][] = {
            {"Autocard", "Photoshop", "Macromedia Flash", "3D Studio MAX"},
            {"Bitmap", "Pixel", "Contras", "Layer"},
            {"Pixel", "Render", "Resolusi", "Layer"},
            {"Pensil", "Painting Brush", "Eraser", "Air bursh"},
            {"Capture video", "Editing video", "Rendering video", "Importing video"}
    };
    private String multipleChoice4 [][] = {
            {"Capture Video", "Editing Video", "Rendering Video", "Importing Video"},
            {"Sound card", "Vga card", "Dv capture card", "Memory card"},
            {"Ntsc", "Secam", "Pal", "Panasonic24p"},
            {"Par", "Aiff", "Clip", "Aliasing"},
            {"Mov", "Mp4", "Flv", "Mpeg-2"}
    };
    private String multipleChoice5 [][] = {
            {"Clip speed/duration", "Keying", "Masking", "Transisi"},
            {"Sequence", "Barcode", "Counting leader", "Track"},
            {"Audio efek", "Klip bars and tone", "Klip black video", "Video transisi"},
            {"Timecode", "Add track", "Opacity", "Color bar"},
            {"Timeline window", "Monitor window", "Project window", "Format display"}
    };

    private String mCorrectAnswers1 [] = {
            "Crop",
            "Adobe Audition",
            "Swish Max",
            "CTRL + Q",
            "Corel Draw"
    };
    private String mCorrectAnswers2 [] = {
            "Animasi",
            "Alpha",
            "Adobe Premier",
            "Motion tween",
            "Ulead"
    };
    private String mCorrectAnswers3 [] = {
            "3D Studio MAX",
            "Pixel",
            "Resolusi",
            "Painting Brush",
            "Editing video"
    };
    private String mCorrectAnswers4 [] = {
            "Capture Video",
            "Dv capture card",
            "Panasonic24p",
            "Par",
            "Mpeg-2"
    };
    private String mCorrectAnswers5 [] = {
            "Clip speed/duration",
            "Counting leader",
            "Klip bars and tone",
            "Opacity",
            "Timeline window"
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
