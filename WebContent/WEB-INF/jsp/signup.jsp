<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    
	    <title>You will be Redirected</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/stylish-portfolio.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/slider.css" rel="stylesheet">


    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
     <style>
     body{
     	font-family: "Open Sans", sans-serif;
     	color: black;
     }
     </style>
</head>
<body>
<form:form method="POST" action="${pageContext.request.contextPath}/values" class="navbar-form navbar-left" role="search" modelAttribute="users">
        	<div class="form-group">
          		<form:label path="cnic"/><form:input path="cnic"  type="number" class="form-control" placeholder="cnic"/>
          		<form:errors path="cnic" cssStyle="color: #ff0000;"/>
          		<form:label path="password"/><form:input path="password" type="password" class="form-control" placeholder="Password"/>
          		<form:errors path="password" cssStyle="color: #ff0000;"/>
          		<form:label path="name"/><form:input path="name"  type="text" class="form-control" placeholder="name"/>
          		<form:errors path="name" cssStyle="color: #ff0000;"/>
          		<form:label path="phone_number"/><form:input path="phone_number" type="number" class="form-control" placeholder="Phone number"/>
          		<form:errors path="phone_number" cssStyle="color: #ff0000;"/>
          		<form:label path="email"/><form:input path="email"  type="email" class="form-control" placeholder="email"/>
          		<form:errors path="email" cssStyle="color: #ff0000;"/>
        	</div>
        		<input type="submit" value="signup" class="btn btn-default"/>
</form:form>
</body>