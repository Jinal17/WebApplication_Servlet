/*Created by: Justin Carlitti */

//Funtion to reset cookie if wrong person
function wrongPerson() {
    //Resets the cookie with a new one that expires immediately since the cookie is in the past
    document.cookie = "name=null;" +
        " expires=Thu, 01-Jan-95 00:00:01 GMT";
    location.reload();
}

//Greeting function
function greet() {
    //Time object
    var now = new Date();
    var hour = now.getHours();
    var name = undefined;
    //Capture from the DOM the greeting id
    var greeting = document.getElementById("greeting");
    var greetingMsg = '<b>Good ';
    //Depending on the time, concat with main string
    if (hour < 12)
        greetingMsg += 'Morning ';
    else if (hour < 18)
        greetingMsg += 'Afternoon ';
    else
        greetingMsg += 'Evening ';

    if (getCookie("name") !== null) {
        name = getCookie("name");
    }
    else {
        while (name === null || name === undefined || name === "") {
            //Set the name
            name = window.prompt("Please enter your name", "Paul");
            //Expire cookie after 1 day
            var d = new Date();
            d.setDate(d.getDate + 1);
            document.cookie = "name=" + escape(name) + "; expires=" + d;
        }
    }

    greetingMsg += name + ", welcome to SWE642 Survey</b><br/>";
    //Hyperlink to reset the cookie
    greetingMsg += "Click " + "<a href = 'javascript:wrongPerson()'>here</a> " +
        " if you are not " + name + ". ";
    greeting.innerHTML = greetingMsg;
}

//Gets the cookie name
function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) {
      return parts[1].split(";")[0];
    }
    else {
      return null;
    }
}

//Function to calc the max and avg
function calculate(data) {
    //Initilize variables
    var count = 0;
    var max = 0;
    var sum = 0;
    var avg = 0;
    //Var of the error to fill in on the fly
    var numberError = document.getElementById("number-error");
    
    numberError.innerHTML = "";
    document.getElementById("avg").innerHTML = "";
    document.getElementById("max").innerHTML = "";
    //Split the array at the comma
    data = data.split(',');
    //Validate that the user enters 10 numbers
    if (data.length !== 10) {
        numberError.innerHTML = "Error: Please enter 10 numbers";
        return false;
    }
    //Validate that the user only entered numbers
    if(data.some(isNaN)) {
	numberError.innerHTML = "Error: Please only enter numbers";
	return false;
    }
    //Loop through array
    for (var x of data) {
        if (x === "") {
            numberError.innerHTML = "Error: Please enter 10 numbers";
            return false;
        }
	//Validate the numbers are between 1-100 inclusivly
        x = x - '0';
        if (x < 1 || x > 100) {
            numberError.innerHTML = "Error: Please enter numbers from 1 - 100.";
            return false;
        }
        else {
            count++;
            sum += x;
            if (x > max) {
                max = x;
            }
        }
    }
    //Set values
    avg = sum / count;
    document.getElementById("avg").innerHTML = avg;
    document.getElementById("max").innerHTML = max; 
}

//Function to validate the form entries
function validate() {
    //Various regex strings for validation
    var alphabet = /^[A-Za-z]+$/;
    //var alphaNumeric = /^[a-zA-Z0-9_]*$/;
    var alphaNumeric = /^[-\w\s]+$/;
    var emailValid = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
    var numOfCheck = 0;
    //var errorMsg = "<p class='errorMsg'>";
    var errorMsg = "";
    errorMsg = "<p>";

    if(!document.getElementById("s_username").value.match(alphabet)) {
        errorMsg += "Username must consist of Alphabet letters! <br>";
	document.getElementById("s_username").value = "";
    }

    if(!document.getElementById("s_address").value.match(alphaNumeric)) {
        errorMsg += "Address must only consist of numeric, alphabet or alphanumeric characters! <br>";
	document.getElementById("s_address").value = "";
    }
    
    if(!document.getElementById("s_email").value.match(emailValid)) {
        errorMsg += "Email must be a valid format! <br>";
	document.getElementById("s_email").value = "";
    }
    
    var thingsLiked = document.getElementsByName("thingsLiked");
    for(var i = 0; i < thingsLiked.length; i++) {
        if(thingsLiked[i].checked) {
	    numOfCheck++;
	}
    }
   
    if(numOfCheck < 2) {
        errorMsg += "Must select atleast 2 checkboxes for things you liked about GMU! <br>"; 
    }

    var interested = document.getElementsByName("interested");
    numOfCheck = 0;
    for(var i = 0; i < interested.length; i++) {
        if(interested[i].checked) {
    	    numOfCheck++;
	}
    }

    if(numOfCheck < 1) {
        errorMsg += "Must select a radio button for what interested you about GMU! <br>";
    }

    errorMsg += "</p>"
    document.getElementById("modal").innerHTML = errorMsg;
    if(errorMsg !== "<p></p>") {
	//$(function(){
	    $("#modal").dialog({"title":"Error Modal"});//{
	//	    "title": "JQuery UI Modal Error MSG",
	//	    "show":true,
	//	    "width": 600,
	//	    "height": 600,
	//	    "position": {
      	//	        "left": 250
       	//	    }
	   // });
		//e.preventDefault();
		//return false;
       // });
	//alert(errorMsg);
	//$("#submitButton").submit(function(e){e.preventDefault(); return false;});
	return false;
    } else {
	//document.getElementById("modal").innerHTML = "Submitted Successfully!";    
	//$(function(e) {
	//	$("#modal").dialog();
	//	e.preventDefault();
	//});
	alert("Submitted Successfully! \n");
	//document.getElementById("modal").innerHTML = "<p>Submitted Successfully!</p>";
	//$("#modal").dialog();
	  //  reset();
	return true;
    }
    
}

//Function to reset the form
function formReset() {

    //document.getElementById("s_username").value = "";
    //document.getElementById("s_address").value = "";
    document.getElementById("city").innerHTML = "";
    document.getElementById("state").innerHTML = "";
    document.getElementById("number-error").innerHTML = "";
    //document.getElementById("s_zip").value = "";
    document.getElementById("zipError").innerHTML = "";
    //$( "zipError" ).empty();
    //document.getElementById("s_telephone").value = "";
    //document.getElementById("s_email").value = "";
    //document.getElementById("s_url").value = "";
    //document.getElementById("s_date").value = "";
    //document.getElementById("s_grad").value = "";
    //document.getElementById("s_gdate").value = "";
    document.getElementById("avg").innerHTML = "";
    document.getElementById("max").innerHTML = "";
    document.getElementById("formId").reset();
}

//Ajax call function
function validateZip(zipCode) {
    try {
        var asyncRequest = new XMLHttpRequest();
    	asyncRequest.onreadystatechange = function () {
            callBack(zipCode, asyncRequest);
    	};
        asyncRequest.open("GET", "js/address.json", true);
    	asyncRequest.withCredentials = true;
	asyncRequest.send(null);
    } catch (exception) {
    	alert("Request Failed!");
    }
}

//Callback function to input the code into the html dynamically
function callBack(zipCode, asyncRequest) {
    document.getElementById("city").innerHTML = "";
    document.getElementById("state").innerHTML = "";
    document.getElementById("zipError").style.color = "black";
    document.getElementById("zipError").innerHTML = "Validating ZipCode";
    //Correct Validation codes
    if(asyncRequest.readyState == 4 && asyncRequest.status == 200) { 
        var response = JSON.parse(asyncRequest.responseText);
	var finalResult = doesExist(zipCode, response);
	if(finalResult.valid) {
	    document.getElementById("zipError").innerHTML = "";
 	    document.getElementById("city").innerHTML = finalResult.city;
	    document.getElementById("state").innerHTML = finalResult.state;
	} else {
	    document.getElementById("zipError").style.color = "red";
	    document.getElementById("zipError").innerHTML = "Error: invalid ZipCode";
	}
    }
}

//Validation function to make sure the entered zip is a valid option
function doesExist(zipCode, response) {
    var validZips = response.zipcodes;
    for(var zip of validZips) {
        if(zip.zip === zipCode) {
	    return {
	        valid: true,
		city: zip.city,
		state: zip.state
	    };
	}
    }
    return {
	valid: false
    };
}