document.querySelectorAll('.card').forEach(card => {
    card.addEventListener('click', (e) => {
      const x = e.offsetX - (card.offsetWidth/2);
      const y = (card.offsetHeight/2) - e.offsetY;

      const y_max = card.offsetHeight * 0.1;
      const x_max = card.offsetWidth * 0.1;

      const top = (card.offsetHeight/2) - y_max;
      const right = (card.offsetWidth/2) - x_max;
      const button = y_max - (card.offsetHeight/2);
      const left = x_max - (card.offsetWidth/2);

      if(card.classList.length > 1){
        card.className = "card";
        card.style = `transform : rotateX(0deg)`;
      }
      else if(y > top){
        document.getElementsByClassName("card-back")[0].id = "top";
        card.style = `transform : rotateX(-180deg)`;
        card.className +=  ' top';
      }else if(y < button){
        document.getElementsByClassName("card-back")[0].id = "button";
        card.style = `transform : rotateX(180deg)`;
        card.className +=  ' button';
      }
      else if(x > right){
        document.getElementsByClassName("card-back")[0].id = "right";
        card.style = `transform : rotateX(0deg) rotateY(-180deg)`;
        card.className +=  ' right';
      }
      else if(x < left){
        document.getElementsByClassName("card-back")[0].id = "left";
        card.style = `transform : rotateX(0deg) rotateY(180deg)`;
        card.className +=  ' left';
      }
    });

    card.addEventListener('mousemove', (e) => {
      const x = e.offsetX;
      const y = e.offsetY;

      const rotateY = (card.classList[1] === "top" || card.classList[1] === "button" ? -1 : 1) * (-40/card.offsetWidth * x + 20 + (card.classList[1] === "right" ? -180 : card.classList[1] === "left" ? 180 : 0));
      const rotateX = 40/card.offsetHeight * y - 20 + (card.classList[1] === "top" ? -180 : card.classList[1] === "button" ? 180 : 0);
      
      card.style = `transform : rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
    });


    card.addEventListener('mouseleave', () => {
      card.style.transform = `rotateX(${card.classList[1] === "top" ? -180 : card.classList[1] === "button" ? 180 : 0}deg) rotateY(${card.classList[1] === "right" ? -180 : card.classList[1] === "left" ? 180 : 0}deg)`;
    });
    
  });
  
  document.getElementById('link').addEventListener('click', (e) =>{
    e.stopPropagation();
  });