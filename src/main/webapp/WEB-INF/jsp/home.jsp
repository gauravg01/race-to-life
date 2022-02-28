<!DOCTYPE html>
<html lang="en">
<head>
<title>Race to Life | R2L</title>
</head>
<!-- body -->

<body class="main-layout">
	<!-- header -->
		<div>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	</div>
	<!-- our -->

	<!-- end our -->
	<!-- We are -->
	<div id="software" class="We_are">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>Abstract</h2>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
					<div class="box_bg">
						<div class="box_bg_img">
							<figure>
								<img src="images/soft.jpg">
							</figure>
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 border_right">
					<div class="box_text">
						<p><b>Race to Life</b> is the metaverse game application. The objective of the <b>Race to Life</b> game is to make general population aware about various fatal diseases and its duration, precautions to be adapted in order to safeguard themselves. This game will not only create a challenging environment, but it will also provide fun and healthy environment to users.
						Players will race from point A to point B. There will be in between checkpoints, hurdles, exposed zones, and healing places. Players can contact diseases at exposed zones and can get cured at healing places accordingly. To get cured, a certain time will be added to players timeline. With each increasing levels, the number of nonplaying characters (NPCs) will increase up to a certain limit and will contain deadly diseases accordingly. Players will be starting as a healthy person and are supposed to reach at point B as is. The Player to reach to point B in less time wins the game.
						During the outbreak of new diseases, myths and rumors are spread across the world and people lack knowledge on various infectious diseases and how to get cure of such diseases if they get infected by it. For bursting these myths and rumors of people, the <b>Race to Life</b> metaverse game application will be helpful.</p>
						<!-- <a href="#">Read more</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end We are -->

	<!-- about  -->
	<div id="about" class="about">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>About Our Game</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="about-box">
						<figure>
							<img src="images/about.jpg" alt="#" />
						</figure>

						<p>
							An open-world multiplayer survival metaverse game
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- end abouts -->

	<!-- testimonial -->
	<div id="testimonial" class="testimonial">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="titlepage">
						<h2>Testimonial</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 offset-md-2">
					<div class="row box">
						<div class="col-xl-3 col-lg-3 col-md-3 col-sm-12">
							<div class="testimonial_box">
								<figure>
									<img src="images/test1.png" alt="#" />
								</figure>
							</div>
						</div>
						<div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
							<div class="testimonial_box">
								<figure>
									<img src="images/test2.png" alt="#" />
								</figure>
							</div>
						</div>
						<div class="col-xl-3 col-lg-3 col-md-3 col-sm-12">
							<div class="testimonial_box">
								<figure>
									<img src="images/test3.png" alt="#" />
								</figure>
							</div>
						</div>
					</div>
					<div class="clients_box">
						<h3>U of W</h3>
						<p>
							An open-world multiplayer survival metaverse game
						</p>

					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- end testimonial -->

	<!-- contact -->
	<div id="contact" class="contact">
		<div class="container">

			<div class="row">

				<div class="col-md-12">

					<form class="contact_bg" method="post" action="/contactFormWeb">
						<div class="row">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
								<input class="contactus" placeholder="Name" type="text"
									name="name">
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
								<input class="contactus" placeholder="Phone" type="number"
									name="phone" maxlength=10>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
								<input class="contactus" placeholder="Email" type="email"
									name="email" required>
							</div>
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
								<textarea class="textarea" placeholder="Message" name="message" required></textarea>
							</div>
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
								<button class="send">Send</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

	<!-- end contact -->

	<!--  footer -->
	<div>
		<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
	</div>
	<!-- end footer -->
	<!-- Javascript files-->
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
	<script>
		window.onload = function() {
			var msg = "${message}";
			if (msg != "") {
				alert(msg);
				window.location.pathname = '/home';
			}
		}
	</script>
</body>

</html>