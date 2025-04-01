import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException {
        String[] listOfName = {"Den","Ibra","Idris"};
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("IO_test.txt")); // FileReader открывает файл для чтения
            for(String i: listOfName){                                                         // BufferedReader фильтр для ускорения процесса чтения
                writer.write(i+"\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new FileReader("IO_test.txt"));
        System.out.println(reader.readLine());
        reader.close();
    }
}
