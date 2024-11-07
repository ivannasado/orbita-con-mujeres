 // Función para manejar el clic en el botón de favorito en cualquier página
function toggleFavorite(button, index) {
    const icon = button.querySelector("i");

    if (icon.classList.contains("bi-star")) {
        icon.classList.remove("bi-star");
        icon.classList.add("bi-star-fill");

        // Obtén el contenido de la publicación
        const postContent = button.closest(".card").innerHTML;

        // Guarda la publicación en el localStorage como favorita
        localStorage.setItem(`favoritePost-${index}`, postContent);
    } else {
        icon.classList.remove("bi-star-fill");
        icon.classList.add("bi-star");

        // Elimina la publicación de favoritos en el localStorage
        localStorage.removeItem(`favoritePost-${index}`);
    }
}

// Configura los botones de favorito en las publicaciones iniciales
document.querySelectorAll(".favorito").forEach((button, index) => {
    button.addEventListener("click", () => toggleFavorite(button, index));
});

// Función para cargar las publicaciones favoritas en la página de perfil
function loadFavoritePosts() {
    const favoritesContainer = document.querySelector(".post-destacados");

    if (favoritesContainer) {
        for (let i = 0; i < localStorage.length; i++) {
            const key = localStorage.key(i);

            // Verifica que el key corresponda a una publicación favorita
            if (key.startsWith("favoritePost-")) {
                const postContent = localStorage.getItem(key);

                // Crea un nuevo elemento div para la publicación
                const favoritePostDiv = document.createElement("div");
                favoritePostDiv.classList.add("card");
                favoritePostDiv.innerHTML = postContent;

                // Agrega un event listener al icono de estrella en esta publicación en el perfil
                const starButton = favoritePostDiv.querySelector(".favorito");
                const index = key.split('-')[1]; // Obtén el índice de la clave

                starButton.addEventListener("click", () => {
                    toggleFavorite(starButton, index);
                    favoritePostDiv.remove(); // Quita la publicación del perfil
                });

                // Agrega la publicación al contenedor en la página de perfil
                favoritesContainer.appendChild(favoritePostDiv);
            }
        }
    }
}

// Llama a la función cuando se carga la página de perfil
document.addEventListener("DOMContentLoaded", loadFavoritePosts);


