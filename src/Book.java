public class Book {
    private String title;
    private String author;
    private int numberOfPages;

    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
class MainBook{
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Harry Poter", "J.K. Rowling", 700);
        System.out.println("info about b1: " + b1.getAuthor() + " " + b1.getTitle() + " " + b1.getNumberOfPages());
        System.out.println("info about b2: " + b2.getAuthor() + " " + b2.getTitle() + " " + b2.getNumberOfPages());

    }
}

