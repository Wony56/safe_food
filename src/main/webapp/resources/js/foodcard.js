$(document).ready(function() { 
	$('.food-card').not('.food-buttons').click(function(){
		var foodName = $(this).attr('id');
		$(location).attr('href', 'getFoodInfo.do?foodName='+foodName);
	});
});