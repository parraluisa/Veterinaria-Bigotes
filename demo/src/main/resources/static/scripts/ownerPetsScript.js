document.addEventListener('DOMContentLoaded', function () {
    const filterNameCheckbox = document.getElementById('filterNamePet');
    const searchPetInput = document.getElementById('searchPet');
    const petRows = document.querySelectorAll('tbody tr');

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

    function filterPets() {
        const searchText = searchPetInput.value.toLowerCase();

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
