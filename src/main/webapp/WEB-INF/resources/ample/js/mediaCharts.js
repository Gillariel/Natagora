$(document).ready(function() {
    
    /**
     * 
     * Media by Type PIE Chart
     */
    var colors = [
        "#2cabe3",
        "#edf1f5",
        "#b4c1d7",
        "#53e69d",
        "#ff7676"
    ];
    
    var colorSize = 5;
    
    var byType = document.getElementById("byType").getContext("2d");
    var dataByType = [];

    $.each($("#byType").data("values"), function(i, item) {
        var colorNb = Math.floor(Math.random()*colorSize);
        var obj = new Object();
        obj["value"] = item[0];
        obj["label"] = item[1];
        obj["color"] = colors[colorNb];
        obj["highlight"] = colors[colorNb];
        dataByType.push(obj);
        colors.splice(colorNb, 1);
        colorSize--;
    });

    var byTypeChart = new Chart(byType).Pie(dataByType,{
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
    
    /**
     * 
     * History of created media LINE Chart
     */
    var newMedia = document.getElementById("newMedia").getContext("2d");

    var labels = [];
    var data = [];
    
    $.each($("#newMedia").data("values"), function(i, item) {
        labels.push(item[1]);
        data.push(item[0]);
    });
    
    var dataNewMedia = {
        labels: labels,
        datasets: [
            {
                label: "New Media",
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
    
    var newMediaChart = new Chart(newMedia).Line(dataNewMedia, {
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
    
    /**
     * 
     * History of pending media LINE Chart
     */
    var pendingMedia = document.getElementById("pendingMedia").getContext("2d");
    
    var labelsPending = [];
    var dataPending = [];
    
    $.each($("#pendingMedia").data("values"), function(i, item) {
        labelsPending.push(item[1]);
        dataPending.push(item[0]);
    });
    
    var dataPendingMedia = {
        labels: labelsPending,
        datasets: [
            {
                label: "New Media",
                fillColor: "rgba(44,171,227,0.8)",
                strokeColor: "rgba(44,171,227,0.8)",
                pointColor: "rgba(44,171,227,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(44,171,227,1)",
                data: dataPending
            }
        ]
    };
    
    var pendingMediaChart = new Chart(pendingMedia).Line(dataPendingMedia, {
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
});

