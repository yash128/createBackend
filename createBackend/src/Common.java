import java.util.Random;
import java.util.Scanner;

public class Common {
    static String dataBaseName = "park";
    static String projectName = "new";
    static String fileAtPath = "D:\\xampp2\\htdocs\\" + projectName + "\\";
    static String conDBfileName = "connect.php";
    static String tableName = "createTable.php";
    static String getFromUser(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        return str;
    }

    static String createStringForQuery(String heading, String query){
        Random rand = new Random(1000);
        StringBuilder str = new StringBuilder();
        str.append("$"+heading+"=\"").append(query).append("\";\n");
        str.append("$res_"+heading+" = mysqli_query($con, $"+heading+");\n");
        str.append("if(!$res_"+heading+"){\n" +
                "\techo mysqli_error($con);\n" +
                "}else{\n" +
                "\techo \"success\";\n" +
                "}");
        return str.toString();
    }
}
