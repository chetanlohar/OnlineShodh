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

/*======================================
Business contact and feature update and add
========================================*/

$(document).ready(function(){
	$("#town").on('change',function(){
	var temp = $("#town").val();
	alert(temp);
		if(temp != '25'){
			$(".hide-div").hide();
		}
		else{
			
			$(".hide-div").show();
		}
	});
	
	$("#town1").on('change',function(){
		var temp = $("#town1").val();
		alert(temp);
			if(temp != '25'){
				$(".hide-div").hide();
			}
			else{
				
				$(".hide-div").show();
			}
		});
	
	 var i=0;
	 var j=0;
	 var m=0;
	 var n=0;
	  $('.b_contact').click(function(e){
		  e.preventDefault();
          var url = $(this).attr('href');
          var contact = $('#contact').val();
          
	
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

	  
	  
	  $('.bd_contact').click(function(e){
		  e.preventDefault();
		 
          var url = $(this).attr('href');
          var contact = $('#bdetail_contact').val();
       
		
	      $.ajax({
	        url:url,
	        timeout:5000,
	        success: function(){
	        
	        	m++;
	        	$('#busi_contact tbody').append('<tr class="child"><td>'+m+'</td><td>contact '+m+' </td><td>'+contact+'</td></tr>');

	        },
	        error: function(){
	     
	          
	        },
	        
	      });
	      $('#bdetail_contact').val('');
	  });
	  
	  
	  $('.bd_features').click(function(e){
		  e.preventDefault();
          var url = $(this).attr('href');
          var features = $('#bus_Features').val();
          
	
	      $.ajax({
	        url:url,
	        timeout:5000,
	        success: function(){
	        	alert("work");
	        	n++;
	        	$('.busi_feature tbody').append('<tr class="child"><td>'+n+'</td><td>'+features+'</td></tr>');

	        },
	        error: function(){
	     alert("not working");
	          
	        },
	        
	      });
	      $('#bus_Features').val('');
	  });

	  $('.sandbox-container input').datepicker({
		  autoclose: true,
		    todayHighlight: true
	  });

});