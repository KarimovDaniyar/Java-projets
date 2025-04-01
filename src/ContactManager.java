import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactBook book = new ContactBook();
        book.getAllContact();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println(
            "1. Добавить контакт \n" +
            "2. Удалить контакт \n" +
            "3. Найти контакт \n" +
            "4. Показать все контакты \n" +
            "5. Выход \n" +
            "Выберите действие: ");
        int answer = scanner.nextInt();
        scanner.nextLine();

        switch (answer){
            case 1:
                System.out.println("Введите имя: ");
                String name = scanner.nextLine();

                System.out.println("Введите телефон: ");
                long number = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Введите email: ");
                String email = scanner.nextLine();

                book.addContact(new Contact(name, number, email));
                book.saveContact();
                break;
            case 2:
                System.out.println("Введите имя: ");
                String name1 = scanner.nextLine();
                book.removeContact(name1);
                break;
            case 3:
                System.out.println("Введите имя: ");
                String name2 = scanner.nextLine();
                book.getContact(name2);
                break;
            case 4:
                book.getAllContact();
                break;
            case 5:
                book.saveContact();
                exit = true;
                break;
            default:
                System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }
}

class Contact{
    String name;
    long phoneNumber;
    String email;

    public Contact(String name, long phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ',' + phoneNumber + ',' + email;
    }

    public static Contact fromString(String data){
        String[] parts = data.split(",");
        return new Contact(parts[0], Long.parseLong(parts[1]),parts[2]);
    }
}

class ContactBook{
    HashMap<String,Contact> listOfContact = new HashMap<>();

    void addContact(Contact t){
        if(!listOfContact.containsKey(t.name)){
            listOfContact.put(t.name,t);
            System.out.println(t.name + " was added successfully");
        }else {
            System.out.println(t.name + " already exists");
        }
    }

    void removeContact(String name) {
        if (listOfContact.remove(name) != null) {
            System.out.println(name + " удален.");
        } else {
            System.out.println("Контакт не найден.");
        }
    }


    void getContact(String name) {
        Contact contact = listOfContact.get(name);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    void saveContact(){
        try{
            BufferedWriter writer = new BufferedWriter( new FileWriter("Contacts.txt"));
            for(Contact c : listOfContact.values()){
                writer.write(c.toString() + "\n");
            }
            writer.close();
            System.out.println("The contacts have been saved");
        }catch (IOException e){
            System.out.println();
            e.printStackTrace();
        }
    }

    void getAllContact(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Contacts.txt"));
            String c;
            while((c = reader.readLine()) != null){
                Contact contact = Contact.fromString(c);
                listOfContact.put(contact.name, contact);
            }
            reader.close();
            listOfContact.values().forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}