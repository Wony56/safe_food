$(function(){
	$('#cellPhone').on('keyup',function(){
		var value = $('#cellPhone').val().trim();
		var tmp = autoHypenPhone(value);
		$('#cellPhone').val(tmp);
	});
})

function invalidCheck(){
	var id = document.getElementById('id-up');
	var pw = document.getElementById('pass-up');
	var name = document.getElementById('name');
	var addr = document.getElementById('addr');
	var phone = document.getElementById('cellPhone');
	
	if(id.value.trim() === ""){
		alert("아이디를 입력해주세요");
		id.focus();
		return false;
	}
	
	if(pw.value.trim() === ""){
		alert("비밀번호를 입력해주세요");
		pw.focus();
		return false;
	}

	if(name.value.trim() === ""){
		alert("이름을 입력해주세요");
		name.focus();
		return false;
	}
	
	if(addr.value.trim() === ""){
		alert("주소를 입력해주세요")
		addr.focus();
		return false;
	}
	
	if(phone.value.trim() === ""){
		alert("전화번호를 입력해주세요");
		phone.focus();
		return false;
	}
	
	return true;
}

function autoHypenPhone(str){
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	
	if(str.length < 4){
		return str;
	}else if(str.length < 7){
		tmp += str.substr(0,3);
		tmp += '-';
		trmp +=  str.substr(3);
		return tmp;
	}else if(str.length < 11){
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3,3);
		tmp += '-';
		tmp += str.substr(6);
		return tmp;
	}else{
		tmp += str.substr(0,3);
		tmp += '-';
		tmp += str.substr(3, 4);
		tmp += '-';
		tmp += str.substr(7);
		return tmp;
	}

	return str;
}