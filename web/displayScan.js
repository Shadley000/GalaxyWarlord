/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function loadScan() {
    document.getElementById("mainwindow").innerHTML = "loading sector              sccccccccccan";

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

            var myScan = JSON.parse(this.responseText);
            var txt = "<table border='1'>";
            txt += "<tr><TH>id</TH><TH>name</TH><TH>type</TH><TH>position</TH><TH>heading</TH></tr>";
            for (x in myScan) {
                var myShip = myScan[x];
                txt += "<tr><td>" + myShip.id + "</td><td>" + myShip.name + "</td><td>" + myShip.type + "</td><td>[" + myShip.location.x + ", " + myShip.location.y + "]</td><td>[" + myShip.heading.x + ", " + myShip.heading.y + "]</td></tr>";
            }
            txt += "</table>";
            document.getElementById("mainwindow").innerHTML = txt;

        }
    };
    xhttp.open("POST", "ScannerJSONServlet", true);

    xhttp.send();
}
