document.querySelectorAll('.card').forEach(card => {
    card.addEventListener('click', () => {
      card.classList.toggle('flip');
    });
  });
  
  document.getElementById('link').addEventListener('click', (e) =>{
    e.stopPropagation();
  })