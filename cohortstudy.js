window.onload = function() {
	var form = document.getElementById("cohortstudycalculator");
	form.onsubmit = function() {
		var expdisease = parseFloat(document.getElementById("expdisease").value);
		var expnondisease = parseFloat(document.getElementById("expnondisease").value);
		var nonexpdisease = parseFloat(document.getElementById("nonexpdisease").value);
		var nonexpnondisease = parseFloat(document.getElementById("nonexpnondisease").value);
		var disease = document.getElementById("disease").value;
		var exposure = document.getElementById("exposure").value;
		var relativerisk = (expdisease/(expdisease+expnondisease))/(nonexpdisease/(nonexpdisease+nonexpnondisease));
		if (relativerisk < 1) {
			relativerisk = (1 - relativerisk) * 100;
			relativerisk = relativerisk.toPrecision(2);
			var output = document.getElementById("result");
			output.innerHTML = "For those exposed to " + exposure + ", they have a " + relativerisk + "% lower chance to develop " + disease + " compared to those not exposed to " + exposure + ".";
		} else {
			relativerisk = (relativerisk - 1) * 100;
			relativerisk = relativerisk.toPrecision(2);
			var output = document.getElementById("result");
			output.innerHTML = "For those exposed to " + exposure + ", they have a " + relativerisk + "% higher chance to develop " + disease + " compared to those not exposed to " + exposure + ".";
		}
		return false;
	}
}