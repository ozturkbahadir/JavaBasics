package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter students name and year
    public Student(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter students first name: ");
        this.firstName = sc.nextLine();
        System.out.println("Enter students last name: ");
        this.lastName = sc.nextLine();
        System.out.println("1-Freshman\n2-Sophmore\n3-Junior\n4-Senior\nEnter grade level: ");
        this.gradeYear = sc.nextLine();

        setStudentID();
    }

    // Generate an ID
    private void setStudentID(){
        //Grade Level ID
        id++;
        this.studentID = gradeYear + id;
    }

    // Enroll in courses
    public void enroll(){
        //Get inside a loop, user hits 0
        do {
            System.out.print("Enter course to enroll(Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n   " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {break;}
        } while (true);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {

        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        if (tuitionBalance < 0) {
            System.out.println("$" + Math.abs(tuitionBalance) + " has been refunded." );
             payment = payment - Math.abs(tuitionBalance) ;
            System.out.println("Thank you for your payment of: $" + payment);
            tuitionBalance = 0 ;
        } else {
            System.out.println("Thank you for your payment of: $" + payment);
        }

        viewBalance();

    }

    // Show status
    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }

}
