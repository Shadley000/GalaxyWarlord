/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadShip() {
    document.getElementById("mainwindow").innerHTML = "loading";

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

            var myShip = JSON.parse(this.responseText);
            var txt = "<table border='1'>";
            txt += "<tr><TH>id</TH><td>" + myShip.id + "</td></tr>";
             txt += "<tr><TH>name</TH><td>" + myShip.name + "</td></tr>";
              txt += "<tr><TH>type</TH><td>" + myShip.type + "</td></tr>";
            txt += "<tr><TH>position</TH><td>[" + myShip.location.x + ", " + myShip.location.y + "]</td></tr>";
            txt += "<tr><TH>heading</TH><td>[" + myShip.heading.x + ", " + myShip.heading.y + "]</td></tr>";
            txt += "</table>";
             document.getElementById("mainwindow").innerHTML = txt;

        }
    };
    xhttp.open("POST", "GalacticEntityJSONServlet", true);

    xhttp.send();
}
