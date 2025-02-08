<?php
include ('connect.php');
if(isset($_POST['submit'])){
    $user = mysqli_real_escape_string($con, $_POST['user']);
    $mail = mysqli_real_escape_string($con, $_POST['mail']);
    $password = mysqli_real_escape_string($con, $_POST['password']);
    $identity = $_POST['identity'];
    $reg = "INSERT into step(name, email, pass, identity, mclass, lverify, cverify) values ('$name', '$mail', '$pass', '$identity', '$main','$lver','1')";
    $acheck = mysqli_query($con, $reg);
    $look = mysqli_fetch_row(mysqli_query($con, "SELECT * from step where email='$mail' && pass = '$pass'"));
    if($acheck){
        header("Location:home.php");
    }
    else{
        echo "An error occurred";
    }
}else{header('Location:index.php');}

?>