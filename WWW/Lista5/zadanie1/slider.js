window.onload = function() {
  changeSlide();
}

let number = Math.floor(Math.random()*5) + 1;
let cursorOnSlide = false;

let timer1;
let timer2;

function hideCurrentSlide() {
  $("#slider").fadeOut(500);
}

function changeSlide() {
  if(cursorOnSlide == false) {
    number++; if (number > 5) number = 1;
    var plik = "<img src=\"img/slajd" + number + ".jpg\"/>";
    document.getElementById("slider").innerHTML = plik;
  }

  $("#slider").fadeIn(500);

  document.getElementById("slider").onmouseover = function() { cursorOnSlide = true; clearTimeout(timer1); clearTimeout(timer2); }
  document.getElementById("slider").onmouseout = function() { cursorOnSlide = false; timer1 = setTimeout("changeSlide()", 1000); timer2 = setTimeout("hideCurrentSlide()", 500); }

  timer1 = setTimeout("changeSlide()", 5000);
  timer2 = setTimeout("hideCurrentSlide()", 4500);
}