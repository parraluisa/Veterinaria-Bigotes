const vetInfo = [
    {
        name: "Dra Laura Fernández",
        description: "Especialista en medicina gatuna y cuidado de gatos",
        interests: ["Medicina Gatuna", "Terapias alternativas"],
        imageSrc: "/imagenes/people/doctorA.png"

    },
    {
        name: "Dr. Juan Pedraza",
        description: "Especialista en medicina de animales de granja",
        interests: ["Animales de granja", "Cirugía"],
        imageSrc: "/imagenes/people/doctorB.png"
    },
    {
        name: "Dr. José Pérez",
        description: "Especialista en medicina de animales de compañía",
        interests: ["Animales de compañía", "Cirugía"],
        imageSrc: "/imagenes/people/doctorC.png"
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
        imageSrc: "/imagenes/reviewCats/catA.jpeg",
        review: "Desde el primer instante, quedó claro que el personal de la clínica tiene un profundo amor y respeto por los animales. Fui recibido con una sonrisa amable y mi mascota fue saludada con caricias y mimos.Este enfoque empático realmente marcó la diferencia para mí, ya que mi mascota a menudo se siente nerviosa en entornos médicos."
    },
    {
        name: "Luisa Parra",
        catName: "Ronny",
        race: "Gato himalayo",
        imageSrc: "/imagenes/reviewCats/catB.jpeg",
        review: "No puedo estar más satisfecho con la atención que recibimos en esta clínica veterinaria. Desde el momento en que entramos, quedó claro que los animales son verdaderamente valorados aquí. La amabilidad del personal y el afecto que mostraron hacia mi mascota me llenaron de confianza de inmediato."
    },
    {
        name: "Andrés García",
        catName: "Peter",
        race: "Gato azul ruso",
        imageSrc: "/imagenes/reviewCats/catC.jpeg",
        review: "No puedo expresar lo agradecido que estoy por haber encontrado esta increíble clínica veterinaria. Desde el primer instante que crucé la puerta, quedó claro que este lugar es un refugio para nuestras adoradas mascotas. El equipo muestra un nivel de amor y respeto que va más allá de lo profesional."

    }
];

let currentReviewIndex = 0;

const reviewsCatImg = document.getElementById("reviewsCatImg");
const reviewsDataName = document.getElementById("reviewsDataName");
const reviewsDataCat = document.getElementById("reviewsDataCat");
const reviewsText = document.getElementById("reviewsText");
const reviewsInnerContainer = document.getElementById("reviewsInnerContainer");

function displayCurrentReview() {
    const currentReview = reviews[currentReviewIndex];

    reviewsInnerContainer.classList.add("hidden");

    setTimeout(() => {
        reviewsCatImg.src = currentReview.imageSrc;
        reviewsDataName.textContent = currentReview.name;
        reviewsDataCat.textContent = "Dueño de " + currentReview.catName + ": " + currentReview.race;
        reviewsText.textContent = currentReview.review;

        reviewsInnerContainer.classList.remove("hidden");
    }, 500);

    // Move to the next review index
    currentReviewIndex = (currentReviewIndex + 1) % reviews.length;
}

// Display the first review immediately
displayCurrentReview();

// Set up an interval to display reviews every 20 seconds
const interval = setInterval(displayCurrentReview, 20000);

