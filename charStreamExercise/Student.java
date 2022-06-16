package charStreamExercise;

public class Student {
    private String name;
    private int englishScore;
    private int mathScore;
    private int scienceScore;

    public Student() {
    }

    public Student(String name, int englishScore, int mathScore, int scienceScore) {
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
    }

    public String getName() {
        return name;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public void setScienceScore(int scienceScore) {
        this.scienceScore = scienceScore;
    }

    public int getSum(){
        return this.englishScore+this.mathScore+this.scienceScore;
    }
}
