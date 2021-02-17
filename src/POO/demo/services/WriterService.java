package POO.demo.services;

import java.io.*;

public class WriterService {

    // region SINGLETON

    private static WriterService instance;
    public static WriterService getInstance(){
        return instance == null ? instance = new WriterService() : instance;
    }
    private WriterService() {
    }

    // endregion

    private static String file = ".\\data\\test.file";

    public void printSomething(){
        try( BufferedWriter writer = new BufferedWriter(new FileWriter(file)) ){

            writer.write("");
//            writer.write("comment ca va?");
//            writer.newLine();
//            writer.flush();
//            writer.append("comment ").append("ca ").append("va?");

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
