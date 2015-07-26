window.onload = function() {
	var form = document.getElementById("screeningtests");
	form.onsubmit = function() {
	/*
	 tp = true positive
	 fn = false negative
	 fp = false positive
	 tn = true negative	 
	 */
		var truePositive = parseFloat(document.getElementById("tp").value);
		var falseNegative = parseFloat(document.getElementById("fn").value);
		var falsePositive = parseFloat(document.getElementById("fp").value);
		var trueNegative = parseFloat(document.getElementById("tn").value);
		var sensitivity = truePositive/(truePositive+falseNegative);
		sensitivity = sensitivity.toPrecision(2);
		var specificity = trueNegative/(trueNegative+falsePositive);
		specificity = specificity.toPrecision(2);
		var ppv = truePositive/(truePositive+falsePositive);
		ppv = ppv.toPrecision(2);
		var npv = trueNegative/(trueNegative+falseNegative);
		npv = npv.toPrecision(2);
		var fpr = falsePositive/(falsePositive+trueNegative);
		fpr = fpr.toPrecision(2);
		var fdr = falsePositive/(truePositive+falsePositive);
		fdr = fdr.toPrecision(2);
		var fnr = falseNegative/(falseNegative+truePositive);
		fnr = fnr.toPrecision(2);
		var acc = (truePositive+trueNegative)/(truePositive+falseNegative+falsePositive+trueNegative);
		acc = acc.toPrecision(2);
		var f1score = 2*truePositive/(2*truePositive+falsePositive+falseNegative);
		f1score = f1score.toPrecision(2);
		var mcc = (truePositive*trueNegative-falsePositive*falseNegative)/(Math.sqrt((truePositive+falsePositive)*(truePositive+falseNegative)*(trueNegative+falsePositive)*(trueNegative+falseNegative)));
		mcc = mcc.toPrecision(2);
		var informedness = (truePositive/(truePositive+falseNegative)) + (trueNegative/(trueNegative+falsePositive)) - 1;
		informedness = informedness.toPrecision(2);
		var markedness = (truePositive/(truePositive+falsePositive)) + (trueNegative/(trueNegative+falseNegative)) - 1;
		markedness = markedness.toPrecision(2);
		var output = document.getElementById("result");
		output.innerHTML = "Sensitivity: " + sensitivity + "<br />Specificity: " + specificity + "<br />PPV: " + ppv + "<br />NPV: " + npv + "<br />FPR: " + fpr + "<br />FDR: " + fdr + "<br />FNR: " + fnr + "<br />ACC: " + acc + "<br />F1 Score: " + f1score + "<br />MCC: " + mcc;
		return false;
	}
}