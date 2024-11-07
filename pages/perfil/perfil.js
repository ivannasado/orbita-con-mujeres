window.addEventListener("resize", ajusteDeTamanioDeHeader);

function ajusteDeTamanioDeHeader() {
    const title = document.querySelector(".title");
    const image = document.querySelector(".header-flowers img");

    const anchoDePantalla = window.innerWidth;

    if (anchoDePantalla <= 750) {
        title.style.fontSize = "4em";
        image.style.width = "5em";
        image.style.height = "5em";
    } else if (anchoDePantalla > 750 && anchoDePantalla <= 1024) {
        title.style.fontSize = "5em";
        image.style.width = "6em";
        image.style.height = "6em";
    } else {
        title.style.fontSize = "11em";
        image.style.width = "16em";
        image.style.height = "16em";
    }
}
ajusteDeTamanioDeHeader();


document.addEventListener('DOMContentLoaded', function () {
  function ajustarFotoPerfil() {
      const container = document.querySelector('.foto-perfil-container');
      const fotoPerfil = document.querySelector('.foto-perfil img');
      const nombreUsuario = document.querySelector('.nombre-usuario');
      const anchoDePantalla = window.innerWidth;

      if (anchoDePantalla <= 768) {
          // Ajustar estilos para pantallas móviles
          container.style.flexDirection = 'column'; 
          container.style.alignItems = 'center'; 
          container.style.marginTop = '-90px';

          fotoPerfil.style.margin = '0';
          nombreUsuario.style.textAlign = 'center'; 
          container.style.justifyContent = 'center'; 
          fotoPerfil.style.marginTop = "-3em";
      
      } else {
          // Ajustar estilos para pantallas grandes
          container.style.flexDirection = 'row'; 
          container.style.justifyContent = 'flex-start'; 
          container.style.alignItems = 'center';
          container.style.marginTop = '-60px';
          fotoPerfil.style.marginTop = "-3em";
          fotoPerfil.style.marginLeft = "8em";

          nombreUsuario.style.textAlign = 'left';
      }
  }

  ajustarFotoPerfil();
  window.addEventListener('resize', ajustarFotoPerfil);
});


/* FUNCIONALIDAD */
window.addEventListener('DOMContentLoaded', function () {
  // Obtener los datos del localStorage
  const nombreUsuario = localStorage.getItem('nombreUsuario') || '@TibioElGuapo';  // Valor por defecto
  const acercaDeMi = localStorage.getItem('acercaDeMi') || '¡Hola! Soy Tibio. Mi mamá es una de las fantásticas desarrolladoras web...';  // Texto por defecto

  // Asignar los valores a los elementos en la página de perfil
  document.querySelector('.nombre-usuario').textContent = nombreUsuario;
  document.querySelector('.acerca-de-mi .card-text').textContent = acercaDeMi;
});