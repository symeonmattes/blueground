# blueground

The project is devided into two implementation parts, i.e. the frontend and backend implementation.

In the frontend implementation jsp technology has been used, which is appropriate for differentiating the frontend with the backend part. The first page is the index page, with a link which directs the user to a jsp page, i.e. wunderground.jsp. This page has a table that depicts the values in question, i.e. Max percentage humidity, Max Temp in C, Min Temp in C and the precipitation in mm.

The backend implementation includes a package, the Wunderground package with one java class, i.e. the apiWunderground. The apiWunderground.class reads from the following link:

http://api.wunderground.com/api/4f5c6f5fc02cc1c2/history_20180305/q/NY/New_York.json

the values that are needed from the frontend part. The class includes 7 methods. The 2 methods, i.e. readAll, readJSONFromUrl are used to read the GET Request from the link above. The setJSONWunderground is used to assign the value of the request to a static variable, i.e. json, which is going to be used by the other 4 methods in order to get the value in interest. The getMaxPercentageHumidity,the getMaxTempInCelcium, getMinTempInCelcium and the getPrecipitationInMM are the methods which read from the json object the corresponding values which are requested from the frontend part.

Finally the java-json.jar library has been used which transforms a json request to a JSON object. This is used to get the corresponding value from the link above.
