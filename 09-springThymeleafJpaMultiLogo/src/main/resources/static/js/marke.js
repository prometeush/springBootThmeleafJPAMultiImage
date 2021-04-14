$(function() {

	$("#primaryImage").change(function() {
		showImagefile(this);
	});
	
	$('input[name="extraImage"').each(function(index) {
		$(this).change(function() {
			showImageExtrafile(this, index);
		});
	});
		
	function showImagefile(fileInput) {
			file = fileInput.files[0];
			reader = new FileReader();

			reader.onload = function(e) {
				$("#imageShow").attr("src", e.target.result);
			};
			reader.readAsDataURL(file);
		}
		
	
		
    function showImageExtrafile(fileInput,index) {
			file = fileInput.files[0];
			reader = new FileReader();

			reader.onload = function(e) {
				$("#imageShow"+index).attr("src", e.target.result);
			};
			reader.readAsDataURL(file);
		}
		
	})