function cargarPostsPorEtiqueta() {
    const postsContainer = document.querySelector('.row');
    const postsPorEtiqueta = JSON.parse(localStorage.getItem("posts-salud")) || []; // Clave específica para "Salud"

    postsPorEtiqueta.forEach(post => {
        postsContainer.insertAdjacentHTML('beforeend', createPostHTML(post.content, post.imageUrl, post.id, post.etiqueta));
    });
}

cargarPostsPorEtiqueta("salud");