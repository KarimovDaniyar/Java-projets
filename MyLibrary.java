import java.util.Scanner;

public class MyLibrary {
    public static void main(String[] args){
    Library center = new Library();
    center.addBook("Мартин Иден","Джек Лондон");
    center.addBook("Жамиля", "Чынгыз Айтматов");
    boolean cont = true;
    while(cont){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLibrary Menu:\n" +
                "1. View Available Books\n" +
                "2. Borrow a Book\n" +
                "3. Return a Book\n" +
                "4. Exit\n" +
                "Choose an option ");
        int answer = scanner.nextInt();
        switch (answer){
            case 1:
                center.getAvailableBooks();
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Название книги: ");
                String book = scanner.nextLine();
                center.borrowBook(book);
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Какую книгу хотите вернуть: ");
                String b = scanner.nextLine();
                center.returnBook(b);
                break;
            case 4:
                System.out.println("До встречи");
                cont = false;
                break;
            default:
                System.out.println("Введите корректные значения");
            }
        }
    }
}
class Book{
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Library{
    Book[] books = new Book[10];
    int indexFree;

    public void addBook(String title, String author){
        if(indexFree < books.length){
            books[indexFree] = new Book(title,author);
            indexFree++;
        }
        else{
            System.out.println("Мест нет в хранилище");
        }

    }

    public void borrowBook(String title){
        for(Book i : books){
            if(i!=null){
                if(i.getTitle().equals(title) && i.isAvailable()){
                    System.out.println("Вы забрали книгу: "+ title);
                    i.setAvailable(false);
                }
            }
        }
    }

    public void returnBook(String title){
        for(Book i : books){
            if(i!=null && i.getTitle().equals(title)){
                i.setAvailable(true);
                System.out.println(title + " успешно возвращена");
            }
        }
    }

    public String getBook(Book book){
        return book.getTitle()+" by "+book.getAuthor();
    }

    public void getAvailableBooks(){
        for(Book i : books){
            if(i != null && i.isAvailable()){
                System.out.println(getBook(i));
            }
        }
    }

    public void replaceBook(String title, String newTitle, String newAuthor){
        for(Book i : books){
            if (i!=null && i.getTitle().equals(title)){
                i.setTitle(newTitle);
                i.setAuthor(newAuthor);
            }
        }
    }
}