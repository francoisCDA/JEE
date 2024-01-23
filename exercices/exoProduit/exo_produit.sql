SELECT * FROM hibernate_exo.produit;

use hibernate_exo;

CREATE TABLE users (
	id_user INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(15),
    pswd VARCHAR(50)
);
