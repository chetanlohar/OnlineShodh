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
	 var i=0;
	 var j=0;
	  $('.b_contact').click(function(e){
		  e.preventDefault();
          var url = $(this).attr('href');
          var contact = $('#contact').val();
          
		alert(url);
	      $.ajax({
	        url:url,
	        timeout:5000,
	        success: function(){
	        	i++;
	        	$('#contact_table tbody').append('<tr class="child"><td>'+i+'</td><td>contact '+i+' </td><td>'+contact+'</td></tr>');

	        },
	        error: function(){
	     
	          
	        },
	        
	      });
	      $('#contact').val('');
	  });
	  
	  
	  $('.b_features').click(function(e){
		  e.preventDefault();
          var url = $(this).attr('href');
          var features = $('#Features').val();
          
		alert(url);
	      $.ajax({
	        url:url,
	        timeout:5000,
	        success: function(){
	        	alert("work");
	        	j++;
	        	$('.feature_table tbody').append('<tr class="child"><td>'+j+'</td><td>'+features+'</td></tr>');

	        },
	        error: function(){
	     alert("not working");
	          
	        },
	        
	      });
	      $('#Features').val('');
	  });


	    
	    $('.sandbox-container input').datepicker({
	        orientation: "top left",
	        autoclose: true
	    });
});