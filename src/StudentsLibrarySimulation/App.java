package StudentsLibrarySimulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static StudentsLibrarySimulation.Constants.NUMBER_OF_BOOKS;
import static StudentsLibrarySimulation.Constants.NUMBER_OF_STUDENTS;

public class App {
    public static void main(String[] args) {
        Student[] students = null;
        Book[] books = null;

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_STUDENTS);

        try {
            books = new Book[NUMBER_OF_BOOKS];
            students = new Student[NUMBER_OF_STUDENTS];

            for (int i = 0; i < NUMBER_OF_BOOKS; i++) {
                books[i] = new Book(i+1);
            }

            for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
                students[i] = new Student(i+1, books);
                executorService.execute(students[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
