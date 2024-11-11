/* 
// Crear la clase PostController
class PostsController {
    //  constructor que define las caracteristicas del post
    constructor(currentId = 0) {
        this.posts = [];
        this.currentId = currentId;
    }

    // Create the addItem method
    addItem( content, imageUrl, etiqueta) {
        const post = {
            //  Crea el conteo de los post que se van subiendo
            id: this.currentId++,
            //user: user, No tenemos user aun estamos trabajando en eso 
            content: content,
            imageUrl: imageUrl,
            etiqueta: etiqueta
        };

        // Darle push al post de los posts
        this.posts.push(post);

        // Guardar los posts en localStorage
        //localStorage.setItem("posts", JSON.stringify(this.posts));

        //Guardar los post en el local storage
        let postsPorEtiqueta = JSON.parse(localStorage.getItem(`posts-${etiqueta}`)) || [];
        postsPorEtiqueta.push(post);
        localStorage.setItem(`posts-${etiqueta}`, JSON.stringify(postsPorEtiqueta));
    }
} 
 */

// Crear la clase PostController
class PostsController {
    //  constructor que define las caracteristicas del post
    constructor(currentId = 0) {
        this.posts = [];
        this.currentId = currentId;
    }

    // Create the addItem method
    addItem( content, imageUrl, etiqueta) {
        const post = {
            //  Crea el conteo de los post que se van subiendo
            id: this.currentId++,
            //user: user, No tenemos user aun estamos trabajando en eso 
            content: content,
            imageUrl: imageUrl,
            etiqueta: etiqueta
        };

        // Darle push al post de los posts
        this.posts.push(post);

        // Guardar los posts en localStorage
        //localStorage.setItem("posts", JSON.stringify(this.posts));

        //Guardar los post en el local storage
        let postsPorEtiqueta = JSON.parse(localStorage.getItem(`posts-${etiqueta}`)) || [];
        postsPorEtiqueta.push(post);
        localStorage.setItem(`posts-${etiqueta}`, JSON.stringify(postsPorEtiqueta));
    }
} 
