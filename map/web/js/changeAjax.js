function add() {
    var origin = document.getElementById("11").value;
    var destination = document.getElementById("12").value;
    var length = document.getElementById("13").value;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var ret = req.responseText;
            if(ret == "true"){
                alert("添加成功!");
                document.getElementById("11").value = "";
                document.getElementById("12").value = "";
                document.getElementById("13").value = "";
            }else{
                alert("添加失败!");
            }
            location.reload();
        }
    }
    var url = "/map/servlet/addPath?";
    var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(destination)) + "&length=" + length;
    req.open("get", url + data);
    req.send(null);
}






function soriginChange(value) {
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var str = req.responseText;
            var dests = str.split("#");
            var dest = document.getElementById("sdestination");
            dest.options.length=0;
            for(var i = 0; i < dests.length; i++){
                var newoption = new Option(dests[i], dests[i]);
                dest.options.add(newoption);
            }
            var tmp2 = document.getElementById("sdestination");
            sdestinationChange(tmp2[tmp2.selectedIndex].value);
        }
    }
    var url = "/map/servlet/searchDest?";
    var data = "origin=" + encodeURI(encodeURI(value));
    req.open("get", url + data);
    req.send(null);
}

function sdestinationChange(value) {
    var origin = document.getElementById("sorigin").value;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var lengthElement = document.getElementById("slength");
            lengthElement.value = req.responseText;
        }
    }
    var url = "/map/servlet/searchLength?";
    var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(value));
    req.open("get", url + data);
    req.send(null);
}

function submitChange() {
    var origin = document.getElementById("sorigin").value;
    var destination = document.getElementById("sdestination").value;
    var length = document.getElementById("slength").value;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var ret = req.responseText;
            if(ret == "true"){
                alert("修改成功!");
                document.getElementById("sorigin").value = "";
                document.getElementById("sdestination").value = "";
                document.getElementById("slength").value = "";
            }else{
                alert("修改失败!");
            }
            location.reload();
        }
    }
    var url = "/map/servlet/changeData?"
    var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(destination)) + "&length=" + length;
    req.open("get", url + data);
    req.send(null);
}









function coriginChange(value) {
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var str = req.responseText;
            var dests = str.split("#");
            var dest = document.getElementById("cdestination");
            dest.options.length=0;
            for(var i = 0; i < dests.length; i++){
                var newoption = new Option(dests[i], dests[i]);
                dest.options.add(newoption);
            }
            var tmp2 = document.getElementById("cdestination");
            cdestinationChange(tmp2[tmp2.selectedIndex].value);
        }
    }
    var url = "/map/servlet/searchDest?";
    var data = "origin=" + encodeURI(encodeURI(value));
    req.open("get", url + data);
    req.send(null);
}

function cdestinationChange(value) {
    var origin = document.getElementById("corigin").value;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var lengthElement = document.getElementById("clength");
            lengthElement.innerHTML = req.responseText;
        }
    }
    var url = "/map/servlet/searchLength?";
    var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(value));
    req.open("get", url + data);
    req.send(null);
}

function delPath() {
    var origin = document.getElementById("corigin").value;
    var destination = document.getElementById("cdestination").value;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState == 4 && req.status == 200){
            var ret = req.responseText;
            if(ret == "true"){
                alert("删除成功!");
                var tmp2 = document.getElementById("corigin");
                coriginChange(tmp2[tmp2.selectedIndex].value);
            }else{
                alert("删除失败!");
            }
            location.reload();
        }
    }
    var url = "/map/servlet/delPath?";
    var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(destination));
    req.open("get", url + data);
    req.send(null);
}
