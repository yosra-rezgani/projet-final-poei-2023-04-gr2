@REQ_POEI23P2G2-2
Feature: US7 - Ajout des articles dans panier depuis la Page Shop
	#*En tant qu'*
	#Utilisateur
	#*Je souhaite*
	#Depuis la page ""Shop"", ajouter des articles dans mon panier
	#*Afin de*
	#Pouvoir passer des commandes

	#On Valide que la page shop existe et contient des articles de vente
	Background:
		Given J ouvre l application
	@TEST_POEI23P2G2-7 @TNR @autom
	Scenario: Valider que la page shop existe et contient des articles de vente 

		When je clique sur le lien pour accéder à la page <shop>
		Then la page “shop” s'affiche et contient des articles de vente
	#* Valider qu'une option ajout d’article dans le panier existe via le bouton "ADD TO BASKET"
	@TEST_POEI23P2G2-8 @TNR @autom @ranya
	Scenario: Valider qu'une option ajout d’article dans le panier existe via le bouton "ADD TO BASKET"
		And je clique sur le lien pour accéder à la page <shop>
		When je clique sur bouton Add to basket pour  ajouter  larticle
		Then le lien VIEW BASKET s'affiche
	#* Valider qu'un bouton "READ MORE" existe à la place de "ADD TO BASKET" si l'article n'est pas en stock
	@TEST_POEI23P2G2-10 @TNR @autom
	Scenario: Valider qu'un bouton "READ MORE" existe à la place de "ADD TO BASKET" si l'article n'est pas en stock
		And je clique sur le lien pour accéder à la page <shop>
		And un bouton <READ MORE> saffiche en dessous de l'article
		When je clique sur l article
		Then l article est en rupture
	#* Valider la possibilité de consulter le panier depuis toute les pages de l'application via le lien de l'icône(chariot)
	@TEST_POEI23P2G2-11 @TNR @autom
	Scenario: Valider la possibilité de consulter le panier depuis toute les pages de l'application via le lien de l'icône(chariot)
		And je clique sur le lien pour accéder à la page <shop>
		And je clique sur bouton Add to basket pour  ajouter  larticle
		When je clique sur l'icone chariot
		Then je suis redirigé vers la page de panier
	#* Vérifier que l’ utilisateur peut filtrer les articles par “Prix” et par “thème”
	@TEST_POEI23P2G2-13 @TNR @autom
	Scenario: Vérifier que l’ utilisateur peut filtrer les articles par “Prix” et par “thème”
		Given je suis dans la page shop
		When je vérifie l’affichage des articles de vente
		And je choisis filtrage par prix
		Then  affichage des articles filtrés par prix
	#* Valider que chaque article contient une photo descriptive, libellée et le prix affiché au-dessous.
	@TEST_POEI23P2G2-14 @TNR @autom
	Scenario: Valider que chaque article contient une photo descriptive, libellée et le prix affiché au-dessous.
		Given  je suis dans la page shop
		When je vérifie l’affichage des articles de vente
		Then affichage des articles avec photo descriptive, libellée et prix affichés au-dessous
	#* Valider l'existence d'un lien actif sur la photo, le libellé et le prix qui redirige vers le détail de l'article.
	@TEST_POEI23P2G2-16
	Scenario: Valider l'existence d'un lien actif sur la photo, le libellé et le prix qui redirige vers le détail de l'article.
		Given  je suis dans la page shop
		When je clique sur "libellé" de l'article
		Then product page affiché
