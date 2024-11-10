
// Función para manejar el clic en el botón de favorito en cualquier página
function toggleFavorite(button, postId) {
    const icon = button.querySelector("i");

    if (icon.classList.contains("bi-star")) {
        icon.classList.remove("bi-star");
        icon.classList.add("bi-star-fill");

        const postContent = button.closest(".card").outerHTML;
        localStorage.setItem(`favoritePost-${postId}`, postContent);
    } else {
        icon.classList.remove("bi-star-fill");
        icon.classList.add("bi-star");

        localStorage.removeItem(`favoritePost-${postId}`);
    }

    loadFavoritePosts(); // Recargar los favoritos en el perfil
}

// Configura los botones de favorito en las publicaciones iniciales
document.querySelectorAll(".favorito").forEach((button, index) => {
    const postId = button.getAttribute("data-id");
    button.addEventListener("click", () => toggleFavorite(button, postId));
});

// Función para cargar las publicaciones favoritas en la página de perfil
function loadFavoritePosts() {
    const favoritesContainer = document.querySelector(".post-destacados");

    // Verifica que el contenedor de favoritos exista antes de continuar
    if (!favoritesContainer) {
        console.warn("El contenedor de favoritos (.post-destacados) no se encontró en el DOM.");
        return;
    }

    favoritesContainer.innerHTML = ''; // Limpia los favoritos actuales

    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (key.startsWith("favoritePost-")) {
            const postContent = localStorage.getItem(key);
            const favoritePostDiv = document.createElement("div");
            favoritePostDiv.innerHTML = postContent;

            const starButton = favoritePostDiv.querySelector(".favorito");
            const postId = key.split('-')[1];
            starButton.addEventListener("click", () => {
                toggleFavorite(starButton, postId);
                favoritePostDiv.remove(); // Elimina la publicación del perfil
            });

            favoritesContainer.appendChild(favoritePostDiv);
        }
    }
}

document.addEventListener("DOMContentLoaded", loadFavoritePosts);





