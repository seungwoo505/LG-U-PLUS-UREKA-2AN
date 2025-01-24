const canvas = document.getElementById("myCanvas");
const ctx = canvas.getContext('2d');

let isDrawing = false;

function startDrawing (e) {
    isDrawing = true;
    ctx.beginPath();
    ctx.moveTo(e.offsetX, e.offsetY);
    //console.log("마우스가 눌러짐");
}

function stopDrawing () {
    isDrawing = false;
    ctx.closePath();
}

function draw(e) {
    if(isDrawing){
        //console.log("마우스가 이동됨 ", e);
        ctx.lineTo(e.offsetX, e.offsetY);
        ctx.stroke();
    }
}

canvas.addEventListener('mousemove', draw);
canvas.addEventListener('mousedown', startDrawing);
canvas.addEventListener('mouseup', stopDrawing);