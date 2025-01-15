TP3
Etape 13

1) Avec cette partie : @GetMapping("/greeting")
2) Avec cette partie  return "greeting";
3) Pour envoyer le nom à qui nous disons bonjour on le change dans cette partie du code : 
     public String greeting(@RequestParam(name="ENSIM", required=false, defaultValue="Word")
     
Etape 17
Oui j'ai remarqué une différence. Il y a une table ADDRESS qui s'est créé avec les colonnes : CREATION, ID et CONTENT.

Etape 18
Apparition de la nouvelle table :

Avec l'annotation @Entity Hibernate considère cette classe comme une entité JPA. Cette annotation indique à JPA qu'il s'agit
d'une classe à mapper dans une table de base de donnée.
Ainsi Hibernate utilise le nom de la classe (Address) pour créer une table correspondante dans la base de donnée.

Etape 20
SELECT * from address;
Oui je vois tout le contenu de data.sql

Etape 22
L'annotation @Autowired est utilisée pour injecter automatiquement une dépendance. Grâce à cette annotation, Spring va rechercher automatiquement
un bean de type AddressRepository dans la contexte de l'application (ApplicationContext) et l'injecter dans le contrôleur AddressController.

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
J'ai ajouté les dépendances Bootstrap au fichier pom.xml : 
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
1. Oui, une clé API est nécessaire pour accéder à l'API MeteoConcept
2. https://api.meteoconcept.com/api/forecast/daily
3. La méthode HTTP à utiliser est GET
4. Les paramètres d'appel sont passés dans l'URL sous forme de query string. Voici les paramètres requis :

token : La clé API.
latlng : Les coordonnées GPS au format latitude,longitude.

5.a) Pour afficher la température du lieu visé par les coordonnées GPS :
La température minimale et maximale sont disponibles dans la section forecast de la réponse. Chaque objet de la liste forecast contient les champs :

tmin : Température minimale (en degrés Celsius).
tmax : Température maximale (en degrés Celsius).
 Pour afficher la prévision météo du lieu visé par les coordonnées GPS :

b) La description des prévisions météo est disponible dans la même section forecast. Elle est accessible via le champ :

weather : Description de la météo 


Lien GitHub : https://github.com/Renaud44/POO/