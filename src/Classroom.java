/*
* Classroom class comprises of an array of Student objects and the fields to store the statistical details required
 */

public class Classroom {

    private Student[] students;
    private int totalMark;
    private double averageMark;
    private int highestMark;
    private int lowestMark;
    private String firstInClass;

    /*
     * Default constructor
     */
    public Classroom() {
    }

    /*
     * Assign the students passed as an argument to the local students array
     */
    public void assignStudents(Student[] s) {
        /*
        Re-create the students array with the number of students inputted
         */
        this.students = new Student[s.length];

        for (int i = 0; i < s.length; i++) {
            this.getStudents()[i] = new Student(s[i].getName(), s[i].getMark());
        }
    }

    /*
     * Returns the students array
     */
    public Student[] getStudents() {
        return students;
    }

    /*
    Returns the total marks for this classroom
     */
    public int getTotalMark() {
        this.totalMark = 0;

        /*
         * Loop through the students array and add all the marks together
         */
        for (int i = 0; i < this.students.length; i++) {
            this.totalMark += this.students[i].getMark();
        }

        return this.totalMark;
    }

    /*
     * Returns the average mark for this classroom
     */
    public double getAverageMark() {
        /*
         * Divides the result of the getTotalMark() returned value by the number of elements in the students array
         */
        this.averageMark = (getTotalMark() / this.students.length);
        return this.averageMark;
    }


    /*
    Returns the highest mark for this classroom
     */
    public int getHighestMark() {
        this.highestMark = 0;

        /*
         * Loops through the students array and stores and returns the highest mark found
         */
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getMark() > this.highestMark) {
                this.highestMark = this.students[i].getMark();
            }
        }
        return this.highestMark;
    }

    /*
     * Returns the lowest mark for this classroom
     */
    public int getLowestMark() {
        this.lowestMark = 100;

        /*
         * Loops through the students array and stores and returns the lowest mark found
         */
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getMark() < this.lowestMark) {
                this.lowestMark = this.students[i].getMark();
            }
        }
        return this.lowestMark;
    }

    /*
     * Returns the name of the first student that has obtained the highest mark
     */
    public String getFirstInClass() {
        this.firstInClass = "";
        int highestMark= 0;
        /*
         * Loops through the students array and stores and returns the name of the student with the highest mark
         */
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getMark() > highestMark) {
                highestMark = this.students[i].getMark();
                this.firstInClass = this.students[i].getName();
            }
        }
        return this.firstInClass;
    }

    /*
     * Returns the (last) student whose name matches the value passed as an argument
     */
    public Student searchStudent(String studentName) {
        Student myStudent = new Student("Not Found", 0);
        int highestMark= 0;
        /*
         * Loops through the student array and, if their name matches the argument passed, the object is stored and returned
         */
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getName().equals(studentName)){
                myStudent = this.students[i];
            }
        }
        return myStudent;
    }

    /*
    Returns a grade, based on the mark specified
     */
    public String getGrades(int mark) {
        if (mark >= 80 && mark <= 100) {
            return ("A");
        } else if (mark >= 60 && mark <= 79) {
            return ("B");
        } else if (mark >= 45 && mark <= 59) {
            return ("C");
        } else if (mark >= 0 && mark <= 45) {
            return ("F");
        } else {
            return ("U");
        }
    }

    /*
    Returns an array index representing grades (A == 0 ... U == 4), based on the mark specified
    */
    private int getGradesIndex(int mark) {
        if (mark >= 80 && mark <= 100) {
            return (0);
        } else if (mark >= 60 && mark <= 79) {
            return (1);
        } else if (mark >= 45 && mark <= 59) {
            return (2);
        } else if (mark >= 0 && mark <= 45) {
            return (3);
        } else {
            return (4);
        }
    }

    /*
    Returns an Integer array with the number of students obtaining a mark by grade
     */
    //Grades being considered are: A, B, C, F and U
    public int[] getStudentsByGrade() {
        int[] result = new int[] {0,0,0,0,0};

        /*
         * Loops through the students array for each grade and updates the appropriate value as needed
         */
        for (Student student : this.students) {
            result[this.getGradesIndex(student.getGrade())]++;
        }
        return result;
    }

    /*
     * Outputs a histogram based on the grades or marks obtained by the students
     */
    public void printHistogram(boolean byGrade) {
        if (byGrade) {
            System.out.println();
            System.out.println("Displaying a histogram of Student Grades");

        } else {
            System.out.println();
        }
    }

}

