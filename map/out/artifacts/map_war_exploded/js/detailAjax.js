function searchInformation() {
    var valueElement = document.getElementById("search");
    var value = valueElement[valueElement.selectedIndex].value;
    var url = "/map/servlet/searchInformation?"
    var data = "origin=" + encodeURI(encodeURI(value));
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var res = document.getElementById("message");
            res.innerHTML = "详细信息:" + req.responseText;
        }
    }
    req.open("get", url + data);
    req.send(null);
}

function changeInformation() {
    var originElement = document.getElementById("change");
    var origin = originElement[originElement.selectedIndex].value;
    var information = document.getElementById("changeText").value;
    var url = "/map/servlet/changeInformation?";
    var data = "origin=" + origin + "&information=" + information;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var ret = req.responseText;
            if(ret == "true"){
                alert("修改成功!");
            }else{
                alert("修改失败!");
            }
            location.reload();
        }
    }
    req.open("get", url + data);
    req.send(null);
}