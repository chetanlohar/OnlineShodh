

$(document).ready(function(){
	
	/*
	  =========================
	Payment Valiadtion VALIDATION
	  ===========================
	 */
	

	
	$('#payment_mode').validate({

		rules : {
		
			"payment.paymentfor": {
				required : true
			 	
			},
			
			"businessName":{
				required : true
				
			},

			"bannerName":{
				required : true
			
			},
			"payment.paymentMode.paymentModeid":{
				required : true
			
			},
			"payment.ammount":{
				required : true,
				number:true,
				min:1
				
			},
			
			"check.checkNo":{
				required : true,
				number:true,
				minlength:6,
				maxlength:10
			},
			
			"check.bankName":{
				required : true,
			
			},
			"check.checkDate":{
				required : true,
				date:true
			
			},
			"check.amount":{
				required : true,
				number:true,
				min:1
			},
			"payment.status":{
				required : true,
				
			},
			"payment.remark":{
				required : true,
			
			},
			"payment.payeeName":{
				required : true,
				
			},
			"check.checkNo":{
				required : true,
				number:true,
				minlength:1
			},
			"payment.transactionid":{
				required : true,
				
			},


		},
		messages : {

		
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
