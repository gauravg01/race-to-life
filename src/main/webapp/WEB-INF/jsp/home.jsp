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
						<h2>Software</h2>
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
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation
							ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
							aute irure dolor in reprehenderit in voluptate velit esse cillum
							dolore eu fugiat nulla pariatur. Excepteur sint occaecat
							cupidatat non proident, sunt in culpa qui officia deserunt mollit
							anim id est laborumLorem ipsum dolor sit amet, consectetur
							adipiscing elit, sed do eiusmod tempor incididunt ut labore et
							dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
							exercitation ullamco laboris nisi ut aliquip ex ea commodo
							consequat</p>
						<a href="#">Read more</a>
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
							consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
							<br> labore et dolore magna aliqua. Ut enim conseq
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
						<h3>Jecoo</h3>
						<p>
							adipiscing elit, sed do eiusmod tempor incididunt ut labore et
							dolore magna <br>aliqua. Ut enim ad minim veniam, quis <br>nostrud
							exercitation ullamco
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