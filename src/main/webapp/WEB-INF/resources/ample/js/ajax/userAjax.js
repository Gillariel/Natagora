$(document).ready(function(){
    setEditClick();
    setDeleteClick();

    $('#newAdmin').on('click', function() {
        var id, pseudo, name, forname, mail, password, picture, roleID, role;
        role = "Admin";
        roleID = 2;
        swal({
            title: 'Create a new Admin',
            showCancelButton: true,
            confirmButtonText: 'Create',
            html:
                '<input type="text" id="swal-input1" class="swal2-input" autofocus="true" placeholder="Admin\'s pseudo" />' +
                '<input type="text" id="swal-input2" class="swal2-input pull-left" placeholder="Admin\'s Name" />' +
                '<input type="text" id="swal-input3" class="swal2-input pull-right" placeholder="Admin\'s Forname" />' +
                '<input type="text" id="swal-input4" class="swal2-input pull-left" placeholder="Admin\'s Mail" />' +
                '<input type="password" id="swal-input5" class="swal2-input pull-right" placeholder="Admin\'s Password" />' +
                '<input type="text" required="false" id="swal-input6" class="swal2-input" placeholder="Admin\'s Photo link" />',
            preConfirm: function() {
                return new Promise(function(resolve) {
                    pseudo = $('#swal-input1').val();
                    name = $('#swal-input2').val();
                    forname = $('#swal-input3').val();
                    mail = $('#swal-input4').val();
                    password = $('#swal-input5').val();
                    picture = $('#swal-input6').val();
                    var data = {
                        id: 1,
                        name: name,
                        forname: forname,
                        pseudo: pseudo,
                        mail: mail,
                        password: password,
                        picture: picture,
                        role: {
                            id: 2,
                            name: "Admin"
                        },
                        fullName: forname + " " + name 
                    };
                    console.log(JSON.stringify(data));
                    $.ajax({
                        url: "http://192.168.128.13:8081/NataRest/api/users",
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
            if(resolve === "true") {
                $('#example').find('tbody').append( '<tr role="row">' +
                    '<td>' + id + '</td>' +
                    '<td>' + forname + ' ' + name + '</td>' +
                    '<td>' + pseudo + '</td>' +
                    '<td>' + mail + '</td>' +
                    '<td>Admin</td>' +
                    '<td><a data-id="' + id + '" data-name ="' + name + '" data-forname="' + forname + '" data-pseudo="' + pseudo +  '" data-mail="' + mail + '" data-password="' + password + '" data-roleID="' + roleID + '" data-roleName="' + role + '" class="edit-btn"><i class="fa fa-pencil-square-o fa-2x"></i> </a>' +
                    '<a data-id="' + id + '" data-name ="' + name + '" class="delete-btn"><i class="fa fa-trash-o fa-2x"></i> </a></td>' +
                    '</tr>'
                );
                setEditClick();
                swal({
                    type:'success',
                    title:'User has been created'
                });
            } else if(resolve === "false"){
                swal({
                    type: 'error',
                    title: 'Server failed to response :('
                });
            }
        });
    });

    function setEditClick() {
        $('.edit-btn').on('click', function() {
            var id = $(this).data("id");
            var pseudo = $(this).data('pseudo');
            var name = $(this).data('name');
            var forname = $(this).data('forname');
            var mail = $(this).data('mail');
            var password = $(this).data('password');
            var picture = $(this).data('picture');
            var roleID = $(this).data('roleID');
            var role = $(this).data('roleName');
            
            var tbody = $(this).parent().parent().parent();
            var line = $(this).parent().parent();

            swal({
                title: 'Edit "' + pseudo + '"',
                showCancelButton: true,
                confirmButtonText: 'Update',
                html:
                    '<input type="text" id="swal-input1" class="swal2-input" autofocus="true" value="' + pseudo + '" />' +
                    '<input type="text" id="swal-input2" class="swal2-input pull-left" value="' + name + '" />' +
                    '<input type="text" id="swal-input3" class="swal2-input pull-right" value="' + forname + '" />' +
                    '<input type="text" id="swal-input4" class="swal2-input pull-left" value="' + mail  + '" />' +
                    '<input type="password" id="swal-input5" class="swal2-input pull-right" value="' + password + '" />' +
                    '<input type="text" required="false" id="swal-input6" class="swal2-input" value="' + picture + '" />',
                preConfirm: function() {
                    return new Promise(function(resolve) {
                        var isOneInputIsChanged = (
                                pseudo !== $('#swal-input1').val() ||
                                name !== $('#swal-input2').val() ||
                                forname !== $('#swal-input3').val() ||
                                mail !== $('#swal-input4').val() ||
                                password !== $('#swal-input5').val() ||
                                picture !== $('#swal-input6').val()
                        );
                        //ajax here to, see delete for example
                        if (isOneInputIsChanged) {
                            pseudo = $('#swal-input1').val();
                            name = $('#swal-input2').val();
                            forname = $('#swal-input3').val();
                            mail = $('#swal-input4').val();
                            password = $('#swal-input5').val();
                            picture = $('#swal-input6').val();
                            var data = {
                                id: id,
                                name: name,
                                forname: forname,
                                pseudo: pseudo,
                                mail: mail,
                                password: password,
                                picture: picture,
                                role: {
                                    id: roleID,
                                    name: role
                                },
                                fullName: forname + " " + name 
                            };
                            $.ajax({
                                url: "http://192.168.128.13:8081/NataRest/api/users/" + id,
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
                if(resolve === "true") {
                    line.remove();
                    tbody.append( '<tr role="row">' +
                        '<td>' + id + '</td>' +
                        '<td>' + forname + ' ' + name + '</td>' +
                        '<td>' + pseudo + '</td>' +
                        '<td>' + mail + '</td>' +
                        '<td>' + role + '</td>' +
                        '<td><a data-id="' + id + '" data-name ="' + name + '" data-forname="' + forname + '" data-pseudo="' + pseudo +  '" data-mail="' + mail + '" data-password="' + password + '" data-roleID="' + roleID + '" data-roleName="' + role + '" class="edit-btn"><i class="fa fa-pencil-square-o fa-2x"></i> </a>' +
                        '<a data-id="' + id + '" data-name ="' + name + '" class="delete-btn"><i class="fa fa-trash-o fa-2x"></i> </a></td>' +
                        '</tr>'
                    );
                    setEditClick();
                    swal({
                        type:'success',
                        title:'User has been updated!'
                    });
                } else if(resolve === "false") {
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
                            url: "http://192.168.128.13:8081/NataRest/api/users/" + id,
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
                if (resolve === "true") {
                    swal({
                        type: 'success',
                        title: name + ' has correctly been deleted!'
                    }).then(function(){
                        line.remove();
                    });  
                }else if(resolve === "false"){
                    swal({
                        type: 'error',
                        title: 'Server failed to response :('
                    });
                }
            });
        });
    };

});