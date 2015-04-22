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
  	infowindow.setContent("<img src=\"${pageContext.request.contextPath}/resources/img/loader.gif\">");
  	 $.ajax({
            url : '${pageContext.request.contextPath}/mosque_data.json',
            method : 'POST',
            dataType : "json",
            data : place.place_id,
            success : function(data) {
            	if (data["status"]=="404")
            		infowindow.setContent("Not Found in Database.");
            	else
            		infowindow.setContent("Name : "+place.name+"<br> Latitude : "+place.geometry.location.lat()+"|| Longitude : "+place.geometry.location.lng()+"<br> Jumma Prayers : "+data["jumma_time"]+"|| Mosque Capacity(Approx.) : "+data["capacity"]+"<br> Eid Prayers : "+data["eid_time"]+"|| Sect : "+data["sect"]+"<br>"+place.types);
            },
            error : function (data) {
            }
        });
     infowindow.open(map, this);
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