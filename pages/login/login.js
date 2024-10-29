// Ajustar estilos según el ancho de la pantalla
function ajustarResponsivo() {
    const titulo = document.querySelector("#titulo h1");
    const subtitulo = document.querySelector("#titulo h2");
    const contenedorPrincipal = document.querySelector(".row.align-items-center");
    const boxContacto = document.querySelector("#box-contacto");
    
    const anchoPantalla = window.innerWidth;

    if (anchoPantalla < 576) { // Pantallas pequeñas (celulares)
        titulo.style.fontSize = "3em";
        subtitulo.style.fontSize = "2.5em";
        boxContacto.style.marginTop = "3em";
        imagenMujeres.style.width = "80%";
        imagenMujeres.style.marginTop = "3rem";
    } else if (anchoPantalla < 768) { // Tablets
        titulo.style.fontSize = "3em";
        subtitulo.style.fontSize = "3em";
        boxContacto.style.marginTop = "5em";
        imagenMujeres.style.width = "60%";
        contenedorPrincipal.style.flexDirection = "column";
    } else if(anchoPantalla < 992){
        titulo.style.fontSize = "6em";
        subtitulo.style.fontSize = "5em";
        titulo.style.marginLeft = "0"; // Resetea marginLeft
        subtitulo.style.marginLeft = "0";
        boxContacto.style.marginTop = "3em";
        
        // Apilar elementos (título, subtítulo, box, imagen)
        contenedorPrincipal.style.flexDirection = "column"; // Apila en columna
        titulo.style.order = "1"; // Orden del título
        subtitulo.style.order = "2"; // Orden del subtítulo
        boxContacto.style.order = "3";
        imagenMujeres.style.order = "4";
        imagenMujeres.style.marginTop = "3em";
    }else if(anchoPantalla < 1200){
        titulo.style.fontSize = "6em";
    subtitulo.style.fontSize = "5em";
    
    boxContacto.style.marginTop = "-12.5em";
        titulo.style.marginLeft = "-6em"; // Ajusta el valor para la cantidad deseada
    subtitulo.style.marginLeft = "-6em"; // Ajusta el valor para la cantidad deseada

    }
    else{ // Escritorio
        titulo.style.fontSize = "7em";
        subtitulo.style.fontSize = "7em";
        boxContacto.style.marginTop = "-17em";
        imagenMujeres.style.width = "50%";
    }
}

// Ejecutar la función al cargar la página y al cambiar el tamaño de la pantalla
window.addEventListener('resize', ajustarResponsivo);
// Llama a la función cuando se carga la página
ajustarResponsivo();


/* --------------------- VALIDACIONES ------------------- */
const logInForm = document.getElementById('datosContacto');

logInForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const usuario = document.getElementById('Usuario').value;
    const password = document.getElementById('Password').value;
    let isValid = true;

    function error(mostrarMensajeDanger, errorBoxId) {
        const mensajeError = document.getElementById(errorBoxId);
        const alertError = `
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <p class="m-0">${mostrarMensajeDanger}</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `;
        mensajeError.innerHTML = alertError;
        isValid = false;
    }

    if (!isNaN(usuario)) error("Usuario inválido", "errorBoxUsuario");
    if (password.length < 8 || !password.match(/[$@$!%*?&]/) || !password.match(/[0-9]/)) {
        error("Contraseña inválida", "errorBoxContraseña");
    }
    
    if (isValid) {
        const Usuarios = JSON.parse(localStorage.getItem('users')) || [];
        const usuarioValidado = Usuarios.find(user => user.usuario === usuario && user.password === password);

        if (usuarioValidado) {
            console.log(`Bienvenido ${usuarioValidado.usuario}`);
            window.location.href = '../feed/feed.html';
        } else {
            error("Usuario y/o contraseña incorrectos", "errorBoxContraseña");
        }
    }
});
