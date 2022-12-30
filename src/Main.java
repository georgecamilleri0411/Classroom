/*
 * Main class. The program starts running from here (using the main method)
 */
public class Main {

    static Classroom myClassroom = new Classroom();

    public static void main(String[]args) {

        int choice;
        final int password=23456;
        int nos = 31;
        final int maxStudentNameLength = 30;
        String padStr = "";
        for (int s = 0; s < maxStudentNameLength; s++) {
            padStr += " ";
        }
        System.out.println ("Welcome to the Student Marks program.");
        System.out.println("Enter password");
        int password2= Keyboard.readInt();
        if (password2 == password) {
            System.out.println("access granted");
            System.out.println("How many students do you have in your class? (Maximum 30)");
            while (nos <= 0 || nos > 30) {
                nos = Keyboard.readInt();
            }

            Student[] students = new Student[nos];

            do {
                /*
                 * Display the menu
                 */
                System.out.println();
                System.out.println("=============================================================================================");
                System.out.println("MENU");
                System.out.println("=============================================================================================");
                System.out.println("1 - Enter Students List of Names and Marks");
                System.out.println("2 - Display Students Details");
                System.out.println("3 - Display Total, Average, Highest and Lowest Marks, Student above and below average mark");
                System.out.println("4 - Display First in Class");
                System.out.println("5 - Search for a particular student.");
                System.out.println("6 - Display a Histogram of student marks");
                System.out.println("7 - Display a Histogram of student grades");
                System.out.println("---------------------------------------------------------------------------------------------");
                System.out.println("0 - Exit");
                System.out.println("=============================================================================================");
                System.out.println("Enter your choice: ");
                System.out.println();
                choice = Keyboard.readInt();

                switch (choice) {
                    case 1: // Option 1: input the student names and marks.
                        System.out.println("You have chosen '1 - Enter Students List of Names and Marks'.");
                        // Loop for the number of students in this classroom and store them in an array
                        for (int i = 0 ; i < nos ; i++){
                            System.out.println();
                            System.out.println("Enter student " + (i + 1) + " name:");
                            String sName = Keyboard.readString();

                            System.out.println("Enter student " + (i + 1) + " mark:");
                            int mark = Keyboard.readInt();
                            while (mark < 0 || mark > 100){
                                System.out.println("Invalid mark. Please try again.");
                                mark=Keyboard.readInt();
                            }
                            students[i] = new Student(sName, mark);

                        }

                        // Once all students have been entered, the Student objects are assigned to static Classroom object
                        myClassroom.assignStudents(students);
                        break;

                    case 2: // Loop through all students and display their properties (Names, Marks and Grades)

                        System.out.println();
                        if (myClassroom.getStudents() != null) {
                            System.out.println("You have chosen '2 - Display Students Details'.");
                            System.out.println();
                            // UPDATED
                            System.out.println (("Student Name" + padStr).substring(0, maxStudentNameLength) + "\tMark\tGrade");
                            //
                            System.out.println();
                            for (int i = 0; i < myClassroom.getStudents().length; i++) {
                                // UPDATED
                                System.out.println((myClassroom.getStudents()[i].getName() + padStr).substring(0, maxStudentNameLength) + "\t" + myClassroom.getStudents()[i].getMark() + "\t\t" + myClassroom.getStudents()[i].getGrade());
                                //
                            }
                            System.out.println();
                        } else {
                            System.out.println ("Please input some students first.");
                            System.out.println();
                        }
                        System.out.println();

                        break;

                    case 3: // Display the total (sum), average, highest, lowest, # students above and below average mark

                        if (myClassroom.getStudents() != null) {
                            System.out.println("You have chosen '3 - Display Total, Average, Highest and Lowest Marks, Student above and below average mark'.");
                            System.out.println();
                            System.out.println("Total Mark   : " + myClassroom.getTotalMark());
                            System.out.println("Average Mark : " + myClassroom.getAverageMark());
                            System.out.println("Highest Mark : " + myClassroom.getHighestMark());
                            System.out.println("Lowest Mark  : " + myClassroom.getLowestMark());
                            System.out.println("Above Average: " + myClassroom.getStudentsAboveAverage());
                            System.out.println("Below Average: " + myClassroom.getStudentsBelowAverage());
                            System.out.println();
                        } else {
                            System.out.println ("Please input some students first.");
                            System.out.println();
                        }

                        break;

                    case 4: // Display the student with the highest mark
                        if (myClassroom.getStudents() != null) {
                            System.out.println("You have chosen '4 - Display First in Class'.");
                            System.out.println();
                            System.out.println("First in class: " + myClassroom.getFirstInClass());
                            System.out.println();
                        } else {
                            System.out.println ("Please input some students first.");
                            System.out.println();
                        }

                        break;

                    case 5: // Display the search results, according to the value input by the user
                        if (myClassroom.getStudents() != null) {
                            System.out.println("You have chosen '5 - Search for a particular student.'.");
                            System.out.println();
                            System.out.println("Enter student name: ");
                            String queryStudent = Keyboard.readString();
                            System.out.println();
                            Student result = myClassroom.searchStudent(queryStudent);

                            System.out.println("Student Name: " + result.getName());
                            System.out.println("Mark        :" + result.getMark());
                            System.out.println("Grade       : " + result.getGrade());
                            System.out.println();
                            //
                        }  else {
                            System.out.println ("Please input some students first.");
                            System.out.println();
                        }

                        break;

                    case 6: // Display the histogram based on student marks
                        if (myClassroom.getStudents() != null) {
                            System.out.println("You have chosen '6 - Display a Histogram of student marks'.");
                            myClassroom.printHistogram(false);
                        } else {
                            System.out.println ("Please input some students first.");
                            System.out.println();
                        }

                        break;

                    case 7: // Display the histogram
                        if (myClassroom.getStudents() != null) {
                            System.out.println("You have chosen '7 - Display a Histogram of student grades'.");
                            myClassroom.printHistogram(true);
                        } else {
                            System.out.println ("Please input some students first.");
                            System.out.println();
                        }
                        break;

                    case 99: // Secret (special) feature - generate dummy data for testing
                        System.out.println("You have unlocked a secret feature '99 - Generate dummy data'.");
                        System.out.println();
                        System.out.print("Generating data for " + students.length + " students ... ");
                        for (int s = 0; s < students.length; s++) {
                            students[s] = new Student(("Student " + s), (int) ((Math.random() * (100 - 1)) + 1));
                        }
                        myClassroom.assignStudents(students);
                        System.out.println("Dummy data has been generated.");

                        break;

                }
            } while (choice != 0);
        }
        else {
            System.out.println("Access denied");
        }

    }

}