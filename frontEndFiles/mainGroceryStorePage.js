function displayStoreInventory()
{
	var groceryStoreUrl = "http://127.0.0.1:8080/groceryStore";
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			try
			{
				if (this.readyState == 4 ) {
					document.getElementById("idDisplayStore").innerHTML = this.responseText;
				}
			}
			catch(erMs)
			{
				document.getElementById("idDisplayStore").innerHTML = erMs;
			}
		};
		xhttp.open("GET", groceryStoreUrl, true);
		xhttp.setRequestHeader('Content-Type', 'application/json');
		xhttp.send();
}

function addItemToInventory()
{
	
	
}

function updateItemByPrice()
{
	
	
}

function displayCart()
{
	
	
	
}

function addToCartUsingBranfAndCategory()
{
	
	
	
}


function addToCartUsingItemId()
{
	
	
}

function removeItemFromCartUsingItemId()
{
	
	
	
}


function logOut()
{
	location.replace("loginPage.html");
	
}