$(document).ready(function(){
	
	$('#myTab a').click(function (e) {
		  e.preventDefault();
		  $(this).tab('show');
		});
	
	$('#myTab a[href="#profile"]').tab('show'); // Select tab by name
	
	
	
});