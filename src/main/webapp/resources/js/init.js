$(document).ready(function() { 
	$('.login-board').hide();
	
	$('.ingestion-update-btn').prop('disabled',true);
	$('.ingestion-update-btn').addClass('inactive-btn');
	
	$('.likes-update-btn').prop('disabled',true);
	$('.likes-update-btn').addClass('inactive-btn');
});

//뒤로가기 후 페이지 리로드
window.addEventListener( "pageshow", function ( event ) {
	  var historyTraversal = event.persisted || 
	                         ( typeof window.performance != "undefined" && 
	                              window.performance.navigation.type === 2 );
	  if ( historyTraversal ) {
	    window.location.reload();
	 }
});

$(function(){
	
	$("#autocomplete").autocomplete({
		source : function( request, response){
			$.ajax({
				type : "post",
				dataType : "JSON",
				url : "selectSearch.do",
				data : "term="+request.term,
				success : function(data){
					response(data);
					console.info(data);
				}
			});
		}
	});
});