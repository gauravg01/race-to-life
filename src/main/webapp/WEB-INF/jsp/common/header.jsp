<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<meta name="keywords" content="open-world, multiplayer, survival, metaverse, game, vr, ar, racetolife, r2l, R2L">
<meta name="description" content="An open-world multiplayer survival metaverse game.">
<meta name="author" content="Gaurav, Sumanth, Pratyusha, Rachana, Anjali, Sai, Rakesh">
<!-- bootstrap css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
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
</head>
<body class="main-layout">
	<!-- loader  -->
	<!--<div class="loader_bg">
		<div class="loader">
			<img src="images/loading.gif" alt="#" />
		</div>
	</div> -->
	<!-- end loader -->
	<header>
		<!-- header inner -->
		<div class="header-top">
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
								<c:if test="${not empty login}">
									<li class="button_login"><a href="/loginWeb">Login</a></li>
								</c:if>

								<c:if test="${not empty register}">
									<li><a href="/registerWeb">Signup</a></li>
								</c:if>

								<c:if test="${not empty logout}">
									<li class="button_login"><a href="/logoutWeb">Logout</a></li>
								</c:if>
								
								<c:if test="${not empty profile}">
									<li><a href="/myProfile">My Profile</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- end header inner -->

			<!-- end header -->
			<section class="slider_section">
				<div class="banner_main">

					<div class="container-fluid">
						<div class="row">
							<div class="col-md-2 padding_left0">
								<div class="menu-area">
									<div class="limit-box">
										<nav class="main-menu">
											<ul class="menu-area-main">
												<li class="active"><a href="#game">Game</a></li>
												<li><a href="#software">Abstract</a></li>
												<li><a href="#about">About</a></li>
												<li><a href="#testimonial">Testimonial</a></li>
												<li><a href="#contact">Contact</a></li>

											</ul>
										</nav>
									</div>
								</div>
							</div>
							<div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 ">
								<div class="text-bg">
									<h1>
										Race<br> to Life
									</h1>
									<span>An open-world multiplayer survival<br> metaverse game.
									</span> <a href="#">Download</a>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 ">
								<div class="text-img">
									<figure>
										<img src="images/img.png" alt="#" />
									</figure>
								</div>
							</div>


						</div>
					</div>
				</div>

			</section>
		</div>
	</header>
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.0.0.min.js"></script>
	<script src="js/plugin.js"></script>
	<!-- sidebar -->
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/custom.js"></script>
	<script
		src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>

</body>

</html>