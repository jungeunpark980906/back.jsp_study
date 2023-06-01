//화면에서 등록한 댓글내용을 컨트롤러로 전송 
async function postCommentToServer(cmtData){
	try{
		const url = "/cmt/post";
		const config = {
			method: 'post',
			headers:{
				'content-Type': 'application/json; charset=utf-8'
			},
			body:JSON.stringify(cmtData)
		};
		const resp = await fetch(url, config); 
		const result = await resp.text(); 
		return result;
	}catch(error){
		console.log(error);
	}
	
}



//cmtData 만들기
document.getElementById('cmtAddBtn').addEventListener('click',()=>{
	const cmtText = document.getElementById('cmtText').value;
	console.log(cmtText);
	
	if(cmtText == null || cmtText == ""){ 
		alert("댓글을 입력해라");
		return false;
	}else{
		let cmtData = { 
			bno : bnoVal,
			writer : document.getElementById('cmtWriter').value,
			content : cmtText 
		};
		postCommentToServer(cmtData).then(result=>{
			if(result > 0){
				alert('댓글이 등록되었동');
				document.getElementById('cmtText').value=""; 
			}
			//댓글 표시
			printCommentList(cmtData.bno);
		});
		
	}
	
}) 


//댓글가져오기
async function getCommentListFromServer(bno){
	try{
		const resp = await fetch('/cmt/list/'+bno); 
		const cmtList = await resp.json(); 
		return cmtList;
	}catch(error){
		console.log(error);
	}
	
}
getCommentListFromServer(bnoVal).then(result=>{
	console.log(result);
})



//통신 완료후 가져온 리스트를 콘솔에 찍어본 작업
function printCommentList(bno){
	getCommentListFromServer(bno).then(result=>{
		console.log(result);
		if(result.length >0){ 
			spreadCommentList(result);
		}else {
			let div = document.getElementById('accordionFlushExample');
			div.innerText="comment가 없습니다.";
		}
	})
}

//댓글 List
function spreadCommentList(result){ 
	console.log(result);
	let div = document.getElementById('accordionFlushExample');
	div.innerHTML="";
	for(let i=0; i<result.length; i++){
	let html = `<div class="accordion-item">`;
	html += `<h2 class="accordion-header" id="heading${i}">`;
	html += `<button class="accordion-button" type="button" data-bs-toggle="collapse" `;
	html += `data-bs-target="#collapse${i}" aria-expanded="true" aria-controls="collapse${i}">`
	html += `${result[i].cno}, ${result[i].writer} </button></h2>`;
	html += `<div id="collapse${i}" class="accordion-collapse collapse show" `;
	html += `aria-labelledby="heading${i}" data-bs-parent="#accordionExample">`;
	html += `<div class="accordion-body">`;
	html += `<button type="button" data-cno="${result[i].cno}" data-writer="${result[i].writer}" 
				class="btn btn-sm btn-outline-warning cmtModBtn">%</button>`;
	html += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-danger cmtDelBtn">X</button>`;
	html += `<input type="text" class="form-control" id="cmtText1" value="${result[i].content}">`;
	html += `${result[i].reg_date}`;
	html += `</div></div></div>`;
	div.innerHTML += html;  
	}	
}

//수정 (업데이트)
async function updateCommentFromServer(cnoVal, cmtText1, writer){
	try{
		const url = "/cmt/modify";
		const config={
			method: "post",
			headers: {
				'Content-Type' : 'application/json; charset=utf-8'
			},
			body: JSON.stringify({cno:cnoVal, content:cmtText1, writer:writer})
		}
		const resp = await fetch(url, config);
		const result = await resp.text();  
		return result;
		
	}catch(error){
		console.log(error);
	}
}

//삭제
async function removeCommentFromServer(cnoVal){
	try{
		const url = '/cmt/remove?cnoVal='+cnoVal;
		const config={
			method:'post'
		}
		const resp = await fetch(url, config);
		const result = await resp.text(); 
		return result;
		
	}catch(error){
		console.log(error);
	}
	
}





document.addEventListener('click', (e)=>{ 
	if(e.target.classList.contains('cmtModBtn')){
		//수정
		let cnoVal = e.target.dataset.cno;
		console.log(cnoVal);
		let div = e.target.closest('div');  
		let cmtText1 = div.querySelector('#cmtText1').value;
		let writer = e.target.dataset.writer;
		

		updateCommentFromServer(cnoVal, cmtText1, writer).then(result=>{
			if(result > 0){
				alert("댓글 수정 성공~!!!");
				console.log(result);
				printCommentList(bnoVal);
			}else{
				alert("수정불가입니다.");
			}
		})
	}
	if(e.target.classList.contains('cmtDelBtn')){
	//삭제
		let cnoVal = e.target.dataset.cno;
		console.log(cnoVal);
		removeCommentFromServer(cnoVal).then(result =>{
			if(result > 0){
				alert('댓글 삭제 완료~!!');
				printCommentList(bnoVal);
				console.log(bnoVal);
			}
		})
	
	}
	
})
