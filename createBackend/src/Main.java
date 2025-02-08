import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void fileWriter(String fileName, String text){
        try (FileWriter w = new FileWriter(new File(Common.fileAtPath + fileName))){
            BufferedWriter writer = new BufferedWriter(w);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("first create your database, create folder;");
        /*System.out.println("enter folder name");
        Common.projectName = Common.getFromUser();*/

        //uncomment these, these are to be run once and then these are to be requested

        /*new connectToDatabase().createFile();
        HashMap<String,Integer> valsCreateTable = new HashMap<String,Integer>();
        valsCreateTable.put("name NOT NULL",20);
        valsCreateTable.put("age NOT NULL",20);
        valsCreateTable.put("gender NOT NULL",20);
        valsCreateTable.put("birthday NOT NULL",20);
        new createTable(valsCreateTable,true,"users").connect();*/



    }
}