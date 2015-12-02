/*=============================================================

   
========================================================  */           
var AJURL;
var AJXURL;
var Bflag=false;
var Bflag1=false; 

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

	/*$("#main-menu ul li a").on("click",function(e){
	e.preventDefault()
	$(this).parent().addClass('active-menu');
	$(this).parent().siblings().removeClass('active-menu');
	$(this).parent().parent().siblings().removeClass('active-menu');
	});
*/	
	$("#bphoneTable").on('click','.Bupcontact',function(e){
	var valc =$(this).parent().siblings(":nth-child(2)").text()
	var valcid =$(this).parent().siblings(":nth-child(1)").text()

	$("#bdetail_contact").val(valc);
	
    $(".b_contact").html('Update');
	
   var BPhoneURl=$("#Bphoneurl1").val();
    AJURL=BPhoneURl+valcid;
    Bflag=true;
    
	});
	
	
	$(".busi_feature").on('click','.modyfeature',function(e){
		alert("work");
		var valf =$(this).parent().siblings(":nth-child(2)").text()
	     $("#bus_Features").val(valf);
		var valfid =$(this).parent().siblings(":nth-child(1)").text()
	    var BFeatureUrl=$('#BFeatureUrl1').val()
	    AJXURL=BFeatureUrl+valfid
	    Bflag1=true;
		$("#featurebutton").html('Update');
		
		});
		
	
	
	
	
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
	  
	  $('#Bphonebutton').click(function(e){
          var phonebyajaxURl;
		  var contact = $('#bdetail_contact').val();
          var phonetype = $('#bdetail_phonetype').val();
          $("#phonebutton").html('Add');
         
         if(Bflag==true){
        	 phonebyajaxURl=AJURL;
         }else{
        	 phonebyajaxURl=$("#Bphoneurl").val();
         }
         alert(phonebyajaxURl);
	      $.ajax({
	    	type: "POST",
	        url:phonebyajaxURl,
	        dataType:"json",
	        timeout:5000,
	        data:{
	        	"businessPhone" :contact,
	        	"phonetype" : phonetype
	        },
	        success: function(response){
	        	console.log(response);
	        	$('.busi_contact tbody tr').remove();
	        	jQuery.each(response, function(index, item) {
	        		$('.busi_contact tbody').append('<tr class="child"><td>'+this.buinessPhoneId+'</td><td>'+this.phone+'</td><td>'+this.phonetype+'</td><td><button class="btn btn-info btn-xs Bupcontact"><i class="fa fa-pencil"></i> Edit</button></td><td><a onclick="deleteBusinessPhone('+this.buinessPhoneId+')"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a></td></tr>');
				});

	        },
	        error: function(e){
	        	console.log("In error BusinessPhone Ajax: "+e);
	        },
	        
	      });
	      $('#bdetail_contact').val('');
	      Bflag=false;
	  });
	  
	  
	  
	  
	  $("#bus_Features").keypress(function(e) {
		    if(e.which == 13) {
		        $("#featurebutton").click();
		    }
		});
	  
	  $('#featurebutton').click(function(e){
       
		  
          var feature = $('#bus_Features').val();
          
          if(Bflag1==true){
        	  featuresUrl=AJXURL;
          }else{
        	  featuresUrl=$('#featureurl').val();
          }
          
          $("#featurebutton").html('Add');
	      $.ajax({
	    	  	type: "POST",
		        url:featuresUrl,
		        dataType:"json",
		        timeout:5000,
		        data:{
		        	"generalInfo" :feature
		        },
		        success: function(response){
		        	console.log(response);
		        	
		        	$('.busi_feature tbody tr').remove();
		        	jQuery.each(response, function(index, item) {
		        		$('.busi_feature tbody').append('<tr class="child"><td>'+this.businessGenInfoId+'</td><td>'+this.generalInfoName+'</td><td><button class="btn btn-info btn-xs modyfeature"><i class="fa fa-pencil"></i> Modify</button></td><td><button class="btn btn-danger btn-xs" onclick="deleteBusinessfeature('+this.businessGenInfoId+')"><i class="fa fa-trash"></i> Delete</button></td></tr>');
					});
		        },
		        error: function(){
		        	console.log("not working");
	        },
	        
	      });
          Bflag1=false;
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


function deleteBusinessPhone(phoneId){
	var phoneid=phoneId;
	alert(phoneid)
	var deleteurl=$('#BphoneDeleteUrl').val()+phoneid+"/delete";
	alert(deleteurl)
	$.ajax({
		type:"POST",
		url:deleteurl,
		dataType:"json",
		data:{ 
			"phoneId":phoneId
		},
		success:function(response) {
			alert(response)
			console.log(response);
        	
			$('.busi_contact tbody tr').remove();
        	jQuery.each(response, function(index, item) {
        		$('.busi_contact tbody').append('<tr class="child"><td>'+this.buinessPhoneId+'</td><td>'+this.phone+'</td><td>'+this.phonetype+'</td><td><button class="btn btn-info btn-xs Bupcontact"><i class="fa fa-pencil"></i> Edit</button></td><td><button class="btn btn-danger btn-xs" onclick="deleteBusinessPhone('+this.buinessPhoneId+')"><i class="fa fa-trash"></i> Delete</button></td></tr>');
			});
        	
		},
		error:function(e) {
			alert("error"+e)
		}
		
	});
}

function deleteBusinessfeature(featureId){
	var featureid=featureId;
	alert(featureid)
	var deleteurl=$('#BfeatureDeleteUrl').val()+featureid+"/delete";
	alert(deleteurl)
	$.ajax({
		type:"POST",
		url:deleteurl,
		dataType:"json",
		data:{ 
			"featureid":featureid
		},
		success:function(response) {
			alert(response)
			console.log(response);
			$('.busi_feature tbody tr').remove();
        	jQuery.each(response, function(index, item) {
        		$('.busi_feature tbody').append('<tr class="child"><td>'+this.businessGenInfoId+'</td><td>'+this.generalInfoName+'</td><td><button class="btn btn-info btn-xs modyfeature"><i class="fa fa-pencil"></i> Modify</button></td><td><button class="btn btn-danger btn-xs" onclick="deleteBusinessfeature('+this.businessGenInfoId+')"><i class="fa fa-trash"></i> Delete</button></td></tr>');
			});
		},
		error:function(e) {
			alert("error"+e)
		}
		
	});
}


