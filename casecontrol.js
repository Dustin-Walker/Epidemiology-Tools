window.onload = function() {
	var form = document.getElementById("casecontrolcalculator");
	form.onsubmit = function() {
		var expcase = parseFloat(document.getElementById("expcase").value);
		var expcontrol = parseFloat(document.getElementById("expcontrol").value);
		var noncase = parseFloat(document.getElementById("noncase").value);
		var noncontrol = parseFloat(document.getElementById("noncontrol").value);
		var disease = document.getElementById("disease").value;
		var exposure = document.getElementById("exposure").value;
		var oddsratio = expcase * noncontrol / expcontrol / noncase;
		if (oddsratio < 1) {
			oddsratio = (1 - oddsratio) * 100;
			oddsratio = oddsratio.toPrecision(2);
			var output = document.getElementById("result");
			output.innerHTML = "For those with " + disease + ", they have " + oddsratio + "% lower odds of having been exposed to " + exposure + " than those without " + disease + ".";
		} else {
			oddsratio = (oddsratio - 1) * 100;
			oddsratio = oddsratio.toPrecision(2);
			var output = document.getElementById("result");
			output.innerHTML = "For those with " + disease + ", they have " + oddsratio + "% higher odds of having been exposed to " + exposure + " than those without " + disease + ".";
		}
		return false;
	}
}