/* function cambiarColor() {
    let boton = document.getElementById("favorito-regular");
    boton.classList.toggle("clickeado");  // Alterna la clase 'clickeado'
} */


/* const btnsFavorite = document.querySelectorAll('.favorito');
const publi = document.querySelectorAll('.row');


const containerListFavorites = document.querySelector(
	'.container-list-favorites'
);
const listFavorites = document.querySelector('.list-favorites');

let favorites = [];

const updateFavoritesInLocalStorage = () => {
	localStorage.setItem('favorites', JSON.stringify(favorites));
};

const loadFavoritesFromLocalStorage = () => {
	const storedFavorites = localStorage.getItem('favorites');

	if (storedFavorites) {
		favorites = JSON.parse(storedFavorites);
		showHTML();
	}
};

const toggleFavorite = product => {
	const index = favorites.findIndex(
		element => element.id === product.id
	);

	if (index > -1) {
		favorites.splice(index, 1);
		updateFavoritesInLocalStorage();
	} else {
		favorites.push(product);
		updateFavoritesInLocalStorage();
	}
};

const updateFavoriteMenu = () => {
	listFavorites.innerHTML = '';

	favorites.forEach(fav => {
		// Crear un nuevo elemento 'div' para el producto favorito
		const favoriteCard = document.createElement('div');
		favoriteCard.classList.add('card-favorite');

		// Crear y añadir el título del producto
		const titleElement = document.createElement('p');
		titleElement.classList.add('title');
		titleElement.textContent = fav.title;
		favoriteCard.appendChild(titleElement);

		// Crear y añadir el precio del producto
		const priceElement = document.createElement('p');
		priceElement.textContent = fav.price;
		favoriteCard.appendChild(priceElement);

		// Añadir el producto favorito a la lista
		listFavorites.appendChild(favoriteCard);
	});
};

const showHTML = () => {
	publi.forEach(product => {
		const contentProduct = product.querySelector(
			'.content-card-product'
		);
		const productId = contentProduct.dataset.productId;
		const isFavorite = favorites.some(
			favorite => favorite.id === productId
		);

		const favoriteButton = product.querySelector('.favorite');
		const favoriteActiveButton =
			product.querySelector('#added-favorite');
		const favoriteRegularIcon = product.querySelector(
			'#favorite-regular'
		);
		favoriteButton.classList.toggle('favorite-active', isFavorite);
		favoriteRegularIcon.classList.toggle('active', isFavorite);
		favoriteActiveButton.classList.toggle('active', isFavorite);
	});

	
	updateFavoriteMenu();
};

btnsFavorite.forEach(button => {
	button.addEventListener('click', e => {
		const card = e.target.closest('.content-card-product');

		const product = {
			id: card.dataset.productId,
			title: card.querySelector('h3').textContent,
			price: card.querySelector('.price').textContent,
		};

		toggleFavorite(product);

		showHTML();
	});
});

const btnClose = document.querySelector('#btn-close');
const buttonHeaderFavorite = document.querySelector(
	'#button-header-favorite'
);

buttonHeaderFavorite.addEventListener('click', () => {
	containerListFavorites.classList.toggle('show');
});

btnClose.addEventListener('click', () => {
	containerListFavorites.classList.remove('show');
});

loadFavoritesFromLocalStorage();
updateFavoriteMenu();  */