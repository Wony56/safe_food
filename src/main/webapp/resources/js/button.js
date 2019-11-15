//로그인버튼
$(document).on('click','#login-btn', function(){
	$('#login').slideToggle("fast");
});

//회원가입버튼
$(document).on('click','#signup-btn', function(){
	$(location).attr('href','signUp.jsp');
});

//회원탈퇴버튼
$(document).on('click','#membership-withdrawal', function(){
	confirm("탈퇴하시겠습니까?");
	$(location).attr('href', 'deleteMember.do');
})

//회원정보버튼
$(document).on('click','#memberinfo-btn', function(){
	$(location).attr('href','memberInfo.jsp');
});

//로그아웃버튼
$(document).on('click','#logout-btn', function(){
	$(location).attr('href','logOut.do');
});

//패스워드찾기버튼
$(document).on('click','#find-pwd', function(){
	$(location).attr('href', 'findPwd.jsp');
});

//메인으로 버튼
$(document).on('click','#go-home', function(){
	$(location).attr('href', 'index.jsp');
});

// Ingestion 버튼
$(document).on('click','.ingestion-btn', function(){
	var foodName = $(this).attr('id');
	$(location).attr('href','addIngestion.do?foodName='+foodName);
});

//수량증가 버튼(Ingestion)
$(document).on('click', '.ingestion-up-btn', function(){
	var count = parseInt($(this).parent('span').next().text());
	var updateBtn = $(this).parents('.quantity-el-set').next();
	
	updateBtn.prop('disabled', false);
	updateBtn.removeClass('inactive-btn');
	updateBtn.addClass('active-btn');
	$(this).parent('span').next().css('color', 'red');
	
	$(this).parent('span').next().text(count+1);
});

// 수량감소 버튼(Ingestion)
$(document).on('click', '.ingestion-down-btn', function(){
	var count = parseInt($(this).parent('span').prev().text());
	var updateBtn = $(this).parents('.quantity-el-set').next();
	
	if(count > 1){
		updateBtn.prop('disabled', false);
		updateBtn.removeClass('inactive-btn');
		updateBtn.addClass('active-btn');
		$(this).parent('span').prev().css('color', 'red');
		
		$(this).parent('span').prev().text(count-1);
	}
});

//섭취 변경버튼
$(document).on('click', '.ingestion-update-btn', function(){
	var foodName = $(this).attr('id');
	var quantity = $(this).prev().find('#quantity').text();
	
	$(location).attr('href','updateIngestionRowQuantity.do?foodName='+foodName+'&quantity='+quantity);
});

// Likes 버튼
$(document).on('click','.likes-btn', function(){
	var foodName = $(this).attr('id');
	$(location).attr('href','addLikes.do?foodName='+foodName);
});

//수량증가 버튼(Likes)
$(document).on('click', '.likes-up-btn', function(){
	var count = parseInt($(this).parent('span').next().text());
	var updateBtn = $(this).parents('.quantity-el-set').next();
	
	updateBtn.prop('disabled', false);
	updateBtn.removeClass('inactive-btn');
	updateBtn.addClass('active-btn');
	$(this).parent('span').next().css('color', 'red');
	
	$(this).parent('span').next().text(count+1);
});

// 수량감소 버튼(Likes)
$(document).on('click', '.likes-down-btn', function(){
	var count = parseInt($(this).parent('span').prev().text());
	var updateBtn = $(this).parents('.quantity-el-set').next();
	
	if(count > 1){
		updateBtn.prop('disabled', false);
		updateBtn.removeClass('inactive-btn');
		updateBtn.addClass('active-btn');
		$(this).parent('span').prev().css('color', 'red');
		
		$(this).parent('span').prev().text(count-1);
	}
});

//예상섭취 변경버튼
$(document).on('click', '.likes-update-btn', function(){
	var foodName = $(this).attr('id');
	var quantity = $(this).prev().find('#quantity').text();
	
	$(location).attr('href','updateLikesRowQuantity.do?foodName='+foodName+'&quantity='+quantity);
});

//up-arrow 버튼
$(document).on('click', '#up-btn', function(){
	var count = parseInt($('#quantity').val());
	$('#quantity').val(count+1);
});

//down-arrow 버튼
$(document).on('click', '#down-btn', function(){
	var count = parseInt($('#quantity').val());
	
	if(count > 1){
		$('#quantity').val(count-1);
	}
	
});

$(document).on('click', '.quantity-update-ingestion', function(){
	var quantity = parseInt($('#quantity').val());
	var foodName = $(this).attr('id');
	$(location).attr('href','updateIngestionQuantity.do?foodName='+foodName+'&quantity='+quantity);
});

$(document).on('click', '.quantity-update-likes', function(){
	var quantity = parseInt($('#quantity').val());
	var foodName = $(this).attr('id');
	$(location).attr('href','updateLikesQuantity.do?foodName='+foodName+'&quantity='+quantity);
});

//공지사항 작성버튼
$(document).on('click', '#notice-register-btn', function(){
	$(location).attr('href', 'noticeRegister.jsp');
});

//취소버튼
$(document).on('click', '#cancel-btn', function(){
	history.go(-1);
});

//공지사항 목록버튼
$(document).on('click', '.notice-list-btn', function(){
	$(location).attr('href', 'getNoticeList.do');
});

//공지사항 수정버튼
$(document).on('click', '.notice-update-btn', function(){
	$(location).attr('href', 'noticeUpdate.jsp');
});

//공지사항 삭제버튼
$(document).on('click', '.notice-delete-btn', function(){
	$(location).attr('href', 'deleteNotice.do?idx='+$(this).attr('id'));
});

function check(){
	alert("ㅅㄷㄴㅅㅁㄴㅇㄻㄴㅇㄹ");
	var deleteArr = document.getElementsByname('deleteCheck');
	var cnt = 0;
	for(var i=0; i<deleteArr.length; i++){
		if(deleteArr[i].checked == true){
			list.push(deleteArr[i]);
			cnt++;
		}
	}
	
	if(cnt == 0){
		return false;
	}
	return true;
}

function backPage(){
	history.back();
}





