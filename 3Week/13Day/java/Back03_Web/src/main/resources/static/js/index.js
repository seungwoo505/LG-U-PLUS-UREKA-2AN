const headers = { "Content-Type" : "application/json" };

document.getElementById("signupBtn").addEventListener("click", () => {
	const email = document.getElementById("email").value;
	const pwd = document.getElementById("pwd").value;
	
	let data = { email : email, pwd : pwd};
	
	console.log(data);
	data = JSON.stringify(data);
	
	console.log(data);
	
	fetch("insertMember", {
		method : "POST",
		headers : headers,
		body : data
	}).then(async e => {
			console.log(e);
		})
});

document.getElementById("loginBtn").addEventListener("click", () => {
	const email = document.getElementById("email").value;
	const pwd = document.getElementById("pwd").value;
	
	let data = { email : email, pwd : pwd};
	
	console.log(data);
	data = JSON.stringify(data);
	
	console.log(data);
	
	fetch("selectMember", {
		method : "POST",
		headers : headers,
		body : data
	}).then(async e => {
		console.log(e);
	})
});