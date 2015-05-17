<%@ page import="com.hibernate.util.users" %>
<%@ page session="true" %>
        <div class='mosque-image'>
                    <img src='${msqpic}'>
                </div>
                <div class='mosque-desc'>
                    <h1>${msqname}</h1>
                    <div class='mosque-address'>
                        <p><i class="fa fa-map-marker fa-lg" style="color:crimson;"></i><span>${msqaddress}</span></p>
                    </div>
                    <div class='mosque-phone'>
                        <p><i class="fa fa-phone fa-lg" style="color:darkblue;"></i><span>${msqnumber}</span></p>
                    </div>
                    <div class='mosque-sect'>
                        <p><i class="fa fa-moon-o fa-lg" style="color:yellowgreen;"></i><span>${msqsect}</span></p>
                    </div>
                    <div class='mosque-imam'>
                        <p><i class="fa fa-user fa-lg"></i><span>${msqadmin}</span></p>
                    </div>
                    <div class='mosque-prayers'>
                        <p><i class="fa fa-clock-o fa-lg" style="color:gold;"></i><span>Prayer Timings</span></p>
                        <ul>
                            <li>Fajr: ${Fajar}</li>
                            <li>Zuhr: ${Zuhr}</li>
                            <li>Asar: ${Asar}</li>
                            <li>Maghrib: ${Maghrib}</li>
                            <li>Isha: ${Isha}</li>
                            <li>Juma: ${Juma}</li>
                            <li>Eid: ${Eid}</li>
                        </ul>
                    </div>
                    <%if (((users)session.getAttribute("users")).getName()!=null){ %>
                    	<button type="button" class="btn btn-default" id="report">Report-Info</button>
                    	<button type="button" class="btn btn-default" id="addmore">Add-Info</button>
                    <%} %>
                </div>
