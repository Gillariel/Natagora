$(document).ready(function(){
    setEditClick();
    setDeleteClick();

    $('#newBird').on('click', function() {
        var id, name, length, weight, pColor, sColor, url;
        swal({
            title: 'Create a new Bird',
            showCancelButton: true,
            confirmButtonText: 'Create',
            html:
                '<input type="text" id="swal-input1" class="swal2-input" autofocus="true" placeholder="Name of Bird" />' +
                '<input type="number" id="swal-input2" class="swal2-input pull-left" placeholder="Bird\'s length" />' +
                '<input type="number" id="swal-input3" class="swal2-input pull-right" placeholder="Bird\'s weight" />' +
                '<select id="swal-input4" class="swal2-input pull-left"> <option value="" disabled selected>Select the primary color</option> <option value="Black">Black</option> <option value="White">White</option> <option value="Yellow">Yellow</option> <option value="Orange">Orange</option> <option value="Red">Red</option> <option value="Blue">Blue</option> <option value="Green">Green</option> <option value="Brown">Brown</option> <option value="Grey">Grey</option> <option value="Beige">Beige</option> </select>' +
                '<select id="swal-input5" class="swal2-input pull-right"> <option value="" disabled selected>Select the secondary color</option> <option value="Black">Black</option> <option value="White">White</option> <option value="Yellow">Yellow</option> <option value="Orange">Orange</option> <option value="Red">Red</option> <option value="Blue">Blue</option> <option value="Green">Green</option> <option value="Brown">Brown</option> <option value="Grey">Grey</option> <option value="Beige">Beige</option> </select>' +
                '<input type="text" id="swal-input6" class="swal2-input" placeholder="Url of this bird picture" />',
            preConfirm: function() {
                return new Promise(function(resolve) {
                    name = $('#swal-input1').val();
                    length = $('#swal-input2').val();
                    weight = $('#swal-input3').val();
                    pColor = $('#swal-input4').val();
                    sColor = $('#swal-input5').val();
                    url = $('#swal-input6').val();
                    var data = {
                        id: 1,
                        name: name,
                        length: parseInt(length),
                        weight: parseInt(weight),
                        primaryColor: pColor,
                        secondaryColor: sColor,
                        url: url,
                        date: ""
                    };
                    console.log(JSON.stringify(data));
                    $.ajax({
                        url: "https://192.168.128.13:8444/NataRest/api/birds",
                        type: 'POST',
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        data: JSON.stringify(data),
                        headers: {
                            'api-key': "136519fd-6d11-4a53-94e3-78f74abd56ee"
                        },
                        success: function (data) {
                            id = data.id;
                            resolve("true");
                        },
                        error: function () {
                            resolve("false");
                        }
                    });
                });
            }
        }).then(function(resolve) {
            if(resolve.value === "true") {
                $('#example').find('tbody').append( '<tr role="row">' +
                    '<td>' + id + '</td>' +
                    '<td>' + name + '</td>' +
                    '<td>' + length + '</td>' +
                    '<td>' + weight + '</td>' +
                    '<td>' + pColor + '</td>' +
                    '<td>' + sColor + '</td>' +
                    '<td><a href="/NatAdmin/data/birds/see?id=' + id + '"><i class="fa fa-eye fa-2x"></i> </a>' +
                    '<a data-id="' + id + '" data-name ="' + name + '" data-length="' + length + '" data-weight="' + weight + '" data-url="' + url + '" data-pcolor="' + pColor + '" data-scolor="' + sColor + '" class="edit-btn"><i class="fa fa-pencil-square-o fa-2x"></i> </a>' +
                    '<a data-id="' + id + '" data-name="' + name + '" class="delete-btn"><i class="fa fa-trash-o fa-2x"></i> </a></td>' +
                    '</tr>'
                );
                setEditClick();
                swal({
                    type:'success',
                    title:'Bird has been created'
                });
            } else if(resolve.value === "false"){
                swal({
                    type: 'error',
                    title: 'Server failed to response :('
                });
            }
        });
    });

    function setEditClick() {
        $('.edit-btn').on('click', function() {
            var name = $(this).data("name");
            var length = $(this).data('length');
            var weight = $(this).data('weight');
            var pColor = $(this).data('pcolor');
            var sColor = $(this).data('scolor');
            var url = $(this).data('url');
            var id = $(this).data("id");
            var tbody = $(this).parent().parent().parent();
            var line = $(this).parent().parent();

            swal({
                title: 'Edit "' + name + '"',
                showCancelButton: true,
                confirmButtonText: 'Update',
                html:
                    '<input type="text" id="swal-input1" class="swal2-input" autofocus="true" value="' + name +'" />' +
                    '<input type="number" id="swal-input2" class="swal2-input" value="' + length +'" />' +
                    '<input type="number" id="swal-input3" class="swal2-input" value="' + weight +'" />' +
                    '<select id="swal-input4" class="swal2-input pull-left"> <option value="" disabled selected>Change the primary color</option> <option value="Black">Black</option> <option value="White">White</option> <option value="Yellow">Yellow</option> <option value="Orange">Orange</option> <option value="Red">Red</option> <option value="Blue">Blue</option> <option value="Green">Green</option> <option value="Brown">Brown</option> <option value="Grey">Grey</option> <option value="Beige">Beige</option> </select>' +
                    '<select id="swal-input5" class="swal2-input pull-right"> <option value="" disabled selected>Change the secondary color</option> <option value="Black">Black</option> <option value="White">White</option> <option value="Yellow">Yellow</option> <option value="Orange">Orange</option> <option value="Red">Red</option> <option value="Blue">Blue</option> <option value="Green">Green</option> <option value="Brown">Brown</option> <option value="Grey">Grey</option> <option value="Beige">Beige</option> </select>' +
                    '<input type="text" id="swal-input6" class="swal2-input" value="' + url + '" />',
                preConfirm: function() {
                    return new Promise(function(resolve) {
                        var isOneInputIsChanged = (
                                name !== $('#swal-input1').val() ||
                                length !== $('#swal-input2').val() ||
                                weight !== $('#swal-input3').val() ||
                                pColor !== $('#swal-input4').val() ||
                                sColor !== $('#swal-input5').val() ||
                                url !== $('#swal-input6').val()
                        );
                        //ajax here to, see delete for example
                        if (isOneInputIsChanged) {
                            name = $('#swal-input1').val();
                            length = $('#swal-input2').val();
                            weight = $('#swal-input3').val();
                            pColor = $('#swal-input4').val();
                            sColor = $('#swal-input5').val();
                            url = $('#swal-input6').val();
                            var data = {
                                id: id,
                                name: name,
                                length: parseInt(length),
                                weight: parseInt(weight),
                                primaryColor: pColor,
                                secondaryColor: sColor,
                                url: url,
                                date: ""
                            };
                            $.ajax({
                                url: "https://192.168.128.13:8444/NataRest/api/birds/" + id,
                                type: 'PUT',
                                contentType: "application/json; charset=utf-8",
                                data: JSON.stringify(data),
                                headers: {
                                    'api-key': "136519fd-6d11-4a53-94e3-78f74abd56ee"
                                },
                                success: function () {
                                    resolve("true");
                                },
                                error: function () {
                                    resolve("false");
                                }
                            });
                        }
                    });
                }
            }).then(function(resolve) {
                if(resolve.value === "true") {
                    line.remove();
                    tbody.append( '<tr role="row">' +
                        '<td>' + id + '</td>' +
                        '<td>' + name + '</td>' +
                        '<td>' + length + '</td>' +
                        '<td>' + weight + '</td>' +
                        '<td>' + pColor + '</td>' +
                        '<td>' + sColor + '</td>' +
                        '<td><a href="/NatAdmin/data/birds/see?id=' + id + '"><i class="fa fa-eye fa-2x"></i> </a>' +
                        '<a data-id="' + id + '" data-name ="' + name + '" data-length="' + length + '" data-weight="' + weight + '" data-url="' + url + '" data-pcolor="' + pColor + '" data-scolor="' + sColor + '" class="edit-btn"><i class="fa fa-pencil-square-o fa-2x"></i> </a>' +
                        '<a data-id="' + id + '" data-name="' + name + '" class="delete-btn"><i class="fa fa-trash-o fa-2x"></i> </a></td>' +
                        '</tr>'
                    );
                    setEditClick();
                    swal({
                        type:'success',
                        title:'Bird has been updated!'
                    });
                } else if(resolve.value === "false") {
                    swal({
                        type: 'error',
                        title: 'Server failed to response :('
                    });
                }
            });
        });
    };

    function setDeleteClick() {
        $('.delete-btn').on('click', function() {
            var id = $(this).data("id");
            var line = $(this).parent().parent();
            var name = $(this).data("name");

            swal({
                title: 'Are you sure?',
                text: "Delete cannot be undone!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Delete',
                confirmButtonColor: '#3085d6',
                cancelButtonText: 'No!',
                showLoaderOnConfirm: true,
                preConfirm: function () {
                    return new Promise(function (resolve) {
                        $.ajax({
                            url: "https://192.168.128.13:8444/NataRest/api/birds/" + id,
                            type: 'DELETE',
                            data: { },
                            headers: {
                                'api-key': "136519fd-6d11-4a53-94e3-78f74abd56ee"
                            },
                            success: function() {
                                resolve("true");
                            },
                            error: function(data, error){
                                console.log(error);
                                resolve("false");
                            }
                        });
                    });
                },
                allowOutsideClick: false
            }).then(function (resolve) {
                if (resolve.value === "true") {
                    swal({
                        type: 'success',
                        title: name + ' has correctly been deleted!'
                    }).then(function(){
                        line.remove();
                    });  
                }else if(resolve.value === "false"){
                    swal({
                        type: 'error',
                        title: 'Server failed to response :('
                    });
                }
            });
        });
    };

});
