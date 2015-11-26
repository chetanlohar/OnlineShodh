$(document).ready(function(){
	/*=========================
	Update CLIENT VALIDATION
	===========================*/
	$.validator.addMethod(
		    "maxfilesize",
		    function (value, element) {
		        return this.optional(element) || (element.files && element.files[0]
		                               && element.files[0].size < 1024  * 300);
		    },
		    'The file size can not exceed 300KB.'
		);
	
	jQuery.validator.addMethod("CustEmail", function(value, element) {
	  	 
	  	  return this.optional( element ) || /^([a-zA-Z0-9_\-])+(\.([a-zA-Z0-9_\-])+)*@((\[(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5]))\]))|((([a-zA-Z0-9])+(([\-])+([a-zA-Z0-9])+)*\.)+([a-zA-Z])+(([\-])+([a-zA-Z0-9])+)*))$/.test( value );
	  	}, 'Please enter a valid email address.');
	

	$('#clientformupdate').validate({
	    rules: {
	    
	        
	        "name": {
	        	 required: true,
	        	
	            
	        },
	        
	        "phone1":{
	        	required: true,
	        	minlength: 10,
	        	maxlength: 10


	        },
	        "phone2":{
	        	required: true,
	        	minlength: 10,
	        	maxlength: 10


	        },
	   
	        "address.address" : {
	            required: true,
	            
	        },
	        
	        "address.street" : {
	            required: true,
	         
	        },
	        "address.landMark": {
	            required: true,
	         
	        },
	    
	        "address.city.cityId" : {
	            required: true,
	            min:1
	            
	          
	        },
	        "address.town.townId" : {
	            required: true,
	            
	        },
	        
	        "address.townOther" : {
	            required: true,
	            
	        },
	        
	        "address.pincode": {
	            required: true,
	           minlength:6,
	           digit:true
	        },
	        
	        file:{
	        	required: true,
	        	extension:"jpg|jpeg|png|bmp",
	        	maxfilesize:true
	        },
	    },
	      messages:{
	    
	    	  "user.userName":"Please Enter Valid Email Id",
	    	  
	    	  filec:{
	    		  required: "This Is Deafault Image Please Select Image",
		        	extension:"Please select valid image",
		        		maxfilesize:"File size should be less than 300 KB"
	    	  }
	     
	      },
	  
	      highlight: function(element) {
	          $(element).closest('.space').addClass('has-error');
	      },
	      unhighlight: function(element) {
	          $(element).closest('.space').removeClass('has-error');
	      },
	      errorElement: 'span',
	      errorClass: 'clienterror',
	      errorPlacement: function(error, element) {
		   	   
	     	  // if element is file type, we put the error message in its grand parent
	           if (element.prop("type") === "file") {
	               error.insertAfter(element.parent().parent());
	               error.removeClass('clienterror,errorimg').addClass('errorimg');
	              
	           } else {
	         	   error.insertAfter(element.parent());
	         	  error.addClass('clienterror');
	         	
	           }},

	});

	
	
	
	
	
	
});

