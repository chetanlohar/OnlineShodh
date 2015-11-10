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
	
		if(temp != '25'){
			$(".hide-div").hide();
		}
		else{
			
			$(".hide-div").show();
		}
	});
	
	$("#town1").on('change',function(){
		var temp = $("#town1").val();
	
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
	  
	  $('#phonebutton').click(function(e){
          var url = $('#phoneurl').val();
          var contact = $('#bdetail_contact').val();
	      $.ajax({
	    	type: "POST",
	        url:url,
	        dataType:"json",
	        timeout:5000,
	        data:{
	        	"businessPhone" :contact
	        },
	        success: function(response){
	        	console.log(response);
	        	$('.busi_contact tbody tr').remove();
	        	jQuery.each(response, function(index, item) {
	        		$('.busi_contact tbody').append('<tr class="child"><td>'+this.buinessPhoneId+'</td><td>'+this.phone+'</td><td><a href="#"><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit</button></a></td><td><a href="#"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a></td></tr>');
				});

	        },
	        error: function(e){
	        	console.log("In error BusinessPhone Ajax: "+e);
	        },
	        
	      });
	      $('#bdetail_contact').val('');
	  });
	  
	  
	  
	  
	  $("#bus_Features").keypress(function(e) {
		    if(e.which == 13) {
		        $("#featurebutton").click();
		    }
		});
	  
	  $('#featurebutton').click(function(e){
          /*var url = $(this).attr('href');*/
          var url = $('#featureurl').val();
          var feature = $('#bus_Features').val();
	      $.ajax({
	    	  	type: "POST",
		        url:url,
		        dataType:"json",
		        timeout:5000,
		        data:{
		        	"generalInfo" :feature
		        },
		        success: function(response){
		        	console.log(response);
		        	
		        	$('.busi_feature tbody tr').remove();
		        	jQuery.each(response, function(index, item) {
		        		$('.busi_feature tbody').append('<tr class="child"><td>'+this.businessGenInfoId+'</td><td>'+this.generalInfoName+'</td><td><a href="#"><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Modify</button></a></td><td><a href="#"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a></td></tr>');
					});
		        },
		        error: function(){
		        	console.log("not working");
	        },
	      });
	      $('#bus_Features').val('');
	  });

	  $('.sandbox-container input').datepicker({
		  autoclose: true,
		    todayHighlight: true
		    
	  });
	  
	  /*======================================
	  Payment Moade Hide Div script
	  ========================================*/
		$("#payfor").on('change',function(e){
			e.preventDefault();
			var temp = $("#payfor").val();
	
				if(temp === 'BusinessAdvertisement'){
					$(".hide_banner").hide();
					$(".hide_business").show();
					
				}
				else if(temp == 'BannerAdvertisement'){
					
					$(".hide_banner").show();
					$(".hide_business").hide();
				}
				else{
					$(".hide_banner").hide();
					$(".hide_business").show();
				}
			});
		
		
		
		$("#pay_mode").on('change',function(e){
			e.preventDefault();
			var temp1 = $("#pay_mode").val();
	
				if(temp1 == '1'){
					$(".hide_cheque").hide();
					$(".hide_cashamount").show();
					
				}
				else if(temp1 == '2'){
					
					$(".hide_cashamount").hide();
					$(".hide_cheque").show();
				}
				else{
					$(".hide_cashamount").show();
				
				}
			});
	  
	  

});