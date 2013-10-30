

var parseError = function(data) {
	if (typeof data.errorParams != undefined && typeof data.errorParams.msg != 'undefined') {
		alert (data.errorParams.msg);
	} else {
		alert ('fail');
	}
};