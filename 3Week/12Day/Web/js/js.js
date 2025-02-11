const login = () =>{
    let id = document.getElementById("id").innerHTML;
    let pw = document.getElementById("pw").innerHTML;

    fetch("https://seungwoo.i234.me:3333/login", {
        method : "POST",
        body : JSON.stringify({
            userId : id,
            password : pw
        })
    })
    .then(e => console.log(e))
    .then(e => console.error(e));
}