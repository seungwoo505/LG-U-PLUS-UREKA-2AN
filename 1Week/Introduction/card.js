document.querySelectorAll('.card').forEach(card => {
    card.addEventListener('click', (e) => {
      const x = e.offsetX;
      const y = e.offsetY;

      
      card.classList.toggle('flip');
    });

    card.addEventListener('mousemove', (e) => {
      let x = e.offsetX;
      let y = e.offsetY;

      let rotateY = -40/card.offsetWidth * x + 20 + (card.classList[1] === "flip" ? 180 : 0);
      let rotateX = 40/card.offsetHeight * y - 20;

      card.style = `transform : rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
    });


    card.addEventListener('mouseleave', () => {
      card.style.transform = `rotateX(0deg) rotateY(${card.classList[1] === "flip" ? 180 : 0}deg)`;
    });
    
  });
  
  document.getElementById('link').addEventListener('click', (e) =>{
    e.stopPropagation();
  });