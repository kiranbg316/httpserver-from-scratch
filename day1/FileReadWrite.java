import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
       try(
               BufferedReader reader = new BufferedReader(new FileReader("day1/input.txt")) ;
           BufferedWriter writer = new BufferedWriter(new FileWriter("day1/output.txt"));
       ){
           String line;
           while ((line= reader.readLine()) != null){
           //    System.out.println(line);
               writer.write(line);
               writer.newLine();

           }
           System.out.println("file read and written succesfully");


       }catch (IOException e){
           System.err.println("error during file operation:");
           e.printStackTrace();
       }

    }
}
