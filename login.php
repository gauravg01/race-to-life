<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "race_to_life";

//variables submitted by user
$loginUser = $_POST["loginUser"];
$loginPass = md5($_POST["loginPass"]);

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT password FROM user_reg WHERE user_name = '$loginUser'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    if($row["password"] == $loginPass){
    // Starting session
    session_start();
    // Storing session data
    $_SESSION["user_name"] = $loginUser;
    echo $_SESSION["user_name"];
    // Get user's data

    //Get player info

    //Get Inventory

    //Modify player data

    //Update Inventory

    }else{
    echo "Wrong Credentials.";
    }
  }
} else {
  echo "Username does not exists";
}
$conn->close();
?>