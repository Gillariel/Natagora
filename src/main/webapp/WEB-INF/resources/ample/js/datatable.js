$(document).ready(function() {
    $(document).ready(function() {
        var table = $('#example').DataTable({
            "columnDefs": [{
                "targets": 0
            }],
            "order": [
                [1, 'asc']
            ],
            "displayLength": 25,
            dom: 'Bfrtip',
            lengthChange: false,
            buttons: [
                'copy', 'excel', 'pdf', 'print', 'colvis'
            ]
        });

        
        table.buttons().container()
            .appendTo( '#example_wrapper .col-sm-6 .btn .btn-default' );
    });
});
