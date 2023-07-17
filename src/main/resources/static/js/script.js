function loadCities() {
    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", "/api/v1/cities", true);
    httpRequest.onreadystatechange = function () {
        if (httpRequest.status === 200) {
            let cities = JSON.parse(httpRequest.response);
            let content = "<option disabled selected value=''>Select city</option>";
            for (let i = 0; i < cities.length; i++) {
                content += "<option>" + cities[i] + "";
            }
            document.getElementById("location-drop-down").innerHTML = content;
        }
    }
    httpRequest.send();
}