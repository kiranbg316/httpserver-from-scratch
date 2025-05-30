import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
       try(BufferedReader reader = new BufferedReader(new FileReader("day1/input.txt"))) {
           String line;
           while ((line= reader.readLine()) != null){
               System.out.println(line);

           }
           System.out.println("file read succesfully");


       }catch (IOException e){
           System.out.println("error reading the file : ");
           e.printStackTrace();
       }

    }
}
