<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>Mobi Portal</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" href="<%=path%>/pages/css/bootstrap.min.css">
<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i" rel="stylesheet">
<!-- Styles -->
<link rel="stylesheet" type="text/css" href="<%=path%>/pages/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/pages/css/slick.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/pages/css/style.css">
</head>
<body>

<header id="header">
	
	<!-- Section title -->
	<h1 class="sr-only">Modus | Home page</h1>
	
	<nav class="navbar navbar-default navbar-fixed-top">
	  <!-- Section title -->
	  <h1 class="sr-only">Main navigation</h1>
		<div class="container-bar">
		<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-navbar" aria-expanded="false">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </button>
		  <a class="navbar-brand smoothScroll" href="#home">
			<img alt="Modus" src="img/logo.png">
		  </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="main-navbar">
		  <ul class="nav navbar-nav navbar-right">
			<li class="active"><a class="smoothScroll" href="#home">首页 <span class="sr-only">(current)</span></a></li>
			<li><a class="smoothScroll" href="#portfolio">精彩专题</a></li>
			<li><a class="smoothScroll" href="#services">我的服务</a></li>
			<li><a class="smoothScroll" href="#clients">关于</a></li>
			<li><a class="smoothScroll" href="#contact">联系我们</a></li>
		  </ul>
		  
		</div><!-- /.navbar-collapse -->
		

	  </div><!-- /.container -->
	  <span class="sign-head">
			<div class="sign" id="login-info"></div>
            <div class="sign-div">
              <a class="sign" href="">Sign in</a>
                <span class="">or</span>
                <a class="sign" href="" >Sign up</a>
            </div>
        </span>
	  </div>
	  <div class="login-icobar"><div><spen class="login-icobar-text">用社交账号直接登录</spen>
		  		<a class="" href="<%=path%>/login"><img alt="qq" src="img/ico/qq.jpg" class="login-ico"></a>
				<a class="" href="<%=path%>/login"><img alt="wech" src="img/ico/wech.jpg" class="login-ico"></a>
				<a class="" href="<%=path%>/login"><img alt="blog" src="img/ico/blog.jpg " class="login-ico"></a></div>
	</nav>

</header>

<main>
	
	<section id="home">

		<!-- Section title -->
		<h1 class="sr-only">Home section</h1>
		
		<div class="overlay"></div>

		<div class="home-content">
			
			<div class="container">
				
				<div class="row">

					<div class="col-md-8 col-md-offset-2">
						
						<span class="h5"><%=path%></span class="h5">

						<h2 class="h1">Creativity have new level</h2>

						<div class="cta-container">

							<a href="#" class="btn btn-default">Preview</a>

							<button href="#" class="btn btn-primary">Get theme</button>

						</div>

					</div>
					
				</div>

			</div>

		</div>

		<a id="down-icon" class="down-icon smoothScroll" href="#history">
			<img class="down-arrow" src="img/svg/down_icon.svg" alt="Down arrow">
		</a>

	</section>

	<section id="history">

		<!-- Section title -->
		<h1 class="sr-only">History section</h1>

		<div class="container">

			<div class="row">
				
				<div class="col-md-8 col-md-offset-2">

					<div class="history-content">
						
						<h2 class="section-title">Little history</h2>

						<p>Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.<br>
						Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. Curabitur aliquet quam id dui posuere blandit. <br>
						Donec rutrum congue leo eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat. <br>
						Vivamus suscipit tortor eget felis porttitor volutpat. Cras ultricies ligula sed magna dictum porta. <br> 
						Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>

					</div>

				</div>

			</div>
			
		</div>	

	</section>

	<section id="portfolio">

		<!-- Section title -->
		<h1 class="sr-only">Portfolio section</h1>

		<div class="slider-container">

			<figure class="project grabbable">
				<img class="img-responsive" src="img/portfolio/01.jpg" alt="Project Image">
				<div class="description">
					<figcaption><h5>Random artwork</h5></figcaption>
					<p>Vivamus suscipit tortor eget felis porttitor
					volutpat. Vestibulum ac diam sit amet
					quam vehicula elementum sed sit amet dui.
					Pellentesque in ipsum id orci. </p>
					<ul class="social-list">
						<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</figure>

			<figure class="project grabbable">
				<img class="img-responsive" src="img/portfolio/02.jpg" alt="Project Image">
				<div class="description">
					<figcaption><h5>Random artwork</h5></figcaption>
					<p>Vivamus suscipit tortor eget felis porttitor
					volutpat. Vestibulum ac diam sit amet
					quam vehicula elementum sed sit amet dui.
					Pellentesque in ipsum id orci. </p>
					<ul class="social-list">
						<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</figure>

			<figure class="project grabbable">
				<img class="img-responsive" src="img/portfolio/03.jpg" alt="Project Image">
				<div class="description">
					<figcaption><h5>Random artwork</h5></figcaption>
					<p>Vivamus suscipit tortor eget felis porttitor
					volutpat. Vestibulum ac diam sit amet
					quam vehicula elementum sed sit amet dui.
					Pellentesque in ipsum id orci. </p>
					<ul class="social-list">
						<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</figure>

			<figure class="project grabbable">
				<img class="img-responsive" src="img/portfolio/04.jpg" alt="Project Image">
				<div class="description">
					<figcaption><h5>Random artwork</h5></figcaption>
					<p>Vivamus suscipit tortor eget felis porttitor
					volutpat. Vestibulum ac diam sit amet
					quam vehicula elementum sed sit amet dui.
					Pellentesque in ipsum id orci. </p>
					<ul class="social-list">
						<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</figure>

			<figure class="project grabbable">
				<img class="img-responsive" src="img/portfolio/05.jpg" alt="Project Image">
				<div class="description">
					<figcaption><h5>Random artwork</h5></figcaption>
					<p>Vivamus suscipit tortor eget felis porttitor
					volutpat. Vestibulum ac diam sit amet
					quam vehicula elementum sed sit amet dui.
					Pellentesque in ipsum id orci. </p>
					<ul class="social-list">
						<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</figure>

			<figure class="project grabbable">
				<img class="img-responsive" src="img/portfolio/06.jpg" alt="Project Image">
				<div class="description">
					<figcaption><h5>Random artwork</h5></figcaption>
					<p>Vivamus suscipit tortor eget felis porttitor
					volutpat. Vestibulum ac diam sit amet
					quam vehicula elementum sed sit amet dui.
					Pellentesque in ipsum id orci. </p>
					<ul class="social-list">
						<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</figure>

		</div>

	</section>

	<section id="services">

		<!-- Section title -->
		<h1 class="sr-only">Services section</h1>
		
		<div class="container">
			
			<div class="row">
				
				<div class="col-md-4">
					
					<div class="service">
						<figure>
							<img src="img/svg/services/idea.svg" alt="Idea image">
							<div class="separator"></div>
							<figcaption><h5>Idea</h5></figcaption>
						</figure>
						<p>Vivamus suscipit tortor eget felis porttitor 
						volutpat. Vestibulum ac diam sit amet 
						quam vehicula elementum sed sit amet dui. 
						Pellentesque in ipsum id orci. </p>
					</div>

				</div>

				<div class="col-md-4">

					<div class="service">
						<figure>
							<img src="img/svg/services/work.svg" alt="Work image">
							<div class="separator"></div>
							<figcaption><h5>Work</h5></figcaption>
						</figure>
						<p>Vivamus suscipit tortor eget felis porttitor 
						volutpat. Vestibulum ac diam sit amet 
						quam vehicula elementum sed sit amet dui. 
						Pellentesque in ipsum id orci. </p>
					</div>

				</div>
				
				<div class="col-md-4">

					<div class="service">
						<figure>
							<img src="img/svg/services/deliver.svg" alt="Deliver image">
							<div class="separator"></div>
							<figcaption><h5>Deliver</h5></figcaption>
						</figure>
						<p>Vivamus suscipit tortor eget felis porttitor 
						volutpat. Vestibulum ac diam sit amet 
						quam vehicula elementum sed sit amet dui. 
						Pellentesque in ipsum id orci. </p>
					</div>

				</div>

			</div>

		</div>

	</section>

	<section id="clients">

		<!-- Section title -->
		<h1 class="sr-only">Clients section</h1>
		
		<div class="container">

			<div class="row">

				<div class="col-md-8 col-md-offset-2">

					<div class="clients-content">
		
						<h2 class="section-title">Our clients are</h2>

						<blockquote>
							<p>��Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. 
							Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. Curabitur aliquet quam id dui posuere blandit��</p>
							<footer><cite title="Mr. Lorem Ipsum">Mr. Lorem Ipsum</cite></footer>
						</blockquote>

					</div>

				</div>

			</div>

			<div class="clients-logs-container">

				<div class="row">
					
					<div class="col-sm-3">
						<div class="single-client-container">
							<img src="img/svg/clients/stephenson_web_design.svg" alt="Client logo image">
						</div>
					</div>

					<div class="col-sm-3">
						<div class="single-client-container">
							<img src="img/svg/clients/john_doe_design.svg" alt="Client logo image">
						</div>
					</div>

					<div class="col-sm-3">
						<div class="single-client-container">
							<img src="img/svg/clients/john_stephenson.svg" alt="Client logo image">
						</div>
					</div>

					<div class="col-sm-3">
						<div class="single-client-container">
							<img src="img/svg/clients/stephenson_william.svg" alt="Client logo image">
						</div>
					</div>

				</div>

			</div>

		</div>

	</section>

	<section id="contact">

		<!-- Section title -->
		<h1 class="sr-only">Contact section</h1>
		
		<div class="container">
				
			<div class="row">
				
				<div class="col-md-6">
					
					<div id="about-subsection" class="contact-subsection">
						
						<h2 class="sub-section-title">About us</h2>

						<p>Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum 
						ac diam sit amet quam vehicula elementum sed sit amet dui. 
						Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. 
						Curabitur aliquet quam id dui posuere blandit. Donec rutrum 
						congue leo eget malesuada. Vivamus suscipit tortor eget 
						felis porttitor volutpat. Vivamus suscipit tortor eget felis.</p>

					</div>

				</div>

				<div class="col-md-6">
					
					<div id="form-subsection" class="contact-subsection">
						
						<h2 class="sub-section-title">Contact us</h2>

						<form>

							<div class="form-group">
								<label class="email-label" for="Email">Email</label>
								<input type="email" class="form-control" id="Email">
							</div>

							<div class="form-group">
								<label class="message-label" for="Message">Message</label>
								<textarea class="form-control" id="Message" rows="2"></textarea>
							</div>
						  
							<button type="submit" class="btn btn-default pull-right">Send</button>

						</form>

					</div>

				</div>

			</div>

		</div>

	</section>

</main>

<footer id="footer">

	<!-- Section title -->
	<h1 class="sr-only">Footer section</h1>
	
	<div class="container">

		<div class="row">

			<div class="col-sm-6">
				<small class="copyright">Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></small>
			</div>

			<div class="col-sm-6">
				<ul class="social-list">
					<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
				</ul>
			</div>

		</div>
		
	</div>

</footer>

<!-- Scripts -->
<script src="<%=path%>/pages/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/pages/js/smooth-scroll.min.js"></script>
<script type="text/javascript" src="<%=path%>/pages/js/modernizr.mq.js"></script>
<script type="text/javascript" src="<%=path%>/pages/js/slick.min.js"></script>

<!-- Latest compiled and minified JavaScript Bootstrap-->
<script src="<%=path%>/pages/js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="js/custom.js"></script>

</body>
</html>