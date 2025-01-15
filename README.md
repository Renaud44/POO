TP3
Etape 13

1) Avec cette partie : @GetMapping("/greeting")
2) Avec cette partie  return "greeting";
3) Pour envoyer le nom � qui nous disons bonjour on le change dans cette partie du code : 
     public String greeting(@RequestParam(name="ENSIM", required=false, defaultValue="Word")
     
Etape 17
Oui j'ai remarqu� une diff�rence. Il y a une table ADDRESS qui s'est cr�� avec les colonnes : CREATION, ID et CONTENT.

Etape 18
Apparition de la nouvelle table :

Avec l'annotation @Entity Hibernate consid�re cette classe comme une entit� JPA. Cette annotation indique � JPA qu'il s'agit
d'une classe � mapper dans une table de base de donn�e.
Ainsi Hibernate utilise le nom de la classe (Address) pour cr�er une table correspondante dans la base de donn�e.

Etape 20
SELECT * from address;
Oui je vois tout le contenu de data.sql

Etape 22
L'annotation @Autowired est utilis�e pour injecter automatiquement une d�pendance. Gr�ce � cette annotation, Spring va rechercher automatiquement
un bean de type AddressRepository dans la contexte de l'application (ApplicationContext) et l'injecter dans le contr�leur AddressController.

Etape 26
1- private String auteur;
	public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String nomAuteur) {
        this.auteur = auteur;
    }
    
2- INSERT INTO address (id, creation, content,auteur) VALUES (1, CURRENT_TIMESTAMP(), '57 boulevard demorieux','Satoru GOJO');
   INSERT INTO address (id, creation, content,auteur) VALUES (2, CURRENT_TIMESTAMP(), '51 allee du gamay, 34080
   montpellier','SUKUNA');
   
3- <h1>Les differentes adresses</h1>
<ul th:each="address:${allAddresses}">
    <li>
        <span th:text="${address.content}"></span>
        <span th:text="'(Auteur : ' + ${address.auteur} + ')'"></span>
    </li>
</ul>

Etape 30
J'ai ajout� les d�pendances Bootstrap au fichier pom.xml : 
<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>5.2.3</version>	
</dependency>
		
<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>webjars-locator</artifactId>
			<version>0.45</version>
</dependency>

TP4

Etape 6
1. Oui, une cl� API est n�cessaire pour acc�der � l'API MeteoConcept
2. https://api.meteoconcept.com/api/forecast/daily
3. La m�thode HTTP � utiliser est GET
4. Les param�tres d'appel sont pass�s dans l'URL sous forme de query string. Voici les param�tres requis :

token : La cl� API.
latlng : Les coordonn�es GPS au format latitude,longitude.

5.a) Pour afficher la temp�rature du lieu vis� par les coordonn�es GPS :
La temp�rature minimale et maximale sont disponibles dans la section forecast de la r�ponse. Chaque objet de la liste forecast contient les champs :

tmin : Temp�rature minimale (en degr�s Celsius).
tmax : Temp�rature maximale (en degr�s Celsius).
 Pour afficher la pr�vision m�t�o du lieu vis� par les coordonn�es GPS :

b) La description des pr�visions m�t�o est disponible dans la m�me section forecast. Elle est accessible via le champ :

weather : Description de la m�t�o 


Lien GitHub : https://github.com/Renaud44/POO/