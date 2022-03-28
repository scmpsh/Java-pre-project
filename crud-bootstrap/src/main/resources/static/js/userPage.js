function showUser() {

    fetch('http://localhost:8080/getAuthorizedUser')
        .then(response => {
            console.log(response)
            if (!response.ok) {
                throw Error("Error")
            }
            return response.json();
        }).then(user => {
        console.log(user)
        var table;
        table += "<tr><td>" + user.id + "</td>"
            + "<td>" + user.firstName + "</td>"
            + "<td>" + user.lastName + "</td>"
            + "<td>" + user.age + "</td>"
            + "<td>" + user.email + "</td>"
            + "<td>";
        for (role of user.roles) {
            table += role.name.substring(5) + " ";
        }
        table += "</td></tr>";

        $("#about-user").html(table);
    }).catch(error => {
        console.log(error);
    });
}

showUser()