function createXMLHttp(cbFunc){
	var XMLhttpObject = null;
	try{
		XMLhttpObject = new XMLHttpRequest();
	}catch (e) {
		try{
			// IE 6
			XMLhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (e) {
			try {
				// IE 5
				XMLhttpObject = new ActiveXObject("Microsoft.XMLHTTP")
			} catch (e) {
				return null;
			}
		}
	}
	
	if(XMLhttpObject){
		XMLhttpObject.onreadystatechange = cbFunc;
	}
	return XMLhttpObject;
}