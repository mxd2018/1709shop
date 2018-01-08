function changeimg() {
	var i = 1;
	var banner = document.getElementById("banner");
	setInterval(changeimg, 2000);
	if (i == 1) {
		banner.src = "images/img/b2.jpg";
		i++;
	} else {
		banner.src = "images/img/b1.jpg";
		i = 1;
	}
}

function show_ad() {
	var img = document.getElementById("img");
	var set = setTimeout(show_ad, 2000);
	img.style.display = "block";
	clearTimeout(set);
	setTimeout(hidden_ad, 5000);
}
function hidden_ad() {
	img.style.display = "none";
}