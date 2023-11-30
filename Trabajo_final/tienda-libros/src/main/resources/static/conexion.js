// document.addEventListener('DOMContentLoaded', function () {
//     // cargarLibros();

//     document.getElementById('agregarLibroForm').addEventListener('submit', function (event) {
//         event.preventDefault();
//         agregarLibro();
//     });
// });

const urlObtenerLibros = 'http://localhost:8080/api/libros';

// function cargarLibros() {
//     fetch(urlObtenerLibros)
//         .then(response => {
//             if (!response.ok) {
//                 console.error(`Error al obtener la lista de libros. Código de estado: ${response.status}, Texto: ${response.statusText}`);
//                 return [];
//             }
//             return response.json();
//         })
//         .then(libros => mostrarLibros(libros))
//         .catch(error => console.error('Error:', error));
// }

function mostrarLibros(libros) {
    const listaLibros = document.querySelector('#listaLibros tbody');
    listaLibros.innerHTML = '';
    fetch(urlObtenerLibros)
        .then(response => {
             if (!response.ok) {
                 console.error(`Error al obtener la lista de libros. Código de estado: ${response.status}, Texto: ${response.statusText}`);
                 return [];
             }
             console.log(response);
             return response.json();
         })


    libros.forEach(libro => {
        const fila = document.createElement('tr');
        fila.innerHTML = `
            <td>${libro.id}</td>
            <td>${libro.titulo}</td>
            <td>${libro.autor}</td>
            <td>${libro.precio}</td>
        `;
        listaLibros.appendChild(fila);
    });
}
