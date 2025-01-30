let x_row = 0;
let y_row = 0;

document.querySelectorAll('.card').forEach(card => {
    card.addEventListener('click', (e) => {
      const x = e.offsetX - (card.offsetWidth/2);
      const y = (card.offsetHeight/2) - e.offsetY;

      const y_max = card.offsetHeight * 0.3;
      const x_max = card.offsetWidth * 0.3;

      const top = (card.offsetHeight/2) - y_max;
      const right = (card.offsetWidth/2) - x_max;
      const button = y_max - (card.offsetHeight/2);
      const left = x_max - (card.offsetWidth/2);

      if(card.classList.length > 1){
        x_row = 0;
        y_row = 0;
        card.className = "card";
        card.style = `transform : rotateX(${x_row}deg) rotateY(${y_row}deg)`;
      }
      else if(y > top){
        document.getElementsByClassName("card-back")[0].id = "top";
        x_row -= 180;
        card.style = `transform : rotateX(${x_row}deg) rotateY(${y_row}deg)`;
        card.className +=  ' top';
      }else if(y < button){
        document.getElementsByClassName("card-back")[0].id = "button";
        x_row += 180;
        card.style = `transform : rotateX(${x_row}deg) rotateY(${y_row}deg)`;
        card.className +=  ' button';
      }
      else if(x > right){
        document.getElementsByClassName("card-back")[0].id = "right";
        y_row -= 180;
        card.style = `transform : rotateX(${x_row}deg) rotateY(${y_row}deg)`;
        card.className +=  ' right';
      }
      else if(x < left){
        document.getElementsByClassName("card-back")[0].id = "left";
        y_row += 180;
        card.style = `transform : rotateX(${x_row}deg) rotateY(${y_row}deg)`;
        card.className +=  ' left';
      }
    });

    card.addEventListener('mousemove', (e) => {
      const x = e.offsetX;
      const y = e.offsetY;

      const rotateY = (card.classList[1] === "top" || card.classList[1] === "button" ? -1 : 1) * (-40/card.offsetWidth * x + 20 + y_row);
      const rotateX = 40/card.offsetHeight * y - 20 + x_row;
      
      card.style = `transform : rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
    });


    card.addEventListener('mouseleave', () => {
      card.style.transform = `rotateX(${x_row}deg) rotateY(${y_row}deg)`;
    });
    
  });
  
  document.getElementById('link').addEventListener('click', (e) =>{
    e.stopPropagation();
  });