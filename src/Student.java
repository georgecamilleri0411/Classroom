/*
 * Student class. This class stores the student's name, mark and grade.
 * The grade is calculated automatically.
 */

public class Student {

    String studentName;
    int mark;
    private char grade;
    int hist;

    /*
     * Default constructor
     */
    public Student() {
    }

    /*
     * Additional constructor, in which the student's name and mark are passed as arguments,
     * and the grade is calculated automatically.
     */
    public Student(String _name, int _mark) {
        this.studentName = _name;
        this.mark = _mark;
        this.grade = setGrades(this.mark);
    }

    /*
     * Sets the student's name
     */
    public void setName(String _name) {
        this.studentName = _name;
    }

    /*
     * Sets the student's mark
     */
    public void setMark(int _mark) {
        this.mark = _mark;
        this.grade = setGrades(this.mark);
    }

    /*
     * Returns the student's name
     */
    public String getName() {
        return this.studentName;
    }

    /*
     * Returns the student's mark
     */
    public int getMark() {
        return this.mark;
    }

    /*
     * Returns the student's grade
     */
    public char getGrade() {
        return this.grade;
    }

    /*
    Calculates and sets this student's grade automatically
    */
    public char setGrades(int mark) {
        if (mark >= 80 && mark <= 100) {
            return ("A".charAt(0));
        } else if (mark >= 60 && mark <= 79) {
            return ("B".charAt(0));
        } else if (mark >= 45 && mark <= 59) {
            return ("C".charAt(0));
        } else if (mark >= 20 && mark <= 44) {
            return ("F".charAt(0));
        } else {
            return ("U".charAt(0));
        }
    }

}