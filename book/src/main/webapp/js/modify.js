// 목록 클릭 시 리스트로 이동
document.querySelector(".btn-primary").addEventListener("click", () => {
	location.href="list_pro.jsp";
	});
	
document.querySelector(".btn-danger").addEventListener("click", () => {

	});

	// 수정 클릭 시 price 의 값이 숫자가 들어있는지 확인	
	document.querySelector("body div:nth-child(3) form").addEventListener("submit", (e) => {
		e.preventDefault();			
		
		// price 찾기
		const price = document.querySelector("#price")
		
		const regEx = /^[0-9]{3,10}$/;
		
		if(regEx.test(price.value)){
			alert("가격을 입력하세요");
			price.focus();
			return;
		}
		
		// 이상이 없는 경우 form 전송
		e.target.submit();
		
});