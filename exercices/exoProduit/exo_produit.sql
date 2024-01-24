SELECT * FROM hibernate_exo.produit;

use hibernate_exo;

CREATE TABLE users (
	id_user INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(15),
    pswd VARCHAR(50)
);

ALTER TABLE users ADD CONSTRAINT UNIQUE(pseudo);

;

ALTER TABLE produit ADD COLUMN pathImg VARCHAR(250) ;

ALTER TABLE produit RENAME COLUMN pathImg to path_img;

select * from produit;

