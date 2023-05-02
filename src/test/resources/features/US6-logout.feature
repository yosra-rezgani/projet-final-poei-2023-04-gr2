@REQ_POEI23P2G2-1
Feature: US6 - Déconnexion de l'espace client
	#En tant qu'
	#Utilisateur
	#Je souhaite
	#Me déconnecter
	#Afin de
	#Ne plus pouvoir accèder à mon espace client

	#On valide qu’un lien de “logout” est disponible et redirige vers la page “My account”qui contient les pavés de "Login" et de "Register"
	@TEST_POEI23P2G2-6 @TNR @autom
	Scenario Outline: Valider qu’un lien de “logout” est disponible et redirige vers la page “My account”qui contient les pavés de "Login" et de "Register"

		Given J ouvre l application
		And Je vais dans l espace My account
		And je suis connecté avec le login "<username>" et le mot de passe "<password>"
		When je clique sur le lien de “logout”
		Then je suis  redirigé vers les pavé de Login et de Register

		Examples:
			|username            |password    |
			|aynar@test.com      |Windmac1405 |


