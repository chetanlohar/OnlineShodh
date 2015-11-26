$(document).ready(function(){
	
	/*============================
	 Free listing form1 Validation
	 ===========================*/
	jQuery.validator.addMethod("CustEmail", function(value, element) {
	  	 
	  	  return this.optional( element ) || /^([a-zA-Z0-9_\-])+(\.([a-zA-Z0-9_\-])+)*@((\[(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5]))\]))|((([a-zA-Z0-9])+(([\-])+([a-zA-Z0-9])+)*\.)+([a-zA-Z])+(([\-])+([a-zA-Z0-9])+)*))$/.test( value );
	  	}, 'Please enter a valid email address.');
	
	
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		  return this.optional(element) || /^[a-z," "]+$/i.test(value);
		}, "Letters only please"); 

	$('#free_list_first').validate({

	    rules: {
	    	"businessName": {
	            required: true
	            
	        },
	        "personName":{
	        	 required: true,
	        	 lettersonly:true
	        },
	        "email":{
	        	required: true,
	        	CustEmail:true
	        },
	        
	        "website":{
	        	required: true,
	        	url:true
	        },
	        "subCategory.category.categoryId":{
	        	required: true,
	        	min:1
	        },
	        "subCategory.subCategoryId":{
	        	required: true,
	        	min:1
	        },
	        "keywords":{
	        	required: true
	        }
	       

	    },
	      messages:{
	    	  
	    	  "businessName":{
	    		  required: "Please enter category name"
	    		 
	    	  },
	    	  "personName":{
	    		  required: "Please enter valid person name"
	    		  
	    	  },
	    	  
	    	  "email" :{
	    		  required: "Please enter valid email id"
		        
	    	  },
	    	  "website" :{
	    		  required: "Please enter valid url Pattern(http://www.website.com)"
		        
	    	  },
	    	  
	    	  "subCategory.category.categoryId" :{
	    		  required: "Please select valid category",
	    		  min:"Please select valid category"
		        
	    	  },
	    	  
	    	  "subCategory.subCategoryId" :{
	    		  required: "Please select valid sub-category",
	    		  min:"Please select valid sub-category"
		        
	    	  },
	    	  
	    	  "keywords" :{
	    		  required: "Please Enter Valid Keywords"
	    		 
		        
	    	  }
	     
	      },
	  
	      highlight: function(element) {
	          $(element).closest('.space').addClass('has-error');
	      },
	      unhighlight: function(element) {
	          $(element).closest('.space').removeClass('has-error');
	      },
	      errorElement: 'span',
	      errorClass: 'fl_error',
	      errorPlacement: function(error, element) {
		   	   
	     	
	         	   error.insertAfter(element.parent().parent());
	         	
	         	
	           },


	});
	
	/*============================
	 Free listing Address form Validation
	 ===========================*/
	
	
	$('#free_list_Address').validate({

	    rules: {
	    	"fl_Address": {
	            required: true
	            
	        },
	        "fl_Street":{
	        	 required: true
	        	
	        },
	        "fl_LandMark":{
	        	required: true
	        
	        },
	        
	        "city.cityId":{
	        	required: true,
	        	min:1
	        },
	        "town.townId":{
	        	required: true,
	        	min:1
	        },
	        "pincode":{
	        	required: true,
	        	number:true,
	        	minlength:6,
	        	maxlength:6
	        }
	       

	    },
	      messages:{
	    	  
	    	  "fl_Address":{
	    		  required: "Please enter valid address"
	    		 
	    	  },
	    	  "fl_Street":{
	    		  required: "Please enter street name"
	    		  
	    	  },
	    	  "fl_LandMark" :{
	    		  required: "Please enter valid landmark"
		        
	    	  },
	    	  "city.cityId":{
	    		  required: "Please select valid city",
	    		  min:"Please select valid city"
	    		  
	    	  },
	    	  "town.townId":{
	    		  required: "Please select valid town",
	    		  min:"Please select valid town"
	    	  },
	    	  "pincode":{
	    		  required: "Please enter valid Pincode",
	    		  number:"Please enter digit pincode",
	    		  minlength:"Please enter valid Pincode",
	    		  maxlength:"Please enter valid Pincode"
	    	  }
	     
	      },
	  
	      highlight: function(element) {
	          $(element).closest('.space').addClass('has-error');
	      },
	      unhighlight: function(element) {
	          $(element).closest('.space').removeClass('has-error');
	      },
	      errorElement: 'span',
	      errorClass: 'fl_error',
	      errorPlacement: function(error, element) {
		   	   
	     	
	         	   error.insertAfter(element.parent());
	         	
	         	
	           },


	});
	
	
	/*============================
	 Free listing contact form Validation
	 ===========================*/
	
	
	$('#free_list_Address').validate({

	    rules: {
	    	"fl_Address": {
	            required: true
	            
	        },
	        "fl_Street":{
	        	 required: true
	        	
	        },
	        "fl_LandMark":{
	        	required: true
	        
	        },
	        
	        "city.cityId":{
	        	required: true,
	        	min:1
	        },
	        "town.townId":{
	        	required: true,
	        	min:1
	        },
	        "pincode":{
	        	required: true,
	        	number:true,
	        	minlength:6,
	        	maxlength:6
	        }
	       

	    },
	      messages:{
	    	  
	    	  "fl_Address":{
	    		  required: "Please enter valid address"
	    		 
	    	  },
	    	  "fl_Street":{
	    		  required: "Please enter street name"
	    		  
	    	  },
	    	  "fl_LandMark" :{
	    		  required: "Please enter valid landmark"
		        
	    	  },
	    	  "city.cityId":{
	    		  required: "Please select valid city",
	    		  min:"Please select valid city"
	    		  
	    	  },
	    	  "town.townId":{
	    		  required: "Please select valid town",
	    		  min:"Please select valid town"
	    	  },
	    	  "pincode":{
	    		  required: "Please enter valid Pincode",
	    		  number:"Please enter digit pincode",
	    		  minlength:"Please enter valid Pincode",
	    		  maxlength:"Please enter valid Pincode"
	    	  }
	     
	      },
	  
	      highlight: function(element) {
	          $(element).closest('.space').addClass('has-error');
	      },
	      unhighlight: function(element) {
	          $(element).closest('.space').removeClass('has-error');
	      },
	      errorElement: 'span',
	      errorClass: 'fl_error',
	      errorPlacement: function(error, element) {
		   	   
	     	
	         	   error.insertAfter(element.parent());
	         	
	         	
	           },


	});
});