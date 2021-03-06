$(document).ready(function(){
	/*=========================
	  category Manage Validation
	 ===========================*/

	$.validator.addMethod(
		    "maxfilesize",
		    function (value, element) {
		        return this.optional(element) || (element.files && element.files[0]
		                               && element.files[0].size < 1024  * 300);
		    },
		    'The file size can not exceed 300KB.'
		);
	
	$('#categorymanage').validate({

	    rules: {
	    	categoryName: {
	            required: true,
	            lettersonly:true
	        },
	        categoryDesc:{
	        	 required: true,
	        	 minlength:20
	        },
	        file:{
	        	required: true,
	        	extension:"jpg|jpeg|png|bmp",
	        	maxfilesize:true
	        }

	    },
	      messages:{
	    	  
	    	  categoryName:{
	    		  required: "Please enter category name",
	    		  lettersonly:"Please enter valid category name"
	    	  },
	    	  categoryDesc:{
	    		  required: "Please enter category Description",
	    		  minlength:"Please enter few more description"
	    	  },
	    	  file:{
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

	
	/*=========================
	  category Update Validation
	 ===========================*/
	$('#categoryupdate').validate({

	    rules: {
	    	categoryName: {
	            required: true,
	            lettersonly:true
	        },
	        categoryDesc:{
	        	 required: true,
	        	 minlength:20
	        },
	        file:{
	        	
	        	maxfilesize:true,
	        	extension: "jpg|jpeg|png|bmp"
	        }
	     
	    },
	    messages:{
	    	  
	    	  categoryName:{
	    		  required: "Please enter category name",
	    		  lettersonly:"Please enter valid category name"
	    	  },
	    	  categoryDesc:{
	    		  required: "Please enter category Description",
	    		  minlength:"Please enter few more description"
	    	  },
	    	  file:{
	    		  
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
	
	
	
	/*=========================
	 sub-category Manage Validation
	 ===========================*/
	/*$.validator.addMethod('filesize', function (value, element, param) {
	    return this.optional(element) || (element.files[0].size <= param)
	}, 'File size must be less than {0}');
	*/
	
	$('#subcategorymanage').validate({

	    rules: {
	    	"category.categoryId": {
	            required: true
	        },
	        subCategoryName:{
	        	 required: true,
	        	 minlength:5,
	        	 lettersonly:true
	        },
	       
	        subCategoryDesc:{
	        	 required: true,
	        	 minlength:20
	        },
	        file:{
	        	 required: true,
	        	maxfilesize:true,
	        	extension: "jpg|jpeg|png|bmp"
	        }

	    },
	      messages:{
	    	  
	    	  "category.categoryId":{
	    		  required: "Please select Category Name"
	    	  },
	    	  subCategoryName:{
	    		  required:"Please enter sub category name",
	    		  minlength:"Please enter minimum 5 charcters",
	    		  lettersonly:"Please enter valid sub category name"
	    	  },
	    	  subCategoryDesc:{
	    		  required:"Please enter category description",
	    		  minlength:"Please enter few more description"
	    	  },
	    	  file:{
	    		  required: "This Is Deafault Image Please Select Image",
		        		maxfilesize:"File size should be less than 300 KB",
		        		extension:"Please select valid image"
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


	
	
	/*=========================
	  category Update Validation
	 ===========================*/
	$('#subcategoryupdate').validate({

	          
	          rules: {
	  	    	"category.categoryId": {
	  	            required: true
	  	        },
	  	        subCategoryName:{
	  	        	 required: true,
	  	        	 minlength:5,
	  	        	 lettersonly:true
	  	        },
	  	       
	  	        subCategoryDesc:{
	  	        	 required: true,
	  	        	 minlength:20
	  	        },
	  	        file:{
	  	        	
	  	        	maxfilesize:true,
	  	        	extension: "jpg|jpeg|png|bmp"
	  	        }

	  	    },
	  	      messages:{
	  	    	  
	  	    	  "category.categoryId":{
	  	    		  required: "Please select Category Name"
	  	    	  },
	  	    	  subCategoryName:{
	  	    		  required:"Please enter sub category name",
	  	    		  minlength:"Please enter minimum 5 charcters",
	  	    		 lettersonly:"Please enter valid sub category name"
	  	    	  },
	  	    	  subCategoryDesc:{
	  	    		  required:"Please enter category description",
	  	    		  minlength:"Please enter few more description"
	  	    		 
	  	    	  },
	  	    	  file:{
	  	    		  
	  		        		maxfilesize:"File size should be less than 300 KB",
	  		        		extension:"Please select valid image"
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
	
	
	
	
/*=========================
  City Manage Validation
 ===========================*/

$('#citymanage').validate({

    rules: {
    	cityName: {
            required: true
        },
        "state.country.countryId": {
            
            required: true,
            min:1
        },
        "state.stateId":{
        	  required: true,
        	  min:1
        }
    },
      messages:{
    	  
    	  cityName:"Please Enter Valid City Name",
    	  "state.stateId":"Please Select Valid State Name",
    	  "state.country.countryId":"Please Select Valid country Name"
     
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});


/*=========================
  City Update Validation
 ===========================*/


$('#cityupdate').validate({
    rules: {
    	cityName: {
            required: true
        },
        "state.country.countryId": {
            
            required: true,
            min:1
        },
        "state.stateId":{
        	  required: true,
        	  min:1
        }
    },
      messages:{
    	  
    	  cityName:"Please Enter Valid City Name",
    	  "state.stateId":"Please Select Valid State Name",
    	  "state.country.countryId":"Please Select Valid country Name"
     
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});

/*=========================
Town Manage Validation
===========================*/

$('#townmanage').validate({
    rules: {
    	"city.state.country.countryId": {
            required: true,
            min:1
            
        },
        "city.cityId": {
            
            required: true,
            min:1
            
        },
        "city.state.stateId":{
        	  required: true,
        	  min:1
        	  
        },
        townName:{
      	  required: true
      	  
      }
    },
      messages:{
    	  
    	  "city.cityId":"Please Enter Valid City Name",
    	  "city.state.stateId":"Please Select Valid State Name",
    	  "city.state.country.countryId":"Please Select Valid country Name",
    	  townName:"Please Enter Valid Town Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});

/*=========================
Town Update Validation
===========================*/

$('#townupdate').validate({
    rules: {
    	"city.state.country.countryId": {
            required: true,
            min:1
        },
        "city.state.stateId": {
            
            required: true,
            min:1
        },
        "city.cityId":{
        	  required: true,
        	  min:1
        },
        townName:{
      	  required: true
      	
      }
    },
      messages:{
    	  
    	  "city.cityId":"Please Enter Valid City Name",
    	  "city.state.stateId":"Please Select Valid State Name",
    	  "city.state.country.countryId":"Please Select Valid country Name",
    	  townName:"Please Enter Valid Town Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});




/*=========================
State Manage  Validation
===========================*/

$('#statemanage').validate({
    rules: {
    	"country.countryId": {
            required: true,
            min:1
        },
        stateName: {
            
            required: true
        }
        
    },
      messages:{
    	  
    	  "country.countryId":"Please Select Valid country Name",
    	  stateName:"Please Enter Valid State Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});



/*=========================
State Update Validation
===========================*/

$('#stateupdate').validate({
    rules: {
    	"country.countryId": {
            required: true,
            min:1
        },
        stateName: {
            
            required: true
        }
        
    },
      messages:{
    	  
    	  "country.countryId":"Please Select Valid country Name",
    	  stateName:"Please Enter Valid State Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});

/*=========================
country Manage  Validation
===========================*/

$('#countrymanage').validate({
    rules: {
    	countryName: {
            required: true
        }
       
        
    },
      messages:{
    
    	  countryName:"Please Enter Valid Country Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',

});

/*=========================
country Update  Validation
===========================*/

$('#countryupdate').validate({
    rules: {
    	countryName: {
            required: true
        }
       
        
    },
      messages:{
    
    	  countryName:"Please Enter Valid Country Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'locerror',
      errorPlacement: function(error, element) {
          if(element.parent('.input-group').length) {
              error.insertAfter(element.parent());
          } else {
              error.insertAfter(element);
          }},

});

/*=========================
   NEW CLIENT VALIDATION
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


$('#clientform').validate({
    rules: {
    	"user.userName": {
    		 CustEmail:true,
            required: true
        },
        
        "user.password": {
            required: true,
        	minlength: 6
        },

      confpass: {
            required: true,
            equalTo:"#clientpass"
        	
        },

        "userDetails.name": {
        	 required: true,
        	 lettersonly:true
            
        },
        
        "userDetails.phone1":{
        	required: true,
        	minlength: 10,
        	maxlength: 10,
        	number:true


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
        clientstate : {
            required: true,
            
        },
        "address.city.cityId" : {
            required: true,
            
          
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
           maxlength: 6,
           number:true
        },
        
        file:{
        	
        	extension:"jpg|jpeg|png|bmp",
        	maxfilesize:true
        },
    },
      messages:{
    
    	  "user.userName":"Please Enter Valid Email Id",
    	  "userDetails.name":"Please Enter Valid Name",
    	  
    	  file:{
    		  required: "This Is Deafault Image Please Select Image",
	        	extension:"Please select valid image",
	        		maxfilesize:"File size should be less than 300 KB"
    	  },
    	  "user.password":{
    		  required: "Please enter valid password" 
    	  },
    	  confpass:{
    		  required: "Please enter valid password"
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

$('#clientformupdate').validate({
    rules: {
    
        
        "name": {
        	 required: true
            
        },
        
        "phone1":{
        	required: true,
        	minlength: 10,
        	maxlength: 10,
        	number:true


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
            minlength: 6,
        	maxlength: 6,
        	number:true
        },
        
        file:{
        	
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
    	  },
    	  "address.city.cityId":{
    		  min:"please Select Valid City Name"
    	  },
    	  "address.pincode":{
    		  required:"Please enter valid pincode",
    		  minlength:"Please enter valid pincode",
    		  maxlength:"Please enter valid pincode"
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




/*=========================
Business Contact VALIDATION
===========================*/

$('#bus_conta').validate({
 rules: {
	 business_contact: {
 		
              required: true,
              digit:true,
              maxlength:10,
              minlength: 10
     },
     
 },
   messages:{
 
	   business_contact:"Please Enter Valid Contact Number",
	   
   },
   
   highlight: function(element) {
       $(element).closest('.space').addClass('has-error');
   },
   unhighlight: function(element) {
       $(element).closest('.space').removeClass('has-error');
   },
   errorElement: 'span',
   errorClass: 'error1',


});


$('#busd_feature').validate({
	 rules: {
		 features: {
	 		
	              required: true
	              
	     },
	     
	 },
	   messages:{
	 
		   features:"Enter Features",
		   
	   },
	   
	   highlight: function(element) {
	       $(element).closest('.space').addClass('has-error');
	   },
	   unhighlight: function(element) {
	       $(element).closest('.space').removeClass('has-error');
	   },
	   errorElement: 'span',
	   errorClass: 'error1',


	});





});