displayStoreInventory();

function displayStoreInventory()
{
	var groceryStoreUrl = "http://127.0.0.1:8080/groceryStore";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		try
		{
			if (this.readyState == 4 && this.status == 200) {
				var itemArray = JSON.parse(this.responseText);
				var list = "<ol id='itemList'>";
				for(var i in itemArray)
				{
					var l = "<ul>" + 
						"<li>" + itemArray[i].brand + " : " + itemArray[i].category  + "</li>" +
						"<li>" + "Price: " + itemArray[i].price + "</li>" +
						"<button class=btnAddToCart onclick=addToCart()>Add to Cart</button><br><br>" + 
						"</ul>";
					list += "<li>" + l + "</li><br><br>";
				}
				list += "</ol>";
				document.getElementById("idDisplayStore").innerHTML = list;
				document.getElementById("idGroceryStoreOptions").style.display="none";
				document.getElementById("idDisplayStore").style.display="block";
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

function openGroceryStoreOptionsPage()
{
	document.getElementById("idGroceryStoreOptions").style.display="block";
	document.getElementById("idDisplayStore").style.display="none";	
}

function displayCart()
{
	
}

function logOut()
{
	location.replace("loginPage.html");
}

function addItemToGorcery()
{	
	var brand = document.getElementById("idBrand").value;
	var category = document.getElementById("idCategory").value;
	var price = document.getElementById("idPrice").value;
	var quantity = document.getElementById("idQuantity").value;
	
	if(brand == "" || category == "" || price == "" || quantity == "") 
	{
		window.alert("Values cannot be empty");
		return;
	}
	
	var groceryStoreUrl = "http://127.0.0.1:8080/groceryStore";
	var jsonInput = JSON.stringify({"brand":brand,"category":category,"price":price,"stock":quantity});
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4)
		{
			if(this.status == 200)
			{
				document.getElementById("idBrand").value="";
				document.getElementById("idCategory").value="";
				document.getElementById("idPrice").value="";
				document.getElementById("idQuantity").value="";			
			}
			else
			{
				window.alert("Server is Down. Please try again@@@");
			}
		}
	};
	xhttp.open("POST", groceryStoreUrl, true);
	xhttp.setRequestHeader('Content-Type', 'application/json');
	xhttp.send(jsonInput);
}

function showAddItemToGrocery()
{
	document.getElementById("idUpdateItemPrice").style.display="none";	
	document.getElementById("idUpdateItemQuantity").style.display="none";
	document.getElementById("idAddItemToGorcery").style.display="block";
}

function showUpdateItemPrice()
{
	document.getElementById("idAddItemToGorcery").style.display="none";
	document.getElementById("idUpdateItemQuantity").style.display="none";
	document.getElementById("idUpdateItemPrice").style.display="block";
}

function showUpdateItemQuantity()
{
	document.getElementById("idAddItemToGorcery").style.display="none";
	document.getElementById("idUpdateItemPrice").style.display="none";
	document.getElementById("idUpdateItemQuantity").style.display="block";
}

function updateItemPrice()
{
	
	
}

function updateItemQuantity()
{
	
}