function header() {
    fetch('/getAuthorizedUser')
        .then(response => {
            console.log(response);
            if (!response.ok) {
                throw Error("Error");
            }
            return response.json();
        }).then(data => {
        console.log(data);
        document.getElementById("emailHeader").innerHTML = data.email;

        let roleList = document.createElement("ul");
        for (let i = 0; i < data.roles.length; i++) {
            let role = document.createElement("li");
            role.textContent = data.roles[i].name.substring(5) + " ";
            roleList.appendChild(role);
        }
        document.getElementById("rolesHeader").innerHTML = "with roles: " + roleList.textContent;
    }).catch(error => {
        console.log(error);
    });
}

header();