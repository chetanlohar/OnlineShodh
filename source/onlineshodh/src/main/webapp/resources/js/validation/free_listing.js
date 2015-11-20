$(document).ready(function(){
	
	/*============================
	 Free listing form1 Validation
	 ===========================*/
	
	
	$('#free_list_first').validate({

	    rules: {
	    	fr_list_company: {
	            required: true
	            
	        },
	        fr_list_person:{
	        	 required: true
	        	
	        },
	        fr_list_email:{
	        	required: true,
	        	email:true
	        },
	        
	        fr_list_web:{
	        	required: true
	        },
	        category:{
	        	required: true
	        },
	        subcategory:{
	        	required: true
	        },
	        keyword:{
	        	required: true
	        }
	       

	    },
	      messages:{
	    	  
	    	  fr_list_company:{
	    		  required: "Please enter category name"
	    		 
	    	  },
	    	  fr_list_person:{
	    		  required: "Please enter valid person name"
	    		  
	    	  },
	    	  fr_list_email :{
	    		  required: "Please enter valid email id"
		        
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
	 Free listing Address form Validation
	 ===========================*/
	
	
	$('#free_list_Address').validate({

	    rules: {
	    	fr_list_address: {
	            required: true
	            
	        },
	        fr_list_road:{
	        	 required: true
	        	
	        },
	        fr_list_landmark:{
	        	required: true
	        
	        },
	        
	        city:{
	        	required: true
	        },
	        town:{
	        	required: true
	        },
	        fl_list_pincode:{
	        	required: true,
	        	number:true,
	        	minlength:6,
	        	maxlength:6
	        }
	       

	    },
	      messages:{
	    	  
	    	  fr_list_address:{
	    		  required: "Please enter valid address"
	    		 
	    	  },
	    	  fr_list_road:{
	    		  required: "Please enter street name"
	    		  
	    	  },
	    	  fr_list_landmark :{
	    		  required: "Please enter valid landmark"
		        
	    	  },
	    	  city:{
	    		  required: "Please enter valid city"
	    		  
	    	  },
	    	  town:{
	    		  required: "Please enter valid town"
	    	  },
	    	  fl_list_pincode:{
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