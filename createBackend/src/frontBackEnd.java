import java.util.HashMap;

public class frontBackEnd {
    //firstName,lastName,email,pass
    HashMap<String,Integer> fields;
    public frontBackEnd(HashMap<String,Integer> fields) {
        for (String key : fields.keySet()) {
            this.fields.put(key.substring(0,key.indexOf(' ')), fields.get(key));
        }
    }

    public void printFront() {
        StringBuilder builder = new StringBuilder();
        builder.append("<form enctype=\"multipart/form-data\" action=\"\" method=\"post\">");
        for (String field : fields.keySet()) {
            if (field.lastIndexOf("pass") != -1) {
                builder.append("<input type='password' maxlength='' name='"+field+"' />");
                continue;
            }
            if (field.lastIndexOf("mail") != -1) {
                builder.append("<input type='email' maxlength='' name='"+field+"' />");
                continue;
            }
            builder.append("<input type='text' maxlength='' name='"+field+"' />");
        }
        builder.append("<input type=\"submit\" value=\"Submit\" />");
        builder.append("</form>");
    }
    public void printBackRegister() {
        StringBuilder builder = new StringBuilder();
        builder.append("<?php\n" +
                "include ('connect.php');\n" +
                "if(isset($_POST['submit'])){\n");
        for (String field : fields.keySet()){
            builder.append("$"+field+" = mysqli_real_escape_string($con, $_POST['"+field+"']);");
        }
        builder.append("\t$query = \"INSERT into "+Common.tableName+"(");
        for (String field : fields.keySet()){
            builder.append(field + ",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(") values (");
        for (String field : fields.keySet()){
            builder.append("'$"+field + "',");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")\";\n");

        builder.append("\t$result = mysqli_query($con, $query);\n" +
                "\tif(!mysqli_error($con)){\n" +
                "\t\techo 'success';\n" +
                "\t}\n" +
                "\telse{\n" +
                "\t\techo \"An error occurred\";\n" +
                "\t}\n" +
                "}");
        System.out.println(builder);
    }
    public void printBackLogin(){

    }
}
