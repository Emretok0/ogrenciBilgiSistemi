public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int matWritten, int matVerbal, int fizikWritten, int fizikVerbal, int kimyaWritten, int kimyaVerbal) {

        if ((matWritten >= 0 && matWritten <= 100) && (matVerbal >= 0 && matVerbal <= 100)) {
            this.mat.writtenNote = matWritten;
            this.mat.verbalNote = matVerbal;
        }

        if ((fizikWritten >= 0 && fizikWritten <= 100) && (fizikVerbal >= 0 && fizikVerbal <= 100)) {
            this.fizik.writtenNote = fizikWritten;
            this.fizik.verbalNote = fizikVerbal;
        }

        if ((kimyaWritten >= 0 && kimyaWritten <= 100) && (kimyaVerbal >= 0 && kimyaVerbal <= 100)) {
            this.kimya.writtenNote = kimyaWritten;
            this.kimya.verbalNote = kimyaVerbal;
        }

    }

    public void isPass() {
        if (this.mat.writtenNote == 0 || this.fizik.writtenNote == 0 || this.kimya.writtenNote == 0 || this.mat.verbalNote == 0 || this.fizik.verbalNote == 0 || this.kimya.verbalNote == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.writtenNote*0.8+this.fizik.verbalNote*0.2) + (this.kimya.writtenNote*0.8+this.kimya.verbalNote*0.2) + (this.mat.writtenNote*0.8+this.kimya.verbalNote*0.2)) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Yazılı Notu : " + this.mat.writtenNote);
        System.out.println("Matematik Sözlü Notu : " + this.mat.verbalNote);
        System.out.println("Fizik Yazılı Notu : " + this.fizik.writtenNote);
        System.out.println("Fizik Sözlü Notu : " + this.fizik.verbalNote);
        System.out.println("Kimya Yazılı Notu : " + this.kimya.writtenNote);
        System.out.println("Kimya Sözlü Notu : " + this.kimya.verbalNote);
    }

}

