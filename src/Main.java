/*
 * Main class. The program starts running from here (using the main method)
 */
public class Main {

    static Classroom myClassroom = new Classroom();

    public static void main(String[]args) {

        int choice;
        final int password=23456; // Default password to provide access to the program
        int nos = 31;
        System.out.println("Enter password");
        int password2= Keyboard.readInt();

        /*
         * This block checks whether to allow access and displays the menu.
         * It also controls the logic to run according to the menu option selected by the user.
         */
        if (password2 == password) {
            System.out.println("access granted");
            System.out.println("How many students do you have in your class? (Maximum 30)");
            while (nos <= 0 || nos > 30) {
                nos = Keyboard.readInt();
            }

            /*
             * Array of Student objects to store the students inputted.
             */
            Student[] students = new Student[nos];

            do {
                /*
                 * Display the menu
                 */
                System.out.println("MENU");
                System.out.println();
                System.out.println("1......Enter Students List of Names and Marks");

                System.out.println("2......Display Students Details");
                System.out.println("3......Display Total and Average Mark, Highest and Lowest Mark");
                System.out.println("4......Display First in Class");
                System.out.println("5......Search for a particular student.");
                System.out.println("6......Exit");
                System.out.println("Enter your choice: ");
                System.out.println();
                choice = Keyboard.readInt();

                switch (choice) {
                    case 1: // Option 1: input the student names and marks.
                        System.out.println("You have chosen '1......Enter Students List of Names and Marks'.");
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
                        System.out.println("You have chosen '2......Display Students Details'.");
                        System.out.println();
                        for (int i = 0; i < myClassroom.getStudents().length; i++) {
                            System.out.println(myClassroom.getStudents()[i].getName() + "\t" +
                                    myClassroom.getStudents()[i].getMark() + "\t" + myClassroom.getStudents()[i].getGrade());

                        }
                        System.out.println();

                        break;

                    case 3: // Display the total mark (sum of all marks), average mark, highest mark and lowest mark

                        System.out.println("You have chosen '3......Display Total and Average Mark, Highest and Lowest Mark'.");

                        System.out.println();
                        System.out.println(myClassroom.getTotalMark() + "\t" + myClassroom.getAverageMark()

                                + "\t" + myClassroom.getHighestMark() + "\t" + myClassroom.getLowestMark());

                        break;

                    case 4: // Display the student with the highest mark
                        System.out.println("You have chosen '4.......Display First in class'.");
                        System.out.println();
                        System.out.println("firstInClass : " + myClassroom.getFirstInClass());

                        break;

                    case 5: // Display the search results, according to the value input by the user
                        System.out.println("You have chosen '5.......Search for a particular student'.");
                        System.out.println();
                        System.out.print("Enter Student Name: ");
                        String queryStudent = Keyboard.readString();
                        System.out.println();
                        Student result = myClassroom.searchStudent(queryStudent);
                        System.out.println("Student: " + result.getName() + " Mark: " + result.getMark() + " Grade: " + result.getGrade()) ;

                        break;

                }
            } while (choice != 6);
        }
        else {
            System.out.println("Access denied");
        }

    }

}