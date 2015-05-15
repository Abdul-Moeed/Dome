<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Stylish Portfolio - Start Bootstrap Theme</title>

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
     }
     </style>
    </head>

    <body>

        <!-- Navigation -->
        <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
                <li class="sidebar-brand">
                    <a href="#top"  onclick = $("#menu-close").click(); >Start Bootstrap</a>
                </li>
                <li>
                    <a href="#top" onclick = $("#menu-close").click(); >Home</a>
                </li>
                <li>
                    <a href="#about" onclick = $("#menu-close").click(); >About</a>
                </li>
                <li>
                    <a href="#services" onclick = $("#menu-close").click(); >Services</a>
                </li>
                <li>
                    <a href="#portfolio" onclick = $("#menu-close").click(); >Portfolio</a>
                </li>
                <li>
                    <a href="#contact" onclick = $("#menu-close").click(); >Contact</a>
                </li>
            </ul>
        </nav>

        <!-- Header -->
        <header id="top" class="header">
            <div class="text-vertical-center">
                <h1 >DOME</h1>
                <br>
                <a href="#about" class="btn btn-dark btn-lg">Find Out More</a>
            </div>
        </header>
        <input id="pac-input" class="controls" type="text" placeholder="Search Box">
        <div id="map-canvas" style="width:100%;height:70%;"></div>
        <div style="width:100%;padding-top:50px;padding-bottom:150px;padding-left:50px">
        <div style="width:45%;float:left;">
        <h1 style="color:black;">Set Radius</h1><input id="ex1" data-slider-id='ex1Slider' type="text" data-slider-min="0" data-slider-max="20" data-slider-step="1" data-slider-value="5"/></div>
        <div style="width:45%;float:right"><button type="button" class="btn btn-primary btn-lg" id="set_loc">Set Current Location</button></div>
        </div>

        <!-- Map -->

    </section>

    <!-- Services -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <section id="services" class="services bg-primary">
        <div class="container">
            <div class="row text-center">
                <div class="col-lg-10 col-lg-offset-1">
                    <h2>Our Services</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-cloud fa-stack-1x text-primary"></i>
                                </span>
                                <h4>
                                    <strong>Service Name</strong>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-compass fa-stack-1x text-primary"></i>
                                </span>
                                <h4>
                                    <strong>Service Name</strong>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-flask fa-stack-1x text-primary"></i>
                                </span>
                                <h4>
                                    <strong>Service Name</strong>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-shield fa-stack-1x text-primary"></i>
                                </span>
                                <h4>
                                    <strong>Service Name</strong>
                                </h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                            </div>
                        </div>
                        <div class="navbar-form navbar-left" role="search">
        							<div class="form-group">
          							<input type="number" class="form-control" placeholder="cnic" id="cnic">
          							<input type="password" class="form-control" placeholder="Password" id="password">
        							</div>
        							<button type="button" class="btn btn-default" id="signin">Sign in</button>
      							</div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Callout -->
    <aside class="callout">
        <div class="text-vertical-center">
            <h1>Vertically Centered Text</h1>
        </div>
    </aside>

    <!-- Portfolio -->
    <section id="portfolio" class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <h2>Our Work</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="#">
                                    <img class="img-portfolio img-responsive" src="${pageContext.request.contextPath}/resources/img/portfolio-1.jpg">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="#">
                                    <img class="img-portfolio img-responsive" src="${pageContext.request.contextPath}/resources/img/portfolio-2.jpg">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="#">
                                    <img class="img-portfolio img-responsive" src="${pageContext.request.contextPath}/resources/img/portfolio-3.jpg">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="portfolio-item">
                                <a href="#">
                                    <img class="img-portfolio img-responsive" src="${pageContext.request.contextPath}/resources/img/portfolio-4.jpg">
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                    <a href="#" class="btn btn-dark">View More Items</a>
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Call to Action -->
    <aside class="call-to-action bg-primary">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3>The buttons below are impossible to resist.</h3>
                    <a href="#" class="btn btn-lg btn-light">Click Me!</a>
                    <a href="#" class="btn btn-lg btn-dark">Look at Me!</a>
                </div>
            </div>
        </div>
    </aside>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Mosque</h4>
      </div>
      <div class="modal-body">
        </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
    

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <h4><strong>Start Bootstrap</strong>
                    </h4>
                    <p>3481 Melrose Place<br>Beverly Hills, CA 90210</p>
                    <ul class="list-unstyled">
                        <li><i class="fa fa-phone fa-fw"></i> (123) 456-7890</li>
                        <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:name@example.com">name@example.com</a>
                        </li>
                    </ul>
                    <br>
                    <ul class="list-inline">
                        <li>
                            <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
                        </li>
                    </ul>
                    <hr class="small">
                    <p class="text-muted">Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-slider.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAthTGJ0IO7_JZ0H2Hm_8oRaM-eYWFhwwM"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyAthTGJ0IO7_JZ0H2Hm_8oRaM-eYWFhwwM"></script>
    <script>
 // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    $("#signin").click(function(){
    	$.ajax({url: "${pageContext.request.contextPath}/user.login", data : JSON.stringify({"cnic" : $("#cnic").val(), "pass" : $("#password").val()}) ,type:"POST",
    	contentType: 'application/json',accepts : 'application/json', success: function(result){
        	alert(result);
    	}});
    });

    // Scrolls to the selected menu item on the page
    var curr_pos;
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
        $("#ex1").slider();
    });
    var initialLocation;var service; var infowindow; var request;
    var siberia = new google.maps.LatLng(60, 105);
    var newyork = new google.maps.LatLng(40.69847032728747, -73.9514422416687);
    var browserSupportFlag =  new Boolean();
    var current_radius=500;var markers=[];

 
function initialize(position_state) {
  var myOptions = {
    zoom: 15,
    mapTypeId: google.maps.MapTypeId.ROADMAP
};
var map = new google.maps.Map(document.getElementById("map-canvas"), myOptions);
   function callback(results, status) {
      if (status == google.maps.places.PlacesServiceStatus.OK) {
        for (var i = 0; i < results.length; i++) {
          createMarker(results[i]);
      }
  }
 
}

function createMarker(place) {
  var placeLoc = place.geometry.location;
  var marker = new google.maps.Marker({
    map: map,
    position: place.geometry.location
});
  markers.push(marker);
  google.maps.event.addListener(marker, 'click', function() {
	$('myModal .modal-body').html("<img src=\"${pageContext.request.contextPath}/resources/img/loader.gif\">");
  	$('#myModal').modal('show');
  	$('#myModal .modal-body').load("${pageContext.request.contextPath}/modal.load", {data : place.place_id});
});
}
  // Try W3C Geolocation (Preferred)
  if(navigator.geolocation) {
    browserSupportFlag = true;
    navigator.geolocation.getCurrentPosition(function(position) {
        if (position_state=='curr_pos'){
            initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
        }
        else{
            initialLocation = new google.maps.LatLng(position_state.lat(),position_state.lng());
        }
      infowindow = new google.maps.InfoWindow({
                map: map,
                position: initialLocation,
                content: 'Your Current Location'
            });
      map.setCenter(initialLocation);
      curr_pos=map.getCenter();
      var request = {
                location:initialLocation,
                radius:current_radius,
                types: ['mosque']
            };
            infowindow = new google.maps.InfoWindow();
            var service = new google.maps.places.PlacesService(map);
            service.nearbySearch(request,callback);
  }, function() {
      handleNoGeolocation(browserSupportFlag);
  });

     var listener = google.maps.event.addListener(map, "idle", function() { 
        if (map.getZoom() > 15) map.setZoom(15); 
        google.maps.event.removeListener(listener); 
    });
}
  // Browser doesn't support Geolocation
  else {
    browserSupportFlag = false;
    handleNoGeolocation(browserSupportFlag);
}

function handleNoGeolocation(errorFlag) {
    if (errorFlag == true) {
      alert("Geolocation service failed.");
      initialLocation = newyork;
  } else {
      alert("Your browser doesn't support geolocation. We've placed you in Siberia.");
      initialLocation = siberia;
  }
  map.setCenter(initialLocation);
}
  // Create the search box and link it to the UI element.
  var input = /** @type {HTMLInputElement} */(
      document.getElementById('pac-input'));
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  var searchBox = new google.maps.places.SearchBox(
    /** @type {HTMLInputElement} */(input));
  google.maps.event.addListener(searchBox, 'places_changed', function() {
    var places = searchBox.getPlaces();

    if (places.length == 0) {
      return;
    }


    var bounds = new google.maps.LatLngBounds();
    for (var i = 0, place; place = places[i]; i++) {
      var image = {
        url: place.icon,
        size: new google.maps.Size(142, 142),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 34),
        scaledSize: new google.maps.Size(50, 50)
      };

      bounds.extend(place.geometry.location);
    }

    map.fitBounds(bounds);
    var listener = google.maps.event.addListener(map, "idle", function() { 
        if (map.getZoom() > 15) map.setZoom(15); 
        google.maps.event.removeListener(listener); 
    });
  });

  // Bias the SearchBox results towards places that are within the bounds of the
  // current map's viewport.
  google.maps.event.addListener(map, 'bounds_changed', function() {
    var bounds = map.getBounds();
    searchBox.setBounds(bounds);
  });
  function clearMarkers(){
  	for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  	}
  }
  $("#set_loc").click(function(){
  		clearMarkers();markers = [];
  		initialLocation = new google.maps.LatLng(map.getCenter().lat(),map.getCenter().lng());
        var request = {
                	location:initialLocation,
                	radius:current_radius,
                	types: ['mosque']
        };
       	infowindow = new google.maps.InfoWindow();
      	var service = new google.maps.places.PlacesService(map);
       	service.nearbySearch(request,callback);
    });
  $("#ex1").on("slide", function(slideEvt) {
  			clearMarkers();markers = [];
            if (parseInt(current_radius)!=parseInt(slideEvt.value)*100){
                current_radius=parseInt(slideEvt.value)*100;
                var request = {
                	location:initialLocation,
                	radius:current_radius,
                	types: ['mosque']
            	};
            	infowindow = new google.maps.InfoWindow();
            	var service = new google.maps.places.PlacesService(map);
            	service.nearbySearch(request,callback);
            	}
    });
}
google.maps.event.addDomListener(window, 'load', initialize('curr_pos'));
    </script>
</body>

</html>
