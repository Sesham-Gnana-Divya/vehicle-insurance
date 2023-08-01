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
                    <h1>Registration Form</h1>
                </div>


                <form id='register' class='input-group-register' action='google/app/register' method='get'>
                    <span style="color:black">Enter User ID:</span>
                    <input type='email' class='input-field' id='userid' name='userid' placeholder='xyz@domain.com' required>

                    <span style="color:black">Enter Full Name:</span>
                    <input type='text' class='input-field' id='username' name='username' placeholder='full name' required>
                    <span style="color:black">Enter Password:</span>
                    <input type='password' class='input-field' id='password' name='password' placeholder='Enter Password' required>
                    <span style="color:black">Enter Password again:</span>
                    <input type='password' class='input-field' id='confirm_password' name='confirm_password' placeholder='Confirm Password' required>



                    <div class="miscelaneous">
                        <a class="miscelaneous-text" href="/google-guice-web">Login</a>
                        <a class="miscelaneous-text" href="forgotuser">Forgot Password</a>
                    </div>
                    <button type='submit' class='submit-btn'>Register</button>

                </form>

            </div>
        </div>
    </div>

</body>

</html>
