<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Guice Application</title>
<link rel="stylesheet" href="css/main.css">
<link rel="icon" href="/images/icons/Logo.png">
</head>


<body>
	<div class="full-page">
		<div class="navbar">
			<div>
				<a href="#">DEMO</a>
			</div>
			<!-- <nav>
                <ul id="MenuItems">
                    <li><button class="loginbtn" onclick="document.getElementById('login-form').style.display='block'" style="width:auto;">Login</button></li>
                </ul>
            </nav> -->

		</div>


		<div class='login-page'>
			<div class="form-box">
				<div class='button-box'>
					<h1>Log In Form</h1>
				</div>


				<form id='login' class='input-group-login' action='google/app/login'
					method='get'>
					<span style="color: black">Enter User ID:</span> 
					<input	type='email' class='input-field' id='userid' name='userid'	placeholder='xyz@domain.com' required> 
					<span style="color: black">Enter Password:</span> 
					<input type='password' class='input-field' id='password' name='password' placeholder='Enter Password' required>
					
					<div class="miscelaneous">
						<a class="miscelaneous-text" href="forgotuser">Forgot
							Password</a> <a class="miscelaneous-text" href="register">Register</a>
					</div>
					<button type='submit' class='submit-btn'>Log in</button>
					 <!-- <div class='error-msg'>${Error.message }</div>  -->
				</form>

				<!--  
				<script type="text/javascript">
					var form = document.getElementById('login');
					form.onsubmit = function(event) {
						var xhr = new XMLHttpRequest();
						var formData = new FormData(form);
						//open the request
						xhr.open('POST', 'http://localhost:8080/google-guice-web/google/app/login')
						xhr.setRequestHeader("Content-Type", "application/json");

						//send the form data
						xhr.send(JSON.stringify(Object.fromEntries(formData)));

						xhr.onreadystatechange = function() {
							if (xhr.readyState == XMLHttpRequest.DONE) {
								form.reset(); //reset form after AJAX success or do something else
							}
						}
						//Fail the onsubmit to avoid page refresh.
						return true;
					}
				</script> 
				-->

			</div>
		</div>
	</div>

</body>

</html>
