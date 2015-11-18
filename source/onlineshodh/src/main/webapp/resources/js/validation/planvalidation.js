

$(document).ready(function(){
	
	/*
	  =========================
	   CREATE PLAN  VALIDATION
	  ===========================
	 */
	

	
	$('#Create_plan').validate({

		rules : {
			"planName" : {

				required : true
				
			},
			"planDescription": {
				required : true
			 	
			},
			
			"priority":{
				required : true
				
			},

			"validityInMonths":{
				required : true,
				number:true,
				minlength:1,
				maxlength:2,
				min:1
			},
			"amount":{
				required : true,
				number:true,
				min:1
			},
			"noOfContacts":{
				required : true,
				number:true,
				min:1
				
			},
			
			"noOfImages":{
				required : true,
				number:true,
				min:1
			}


		},
		messages : {

			"planName":"Please Enter Valid Plan Name",
			"planDescription":"Please Enter Valid Plan Description",
			"priority":"Please Enter Valid Plan Priority",
			"validityInMonths":"Please Enter Validity In Month",
			"amount":"Please Enter Valid Plan Amount",
			"noOfContacts":"Please Enter Valid Range Of Contact Number",
			"noOfImages":"Please Enter Valid Range Of Images"
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
	

	
	
	/*
	=========================
	 UPDATE PLAN  VALIDATION
	===========================
	*/



	$('#plan').validate({

		rules : {
			"planName" : {

				required : true
				
			},
			"planDescription": {
				required : true
			 	
			},
			
			"priority":{
				required : true
				
			},

			"validityInMonths":{
				required : true,
				number:true,
				minlength:1,
				maxlength:2,
				min:1
			},
			"amount":{
				required : true,
				number:true,
				min:1
			},
			"noOfContacts":{
				required : true,
				number:true,
				min:1
				
			},
			
			"noOfImages":{
				required : true,
				number:true,
				min:1
			}


		},
		messages : {

			"planName":"Please Enter Valid Plan Name",
			"planDescription":"Please Enter Valid Plan Description",
			"priority":"Please Enter Valid Plan Priority",
			"validityInMonths":"Please Enter Validity In Month",
			"amount":"Please Enter Valid Plan Amount",
			"noOfContacts":"Please Enter Valid Range Of Contact Number",
			"noOfImages":"Please Enter Valid Range Of Images"
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

	
	
	
	
	
	
	/*
	  =========================
	   ASSIGN PLAN  VALIDATION
	  ===========================
	 */


	$("#assgin_plan_form").validate({
		rules : {
			"plan.planId" : {

				required : true,
				min:1
				
			},
			"startdate": {
				required : true
			 	
			},
			
			"enddate":{
				required : true,
				greaterThan:true
				
			},

			"status":{
				required : true,
				
			
			}
			

		},
		messages : {

			"plan.planId":"Please Enter Valid Plan ID",
			"startdate":"Please Enter Valid Start Date",
			"enddate":{required:"Please Enter Valid End Date",
				greaterThan:"End Date Must Be Greater Than Start Date"
				
			},
			"status":"Please Select Status" 
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
	
    $(".assign_plan").click(function () {
        if (!$("#assgin_plan_form").validate()) { // Not Valid
            return false;
        } else {
            $("#assgin_plan_form").submit()
        }
    });

	
	$.validator.addMethod("greaterThan", 
			function(value, element, params) {

			    if (!/Invalid|NaN/.test(new Date(value))) {
			        return new Date(value) > new Date($(params).val());
			    }

			    return isNaN(value) && isNaN($(params).val()) 
			        || (Number(value) > Number($(params).val())); 
			},'Must be greater than {0}.');
	
	$("#expiryDate").rules('add', { greaterThan: "#startDate" });
	
	
	
});

