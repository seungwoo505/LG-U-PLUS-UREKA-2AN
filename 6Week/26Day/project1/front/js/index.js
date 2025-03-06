window.onload =  async () => {
  const email = sessionStorage.getItem("email");
  if(email !== null){
    document.getElementById("loginSpan").innerHTML = email + `<button id = "logoutBtn" class="btn btn-outline-danger">로그아웃</button>`;
  }
  axios.defaults.withCredentials = true;
  console.log(axios);
  let responseObj = await fetch("http://localhost:8080/getAllProducts", {method : "GET"});
  let arr = await responseObj.json();

  let getAllProductsDiv = '';

  arr.forEach(element => {
    getAllProductsDiv += 
    `<div class="card" style="width: 18rem;">
    <img src="./img/${element.pimg}" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${element.prodname}</h5>
      <p class="card-text">${element.price}원</p>
      <a href="#" class="btn btn-outline-info" id="addCart">장바구니 담기</a>
    </div>
  </div>`;
  });

  document.getElementById("productListDiv").innerHTML = getAllProductsDiv;
};

document.getElementById("signupBtn").addEventListener("click", async () => {
  const nickname = document.getElementById("nickname").value;
  const email = document.getElementById("email").value;
  const pw = document.getElementById("pw").value;
  const data = { nickname, email, pw };
  let response = await fetch("http://localhost:8080/insertMember", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: JSON.stringify(data),
  });
  response = await response.json();
  console.log(response.msg);
  if (response.msg === "ok") {
    console.log("ok");
    const modal = bootstrap.Modal.getInstance(document.getElementById("signupModal"));
    modal.hide();
    //hero icons
    /* document.getElementById("loginSpan").innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6" width="24" height="24">
  <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0 0 13.5 3h-6a2.25 2.25 0 0 0-2.25 2.25v13.5A2.25 2.25 0 0 0 7.5 21h6a2.25 2.25 0 0 0 2.25-2.25V15M12 9l-3 3m0 0 3 3m-3-3h12.75" />
</svg>`; */
    document.getElementById("signupLi").remove();
  }
});

document.getElementById("loginBtn").addEventListener("click", async () => {
  const email = document.getElementById("loginEmail").value;
  const pw = document.getElementById("loginPw").value;
  const data = { email, pw };
  let response = await axios.post("http://localhost:8080/login", data);
  // response = await response.json();
  console.log(response.data.msg);
  alert(response.data.msg);
  if(response.data.msg === "ok"){
    const modal = bootstrap.Modal.getInstance(document.getElementById("loginModal"));
    modal.hide();

    document.getElementById("loginSpan").innerHTML = email + `<button id = "logoutBtn" class="btn btn-outline-danger">로그아웃</button>`;

    window.sessionStorage.setItem("email", email);
  }
});

document.getElementById("productListDiv").addEventListener("click", (e) => {
  if(e.target.id === "addCart"){
    axios.post("http://localhost:8080/addCart", {});


  }
});

document.getElementById("loginSpan").addEventListener("click", (e) => {
  if(e.target.id === "logoutBtn"){
    window.sessionStorage.removeItem("email");
    window.location.reload();
  }
});