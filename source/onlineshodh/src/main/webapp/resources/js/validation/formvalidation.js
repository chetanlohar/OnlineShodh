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
      errorClass: 'error',

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
      errorClass: 'error',

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
      errorClass: 'error',

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
      errorClass: 'error',

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
    	"user.userName": {
    		email:true,
            required: true
        },
        
        "user.password": {
            required: true,
        	minlength: 6
        },
        
        "user.password" : {
            required: true,
            equalTo: "user.password"
        },
        
        "userDetails.name": {
        	 required: true
            
        },
        
        "userDetails.phone1":{
        	required: true,
        	minlength: 10,
        	maxlength: 10


        },
        "userDetails.phone2":{
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
           digit:true
        },
    },
      messages:{
    
    	  "user.userName":"Please Enter Valid User Name",
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
Update CLIENT VALIDATION
===========================*/

$('#clientformupdate').validate({
 rules: {
 	"name": {
 		
         required: true
     },
     
     
     "user.password" : {
         required: true,
         equalTo: "user.password"
     },
     
     "userDetails.name": {
     	 required: true
         
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
         required: true
         
     },
     
     "address.street" : {
         required: true
      
     },
     "address.landMark": {
         required: true
      
     },
     clientstate : {
         required: true
         
     },
     "address.city.cityId" : {
         required: true,
         min:1
         
       
     },
     "address.town.townId" : {
         required: true
         
     },
     
     "address.townOther" : {
         required: true,
         
     },
     
     "address.pincode": {
         required: true,
        minlength:6,
        digit:true
     },
 },
   messages:{
 
 	  "user.userName":"Please Enter Valid User Name",
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