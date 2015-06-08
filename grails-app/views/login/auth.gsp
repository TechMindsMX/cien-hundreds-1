<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Login</title>

    <asset:stylesheet src="css/bootstrap.min.css"/>
    <asset:stylesheet src="font-awesome/css/font-awesome.css"/>

    <asset:stylesheet src="css/animate.css"/>
    <asset:stylesheet src="css/style.css"/>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <asset:image src="cien_logo.gif" />

            </div>
            <h3>Welcome to 100-Hundreds</h3>
            <p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
                <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
            </p>
            <p>Login in. To see it in action.</p>
            <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                <div class="form-group">
                    <input type="text" name='j_username' class="form-control" placeholder="Username" id='username' required="">
                </div>
                <div class="form-group">
                    <input type="password" name='j_password' class="form-control" placeholder="Password" id='password' required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                <a href="#"><small>Forgot password?</small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
            </form>
            <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <asset:javascript src="js/jquery-2.1.1.js" />
    <asset:javascript src="js/bootstrap.min.js" />

</body>

</html>
