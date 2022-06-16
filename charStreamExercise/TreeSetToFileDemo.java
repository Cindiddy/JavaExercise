package charStreamExercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetToFileDemo {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s2.getSum() - s1.getSum();
                int num2 = num == 0 ? s2.getEnglishScore() - s1.getEnglishScore() : num;
                int num3 = num2 == 0 ? s2.getMathScore() - s1.getMathScore() : num2;
                int num4 = num3 == 0 ? s2.getName().compareTo(s1.getName()):num3;
                return num4;
            }
        });

        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter No." + (i + 1) + " student information:");
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("English Score: ");
            int englishScore = sc.nextInt();
            System.out.println("Math Score: ");
            int mathScore = sc.nextInt();
            System.out.println("Science Score: ");
            int scienceScore = sc.nextInt();

            Student s = new Student();
            s.setName(name);
            s.setEnglishScore(englishScore);
            s.setMathScore(mathScore);
            s.setScienceScore(scienceScore);

            ts.add(s);
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter("ts.txt"));

        for (Student s:ts){
            String str=s.getName()+","+s.getEnglishScore()+","+s.getMathScore()+","+s.getScienceScore();
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
