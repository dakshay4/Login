<html>
<head>
<title>Username Availability</title>
<style type="text/css">
.flable {
	color: red;
}

.status {
	font-family: verdana;
	font-size: 12px;
}

.uname {
	color: blue;
}
</style>
<script src="jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
          $(document).ready(function(){
              $(".uname").change(function(){
                  var uname = $(this).val();
                  if(uname.length >= 3){
                      $(".status").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                       $.ajax({
                          type: "POST",
                          url: "check",
                          data: "uname="+ uname,
                          success: function(msg){

                              $(".status").ajaxComplete(function(event, request, settings){
                                   
                                  $(".status").html(msg);

                              });
                          }
                      }); 
                  }
                  else{
                       
                      $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");
                  }
                  
              });
          });
        </script>
</head>
<body>
	<div>
		<form method="post" action="register">
		<label class="flable">User Name :</label> <input type="text"
			class="uname" />&nbsp;<span class="status"></span> <br/>
	
		
			Email Id :<input type="email" name="email" required /><br/>
        Password :<input type="password" name="pass" required /><br/>
        Mobile :<input type="number" name="mobile" maxlength=10 min=10 required /><br/>
        <input type="submit" value="register" /> 
        </form>
	</div>

</body>
</html>
