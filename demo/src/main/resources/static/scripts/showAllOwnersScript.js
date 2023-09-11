document.addEventListener('DOMContentLoaded', function () {
    const filterNameCheckbox = document.getElementById('filterNameOwner');
    const searchOwnerInput = document.getElementById('searchPet'); // Debería ser 'searchOwner'
    const ownerRows = document.querySelectorAll('tbody tr');

    filterNameCheckbox.addEventListener('change', () => {
        if (filterNameCheckbox.checked) {
            searchOwnerInput.addEventListener('input', filterOwners);
        } else {
            searchOwnerInput.removeEventListener('input', filterOwners);
        }
    });

    filterNameCheckbox.addEventListener('change', () => {
        if (filterNameCheckbox.checked) {
            searchOwnerInput.addEventListener('input', filterOwners);
        } else {
            searchOwnerInput.value = ''; // Borra el contenido del campo de búsqueda
            searchOwnerInput.removeEventListener('input', filterOwners);
            // Muestra todas las filas nuevamente
            ownerRows.forEach((row) => {
                row.style.display = 'table-row';
            });
        }
    });
    
    function filterOwners() {
        const searchText = searchOwnerInput.value.toLowerCase();

        ownerRows.forEach((row) => {
            const ownerName = row.querySelector('td:nth-child(2)').textContent.toLowerCase();
            if (ownerName.includes(searchText)) {
                row.style.display = 'table-row';
            } else {
                row.style.display = 'none';
            }
        });
    }
});
