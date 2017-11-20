$(document).ready(function () {
     
    var paths = location.pathname.split("/");
    var current = paths[2].split(".")[0].toString();
    $("#"+current).addClass('active');
    
    $("#breadcumb-title").text(document.title);
    
    if(current !== "dashboard"){
        $("#breadcumb-message").text("");
    }
    
    // 0 is server name, 1 is project name
    // paths length - 1 to avoid non necesseary if on last index and just do it after the loop 
    for(var i = 2; i < paths.length - 1; i++){
        var links = location.pathname.split("/", i+1), link = "";
        for(var j = 2; j < links.length; j++)
            link += "/" + links[j];
        $("#breadcumb-chain").append("<li><a href=\"/NatAdmin" + link + ".xhtml\">" + paths[i].toString() + "</a></li>");
    }
    $("#breadcumb-chain").append("<li class=\"active\">" + paths[paths.length - 1].split(".")[0].toString() + "</li>");
    
    
});