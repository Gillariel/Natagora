$(document).ready(function() {
    
    var colors = [
        "#2cabe3",
        "#edf1f5",
        "#b4c1d7",
        "#53e69d",
        "#ff7676"
    ];
    
    var colorSize = 5;
    
    var roles = document.getElementById("roles").getContext("2d");
    var rolesData = [];

    console.log($("#roles").data("values"));

    $.each($("#roles").data("values"), function(i, item) {
        var colorNb = Math.floor(Math.random()*colorSize);
        var obj = new Object();
        obj["value"] = item[0];
        obj["label"] = item[1];
        obj["color"] = colors[colorNb];
        obj["highlight"] = colors[colorNb];
        rolesData.push(obj);
        colors.splice(colorNb, 1);
        colorSize--;
    });

    var rolesChart = new Chart(roles).Pie(rolesData,{
        segmentShowStroke : true,
        segmentStrokeColor : "#fff",
        segmentStrokeWidth : 0,
        animationSteps : 100,
        tooltipCornerRadius: 0,
        animationEasing : "easeOutBounce",
        animateRotate : true,
        animateScale : false,
        legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>",
        responsive: true
    });
    
    var newUsers = document.getElementById("newUsers").getContext("2d");
    
    
    var labels = [];
    var data = [];
    
    $.each($("#newUsers").data("values"), function(i, item) {
        labels.push(item[1]);
        data.push(item[0]);
    });
    
    var dataNewUsers = {
        labels: labels,
        datasets: [
            {
                label: "new Users",
                fillColor: "rgba(44,171,227,0.8)",
                strokeColor: "rgba(44,171,227,0.8)",
                pointColor: "rgba(44,171,227,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(44,171,227,1)",
                data: data
            }
        ]
    };
    
    var newUsersChart = new Chart(newUsers).Line(dataNewUsers, {
        scaleShowGridLines : true,
        scaleGridLineColor : "rgba(0,0,0,.005)",
        scaleGridLineWidth : 0,
        scaleShowHorizontalLines: true,
        scaleShowVerticalLines: true,
        bezierCurve : true,
        bezierCurveTension : 0.4,
        pointDot : true,
        pointDotRadius : 4,
        pointDotStrokeWidth : 1,
        pointHitDetectionRadius : 2,
        datasetStroke : true,
	tooltipCornerRadius: 2,
        datasetStrokeWidth : 2,
        datasetFill : true,
        legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
        responsive: true
    });
    
    
    var vsFb = document.getElementById("vsFb").getContext("2d");
    var values = $("#vsFb").data('values');
    var dataVsFb = {
        labels: ["Facebook", "Normal"],
        datasets: [
            {
                label: "Facebook",
                fillColor: "rgba(44,171,227,0.8)",
                strokeColor: "rgba(44,171,227,0.8)",
                highlightFill: "rgba(44,171,227,1)",
                highlightStroke: "rgba(44,171,227,1))",
                data: [values[1][0],values[0][0]]
            }
        ]
    };
    
    var vsFbChart = new Chart(vsFb).Bar(dataVsFb, {
        scaleBeginAtZero : true,
        scaleShowGridLines : true,
        scaleGridLineColor : "rgba(0,0,0,.005)",
        scaleGridLineWidth : 0,
        scaleShowHorizontalLines: true,
        scaleShowVerticalLines: true,
        barShowStroke : true,
        barStrokeWidth : 0,
        tooltipCornerRadius: 2,
        barDatasetSpacing : 3,
        legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
        responsive: true
    });
});

