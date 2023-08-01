var choice  = document.getElementById("mySelect");


function choice() {
    var x = choice.options[choice.selectedIndex].text;
    if (x == 1) {
        document.getElementById("text-message").innerHTML = "Go to Counter No 4";
        document.getElementById("tokenis").innerHTML = "Your Token is:";
        document.getElementById("token").innerHTML = generateString(4);
    }
    else if (x == 2) {
        document.getElementById("text-message").innerHTML = "Go to Counter No 1";
        document.getElementById("tokenis").innerHTML = "Your Token is:";
        document.getElementById("token").innerHTML = generateString(4);
    }
    else if (x == 3) {
        document.getElementById("text-message").innerHTML = "Go to Counter No 3";
        document.getElementById("tokenis").innerHTML = "Your Token is:";
        document.getElementById("token").innerHTML = generateString(4);
    }
    else if (x == 4) {
        document.getElementById("text-message").innerHTML = "Go to Counter No 6";
        document.getElementById("tokenis").innerHTML = "Your Token is:";
        document.getElementById("token").innerHTML = generateString(4);
    }
    else if (x == 5) {
        document.getElementById("text-message").innerHTML = "Go to Counter No 2";
        document.getElementById("tokenis").innerHTML = "Your Token is:";
        document.getElementById("token").innerHTML = generateString(4);
    }
    else {
        document.getElementById("text-message").innerHTML = "";
        document.getElementById("tokenis").innerHTML = "";
        document.getElementById("token").innerHTML = "";
    }
    alert("You selected " + x)
}

const characters ='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';

function generateString(length) {
    let result = ' ';
    const charactersLength = characters.length;
    for ( let i = 0; i < length; i++ ) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }

    return result;
}