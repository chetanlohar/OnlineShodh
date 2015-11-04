$(document).ready(function(){
	/*=========================
	  category Manage Validation
	 ===========================*/
	/*$.validator.addMethod('filesize', function (value, element, param) {
	    return this.optional(element) || (element.files[0].size <= param)
	}, 'File size must be less than {0}');
	*/
	
	$('#categorymanage').validate({

	    rules: {
	    	categoryName: {
	            required: true
	        },
	        categoryDesc:{
	        	 required: true
	        }

	    },
	      messages:{
	    	  
	    	  categoryName:"Please Enter Valid Category Name",
	    	  categoryDesc:"Please Select Valid category Description",
	    	  file:"Please Select Valid File"
	     
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
	          if(element.parent('.input-group').length) {
	              error.insertAfter(element.parent());
	          } else {
	              error.insertAfter(element);
	          }},


	});


	
	
	/*=========================
	  category Update Validation
	 ===========================*/
	$('#categoryupdate').validate({

	    rules: {
	    	categoryName: {
	            required: true
	        },
	        categoryDesc:{
	        	 required: true
	        }
	     
	    },
	      messages:{
	    	  
	    	  categoryName:"Please Enter Valid Category Name",
	    	  categoryDesc:"Please Select Valid category Description",
	    	  country:"Please Select Valid country Name"
	     
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
	          if(element.parent('.input-group').length) {
	              error.insertAfter(element.parent());
	          } else {
	              error.insertAfter(element);
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
	        	 required: true
	        },
	        subCategoryDesc:{
	        	required: true	
	        }

	    },
	      messages:{
	    	  
	    	  "category.categoryId":"Please Enter Valid sub-Category Name",
	    	  categoryDesc:"Please Select Valid category Description",
	    	  file:"Please Select Valid File"
	     
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
	          if(element.parent('.input-group').length) {
	              error.insertAfter(element.parent());
	          } else {
	              error.insertAfter(element);
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
	        	   required: true
	        },
	        subCategoryDesc:{
	        	 required: true
	        }
	     
	    },
	      messages:{
	    	  
	    	  "category.categoryId":"Please Enter Valid Category Name",
	    	  subCategoryDesc:"Please Select Valid category Description",
	    	  subCategoryName:"Please Select Valid Sub-Category Name"
	     
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
	          if(element.parent('.input-group').length) {
	              error.insertAfter(element.parent());
	          } else {
	              error.insertAfter(element);
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
            
            required: true
        },
        "state.stateId":{
        	  required: true
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
      errorClass: 'error',

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
            
            required: true
        },
        Cstate:{
        	  required: true
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
      errorClass: 'error',

});

/*=========================
Town Manage Validation
===========================*/

$('#townmanage').validate({
    rules: {
        tcity: {
            required: true
        },
        tcountry: {
            
            required: true
        },
        tstate:{
        	  required: true
        },
        ttowm:{
      	  required: true
      }
    },
      messages:{
    	  
    	  tcity:"Please Enter Valid City Name",
    	  tstate:"Please Select Valid State Name",
    	  tcountry:"Please Select Valid country Name",
    	  ttowm:"Please Enter Valid Town Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'error',

});

/*=========================
Town Update Validation
===========================*/

$('#townupdate').validate({
    rules: {
        tucity: {
            required: true
        },
        tucountry: {
            
            required: true
        },
        tustate:{
        	  required: true
        },
        tutown:{
      	  required: true
      }
    },
      messages:{
    	  
    	  tucity:"Please Enter Valid City Name",
    	  tustate:"Please Select Valid State Name",
    	  tucountry:"Please Select Valid country Name",
    	  tutown:"Please Enter Valid Town Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'error',

});




/*=========================
State Manage  Validation
===========================*/

$('#statemanage').validate({
    rules: {
    	scountry: {
            required: true
        },
        sstate: {
            
            required: true
        }
        
    },
      messages:{
    	  
    	  scountry:"Please Select Valid country Name",
    	  sstate:"Please Enter Valid State Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'error',

});



/*=========================
State Update Validation
===========================*/

$('#stateupdate').validate({
    rules: {
    	sucountry: {
            required: true
        },
        sustate: {
            
            required: true
        }
        
    },
      messages:{
    	  
    	  sucountry:"Please Select Valid country Name",
    	  sustate:"Please Enter Valid State Name",
      },
  
      highlight: function(element) {
          $(element).closest('.form-group').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-group').removeClass('has-error');
      },
      
      errorElement: 'span',
      errorClass: 'error',

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
      errorClass: 'error',

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
      errorClass: 'error',
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

$('#clientform').validate({
    rules: {
    	clietmail: {
    		email:true,
            required: true
        },
        
        clietpass: {
            required: true,
        	minlength: 6
        },
        
          clietCpass : {
            required: true,
            equalTo: "#clientpass"
        },
        
        clietname: {
        	 required: true
            
        },
   
        address : {
            required: true,
            
        },
        
        clientcountry : {
            required: true,
         
        },
        clientstate : {
            required: true,
            
        },
        clientcity : {
            required: true,
          
        },
        clinettown : {
            required: true,
            
        },
        
        clietpin: {
            required: true,
           minlength:6,
           digit:true
        },
    },
      messages:{
    
    	  cupdate:"Please Enter Valid Country Name",
      },
      
      highlight: function(element) {
          $(element).closest('.space').addClass('has-error');
      },
      unhighlight: function(element) {
          $(element).closest('.space').removeClass('has-error');
      },
      errorElement: 'span',
      errorClass: 'error1',
      errorPlacement: function(error, element) {
          if(element.parent('.input-group').length) {
              error.insertAfter(element.parent());
          } else {
              error.insertAfter(element);
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





});