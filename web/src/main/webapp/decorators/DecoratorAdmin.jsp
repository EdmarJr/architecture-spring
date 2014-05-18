<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title><decorator:title default="Dashboard - SB Admin"/></title>
<script src='<c:url value="/resources/admin/js/jquery-1.10.2.js"/>'></script>
<!-- Bootstrap core CSS -->
<link href='<c:url value="/resources/admin/css/bootstrap.css"/>'
	rel="stylesheet">

<!-- Add custom CSS here -->
<link href='<c:url value="/resources/admin/css/sb-admin.css"/>'
	rel="stylesheet">
<link rel="stylesheet"
	href='<c:url value="/resources/admin/font-awesome/css/font-awesome.min.css"/>'>
<!-- Page Specific CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/admin/css/morris-0.4.3.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/admin/css/category.css"/>'>
</head>
<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">SB Admin</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="${pageContext.request.contextPath}/admin"><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/orcamentos"><i class="fa fa-bar-chart-o"></i>
							Orçamentos</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/categorias"><i class="fa fa-table"></i>
							Categorias</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/produtos"><i class="fa fa-edit"></i> Produtos</a></li>
					<li><a href="typography.html"><i class="fa fa-font"></i>
							Typography</a></li>
					<li><a href="bootstrap-elements.html"><i
							class="fa fa-desktop"></i> Bootstrap Elements</a></li>
					<li><a href="bootstrap-grid.html"><i class="fa fa-wrench"></i>
							Bootstrap Grid</a></li>
					<li><a href="blank-page.html"><i class="fa fa-file"></i>
							Blank Page</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown Item</a></li>
							<li><a href="#">Another Item</a></li>
							<li><a href="#">Third Item</a></li>
							<li><a href="#">Last Item</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right navbar-user">
					<li class="dropdown messages-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-envelope"></i> Messages <span class="badge">7</span>
							<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">7 New Messages</li>
							<li class="message-preview"><a href="#"> <span
									class="avatar"><img src="http://placehold.it/50x50"></span>
									<span class="name">John Smith:</span> <span class="message">Hey
										there, I wanted to ask you something...</span> <span class="time"><i
										class="fa fa-clock-o"></i> 4:34 PM</span>
							</a></li>
							<li class="divider"></li>
							<li class="message-preview"><a href="#"> <span
									class="avatar"><img src="http://placehold.it/50x50"></span>
									<span class="name">John Smith:</span> <span class="message">Hey
										there, I wanted to ask you something...</span> <span class="time"><i
										class="fa fa-clock-o"></i> 4:34 PM</span>
							</a></li>
							<li class="divider"></li>
							<li class="message-preview"><a href="#"> <span
									class="avatar"><img src="http://placehold.it/50x50"></span>
									<span class="name">John Smith:</span> <span class="message">Hey
										there, I wanted to ask you something...</span> <span class="time"><i
										class="fa fa-clock-o"></i> 4:34 PM</span>
							</a></li>
							<li class="divider"></li>
							<li><a href="#">View Inbox <span class="badge">7</span></a></li>
						</ul></li>
					<li class="dropdown alerts-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-bell"></i> Alerts <span class="badge">3</span> <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Default <span
									class="label label-default">Default</span></a></li>
							<li><a href="#">Primary <span
									class="label label-primary">Primary</span></a></li>
							<li><a href="#">Success <span
									class="label label-success">Success</span></a></li>
							<li><a href="#">Info <span class="label label-info">Info</span></a></li>
							<li><a href="#">Warning <span
									class="label label-warning">Warning</span></a></li>
							<li><a href="#">Danger <span class="label label-danger">Danger</span></a></li>
							<li class="divider"></li>
							<li><a href="#">View All</a></li>
						</ul></li>
					<li class="dropdown user-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user"></i> John Smith <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
							<li><a href="#"><i class="fa fa-envelope"></i> Inbox <span
									class="badge">7</span></a></li>
							<li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>


		<div id="content">
			<decorator:body />
		</div>
		
		<script src='<c:url value="/resources/admin/js/bootstrap.js"/>'></script>

		<!-- Page Specific Plugins -->
		<script
			src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
		<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
		<script
			src='<c:url value="/resources/admin/js/morris/chart-data-morris.js"/>'></script>
		<script
			src='<c:url value="/resources/admin/js/tablesorter/jquery.tablesorter.js"/>'></script>
		<script
			src='<c:url value="/resources/admin/js/tablesorter/tables.js"/>'></script>
	</div>
	
	<div id="Footer">
		<!-- FOOTER -->
	</div>
</body>
</html>