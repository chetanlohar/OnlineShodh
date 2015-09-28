function changeImage(input) {
	/*alert("hi...");*/
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
				$('#categorylogo').attr('src', e.target.result);
		};
		reader.readAsDataURL(input.files[0]);
	}
}