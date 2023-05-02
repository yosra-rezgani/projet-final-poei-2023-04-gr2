@REQ_POEI23P2G2-44
Feature: US1 -  Création de compte client
	#*En tant qu*'Utilisateur
	#*Je souhaite* Créer un compte client
	#*Afin de* Gérer mes commandes et mes informations personnelles
	#
	#+*Règles de gestion :*+
	#
	#
	#*RG1 :* Dans l'espace "My Account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" :
	#
	#* En saisissant son nom et prénom
	#* En saisissant un mail et un mot de passe
	#* En validant avec un bouton "REGISTER"
	#
	#
	#*RG2 :* Le mot de passe doit être composé à minima de 7 caractères et contenir à minima une majuscule, une
	#minuscule, un chiffre et un caractère spécial

	#On vérifie que  le pavé “Register” est disponible dans l’espace “My account”
	@TEST_POEI23P2G2-45 @TNR @autom
	Scenario: Valider que le pavé “Register” est disponible dans l’espace “My account”
		Given J ouvre l application
		When  Je vais dans l espace My account
		Then  le pavé Register s affiche
	#On vérifie que l’utilisateur peut créer un compte dans le pavé “Register”
	@TEST_POEI23P2G2-47 @TNR @manual
	Scenario Outline: Valider que l’utilisateur peut créer un compte dans le pavé “Register” 
		Given Je suis sur le pavé Register
		When Je saisis mon adresse e-mail "<email>" et mon mot de passe "<password>" et Je clique sur le bouton REGISTER
		Then Je suis redirigé vers la page My Account
		And Je vois le message de confirmation "<Msg-success>"
		
		 Examples:
				|email               |password     |Msg-success                      |
				|aynar@yahoo.com      |Windmac1405  |Hello aynar|
	#On vérifie  que le mot de passe répond aux exigences de l’application
	@TEST_POEI23P2G2-48 @TNR @autom
	Scenario Outline: Valider que le mot de passe doit répondre aux exigences de l’application
		Given Je suis sur le pavé Register
		When Je renseigne mon adresse e-mail "<email>" et mon mot de passe "<password>"
		Then Je reste sur la page d inscription
		And Le bouton <Register> est désactivé
		And Je vois un message d'erreur qui commence par "<Msg-error>"

		Examples:
			|email             |password |Msg-error|
			|arij@test.com     |mdp123   |The password should be at least seven characters long|
