function showTable() {

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
            + "<td>" + user.email + "</td>";
        for (var i = 0; i < user.roles.length; i++) {
            table += "<td>" + user.roles[i].name.substring(5) + " " + "</td>";
        }
        table += "</tr>";

        $("#about-user").html(table);
    }).catch(error => {
        console.log(error);
    });
}
