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
	#On vérifie  que le mot de passe répond aux exigences de l’application
	@TEST_POEI23P2G2-48 @TNR @autom
	Scenario Outline: Valider que le mot de passe doit répondre aux exigences de l’application en refusant un mot de passe faible lors de la création de compte
		Given Je suis sur le pavé Register
		When Je renseigne mon adresse e-mail "<email>" et mon mot de passe "<password>"
		Then Je reste sur la page d inscription
		And Le bouton <Register> est désactivé
		And Je vois un message d'erreur qui commence par "<Msg-error>"

		Examples:
			|email             |password |Msg-error|
			|arij@test.com     |mdp123   |The password should be at least seven characters long|

	@TEST_POEI23P2G2-160 @TNR @autom
	Scenario Outline: Vérifier que l’utilisateur ne peut pas créer un compte avec un mot de passe ne respectant pas le format décrit dans la US
		Given Je suis sur le pavé Register
		When Je remplie le champs adresse e-mail "<email>" et mot de passe "<password>"
		Then Le bouton <Register> est activé


		Examples:
			|email              |password     |
			|leila@test.com     |leilash00    |
