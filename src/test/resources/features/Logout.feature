@REQ_POEI23P2G2-1
Feature: US6 - Déconnexion de l'espace client

	#On valide qu’un lien de “logout” est disponible et redirige vers la page “My account”qui contient les pavés de "Login" et de "Register"
	@TEST_POEI23P2G2-6 @TNR @autom
	Scenario: Valider qu’un lien de “logout” est disponible et redirige vers la page “My account”qui contient les pavés de "Login" et de "Register" 
		Given je suis connecté à mon compte
		And je cherche dans la page pour trouver le lien ” logout”
		When je clique sur le lien de “logout” 
		Then je suis déconnecté de mon compte
		And  je suis  redirigé vers la page daccueil vers les pavé de "Login" et de "Register"
