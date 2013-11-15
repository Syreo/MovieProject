$(document).ready(function(){

	var year = generateRandomYear();
	
	getMovieList(year);


});


function generateRandomYear(){

return Math.floor(Math.random() * (2013 - 1906 + 1)) + 1906;

}

function getMovieList(year){

// Send Request

$.ajax({
	type : "GET",
	url : 'http://www.omdbapi.com/?y=1990"',
	dataType : "json",
	success : function(data){

		var list = data.response;
		var count = data.length;
		var randomNum = getRandomNumber(count);
		console.log(data);
//		var title = data[randomNum].Title;
		alert(title);

}
});
// Response to JSON
//var omdbData = http.responseText;
//var omdbJSON = eval("(" + omdbData + ")");
//var count = omdbData.size();
//var randomNum = getRandomNumber(count);
//var title = omdbData[randomNum].Title;
//alert(title);
}

function getRandomNumber(count){

return Math.floor(Math.random() * (count - 0 + 1)) + 0;

}

