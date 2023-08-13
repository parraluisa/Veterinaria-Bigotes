const vetInfo = [
    {
        name: "Dra Laura Fernández",
        description: "Especialista en medicina equina y cuidado de caballos",
        interests: ["Medicina Equina", "Terapias alternativas"],
        imageSrc: "imagenes/people/doctorA.png"

    },
    {
        name: "Dr. Juan Pedraza",
        description: "Especialista en medicina de animales de granja",
        interests: ["Animales de granja", "Cirugía"],
        imageSrc: "imagenes/people/doctorB.png"
    },
    {
        name: "Dr. José Pérez",
        description: "Especialista en medicina de animales de compañía",
        interests: ["Animales de compañía", "Cirugía"],
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


const reviews = [
    {
        name: "Fabio Buitrago",
        catName: "Maw",
        race: "Gato persa",
        imageSrc: "imagenes/reviewCats/catA.jpeg",
        review: "Desde el primer instante, quedó claro que el personal de la clínica tiene un profundo amor y respeto por los animales. Fui recibido con una sonrisa amable y mi mascota fue saludada con caricias y mimos.Este enfoque empático realmente marcó la diferencia para mí, ya que mi mascota a menudo se siente nerviosa en entornos médicos."
    },
    {
        name: "Luisa Parra",
        catName: "Ronny",
        race: "Gato himalayo",
        imageSrc: "imagenes/reviewCats/catB.jpeg",
        review: "Desde el primer instante, quedó claro que el personal de la clínica tiene un profundo amor y respeto por los animales. Fui recibido con una sonrisa amable y mi mascota fue saludada con caricias y mimos.Este enfoque empático realmente marcó la diferencia para mí, ya que mi mascota a menudo se siente nerviosa en entornos médicos."
    },
    {
        name: "Andrés García",
        catName: "Peter",
        race: "Gato azul ruso",
        imageSrc: "imagenes/reviewCats/catC.jpeg",
        review: "Desde el primer instante, quedó claro que el personal de la clínica tiene un profundo amor y respeto por los animales. Fui recibido con una sonrisa amable y mi mascota fue saludada con caricias y mimos.Este enfoque empático realmente marcó la diferencia para mí, ya que mi mascota a menudo se siente nerviosa en entornos médicos."

    }
];

let currentReviewIndex = 0;

const reviewsCatImg = document.querySelector(".reviewsCatOwned");
const reviewsDataName = document.querySelector(".reviewsData h2");
const reviewsData = document.querySelector(".reviewsData p");
const reviewsContent = document.querySelector(".reviewsContent p");
const reviewsInnerContainer = document.querySelector(".reviewsInnerContainer");

function displayCurrentReview() {
    const currentReview = reviews[currentReviewIndex];

    reviewsInnerContainer.classList.add("hidden");

    setTimeout(() => {
        reviewsCatImg.src = currentReview.imageSrc;
        reviewsDataName.textContent = currentReview.name;
        reviewsData.textContent = "Dueño de " + currentReview.catName + ": " + currentReview.race;
        reviewsContent.textContent = currentReview.review;

        reviewsInnerContainer.classList.remove("hidden");
    }, 500);

    // Move to the next review index
    currentReviewIndex = (currentReviewIndex + 1) % reviews.length;
}

// Display the first review immediately
displayCurrentReview();

// Set up an interval to display reviews every 20 seconds
const interval = setInterval(displayCurrentReview, 5);

