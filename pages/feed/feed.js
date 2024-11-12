// Initialize a new ItemsController with currentId set to 0
const postController = new PostsController(0);

// Select the New Post Form
const newPostForm = document.querySelector('#newPostForm');

// Function to create the HTML for a post
const createPostHTML = (content, imageUrl = '', postId, etiqueta = '') => {
    return `
        <div class="col-sm-6 col-lg-4 mb-4">
            <div class="card">
                ${imageUrl ? `<img src="${imageUrl}" alt="Post image">` : ''}
                <div class="d-flex text-body-secondary pt-3 p-2">
                    <img class="profile-pic-post" style="width: 50px; margin-right: 10px;" src="/assets/fotos/TIBIO.jpeg" alt="Perfil"></img>
                    <div class="mb-0 small d-flex align-items-center border-bottom w-100">
                        <strong class="user text-gray-dark">@TibioElGuapo</strong>           
                    </div>
                    <div class="d-flex align-items-center justify-content-end">
                        <button class="favorito" data-id="${postId}">
                            <i class="bi bi-star" id="favorito-regular"></i>
                        </button>
                    </div>
                </div>
                <div class="card-body">
                    <p class="card-text">${content}</p>
                    <p class="card-text"><small class="text-muted">#${etiqueta}</small></p>
                </div>
            </div>
        </div>
    `;
};

// Verifica si el formulario existe antes de añadir el listener
if (newPostForm) {
    // Add an 'onsubmit' event listener
    newPostForm.addEventListener('submit', (event) => {
        event.preventDefault();
    
        // Get the values of the inputs
        const newPostContent = document.querySelector('#postText').value;
        const newPostImageUrl = document.querySelector('#postImage');
        const etiqueta = document.querySelector('#menu-etiqueta').value;
        const newCard = document.querySelector('.row');
        const postId = postController.currentId;
    
        // Check if a file is selected and create a FileReader to read it
        if (newPostImageUrl.files && newPostImageUrl.files[0]) {
            const reader = new FileReader();
            
            reader.onload = function (e) {
                const imageUrl = e.target.result;
                postController.addItem(newPostContent, imageUrl, etiqueta);
                newCard.insertAdjacentHTML('beforeend', createPostHTML(newPostContent, imageUrl, postId, etiqueta));
                setFavoriteButton(postId);
            };
            reader.readAsDataURL(newPostImageUrl.files[0]);
        } else {
            postController.addItem(newPostContent, '', etiqueta);
            newCard.insertAdjacentHTML('beforeend', createPostHTML(newPostContent, '', postId, etiqueta));
            setFavoriteButton(postId);
        }
    
        // Clear the form
        document.querySelector('#postText').value = '';  
        newPostImageUrl.value = '';
        document.querySelector('#menu-etiqueta').value = 'Etiqueta';
    });
} else {
    console.warn("El formulario #newPostForm no se encontró en esta página.");
}

// Utility function to check if a post is a favorite
function isFavorite(postId) {
    return localStorage.getItem(`favoritePost-${postId}`) !== null;
}

// Set the favorite button functionality
function setFavoriteButton(postId) {
    document.querySelector(`button[data-id="${postId}"]`).addEventListener("click", (event) => {
        toggleFavorite(event.target.closest(".favorito"), postId);
    });
}

function cargarTodosLosPosts(etiqueta = null) {
    const postsContainer = document.querySelector('.row');
    const posts = JSON.parse(localStorage.getItem("posts")) || [];

    posts.forEach(post => {
        postsContainer.insertAdjacentHTML('beforeend', createPostHTML(post.content, post.imageUrl, post.id, post.etiqueta));
    });
}

// Llama a esta función en el archivo JavaScript del feed principal
cargarTodosLosPosts();