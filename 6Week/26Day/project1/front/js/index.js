window.onload =  async () => {
  let responseObj = await fetch("http://localhost:8080/getAllProducts", {method : "GET"});
  let arr = await responseObj.json();

  let getAllProductsDiv = '';

  arr.forEach(element => {
    getAllProductsDiv += 
    `<div class="card" style="width: 18rem;">
    <img src="./img/${element.pimg}" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${element.prodname}</h5>
      <p class="card-text">${element.price}</p>
      <a href="#" class="btn btn-primary">Go somewhere</a>
    </div>
  </div>`;
  });

  document.getElementById("productListDiv").innerHTML = getAllProductsDiv;
};