<!DOCTYPE html>
<html lang="en">
<body>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<footer>
		<div class="footer ">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2>Newsletter</h2>
					</div>
					<div class="col-md-10 offset-md-1">
						<form class="news" action="/subscribeWeb" method="post">
							<input class="newslatter" placeholder="Enter Your Email"
								type="text" name="email">
							<button class="submit">Subscribe</button>
						</form>
					</div>
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
						<div class="row">
							<div class="col-xl-3 col-lg-3 col-md-6 col-sm-6 ">
								<div class="address">
									<ul class="social_link">
										<li><a href="#"><img src="icon/fb.png"></a></li>
										<li><a href="#"><img src="icon/tw.png"></a></li>
										<li><a href="#"><img src="icon/lin(2).png"></a></li>
										<li><a href="#"><img src="icon/instagram.png"></a></li>
									</ul>
									<a href="index.html"> <img src="images/logo.png" alt="logo"></a>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-6">
								<div class="address">
									<h3>Quick links</h3>
									<ul class="Menu_footer">
										<li class="active"><img src="images/3.png" alt="#">
											<a href="#game">Game</a></li>
										<li><img src="images/3.png" alt="#"> <a
											href="#software">Software</a></li>
										<li><img src="images/3.png" alt="#"> <a
											href="#about">About</a></li>
										<li><img src="images/3.png" alt="#"> <a
											href="#testimonial"> Testimonial</a></li>
										<li><img src="images/3.png" alt="#"> <a
											href="#contact">Contact</a></li>
									</ul>
								</div>
							</div>
							<div class="col-lg-3 col-md-6 col-sm-6">
								<div class="address">
									<h3>Authors</h3>
									<ul class="Links_footer">
										<li class="active"><img src="images/3.png" alt="#">Gaurav</li>
										<li><img src="images/3.png" alt="#">Sumanth</li>
										<li><img src="images/3.png" alt="#"> Pratyusha</li>
										<li><img src="images/3.png" alt="#"> Rachana</li>
										<li><img src="images/3.png" alt="#"> Anjali</li>
										<li><img src="images/3.png" alt="#"> Sai</li>
										<li><img src="images/3.png" alt="#"> Rakesh</li>
									</ul>
								</div>
							</div>

							<div class="col-lg-3 col-md-6 col-sm-6 ">
								<div class="address">
									<h3>Contact us</h3>
									<ul class="loca">
										<li><a href="#"><img src="icon/loc.png" alt="#" /></a>University
											of Windsor <br>ON, CA</li>
										<li><a href="#"><img src="icon/email.png" alt="#" /></a>dummy@gmail.com
										</li>
										<li><a href="#"><img src="icon/call.png" alt="#" /></a>+11111111111
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
			<div class="copyright">
				<div class="container">
					<p>© 2022 All Rights Reserved | Race to Life</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>