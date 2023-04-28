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
		When  Je vais dans l espace <My account>
		Then  Le pavé <Register> s affiche
