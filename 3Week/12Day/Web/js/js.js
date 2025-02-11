const sign1 = () => {
    document.getElementById("login").innerHTML = `id : <input id="id" autocomplete="username" type="text" name="id"><br>
        password : <input id="pw" autocomplete="current-password" type="password" name="password"><br>
        nickname : <input id="nickname" type="text" name="nickname"><br>
        <button onclick="sign2()">가입하기</button>`;
}

const sign2 = () => {
    const id = document.getElementById("id").value;
    const pw = document.getElementById("pw").value;
    const nickname = document.getElementById("nickname").value;
    
    fetch("https://seungwoo.i234.me:3333/signUp", {
        method : "POST",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify({
            userId : id,
            password : pw,
            nickname : nickname
        })
    })
    .then( async e =>{
        const data = await e.json();
        alert(data.message);
        if(data.success)document.getElementById("login").innerHTML = `id : <input id="id" autocomplete="username" type="text" name="id"><br>
        password : <input id="pw" autocomplete="current-password" type="password" name="password"><br>
        <button onclick="login()">로그인</button>`;
    });
}

const login = () =>{
    const id = document.getElementById("id").value;
    const pw = document.getElementById("pw").value;
    
    fetch("https://seungwoo.i234.me:3333/login", {
        method : "POST",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify({
            userId : id,
            password : pw
        })
    })
    .then( async e =>{
        const data = await e.json();
        alert(data.message);
        if(data.success)document.getElementById("login").innerHTML = `${data.nickname}님 환영합니다.<button onClick="logout()">로그아웃</button>`;
    });
}

const logout = () => {
    document.getElementById("login").innerHTML = `id : <input id="id" autocomplete="username" type="text" name="id"><br>
        password : <input id="pw" autocomplete="current-password" type="password" name="password"><br>
        <button onclick="login()">로그인</button>`;
}

const book = () => {
    const book = document.getElementById("book").value;

    fetch("https://seungwoo.i234.me:3333/bookSearch", {
        method : "POST",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify({
            book : book
        })
    })
    .then( async e =>{
        const data = await e.json();
        alert(data.message);
        alert(`제목 : ${data.book[0]}\n지은이 : ${data.book[1]}\n줄거리 : ${data.book[2]}`);
    });
}

const bookAdd = () => {
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const plot = document.getElementById("plot").value;

    fetch("https://seungwoo.i234.me:3333/bookAdd", {
        method : "POST",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify({
            title : title,
            author : author,
            plot : plot
        })
    })
    .then( async e =>{
        const data = await e.json();
        alert(data.message);
        document.getElementById("title").value = "";
        document.getElementById("author").value = "";
        document.getElementById("plot").value = "";
    });
};