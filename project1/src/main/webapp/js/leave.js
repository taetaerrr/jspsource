/**
 * 
 */
// 회원탈퇴 클릭 시 form submit 중지
// 정말로 탈퇴하시겟습니까?
document.querySelector("form").addEventListener("submit", (e) => {
	
	e.preventDefault();

	// 확인 : true, 취소 : false
	// const result =confirm("정말로 탈퇴하시겠습니까?")
	// console.log(result);
	
	// 확인인 경우 form submit
	if(confirm("정말로 탈퇴하시겠습니까?")){
	e.target.sumit();
	}
});





