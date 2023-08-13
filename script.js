const vetInfo = [
    {
        name: "Dra. Laura Fernández",
        description: "Especialista en medicina equina y cuidado de caballos",
        interests: ["Medicina Equina", "Terapias alternativas"],
        imageSrc: "imagenes/people/doctorA.png"

    },
    {
        name: "Dr. Juan Pedraza",
        description: "Especialista en medicina de animales de granja",
        interests: ["Medicina de animales de granja", "Cirugía"],
        imageSrc: "imagenes/people/doctorB.png"
    },
    {
        name: "Dr. José Pérez",
        description: "Especialista en medicina de animales de compañía",
        interests: ["Medicina de animales de compañía", "Cirugía"],
        imageSrc: "imagenes/people/doctorC.png"
    },
    // Add more veterinarian data objects as needed
];

let currentVetIndex = 0;

const prevButton = document.getElementById("prev-button");
const nextButton = document.getElementById("next-button");
const vetName = document.querySelector(".vet-name");
const vetDescription = document.querySelector(".vet-description");
const vetInterestsList = document.querySelector(".vet-interests-list");
const vetImage = document.querySelector(".vet-image img");

// ... (Código anterior)

const vetInfoContainer = document.querySelector(".vet-info"); // Agrega esta línea para obtener el elemento de información del veterinario

// ... (Código anterior)

function displayCurrentVet() {
    const currentVet = vetInfo[currentVetIndex];

    // Oculta la información con transición
    vetInfoContainer.classList.add("hidden");

    // Espera la duración de la transición antes de actualizar los datos
    setTimeout(() => {
        vetName.textContent = currentVet.name;
        vetDescription.textContent = currentVet.description;
        vetInterestsList.innerHTML = currentVet.interests.map(interest => `<li>${interest}</li>`).join("");
        vetImage.src = currentVet.imageSrc;

        // Muestra la información nuevamente con transición
        vetInfoContainer.classList.remove("hidden");
    }, 500); // Ajusta este valor al tiempo de duración de la transición en milisegundos
}

prevButton.addEventListener("click", () => {
    currentVetIndex = (currentVetIndex - 1 + vetInfo.length) % vetInfo.length; // Ciclo hacia atrás
    displayCurrentVet();
});

nextButton.addEventListener("click", () => {
    currentVetIndex = (currentVetIndex + 1) % vetInfo.length; // Ciclo hacia adelante
    displayCurrentVet();
});

// ... (Resto del código)


displayCurrentVet();
