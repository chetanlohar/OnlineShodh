$(document).ready(function(){

/*=========================
  City Manage Validation
 ===========================*/

$('#citymanage').validate({
    rules: {
        city: {
            required: true
        },
        country: {
            
            required: true
        },
        state:{
        	  required: true
        }
    },
      messages:{
    	  
    	  city:"Please Enter Valid City Name",
    	  state:"Please Select Valid State Name",
    	  country:"Please Select Valid country Name"
     
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
        Ccity: {
            required: true
        },
        Ccountry: {
            
            required: true
        },
        Cstate:{
        	  required: true
        }
    },
      messages:{
    	  
    	  Ccity:"Please Enter Valid City Name",
    	  Cstate:"Please Select Valid State Name",
    	  Ccountry:"Please Select Valid country Name"
     
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
    	countryc: {
            required: true
        }
       
        
    },
      messages:{
    
    	  countryc:"Please Enter Valid Country Name",
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
    	cupdate: {
            required: true
        }
       
        
    },
      messages:{
    
    	  cupdate:"Please Enter Valid Country Name",
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
      /*  clietphone : {
            required: true,
           
        },
        clietphone2 : {
            required: true,
         
        },*/
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







});