/*=============================================================

   
========================================================  */           

$(document).ready(function () {

    /*====================================
           METIS MENU 
     ======================================*/

    $('#main-menu').metisMenu();

    /*======================================
    LOAD APPROPRIATE MENU BAR ON SIZE SCREEN
    ========================================*/

    $(window).bind("load resize", function () {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse')
        } else {
            $('div.sidebar-collapse').removeClass('collapse')
        }
    });
 
    
    
});


$(document).ready(function(){
	 /* var container = $('#page-inner');
	  alert("hi out of ajax");
	  $('.edit').click(function(){
		  alert(" hi in ajax");
	    doAjax($(this).attr('href'));
	    return false;
	  });
	  function doAjax(url){
	    if(url.match('^http')){
	      var errormsg = 'AJAX cannot load external content';
	      container.html(errormsg);
	    } else {
	      $.ajax({
	        url: url,
	        timeout:5000,
	        success: function(data){
	          container.html(data);
	        },
	        error: function(req,error){
	          if(error === 'error'){error = req.statusText;}
	          var errormsg = 'There was a communication error: '+error;
	          container.html(errormsg);
	        },
	        beforeSend: function(data){
	          container.html('<p>Loading...</p>');
	        }
	      });
	    }
	  }*/

	    
	    $('.sandbox-container input').datepicker({
	        orientation: "top left",
	        autoclose: true
	    });
});