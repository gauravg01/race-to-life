<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Race to Life | My Profile</title>
<meta name="keywords"
	content="open-world, multiplayer, survival, metaverse, game, vr, ar, racetolife, r2l, R2L">
<meta name="description"
	content="An open-world multiplayer survival metaverse game.">
<meta name="author"
	content="Gaurav, Sumanth, Pratyusha, Rachana, Anjali, Sai, Rakesh">
<!-- bootstrap css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
<style>
th, td {
	padding: 15px;
	text-align: center
}

.error {
	color: red;
	font-weight: bold;
}

.msg {
	color: green;
	font-weight: bold;
}
</style>
</head>
<body>
	<!-- loader  -->
	<!-- <div class="loader_bg">
		<div class="loader">
			<img src="images/loading.gif" alt="#" />
		</div>
	</div>-->

	<header>
		<!-- header inner -->
		<div class="header-top-login">
			<div class="header">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
							<div class="full">
								<div class="center-desk">
									<div class="logo">
										<a href="/"><img src="images/logo.png" alt="#" /></a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">

							<ul class="top_icon">
								<li><a href="/home">Home</a></li>
								<li><a href="/myProfile">My Profile</a></li>
								<li class="button_login"><a href="/logoutWeb">Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- end header inner -->
		</div>
	</header>
	<br>
	<div align=center>
		<h1>Welcome to Race to Life | My Profile</h1>
	</div>

	<div class="container" style="background-color: #f2f2f2">
		<div id="changePassword" style="display: none">
			<form method="post" action="/changePassword">
				<div style="overflow-x: auto;">
					<table class="table table-striped" style="font-size: 14px">
						<tr>
							<td><label>Enter old password:</label></td>
							<td><div class="group">
									<input type="password" name="passwordOld" />
								</div></td>
						</tr>
						<tr>
							<td><label>Enter new password:</label></td>
							<td><div class="group">
									<input type="password" name="passwordNew" />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">
									<input type="button" onclick="back()" value="Back" />
								</div></td>
							<td><div align="center">
									<input type="submit" value="Change Password">
								</div></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<div id="changeEmail" style="display: none">
			<form method="post" action="/changeEmail">
				<div style="overflow-x: auto;">
					<table class="table table-striped" style="font-size: 14px">
						<tr>
							<td><label>Enter new email:</label></td>
							<td><div class="group">
									<input type="email" name="newEmail" />
								</div></td>
						</tr>
						<tr>
							<td><label>Enter password:</label></td>
							<td><div class="group">
									<input type="password" name="password" />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">
									<input type="button" onclick="back()" value="Back" />
								</div></td>
							<td><div align="center">
									<input type="submit" value="Change Email">
								</div></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<form>
			<div style="overflow-x: auto;">
				<table class="table table-striped" style="font-size: 14px">
					<tr>
						<th>Email</th>
						<td><label>${user.email}</label></td>
						<td></td>
					</tr>
					<tr>
						<th><div align="center">
								<input type="button" value="Change Email"
									onclick="changeEmail()" />&nbsp;&nbsp;&nbsp; <input
									type="button" value="Change Password" onclick="changePass()" />
							</div></th>
						<td><div align="center">
								<input type="button" value="Edit Profile" onclick="update()" disabled>
								<div id="updateButton" style="display: none">
									<br> <input type="button" onclick="back()" value="Back" />
									&nbsp;&nbsp;&nbsp; <input type="submit" class="hover-green"
										value="Save" />
								</div>
							</div></td>
						<td></td>
					</tr>
				</table>
			</div>
		</form>
	</div>

	<footer>
		<div class="copyright"
			style="position: fluid; left: 0; bottom: 0; width: 100%; background-color: white; color: black; text-align: center;">
			<div class="container">
				<p>© 2022 All Rights Reserved | Race to Life</p>
			</div>
		</div>
	</footer>
	<script>
		window.onload = function() {
			var err = "${errorMessage}";
			var succ = "${successMessage}";
			var errCP = "${errorMessageCP}";
			var succCP = "${successMessageCP}";
			var errCE = "${errorMessageCE}";
			var succCE = "${successMessageCE}";
			if (err != "") {
				alert(err);
			}
			if (succ != "") {
				alert(succ);
				window.location.pathname = '/myProfile';
			}
			if (errCP != "") {
				alert(errCP);
				window.location.pathname = '/myProfile';
			}
			if (succCP != "") {
				alert(succCP);
				window.location.pathname = '/myProfile';
			}
			if (errCE != "") {
				alert(errCE);
				window.location.pathname = '/myProfile';
			}
			if (succCE != "") {
				alert(succCE);
				window.location.pathname = '/logoutWeb';
			}
		}
		function update() {
			document.getElementById("updateButton").style.display = "block";
			document.getElementById("changeEmail").style.display = "none";
			document.getElementById("changePassword").style.display = "none";
		}
		function back() {
			window.location.pathname = '/myProfile';
		}
		function changePass() {
			document.getElementById("changePassword").style.display = "block";
			document.getElementById("updateButton").style.display = "none";
			document.getElementById("changeEmail").style.display = "none";
		}
		function changeEmail() {
			document.getElementById("changeEmail").style.display = "block";
			document.getElementById("updateButton").style.display = "none";
			document.getElementById("changePassword").style.display = "none";
		}
	</script>
</body>
</html>