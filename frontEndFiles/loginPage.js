function login()
{
	var name = document.getElementById("idName").value;
	var city = document.getElementById("idCity").value;
	var walletAmount = document.getElementById("idWalletAmount").value;
	
	var baseURL = "http://127.0.0.1:8080/user";
	var logiUrl = baseURL + "/login";
	var jsonInput = JSON.stringify({"name":name,"address": city,"walletAmount":walletAmount});
	var user = new User(name, city, walletAmount);
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", logiUrl, true);
	xhttp.setRequestHeader('Content-Type', 'application/json');
	xhttp.send(jsonInput);
}
class User
{
	constructor(name,address, walletAmount)
	{
		this.name = name;
		this.address = address;
		this.walletAmount = walletAmount;
	}
}

function getCurrentUser()
{
	try
	{
		var userUrl = "http://127.0.0.1:8080/user";
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			try
			{
				if (this.readyState == 4 ) {
					showData(this);
				}
			}
			catch(erMs)
			{
				document.getElementById("idCurrentName").innerHTML = erMs;
			}
		};
		xhttp.open("GET", userUrl, true);
		xhttp.setRequestHeader('Content-Type', 'text/plain');
		xhttp.send();
	}
	catch(erMsg)
	{
		document.getElementById("idCurrentName").innerHTML = erMsg;
	}
}

function showData(xhttp) {
  var response = JSON.parse(xhttp.responseText);
  document.getElementById("idCurrentName").innerHTML = response["name"];	
  document.getElementById("idCurrentCity").innerHTML = response["address"];
  document.getElementById("idCurrentWalletAmount").innerHTML = response["walletAmount"];
}



