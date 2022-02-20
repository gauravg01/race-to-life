<?php
date_default_timezone_set('America/Toronto');
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "race_to_life";

//variables submitted by user
$loginUser = $_POST["loginUser"];
$loginPass = md5($_POST["loginPass"]);
$created_at = date("Y-m-d h:i:s");

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT user_name FROM user_reg WHERE user_name = '$loginUser'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
//Tell user that username is already taken
  echo "Username is already taken";
  }
 else {
 // Insert new user into the database
  echo "User created...";
  $sql2 = "INSERT INTO user_reg (user_name,password,created_at) VALUES ('$loginUser','$loginPass','$created_at')";
  if($conn->query($sql2) == TRUE){
  echo "New record created successfully";
  }else{
		echo "Error" . $sql2 . "<br>" . $conn->error;
  }
$conn->close();
}
?>