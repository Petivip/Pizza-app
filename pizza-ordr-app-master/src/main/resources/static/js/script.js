// Material Select Initialization
$(document).ready(function() {
    $('.mdb-select').materialSelect();
});

new WOW().init();


function pepperoniToggle() {
    document.getElementById('pepperoni-pic').style.visibility =
        document.getElementById('pepperoni-pic').style.visibility == 'visible'? 'hidden' : 'visible';
}

function mushroomToggle() {
    document.getElementById("shroom1").style.visibility =
        document.getElementById('shroom1').style.visibility == 'visible'? 'hidden' : 'visible';

    document.getElementById("shroom2").style.visibility =
        document.getElementById('shroom2').style.visibility == 'visible'? 'hidden' : 'visible';
}

function greenPepperToggle() {
    document.getElementById("green-pepper").style.visibility =
        document.getElementById('green-pepper').style.visibility == 'visible'? 'hidden' : 'visible';
}