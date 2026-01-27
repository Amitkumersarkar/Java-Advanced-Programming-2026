class Book {
    String title;
    String author;
    int yearPublished;

    Book(String t, String a, int y) {
        title = t;
        author = a;
        yearPublished = y;
    }

    void displayInfo() {
        System.out.println(title + " | " + author + " | " + yearPublished);
    }
}

public class Books {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James", 2018);
        Book b2 = new Book("DSA Guide", "Rahul", 2022);

        b1.displayInfo();
        b2.displayInfo();
    }
}
