const loginVet = document.querySelector(".loginVet")
const loginOwner = document.querySelector(".loginOwner")
const formActive = document.querySelector(".container-forms")
const switchs = document.querySelector(".switch")

function tab1(){
    formActive.style.marginLeft = "0";

    loginVet.style.opacity = "0.7";
    const vetImage = loginVet.querySelector("img");
    vetImage.style.opacity = "0.7";

    loginOwner.style.opacity = "";
    const ownerImage = loginOwner.querySelector("img");
    ownerImage.style.opacity = "";
}

function tab2(){
    formActive.style.marginLeft = "-97%";

    loginVet.style.opacity = "1";
    const vetImage = loginVet.querySelector("img");
    vetImage.style.opacity = "1";

    loginOwner.style.opacity = "0.7";
    const ownerImage = loginOwner.querySelector("img");
    ownerImage.style.opacity = "0.7";
}

// JavaScript code to show the error pop-up and handle form submission
const urlParams = new URLSearchParams(window.location.search);
const error = urlParams.get('error');

if (error === 'idNotFound') {
    alert('ID not found. Please try again.');
}

// Handling form submission
const formOwner = document.getElementById('formOwner');
const idCard = document.getElementById('idCard');

formOwner.addEventListener('submit', (e) => {
    const idOwner = idCard.value;

    if (idOwner === '') {
        e.preventDefault(); // Prevent the form from submitting
        alert('Por favor ingrese su cédula');
    }
});
