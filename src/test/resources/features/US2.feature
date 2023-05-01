@REQ_POEI23P2G2-66
Feature: US2:Connexion à un compte
	#*En tant qu*'Utilisateur
	#*Je souhaite* Me connecter à mon compte
	#*Afin de* Gérer mes commandes et mes informations personnelles
	#
	#
	#+*Règles de gestion :*+
	#*RG1 :* Dans l'espace ""My Account"" un pavé ""Login"" permet de saisir son login et son mot de passe et de valider avec un bouton ""LOGIN""
	#*RG2 :* En se connectant à son compte l'écran ""Dashboard"" doit s'afficher, et des liens renvoyant aux pages
	#suivantes sont présentes : Dashboard, Orders, Download, Adresses, Account Details, Logout
	#*RG3 :* En cas de connexion avec un mot de passe erroné, un message ""ERROR: The password you entered for the
	#username ""Email"" incorrect s'affiche
	#*RG4 :* Une case à cocher ""Remember me"" permet de garder son login pré-rempli à la prochaine connexion

	@TEST_POEI23P2G2-84 @TNR @autom
	Scenario: Valider que le pavé “Login” est disponible dans l’espace “My account”
		Given J ouvre l application
		When  Je vais dans l espace My account
		Then  le pavé Login s affiche
	#Dans l’espace “Dashbord”, on doit valider  la présence de liens qui redirigent l’utilisateur vers les pages: Orders, Download, Adresses, Account Details, Logout
	@TEST_POEI23P2G2-85 @TNR @autom
	Scenario Outline: Valider que l’utilisateur a la possibilité de se connecter à son compte en saisissant un login et un mot de passe et est redirigé vers un espace Dashbord 
		Given  J ouvre l application
		And Je suis dans l espace My account
		When je me connecte avec le username "<username>" et le mot de passe "<password>" 
		Then l ecran <Dashboard> doit s'afficher
		And les liens renvoyant aux pages suivantes sont présents : Dashboard, Orders, Download, Adresses, Account Details, Logout
		
		 Examples:
						|username            |password    |
						|aynar@test.com      |Windmac1405 |
	@TEST_POEI23P2G2-87 @TNR @autom
	Scenario Outline: Valider que  le message "ERROR: The password you entered for the username "Email" incorrect” s’affiche dans le cas où l’utilisateur saisie un mot de passe erroné
		Given  J ouvre l application
		And Je suis dans l espace My account
		When je me connecte avec le username "<username>" et le mot de passe "<incorrectPwd>"
		Then un message d erreur "<msg-error>" doit s'afficher
		
		 Examples:
			        |username            |incorrectPwd           |msg-error|
		  			|aynar@test.com      |MotDePasseIncorrect123 |Error: the password you entered for the username aynar@test.com is incorrect|
	@TEST_POEI23P2G2-88 @TNR @autom @siteOpened
	Scenario Outline: Valider la présence de la case "remember me" qui permet de garder le login pré-rempli pour la prochaine connexion 
		Given Je suis dans l espace My account
		When je saisie le login "<username>" et le mot de passe "<password>"
		And  je coche la case <Remember me>
		And je clique sur le bouton <LOGIN>
		Then je suis sur l espace <Dashboard>

		When je me déconnecte et revient sur le pavé <Login>
		Then le login "monlogin@gmail.com" doit être pré-rempli dans le champs du username
		
		 Examples:
						|username            |password    |
						|aynar@test.com      |Windmac1405 |
