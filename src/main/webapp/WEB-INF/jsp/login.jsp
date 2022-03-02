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
<title>Race to Life | Login</title>
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
								<li class="button_login"><a href="/loginWeb">Login</a></li>
								<li><a href="/registerWeb">Signup</a></li>
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
		<h1>Welcome to Race to Life</h1>
	</div>
	<div align=center>
	<fieldset
		style="border: 5px groove; padding-top: 0.35em; padding: 0.75em; width:50%;">
		<form method="post" action="/loginWeb" name="login">
			<table>
				<tr>
					<th colspan=2>
						<h1 align=center>Login</h1>
					</th>
				</tr>

				<tr>
					<th><label>Email:</label></th>
					<th>
						<p>
							<input type="email" placeholder="Enter your email"
								name="username" required="required" />
						</p>
					</th>
				</tr>
				<tr>
					<th><label>Password:</label></th>
					<th>
						<p>
							<input type="password" placeholder="Password" name="password"
								required="required" />
						</p>
					</th>
				</tr>
				<tr>
					<th colspan=2>
						<h3>
							<c:if test="${not empty error}">
								<div class="error">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="msg">${msg}</div>
							</c:if>
						</h3>
					</th>
				</tr>
				<tr>
					<th colspan=2>
						<p class="remember_me">
							<label> <input type="checkbox" name="remember_me"
								id="remember_me"> Remember me on this computer
							</label>
						</p>
					</th>
				</tr>
				<tr>
					<th><input type="reset" name="reset" value="Clear"></th>
					<th><input type="submit" name="commit" value="Login"></th>
				</tr>
			</table>
			<br>
			<div align=center>
				<p>
					Forgot your password? <a href="/reset-password-web">Click here to
						reset it</a>.
				</p>
				<br>
				<p>
					Don't have an account? <a href="/registerWeb">Click here to
						Register</a>.
				</p>
			</div>
		</form>
	</fieldset>
	</div>
	<footer>
		<div class="copyright"
			style="position: fluid; left: 0; bottom: 0; width: 100%; background-color: white; color: black; text-align: center;">
			<div class="container">
				<p>� 2022 All Rights Reserved | Race to Life</p>
			</div>
		</div>
	</footer>
</body>
</html>