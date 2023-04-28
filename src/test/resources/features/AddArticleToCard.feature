@REQ_POEI23P2G2-2
Feature: US7 - Ajout des articles dans panier depuis la Page Shop
	#*En tant qu'*
	#Utilisateur
	#*Je souhaite*
	#Depuis la page ""Shop"", ajouter des articles dans mon panier
	#*Afin de*
	#Pouvoir passer des commandes

	#On Valide que la page shop existe et contient des articles de vente
	@TEST_POEI23P2G2-7 @TNR @autom
	Scenario: Valider que la page shop existe et contient des articles de vente 
		Given je clique sur le lien pour accéder à la page “shop”
		When je vérifie l'affichage de la page “shop”
		Then la page “shop” s’affiche
		And la page “shop” contient des articles de vente
	#* Valider qu'une option ajout d’article dans le panier existe via le bouton "ADD TO BASKET"
	@TEST_POEI23P2G2-8 @TNR @autom
	Scenario: Valider qu'une option ajout d’article dans le panier existe via le bouton "ADD TO BASKET"
		Given je suis dans la page "shop"
		When je clique sur bouton "ADD TO BASKET" pour  ajouter  larticle 
		Then article est bien ajouté dans le panier
	#* Vérifier l'apparition d'un lien "VIEW BASKET" à chaque ajout d'article en panier
	@TEST_POEI23P2G2-9 @TNR @autom
	Scenario: Vérifier l'apparition d'un lien "VIEW BASKET" à chaque ajout d'article en panier
		Given je suis sur la page shop
		When  jai ajouté un article en panier
		Then le lien "VIEW BASKET" est affiché
	#* Valider qu'un bouton "READ MORE" existe à la place de "ADD TO BASKET" si l'article n'est pas en stock (cas non passant)
	@TEST_POEI23P2G2-10 @TNR @autom
	Scenario: Valider qu'un bouton "READ MORE" existe à la place de "ADD TO BASKET" si l'article n'est pas en stock (cas non passant)
		Given je suis sur la page shop
		When jai cliqué sur le bouton ADD TO BASKET 
		Then un bouton “READ MOR”E saffiche
	#* Valider la possibilité de consulter le panier depuis toute les pages de l'application via le lien de l'icône(chariot)
	@TEST_POEI23P2G2-11 @TNR @autom
	Scenario: Valider la possibilité de consulter le panier depuis toute les pages de l'application via le lien de l'icône(chariot)
		Given  j’ai ajouté un article dans le panier
		When j’ai cliqué sur le lien “View basket”
		Then je suis redirigé vers la page de panier
	#* Vérifier que l’option filtrage des articles par “Prix” et “thème” est disponible
	@TEST_POEI23P2G2-12 @TNR @autom
	Scenario: -Vérifier que l’option filtrage des articles par “Prix” et “thème” est disponible
		Given je suis dans une page de lapplication
		When jai ajouté un article dans le panier
		And jai clique sur le lien de licône chariot
		Then page panier affichée
	#* Valider que chaque article contient une photo descriptive, libellée et le prix affiché au-dessous.
	@TEST_POEI23P2G2-14 @TNR @autom
	Scenario: Valider que chaque article contient une photo descriptive, libellée et le prix affiché au-dessous.
		Given  je suis dans la page “shop”
		When je vérifie l’affichage des articles de vente
		Then affichage des articles avec photo descriptive, libellée et prix affichés au-dessous.
	#* Valider l'existence d'un lien actif sur la photo, le libellé et le prix qui redirige vers le détail de l'article.
	@TEST_POEI23P2G2-16
	Scenario: Valider l'existence d'un lien actif sur la photo, le libellé et le prix qui redirige vers le détail de l'article.
		Given je suis dans la page “shop”
		When je vérifie l’affichage des articles de vente
		Then affichage des articles avec photo descriptive, libellée et prix affichés au-dessous.
