function allPath() {
    var originElement = document.getElementById("origin");
    var destinationElement = document.getElementById("destination");
    var origin = originElement[originElement.selectedIndex].value;
    var destination = destinationElement[destinationElement.selectedIndex].value;
    var url = "/map/servlet/advanceSearch?";
    var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(destination));
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var res = req.responseText;
            document.getElementById("allPathResult").innerHTML = res;
        }
    }
    req.open("get", url + data);
    req.send(null);
}


function multiPoints() {
    var points = document.getElementById("points").value;
    var ps = points.split("#");
    var url = "/map/servlet/multiPoints?";
    var data = "";
    for(var i = 0; i < ps.length - 1; i++){
        data = data + "point=" + encodeURI(encodeURI(ps[i])) + "&";
    }
    data = data + "point=" + encodeURI(encodeURI(ps[ps.length - 1]));
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            document.getElementById("multiRes").innerHTML = req.responseText;
        }
    }
    req.open("get", url + data);
    req.send(null);
}