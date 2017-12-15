function newBird() {
                
    var name = $("#name").val();
    var length = $("#length").val();
    var weight = $("#weight").val();
    
    if(name !== '' && length !== '' && weight !== ''){

        var data = {
                id: 1,
                name: name,
                length: parseInt(length),
                weight: parseInt(weight)
        };
        
        console.log(JSON.stringify(data));
        
        $.ajax({
            url: "http://localhost:8081/NataRest/api/birds",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            headers: {
                'api-key': "136519fd-6d11-4a53-94e3-78f74abd56ee"
            },
            
            dataType: 'json',
            success: function (data) {
                alert("Bird has been created");
                console.info(data);
            },
            error: function (data) {
                alert("Request encountered error from server");
            }
        });
    } else {
        alert("Variable are not all set!");
    }
}

function putBird() {
    
    var name = $("#name").val();
    var length = $("#length").val();
    var weight = $("#weight").val();
    
    if(name !== '' && length !== '' && weight !== ''){

        var data = {
                id: 1,
                name: name,
                length: parseInt(length),
                weight: parseInt(weight)
        };
        
        console.log(JSON.stringify(data));
        
        $.ajax({
            url: "http://localhost:8081/NataRest/api/birds/" + id,
            type: 'PUT',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            headers: {
                'api-key': "136519fd-6d11-4a53-94e3-78f74abd56ee"
            },
            
            dataType: 'json',
            success: function (data) {
                alert("Bird has been created");
                console.info(data);
            },
            error: function (data) {
                alert("Request encountered error from server");
            }
        });
    } else {
        alert("Variable are not all set!");
    }
}

function deleteBird() {
                
    var name = $("#name").val();
    var length = $("#length").val();
    var weight = $("#weight").val();
    
    if(name !== '' && length !== '' && weight !== ''){

        var data = {
                id: 1,
                name: name,
                length: parseInt(length),
                weight: parseInt(weight)
        };
        
        console.log(JSON.stringify(data));
        
        $.ajax({
            url: "http://localhost:8081/NataRest/api/birds/" + id,
            type: 'DELETE',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            headers: {
                'api-key': "136519fd-6d11-4a53-94e3-78f74abd56ee"
            },
            
            dataType: 'json',
            success: function (data) {
                alert("Bird has been created");
                console.info(data);
            },
            error: function (data) {
                alert("Request encountered error from server");
            }
        });
    } else {
        alert("Variable are not all set!");
    }
}