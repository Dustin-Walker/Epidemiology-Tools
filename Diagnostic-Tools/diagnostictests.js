window.onload = function() {
	var form = document.getElementById("screeningtests");
	form.onsubmit = function() {
	/*
	 tp = true positive
	 fn = false negative
	 fp = false positive
	 tn = true negative	 
	 */
		var tp = parseFloat(document.getElementById("tp").value);
		var fn = parseFloat(document.getElementById("fn").value);
		var fp = parseFloat(document.getElementById("fp").value);
		var tn = parseFloat(document.getElementById("tn").value);
		var sensitivity = tp/(tp+fn);
		sensitivity = sensitivity.toPrecision(2);
		var specificity = tn/(tn+fp);
		specificity = specificity.toPrecision(2);
		var ppv = tp/(tp+fp);
		ppv = ppv.toPrecision(2);
		var npv = tn/(tn+fn);
		npv = npv.toPrecision(2);
		var fpr = fp/(fp+tn);
		fpr = fpr.toPrecision(2);
		var fdr = fp/(tp+fp);
		fdr = fdr.toPrecision(2);
		var fnr = fn/(fn+tp);
		fnr = fnr.toPrecision(2);
		var acc = (tp+tn)/(tp+fn+fp+tn);
		acc = acc.toPrecision(2);
		var f1score = 2*tp/(2*tp+fp+fn);
		f1score = f1score.toPrecision(2);
		var mcc = (tp*tn-fp*fn)/(Math.sqrt((tp+fp)*(tp+fn)*(tn+fp)*(tn+fn)));
		mcc = mcc.toPrecision(2);
		var informedness = (tp/(tp+fn)) + (tn/(tn+fp)) - 1;
		informedness = informedness.toPrecision(2);
		var markedness = (tp/(tp+fp)) + (tn/(tn+fn)) - 1;
		markedness = markedness.toPrecision(2);
		var output = document.getElementById("result");
		output.innerHTML = "Sensitivity: " + sensitivity + "<P>Specificity: " + specificity + "<P>PPV: " + ppv + "<P>NPV: " + npv + "<P>FPR: " + fpr + "<P>FDR: " + fdr + "<P>FNR: " + fnr + "<P>ACC: " + acc + "<P>F1 Score: " + f1score + "<P>MCC: " + mcc;
		return false;
	}
}