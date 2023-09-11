document.addEventListener('DOMContentLoaded', function () {
// Obtén referencias a los elementos HTML relevantes
const filterNameCheckbox = document.getElementById('filterNamePet');
const searchPetInput = document.getElementById('searchPet');
const petRows = document.querySelectorAll('tbody tr');

// Agrega un evento de escucha al checkbox
filterNameCheckbox.addEventListener('change', () => {
    // Cuando se cambie el estado del checkbox, verifica si está marcado
    if (filterNameCheckbox.checked) {
        // Si está marcado, agrega un evento de escucha al campo de búsqueda
        searchPetInput.addEventListener('input', filterPets);
    } else {
        // Si no está marcado, elimina el evento de escucha del campo de búsqueda
        searchPetInput.removeEventListener('input', filterPets);
    }
});
filterNameCheckbox.addEventListener('change', () => {
    if (filterNameCheckbox.checked) {
        searchPetInput.addEventListener('input', filterPets);
    } else {
        searchPetInput.value = ''; // Borra el contenido del campo de búsqueda
        searchPetInput.removeEventListener('input', filterPets);
        // Muestra todas las filas nuevamente
        petRows.forEach((row) => {
            row.style.display = 'table-row';
        });
    }
});

// Función para filtrar las mascotas según el texto de búsqueda
function filterPets() {
    const searchText = searchPetInput.value.toLowerCase();

    // Itera a través de las filas de mascotas y muestra/oculta según la búsqueda
    petRows.forEach((row) => {
        const petName = row.querySelector('td span').textContent.toLowerCase();
        if (petName.includes(searchText)) {
            row.style.display = 'table-row';
        } else {
            row.style.display = 'none';
        }
    });
}
});

