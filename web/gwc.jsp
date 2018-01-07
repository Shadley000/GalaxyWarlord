<%-- 
    Document   : gwc
    Created on : Jan 3, 2018, 11:14:30 AM
    Author     : shadl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galactic Warlord Control Console</title>
        <link rel="stylesheet" href="styles.css">
       <script src="displayScan.js"></script>
       <script src="displayShip.js"></script>
    </head>
    <body>
        
        <div class="container">
            <header>
                <h1>Galactic Warlord Control Console</h1>
            </header>
            <nav>
                <h2>Main Menu</h2>
                <ul>
                    <li><a href="login"> Logout</a> </li>
                    <li><a href="index.html">Home</a>  </li>
                    <li><button type="button" onclick="loadShip()">Ship</button> </li>
                    <li><button type="button" onclick="loadScan()">Scan Sector</button> </li>
                </ul>
            </nav>
            <article id="mainwindow">
             
                
            </article>
            <footer>  <P>GWC 2018</P></footer>
        </div> 
        
    </body>
</html>
