// 签名结果
var signResult;

// 根据原文和证书产生认证数据包
function login(initParam, random) {
	var issuerDNFilter = "";
	if (random == "") {
		alert("认证原文不能为空!");
		return false;
	} else {
		signResult = detachSignStr(initParam, random, issuerDNFilter);
		if (signResult) {
			$("#signature").val(signResult);
		} else {
			return false;
		}
	}
	
}
