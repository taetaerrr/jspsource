
// 수정 클릭 시 price 의 값이 숫자가 들어있는지 확인
document.querySelector("body div:nth-child(3) form").addEventListener("submit", (e) => {
	e.preventDefault();

	const form = e.target;

	const code = form.querySelector("#code");
	const title = form.querySelector("#title");
	const writer = form.querySelector("#writer");
	const price = form.querySelector("#price");

	const codeReg = /^[0-9]{4}$/;
	const textReg = /[A-Za-z가-힣0-9]+/;
	const priceReg = /^[0-9]{3,10}$/;

	if (!codeReg.test(code.value)) {
		alert("도서코드는 4자리 숫자로 입력해야 합니다. ");
		//		price.focus();
		price.select();  // focus + 입력값 존재 시 블럭으로 잡아줌
		return;
	} else if (!textReg.test(title.value)) {
		alert("도서명을 입력하세요");
		//		price.focus();
		price.select();  // focus + 입력값 존재 시 블럭으로 잡아줌
		return;
	} else if (!textReg.test(writer.value)) {
		alert("도서 저자를 입력하세요");
		//		price.focus();
		price.select();  // focus + 입력값 존재 시 블럭으로 잡아줌
		return;
	} else if (!priceReg.test(price.value)) {
		alert("가격을 입력하세요");
		//		price.focus();
		price.select();  // focus + 입력값 존재 시 블럭으로 잡아줌
		return;
	}

	// 이상이 없는 경우 form 전송
	form.submit();

});/**
 * 
 */