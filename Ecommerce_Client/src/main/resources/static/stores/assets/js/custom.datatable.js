var table;

jQuery(document).ready(function() {
 table = $('#personTable').dataTable({
     "bPaginate": true,
     "order": [ 0, 'asc' ],
     "bInfo": true,
     "iDisplayStart":0,
     "bProcessing" : true,
    "bServerSide" : true,
    "sAjaxSource" : path+"/com/studywithdemo/JqueryDatatablePluginDemo.java",
    "dom": 'C<"clear">lfrtip',
   colVis: {
    "align": "right",
             restore: "Restore",
             showAll: "Show all",
             showNone: "Show none",
    order: 'alpha',
    "buttonText": "columns <img src=\"/datatableServersideExample/images/caaret.png\"/>"
         },
      "language": {
             "infoFiltered": ""
         },
         "dom": 'Cf<"toolbar"">rtip',
 
       })
     .columnFilter({
      aoColumns: [
               { type: "number"},
               { type: "text" },
               { type: "text" },
               { type: "text" },
               { type: "text" },
               { type: "text" },
       ],
      bUseColVis: true
      }).fnSetFilteringDelay();
   $("#personTable_length").hide();
   $("div.toolbar").append('<div class="btn-group" style="padding:5px "><button class="btn btn-default" id="refreshbtn" style="background:none;border:1px solid #ccc;height:30px"' 
    + 'type="button"><span class="glyphicon glyphicon-refresh" style="padding:3px"></span></button></div>');
      $("div.toolbar").css("float","right");
      $('#refreshbtn').click(function(){
       table.fnStandingRedraw();
     });
   

 });
