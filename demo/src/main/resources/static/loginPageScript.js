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
