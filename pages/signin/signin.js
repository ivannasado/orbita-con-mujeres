// Ajustar estilos según el ancho de la pantalla
function ajustarResponsivo() {
    const titulo = document.querySelector("#titulo h1");
    const subtitulo = document.querySelector("#titulo h2");
    const contenedorPrincipal = document.querySelector(".row.align-items-center");
    const boxContacto = document.querySelector("#box-contacto");
    const imagenMujeres = document.querySelector("#imagenMujeres");

    const anchoPantalla = window.innerWidth;
    const altoPantalla = window.innerHeight;

    if (anchoPantalla < 576) { // Pantallas pequeñas (celulares)
        titulo.style.fontSize = "4em";
        subtitulo.style.fontSize = "4em";
        boxContacto.style.marginTop = "3em";
        boxContacto.style.marginLeft = "1";
        titulo.style.marginLeft = "-1em";
        subtitulo.style.marginLeft = "-1em";
        imagenMujeres.style.display = "none"; // Oculta la imagen 
       

    } else if (anchoPantalla < 768) { // Entre celular y tablet
        titulo.style.fontSize = "4em";
        subtitulo.style.fontSize = "4em";
        boxContacto.style.marginTop = "3em";
        boxContacto.style.marginLeft = "0";
        titulo.style.marginLeft = "-1em";
        subtitulo.style.marginLeft = "-1em";
        imagenMujeres.style.display = "none"; // Oculta la imagen
        contenedorPrincipal.style.flexDirection = "column";
 
    } else if (anchoPantalla < 992) { // Tablets
        titulo.style.fontSize = "6em";
        subtitulo.style.fontSize = "6em";
        boxContacto.style.marginTop = "3em";
        boxContacto.style.marginLeft = "-2em";
        titulo.style.marginLeft = "-1em";
        subtitulo.style.marginLeft = "-1em";
        contenedorPrincipal.style.flexDirection = "column";
        imagenMujeres.style.width = "50%";
        imagenMujeres.style.display = "block";
    
        // Orden de los elementos
        titulo.style.order = "1";
        subtitulo.style.order = "2";
        boxContacto.style.order = "3";
        imagenMujeres.style.display = "none"; // Oculta la imagen */
   

    } else if (anchoPantalla < 1044) {
        titulo.style.fontSize = "5em";
        subtitulo.style.fontSize = "5em";
        boxContacto.style.marginTop = "-12.5em";
        boxContacto.style.marginLeft = "-6em";
        titulo.style.marginLeft = "-6em";
        subtitulo.style.marginLeft = "-6em";
        contenedorPrincipal.style.flexDirection = "column";

        titulo.style.order = "1";
        subtitulo.style.order = "2";
        boxContacto.style.order = "3";
        imagenMujeres.style.width = "50%";
        imagenMujeres.style.marginTop = "12em";
        imagenMujeres.style.display = "block"; // Asegúrate de mostrar la imagen
       

    } else if (anchoPantalla < 1200) {
        titulo.style.fontSize = "6em";
        subtitulo.style.fontSize = "5em";
        boxContacto.style.marginTop = "-12.5em";
        titulo.style.marginLeft = "-6em";
        subtitulo.style.marginLeft = "-6em";
        imagenMujeres.style.width = "50%";
        imagenMujeres.style.marginTop = "12em";
        imagenMujeres.style.display = "block"; // Asegúrate de mostrar la imagen

    } else if (anchoPantalla < 1422) {
        titulo.style.fontSize = "6em";
        subtitulo.style.fontSize = "5em";
        boxContacto.style.marginTop = "-12.5em";
        titulo.style.marginLeft = "-6em";
        subtitulo.style.marginLeft = "-6em";
        imagenMujeres.style.marginTop = "12em";
        imagenMujeres.style.width = "50%";
        imagenMujeres.style.display = "block"; // Asegúrate de mostrar la imagen

    } else { // Escritorio y pantallas grandes
        titulo.style.fontSize = "7em";
        subtitulo.style.fontSize = "7em";
        boxContacto.style.marginTop = "-17em";
        imagenMujeres.style.width = "50%";
        imagenMujeres.style.display = "block"; // Asegúrate de mostrar la imagen

        
    }
}

// Ejecuta la función al cargar la página y cada vez que se redimensiona la ventana
window.onload = ajustarResponsivo;
window.onresize = ajustarResponsivo;

// Ejecutar la función al cargar la página y al cambiar el tamaño de la pantalla
window.addEventListener('resize');


/* --------------------- VALIDACIONES ------------------- */
const signInForm = document.getElementById('form-enviar');

signInForm.addEventListener('submit', (e) => {
    e.preventDefault();

    // Validación de los datos
    const nombre = document.getElementById('Nombre').value; 
    const apellido = document.getElementById('Apellido').value;
    const usuario = document.getElementById('Usuario').value;
    const telefono = document.getElementById('Telefono').value;
    const email = document.getElementById('E-mail').value;
    const password = document.getElementById('Password').value;
    const confirmPassword = document.getElementById('ConfirmPassword').value;
    let isValid = true;

    function error(mostrarMensajeDanger, errorBoxId) {
        const mensajeError = document.getElementById(errorBoxId);
        const alertError = `
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <p class="m-0">${mostrarMensajeDanger}</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `;
        mensajeError.insertAdjacentHTML('afterbegin', alertError);
        isValid = false;
    }

    // Verificación de cada campo y errores
    if (!isNaN(nombre)) error("El nombre solo debe contener letras.", "errorBoxNombre");
    if (!isNaN(apellido)) error("El apellido sólo debe contener letras.", "errorBoxApellido");
    if (!isNaN(usuario)) error("El nombre de usuario sólo debe contener letras.", "errorBoxUsuario");
    if (telefono.length < 10) error("El teléfono debe contener más de 10 dígitos.", "errorBoxTelefono");
    if (!email.includes('@')) error("Ingresa un correo electrónico válido.", "errorBoxEmail");
    if (password.length < 8 || !password.match(/[$@$!%*?&]/) || !password.match(/[0-9]/)) {
        error("La contraseña debe tener al menos 8 caracteres, un carácter especial y un número.", "errorBoxContraseña");
    }
    if (confirmPassword !== password) error("Las contraseñas deben ser iguales.", "errorBoxConfirmarContraseña");

    if (isValid) {
        const Usuarios = JSON.parse(localStorage.getItem('users')) || [];
        
        const usuarioRegistrado = Usuarios.find(user => user.usuario === usuario);
        
        if (usuarioRegistrado) {
            error("Usuario ya registrado");
        } else {
            Usuarios.push({ usuario: usuario, password: password });
            localStorage.setItem('users', JSON.stringify(Usuarios));
            console.log("Registro Exitoso");

            window.location.href = '../feed/feed.html';
        }
    } else {
        console.log("Errores en la validación, no se guarda el usuario.");
    }
});





