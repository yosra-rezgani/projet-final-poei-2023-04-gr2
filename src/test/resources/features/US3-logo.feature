@REQ_POEI23P2G2-67
Feature: US3- Visualisation du logo du site
	#*En tant qu'* Utilisateur
	#*Je souhaite* Voir le logo du Site "AT"
	#
	#
	#
	#+*Règles de gestion :*+
	#*RG1 :* Le logo contient un lien qui doit rediriger le site sur la page accueil
	#*RG2 :* Le logo doit être présent sur toutes les pages du site

	Background:

		Given J ouvre l application
	@TEST_POEI23P2G2-104 @TNR @autom
	Scenario Outline: Vérifier que le logo est présent sur toutes les pages du site

		When je vais sur la page "<Page>"
		Then le logo <AT> est présent sur la page "<Page>"
		
		Examples:
			| Page       |
			| Home       |
			| My Account |
			| Cart       |
			| Product    |
			| Shop       |

	@TEST_POEI23P2G2-105 @TNR @autom
	Scenario Outline: Vérifier que le logo contient un lien redirigeant vers la page d'accueil, depuis toutes les pages du site
		And je vais sur la page "<Page>"
		When je clique sur le logo AT en haut à gauche de la page "<Page>"
		Then je suis redirigé vers la page d'accueil
		
		Examples:
			| Page       |
			| Home       |
			| My Account |
			| Cart       |
			| Product    |
			| Shop       |