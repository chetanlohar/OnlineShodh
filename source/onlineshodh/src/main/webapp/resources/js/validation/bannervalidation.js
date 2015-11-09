
	/*=========================
	  Banner Manage Validation
	 ===========================*/

$(document).ready(function(){	

	$('#managebanner').validate({
		
		
		 rules: {
			 "category.categoryId": {
		            required: true,
		            min:1
		           
		        },
		       "city.state.country.countryId":{
		        	 required: true,
		        	 min:1
		        	
		        },
		        "city.state.stateId":{
		        	required: true,
		        	min:1
		        },
		        "city.cityId":{
		        	  required: true,
		        	  min:1
		        },
		        
		        file:{
		        	extension:"jpg|jpeg|png|bmp",
		        	maxfilesize:true
		        },
		        
		     
		        
		        "startDate":{
		        	required: true
		        },
		        
		        "expiryDate":{
		        	required: true,
		        	greaterThan: "#StartDate" 
		        },
		        
		        "regDate":{
		        	required: true
		        },
		        
		        "status":{
		        	required: true
		        },

		        "bannerName":{
		        	required: true,
		        	lettersonly:true
		        }

		    },
		      messages:{
		    	  
		    	  "category.categoryId":{
		    		  required: "Please select category ",
		    			  min:"Please select category"
		    	  },
		    	  "city.state.country.countryId":{
		    		  required: "Please select country",
		    		  min:"Please select country"
		    		 
		    	  },
		    	  "city.state.stateId":{
			        	required: "Please select state",
			        		min:"Please select state"
		    	  },
		    	  "city.cityId":{
		    			required: "Please select city",
		    				min:"Please select city"	
		    				
		    	  },
		    	  file:{
			        	
			        	extension:"Please select valid image",
			        		maxfilesize:"File size should be less than 300 KB"
		    	  },
		    	  bannerName:{
		    		  required: "Please enter banner name",
		    		  lettersonly:"Please enter valid banner name"
		    	  },
		    	
		    	  startDate:{
			        	required: "Please select start date"
			        		
			        },
			        expiryDate:{
			        	required: "Please select end date",
			        	greaterThan:"Expiry date must be greater than start date"
			        },
			        regDate:{
			        	required:"Please select registration date"
			        },
			        status:{
			        	required: "please enter status"
			        }
		     
		      },
		  
		      highlight: function(element) {
		          $(element).closest('.space').addClass('has-error');
		      },
		      unhighlight: function(element) {
		          $(element).closest('.space').removeClass('has-error');
		      },
		      errorElement: 'span',
		      errorClass: 'error',
		      errorPlacement: function(error, element) {
			   	   
		     	  // if element is file type, we put the error message in its grand parent
		           if (element.prop("type") === "file") {
		               error.insertAfter(element.parent().parent());
		               error.removeClass('error,errorimg').addClass('errorimg');
		              
		           } else {
		         	   error.insertAfter(element.parent());
		         	  error.addClass('error');
		         	
		           }},
		
		
	});

	jQuery.validator.addMethod("lettersonly", function(value, element) {
		  return this.optional(element) || /^[a-z," "]+$/i.test(value);
		}, "Letters only please"); 
	jQuery.validator.addMethod("validurl", function(value, element) {
		  return this.optional(element) || /^(https?|s?ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value);
		}, "Valid Url only please"); 

	$.validator.addMethod(
		    "maxfilesize",
		    function (value, element) {
		        return this.optional(element) || (element.files && element.files[0]
		                               && element.files[0].size < 1024  * 300);
		    },
		    'The file size can not exceed 300KB.'
		);
	$.validator.addMethod("greaterThan", 
			function(value, element, params) {

			    if (!/Invalid|NaN/.test(new Date(value))) {
			        return new Date(value) > new Date($(params).val());
			    }

			    return isNaN(value) && isNaN($(params).val()) 
			        || (Number(value) > Number($(params).val())); 
			},'Must be greater than {0}.');
	
	$("#expiryDate").rules('add', { greaterThan: "#startDate" });
	

	
	
	
	
	/*=========================
	  Banner Update Validation
	 ===========================*/

	
	$('#bannerUpdate').validate({
		
		
		 rules: {
			 
			 "category.categoryId": {
		            required: true,
		            min:1
		           
		        },
		       "city.state.country.countryId":{
		        	 required: true,
		        	 min:1
		        	
		        },
		        "city.state.stateId":{
		        	required: true,
		        	min:1
		        },
		        "city.cityId":{
		        	  required: true,
		        	  min:1
		        },
		        
		        file:{
		        	
		        	extension:"jpg|jpeg|png|bmp",
		        	maxfilesize:true
		        },
		        
		        
		        "startDate":{
		        	required: true,
		        	date:true
		        },
		        
		        "expiryDate":{
		        	required: true,
		        	date:true
		        	
		        },
		        
		        "regDate":{
		        	required: true,
		        	date:true
		        },
		        
		        "status":{
		        	required: true
		        },

		        "bannerName":{
		        	required: true,
		        	lettersonly:true
		        }

		    },
		      messages:{
		    	  
		    	  "category.categoryId":{
		    		  required: "Please select category ",
		    			  min:"Please select category"
		    	  },
		    	  "city.state.country.countryId":{
		    		  required: "Please select country",
		    		  min:"Please select country"
		    		 
		    	  },
		    	  "city.state.stateId":{
			        	required: "Please select state",
			        		min:"Please select state"
		    	  },
		    	  "city.cityId":{
		    			required: "Please select city",
		    				min:"Please select city"	
		    				
		    	  },
		    	  
		    	  file:{
			        	
			        	extension:"Please select valid image",
			        		maxfilesize:"File size should be less than 300 KB"
		    	  },
		    	 " bannerName":{
		    		  required: "Please enter banner name",
		    		  lettersonly:"Please enter valid banner name"
		    	  },
		    	
		    	  "startDate":{
			        	required: "Please select start date"
			        },
			        "expiryDate":{
			        	required: "Please select end date",
			        
			        },
			       "regDate":{
			        	required:"Please select registration date"
			        },
			        "status":{
			        	required: "please enter status"
			        }
		     
		      },
		  
		      highlight: function(element) {
		          $(element).closest('.space').addClass('has-error');
		      },
		      unhighlight: function(element) {
		          $(element).closest('.space').removeClass('has-error');
		      },
		      errorElement: 'span',
		      errorClass: 'error',
		      errorPlacement: function(error, element) {
			   	   
		     	  // if element is file type, we put the error message in its grand parent
		           if (element.prop("type") === "file") {
		               error.insertAfter(element.parent().parent());
		               error.removeClass('error,errorimg').addClass('errorimg');
		              
		           } else {
		         	   error.insertAfter(element.parent());
		         	  error.addClass('error');
		         	
		           }},
		
		
	});
	
	
	
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		  return this.optional(element) || /^[a-z," "]+$/i.test(value);
		}, "Letters only please"); 
	jQuery.validator.addMethod("validurl", function(value, element) {
		  return this.optional(element) || /^(https?|s?ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value);
		}, "Valid Url only please"); 

	$.validator.addMethod(
		    "maxfilesize",
		    function (value, element) {
		        return this.optional(element) || (element.files && element.files[0]
		                               && element.files[0].size < 1024  * 300);
		    },
		    'The file size can not exceed 300KB.'
		);

	

	
	


	

});
		  
	