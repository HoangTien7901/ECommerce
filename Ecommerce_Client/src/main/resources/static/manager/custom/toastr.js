
$(document).ready(function() {
	var msg = $('#msg').val();
	var msgType = $('#msgType').val();
	
	var timeOut = "2000";
	if (msgType === 'danger') {
		timeOut = "0";
	}
	
	toastr.options = {
		"newestOnTop": true,
  		"closeButton": false,
  		"debug": false,
  		"newestOnTop": false,
  		"progressBar": true,
  		"positionClass": "toast-top-right",
  		"preventDuplicates": false,
  		"onclick": null,
  		"showDuration": "300",
  		"hideDuration": "1000",
  		"timeOut": timeOut,
  		"extendedTimeOut": "1000",
  		"showEasing": "swing",
  		"hideEasing": "linear",
  		"showMethod": "fadeIn",
  		"hideMethod": "fadeOut"
	}
	
	if (msg) {
		if (msgType === 'danger') {
			toastr.error(msg);
		} else {
			toastr.success(msg);
		}
	}
})




