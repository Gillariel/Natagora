$(document).ready(function(){
    setDeleteClick();
    
    function setDeleteClick() {
        $('.delete-btn').on('click', function() {
            var id = $(this).data("id");
            var line = $(this).parent().parent();

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
                            url: "https://192.168.128.13:8444/NataRest/api/sessions/" + id,
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
                        title: 'Session' + id + ' has correctly been deleted!'
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
