<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

					<div class="container-lg p-responsive position-relative">
						<div class="d-md-flex flex-items-center gutter-md-spacious">
						  <div class="col-md-7 text-center text-md-left ">
							<h2 class="alt-h0 text-white lh-condensed-ultra mb-3">寒冬不会阻挡你前行</h2>
							<br>
							<p class="alt-lead mb-4">
							 风雪会为你指引前方的路
							</p>
						  </div>
							<div class="mx-auto col-sm-8 col-md-5 hide-sm">
							  <div class="rounded-1 text-gray bg-gray-light py-4 px-4 px-md-3 px-lg-4">
							  <!-- start  sign up-->
								<form class="home-hero-signup js-signup-form sign-up" autocomplete="off" action="/join" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="✓"><input type="hidden" name="authenticity_token" value="rM83KrMf1GLAUmiW2xCHBPfV/zNKv58GFLeee23cDTxQrcr+nA1XuwCFpS9Jz+lQe8Flm8THOtGlQGcrFdcU2w==">              <dl class="form-group mt-0">
									<dt class="input-label">
									  <label class="form-label f5" >用户名</label>
									</dt>
									<dd>
										<input type="text" name="username" id="username" class="form-control form-control-lg input-block" placeholder="you username">
									</dd>
								  </dl>
								  <dl class="form-group errored">
									<dt class="input-label">
									  <label class="form-label f5" >邮箱</label>
									</dt>
									<dd>
										<input type="text" name="email" id="email" class="form-control form-control-lg input-block js-email-notice-trigger is-autocheck-errored" placeholder="you@example.com">
									</dd>
								  <dd class="error">Email is invalid or already taken</dd></dl>
								  <dl class="form-group successed">
									<dt class="input-label">
									  <label class="form-label f5" ">密码</label>
									</dt>
									<dd>
										<input type="password" name="loginpassword" id="loginpassword" class="form-control form-control-lg input-block is-autocheck-successful" placeholder="Create a password">
									</dd>
									<p class="form-control-note">Use at least one letter, one numeral, and seven characters.</p>
								  </dl>
								  <input type="hidden" name="source" class="js-signup-source" value="form-home">
								  <input type="text" name="required_field_d5e1" id="sign-up-info" style="display: none" class="form-control">
								  <button class="btn btn-primary btn-large f4 btn-block" type="submit" data-ga-click="Signup, Attempt, location:teams;">注册</button>
								  <p class="form-control-note mb-0 text-center">
								  注册后，我们会发送一封电子邮件，用于激活您的账号<br>已有账号&nbsp <a href="#" class="sign">登录</a>
									</p>

					</form>   
					<!-- end  sign up-->
					<!-- start  sign in-->
						<form class="home-hero-signup js-signup-form sign-in" autocomplete="off" action="/join" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="✓"><input type="hidden" name="authenticity_token" value="rM83KrMf1GLAUmiW2xCHBPfV/zNKv58GFLeee23cDTxQrcr+nA1XuwCFpS9Jz+lQe8Flm8THOtGlQGcrFdcU2w==">              <dl class="form-group mt-0">
									<dt class="input-label">
									  <label class="form-label f5" for="user[login]">用户名</label>
									</dt>
									<dd>
										<input type="text" name="loginname" id="loginname" class="form-control form-control-lg input-block" placeholder="you username" autofocus="">
									</dd>
								  </dl>
								  <dl class="form-group successed">
									<dt class="input-label">
									  <label class="form-label f5" >密码</label>
									</dt>
									<dd>
										<input type="password" name="password" id="password" class="form-control form-control-lg input-block is-autocheck-successful" placeholder="your password">
									</dd>
									<p class="form-control-note"></p>
								  </dl>
								  <input type="hidden" name="source" class="js-signup-source" value="form-home">
								  <input type="text" name="required_field_d5e1" id="sign-in-info" style="display: none" class="form-control">

								  <button class="btn btn-primary btn-large f4 btn-block sign-in-btn" type="submit" data-ga-click="Signup, Attempt, location:teams;">登录</button>
								  
					</form>
					<!-- end  sign in-->
					</div>
							<div class="login-icobar-sign-up"><div><spen class="login-icobar-text">用社交账号直接登录</spen>
								<a class="" href="<%=path%>/login"><img alt="qq" src="img/ico/qq.jpg" class="login-ico"></a>
								<a class="" href="<%=path%>/login"><img alt="wech" src="img/ico/wech.jpg" class="login-ico"></a>
								<a class="" href="<%=path%>/login"><img alt="blog" src="img/ico/blog.jpg " class="login-ico"></a></div>
							
							</div>
							<div class="d-sm-none text-center">
							</div>
						</div>
					  </div>
					
				</div>

			</div>

		</div>



	</section>

	

<footer id="footer">

	<!-- Section title -->
	<h1 class="sr-only">Footer section</h1>
	
	<div class="container">

<div class="d-flex flex-wrap py-5 mb-5">
    <div class="col-12 col-md-2 mb-3">
      <svg height="24" class="octicon octicon-logo-github" viewBox="0 0 45 16" version="1.1" width="67" aria-hidden="true"><path fill-rule="evenodd" d="M18.53 12.03h-.02c.009 0 .015.01.024.011h.006l-.01-.01zm.004.011c-.093.001-.327.05-.574.05-.78 0-1.05-.36-1.05-.83V8.13h1.59c.09 0 .16-.08.16-.19v-1.7c0-.09-.08-.17-.16-.17h-1.59V3.96c0-.08-.05-.13-.14-.13h-2.16c-.09 0-.14.05-.14.13v2.17s-1.09.27-1.16.28c-.08.02-.13.09-.13.17v1.36c0 .11.08.19.17.19h1.11v3.28c0 2.44 1.7 2.69 2.86 2.69.53 0 1.17-.17 1.27-.22.06-.02.09-.09.09-.16v-1.5a.177.177 0 0 0-.146-.18zm23.696-2.2c0-1.81-.73-2.05-1.5-1.97-.6.04-1.08.34-1.08.34v3.52s.49.34 1.22.36c1.03.03 1.36-.34 1.36-2.25zm2.43-.16c0 3.43-1.11 4.41-3.05 4.41-1.64 0-2.52-.83-2.52-.83s-.04.46-.09.52c-.03.06-.08.08-.14.08h-1.48c-.1 0-.19-.08-.19-.17l.02-11.11c0-.09.08-.17.17-.17h2.13c.09 0 .17.08.17.17v3.77s.82-.53 2.02-.53l-.01-.02c1.2 0 2.97.45 2.97 3.88zm-8.72-3.61H33.84c-.11 0-.17.08-.17.19v5.44s-.55.39-1.3.39-.97-.34-.97-1.09V6.25c0-.09-.08-.17-.17-.17h-2.14c-.09 0-.17.08-.17.17v5.11c0 2.2 1.23 2.75 2.92 2.75 1.39 0 2.52-.77 2.52-.77s.05.39.08.45c.02.05.09.09.16.09h1.34c.11 0 .17-.08.17-.17l.02-7.47c0-.09-.08-.17-.19-.17zm-23.7-.01h-2.13c-.09 0-.17.09-.17.2v7.34c0 .2.13.27.3.27h1.92c.2 0 .25-.09.25-.27V6.23c0-.09-.08-.17-.17-.17zm-1.05-3.38c-.77 0-1.38.61-1.38 1.38 0 .77.61 1.38 1.38 1.38.75 0 1.36-.61 1.36-1.38 0-.77-.61-1.38-1.36-1.38zm16.49-.25h-2.11c-.09 0-.17.08-.17.17v4.09h-3.31V2.6c0-.09-.08-.17-.17-.17h-2.13c-.09 0-.17.08-.17.17v11.11c0 .09.09.17.17.17h2.13c.09 0 .17-.08.17-.17V8.96h3.31l-.02 4.75c0 .09.08.17.17.17h2.13c.09 0 .17-.08.17-.17V2.6c0-.09-.08-.17-.17-.17zM8.81 7.35v5.74c0 .04-.01.11-.06.13 0 0-1.25.89-3.31.89-2.49 0-5.44-.78-5.44-5.92S2.58 1.99 5.1 2c2.18 0 3.06.49 3.2.58.04.05.06.09.06.14L7.94 4.5c0 .09-.09.2-.2.17-.36-.11-.9-.33-2.17-.33-1.47 0-3.05.42-3.05 3.73s1.5 3.7 2.58 3.7c.92 0 1.25-.11 1.25-.11v-2.3H4.88c-.11 0-.19-.08-.19-.17V7.35c0-.09.08-.17.19-.17h3.74c.11 0 .19.08.19.17z"></path></svg>
      <p class="text-gray alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
        ©2018年
      </font></font></p>
    </div>
    <div class="col-6 col-sm-4 col-md-2 mb-3 pr-3">
      <h4 class="mb-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">特征</font></font></h4>
      <ul class="list-style-none text-gray">
        <li class="lh-condensed mb-2"><a href="/features#code-review" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">代码审查</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/features#project-management" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">项目管理</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/features#integrations" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">集成</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/features#team-management" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">团队管理</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/features#social-coding" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">社会编码</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/features#documentation" class="muted-link alt-text-small no-wrap"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">文档</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/features#code-hosting" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">代码托管</font></font></a></li>
      </ul>
    </div>
    <div class="col-6 col-sm-4 col-md-2 mb-3 pr-3">
      <h4 class="mb-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">平台</font></font></h4>
      <ul class="list-style-none">
        <li class="lh-condensed mb-2"><a href="https://atom.io" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">原子</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="http://electron.atom.io/" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">电子</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://desktop.github.com/" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">GitHub桌面</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://developer.github.com" data-ga-click="Footer, go to api, text:api" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">开发人员API</font></font></a></li>
      </ul>
    </div>
    <div class="col-6 col-sm-4 col-md-2 mb-3 pr-3">
      <h4 class="mb-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">社区</font></font></h4>
      <ul class="list-style-none">
        <li class="lh-condensed mb-2"><a href="/personal" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">个人</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/open-source" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">开源</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/business" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">商业</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://education.github.com/" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">教育</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/business/customers" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">顾客</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://partner.github.com/" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">伙伴</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://community.github.com/" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">赞助</font></font></a></li>
      </ul>
    </div>
    <div class="col-6 col-sm-4 col-md-2 mb-3 pr-3">
      <h4 class="mb-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">公司</font></font></h4>
      <ul class="list-style-none">
        <li class="lh-condensed mb-2"><a data-ga-click="Footer, go to about, text:about" class="muted-link alt-text-small" href="https://github.com/about"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">关于</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://blog.github.com" data-ga-click="Footer, go to blog, text:blog" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">博客</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/about/careers" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">招聘</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/about/press" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">按</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://shop.github.com" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">店</font></font></a></li>
      </ul>
    </div>
    <div class="col-6 col-sm-4 col-md-2 mb-3 pr-3">
      <h4 class="mb-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">资源</font></font></h4>
      <ul class="list-style-none">
        <li class="lh-condensed mb-2"><a data-ga-click="Footer, go to contact, text:contact" class="muted-link alt-text-small" href="https://github.com/contact"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">联系GitHub</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://github.community" data-ga-click="Footer, go to community, text:community" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">社区论坛</font></font></a></li>
        <li class="lh-condensed mb-2"><a data-ga-click="Footer, go to help, text:help" class="muted-link alt-text-small" href="https://help.github.com"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">帮帮我</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://status.github.com/" data-ga-click="Footer, go to status, text:status" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">状态</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/site/terms" data-ga-click="Footer, go to terms, text:terms" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">条款</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="/site/privacy" data-ga-click="Footer, go to privacy, text:privacy" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">隐私</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://help.github.com/articles/github-security/" data-ga-click="Footer, go to security, text:security" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">安全</font></font></a></li>
        <li class="lh-condensed mb-2"><a href="https://services.github.com/" class="muted-link alt-text-small"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">训练</font></font></a></li>
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