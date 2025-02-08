import java.util.HashMap;
import java.util.Scanner;


class connectToDatabase{
    String main = "<?php\n" +
            "$con = mysqli_connect(\"localhost\",\"root\", \"\");\n" +
            "$query = mysqli_select_db($con, '"+ Common.dataBaseName +"');\n" +
            "if(!$query){\n" +
            "\tmysqli_query($con,\"CREATE DATABASE "+ Common.dataBaseName +"\");\n" +
            "\tmysqli_select_db($con, '"+ Common.dataBaseName +"');\n" +
            "}\n" +
            "?>\n";


    void createFile(){
        Main.fileWriter(Common.conDBfileName,main);
    }

}

//primaryId?,firstName not null auto_increment 20, lastName 40, fullName , email, password,
public class createTable {
    HashMap<String,Integer> values;
    Boolean isPrimaryId;
    String tableName;

    public createTable(HashMap<String, Integer> values, Boolean isPrimaryId, String tableName) {
        this.values = values;
        this.isPrimaryId = isPrimaryId;
        this.tableName = tableName;
    }

    private String main() {

        String start = "<?php\n";
        String end = "?>\n";
        StringBuilder query = new StringBuilder();
        query.append("create table " + tableName + "(");
        for (String key : values.keySet()) {
            String init = key.substring(0, key.indexOf(' '));
            query.append(init+" varchar(").append(values.get(key)+") " +key.substring(key.indexOf(' ')+1)+",");
        }
        if(isPrimaryId){
            query.append("ID int NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID)");
        }
        query.append(")");
        //uncomment
        /*System.out.println("goint to write query: " + query + " yes(y) or no(n)");
        if(!Common.getFromUser().toUpperCase().equals("Y")){
            query = new StringBuilder(Common.getFromUser());
        }*/
        String middle = "include('connect.php');\n" + Common.createStringForQuery("tableCreate",query.toString()) + "mysqli_close($con);\n";
        return start + middle + end;
    }
 /*   CREATE TABLE Persons (
            ID int NOT NULL AUTO_INCREMENT,
            LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);*/

    void connect(){
        Main.fileWriter(Common.tableName,main());
    }
}
