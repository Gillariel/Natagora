$( document ).ready(function() {
    
    var ctx4 = document.getElementById("chart4").getContext("2d");
    var all = $("#chart4").data("all");
    var newU = $("#chart4").data("number");
    var diff = all - newU;
    var data4 = [
        {
            value: diff,
            color:"#2cabe3",
            highlight: "#2cabe3",
            label: "Old Users"
        },
        {
            value: newU,
            color: "#ff7676",
            highlight: "#ff7676",
            label: "New Users"
        }
    ];
    
    var myDoughnutChart = new Chart(ctx4).Doughnut(data4,{
        segmentShowStroke : true,
        segmentStrokeColor : "#fff",
        segmentStrokeWidth : 0,
        animationSteps : 100,
		tooltipCornerRadius: 2,
        animationEasing : "easeOutBounce",
        animateRotate : true,
        animateScale : false,
        legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>",
        responsive: true
    }); 
});