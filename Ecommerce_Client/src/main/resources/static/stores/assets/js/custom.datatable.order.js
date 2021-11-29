var arrayExport = [2,3,4,5,6,7,8,9,11,12,13,14,15,16];
$(document).ready(function() {		
	$('#example1').DataTable({
		responsive: true, lengthChange: true, autoWidth: false,
		pageLength : 5,
		ajax : {
			url : path + '/transaction/findAllOrder',
			dataSrc : ''
		},
		columns : [ 
			{
				title: '<input name="select_all" id="example-select-all" type="checkbox" />',
				data: 'id'				
          	},
			{title : '#', data : null},
		 	{title : 'Name', data : 'productName'},
			{title : 'Price', data : 'price'},
			{title : 'Quantity', data : 'quantity'},
			{title : 'Tax', data : 'tax'},
			{title : 'Note', data : 'note'},
			{title : 'Status', data : 'status'},			
			{data: null, defaultContent: ''}
		],
		columnDefs : [
			{				
			    'targets': 0,
		         'searchable':false,
		         'orderable':false,
		         'className': 'dt-body-center',
		         'render': function (data, type, full, meta){
		             return '<input type="checkbox" name="editor-active" value="' 
		                + $('<div/>').text(data).html() + '">';
				}
         	},
            {
                targets: 1,
                width: 10,
				searchable: false,
                orderable: false
            },
            {
                targets: 2,
                render: catalogDrillDownFormatter
            },	
            {
                targets: -2,
                width: 65,
				render: statusFormatter
            },
			{
				className: 'dtr-control',
	            orderable: false,
	            targets:   -1
			}
        ],
		select: {
            style: 'multi'
        },
		responsive: {
            details: {
                type: 'column',
                target: -1
            }
        },
		order: [[ 2, 'asc' ]]	  
    });
	codeListTable = $("#example1").DataTable();
	codeListTable.on( 'draw.dt', function () {
    var PageInfo = $('#example1').DataTable().page.info();
         codeListTable.column(1, { page: 'current' }).nodes().each( function (cell, i) {
            cell.innerHTML = i + 1 + PageInfo.start;
        } );
    } );
        new $.fn.dataTable.Buttons( codeListTable, {
            buttons: [
				{
		            text: '<i class="fa fa-plus-square" aria-hidden="true"></i> Add',
					className: 'btn btn-new-index btn-success',
		            action: function ( e, dt, node, config ) {
		               window.location=path + "/home/product/add";
		            }
		        },
				{
		            text: '<i class="fa fa-trash" aria-hidden="true"></i> Delete',
					className: 'btn btn-new-index btn-danger btn-delete',
		            action: function ( e, dt, node, config ) {
			 			//window.location=path + "/home/product/add";
						//Delete function
		            }
		        },
                {
                extend:    'excel',
                text:      '<i class="fa fa-files-o"></i> Excel',
                titleAttr: 'Export to Excel',
                className: 'btn btn-default btn-sm',
                exportOptions: { 
							columns: function () { return arrayExport; }}
                },
                {
                extend:    'print',
                text:      '<i class="fa fa-print"></i> Print',
                titleAttr: 'Print table',
                className: 'btn btn-default btn-sm',
                exportOptions: { 
							columns: function () { return arrayExport; }}
                },
				{
                extend:    'colvis',
                text:      '<i class="fa fa-files-o"></i> Column Visibility',
                titleAttr: 'Column Visibility',
                className: 'btn btn-default btn-sm',
                exportOptions: { 
							columns: function () { return arrayExport; }}
                }, 
            ]
        } );
		//#example1_filter
        codeListTable.buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
	// Handle click on "Select all" control
   $('#example-select-all').on('click', function(){
      // Check/uncheck all checkboxes in the table
      var rows = codeListTable.rows({ 'search': 'applied' }).nodes();
      $('input[type="checkbox"]', rows).prop('checked', this.checked);
   });
	//delete product
	function deleteProducts(p1, p2) {
	  // The function returns the product of p1 and p2
	}
	//delete from here 11:21 11/22/2021******************	
   // Handle click on checkbox to set state of "Select all" control
   $('#example1 tbody').on('change', 'input[type="checkbox"]', function(){
      // If checkbox is not checked
      if(!this.checked){
         var el = $('#example-select-all').get(0);
         // If "Select all" control is checked and has 'indeterminate' property
         if(el && el.checked && ('indeterminate' in el)){
            // Set visual state of "Select all" control 
            // as 'indeterminate'
            el.indeterminate = true;
         }
      }
   });	

	$('.btn-delete').click(function() { 
		var names = [];       
        $('#example1 input:checked').each(function() {
            if(this.value != 'on'){
				names.push(this.value);
			}
        });
		console.log(names);
		if(names.length !== 0 && names){
			Swal.fire({
			  title: 'Are you sure?',
			  text: "You won't be able to revert this!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
			  if (result.isConfirmed) {
				$.ajax({
				  url: path + "/product/deleteListProduct/" + names,
				  type: 'DELETE'
				}).done(function() {
					Swal.fire({
				      title: 'Deleted!',
				      text : 'Your file has been deleted.',
				      icon : 'success'
				    }).then(function() {
			            location.reload();
			        });
				}).fail(function() {
				    Swal.fire({
					  icon: 'error',
					  title: 'Oops...',
					  text: 'Something went wrong!',
					});
				});		    
			  }
			})		
		}
        // now names contains all of the names of checked checkboxes
        // do something with it
    });
});
