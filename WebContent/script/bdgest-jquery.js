var buttonsList = new Array('0','A','B',"C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"," ");

$(document).ready(function() {
	displayItems();
});

function displayItems () {
	var xhtmlButtons = "<table><tr>";
	
	for (i = 0; i< buttonsList.length; i++) {
		if (i == buttonsList.length/2) {
			xhtmlButtons+="</tr><tr>";
		}
		lettre = buttonsList[i];
		if (lettre == " ") {
			lettre = "_";
		}
		
		// Suivant la sélection du type d'objet
		var calledMethod = "";
		if ($("#objectType").val()=="albums") {
			calledMethod="getListeAlbums(\""+buttonsList[i]+"\")";
		} else if ($("#objectType").val()=="parabd") {
			calledMethod="getParaBD(\""+buttonsList[i]+"\")";
		} else if ($("#objectType").val()=="revues") {
			calledMethod="getRevues(\""+buttonsList[i]+"\")";
		} else {
			alert("Type d'objet inconnu");
			// TODO : ecrire un joli messge d'alerte
			return;
		}
		xhtmlButtons+="<td id='"+buttonsList[i].charCodeAt(0)+"button' class='button'><a href='#' onclick='"+calledMethod+"'>"+lettre+"</a></td>";
	}
	xhtmlButtons+="</tr></table>";
	$("#listeBoutons").html(xhtmlButtons);	
}
	
function getListeAlbums(lettre) {
	// On demande a récupérer les informations pour les albums
	// On vide le panneau d'affichage des listes
	$("#listeResume").html("");
	// TODO : Pour l'instant on ne gere pas la langue, amélioration a faire 
	$.get("Proxy?action=series&lettre="+lettre.charCodeAt(0), function(data) {
		populateListeObject(data);
	});
}

/**
 * Rempli la liste des objets
 * @param data
 * @return
 */
function populateListeObject(data) {
	// On alimente le div response
	if (data.substring(0,"[ERROR]".length) == "[ERROR]") {
		alert(data.replace(["ERROR"],"","g")); // On affiche le message d'erreur dans une boite d'alerte
	} else {
		eval("var result="+data);
		var htmlResult = "<table id='result'>";
		htmlResult+= "<thead><tr><td>idBel</td><td>Nom</td><td>nbAlbum</td><td>Langue</td></tr></thead>";
		htmlResult+= "<tbody>";
		for (i=0; i< result.listeObject.length-1; i++) {
			var object = result.listeObject[i];
			//TODO créé le tableau
			htmlResult+="<tr onclick='afficheObject(\""+object.idBel+"\",\""+object.nom+"\")' class='ligneType"+(i%2)+"'>";
			htmlResult+="<td>"+object.idBel+"</td>";
			htmlResult+="<td>"+object.nom+"</td>";
			htmlResult+="<td>"+object.nbAlbum+"</td>";
			htmlResult+="<td>"+object.langue+"</td>";
			htmlResult+="</tr>";
		}
		htmlResult+="</tbody></table>";
		$("#response").html(htmlResult);
		// On espere que les données nous arrive sérialisé JSON
	}
}

function afficheObject(idBel, nom) {
	if ($("#objectType").val()=="albums") {
		afficheSerie(idBel);
	} else if ($("#objectType").val()=="parabd") {
		afficheParaBD(idBel);
	} else if ($("#objectType").val()=="revues") {
		afficheRevues(nom);
	}
}

// Affichage d'une serie depuis son Id
function afficheSerie(idBel) {
	$.get("Proxy?action=albumResume&idBel="+idBel, function(data) {
		// On alimente le div response
		if (data.substring(0,"[ERROR]".length) == "[ERROR]") {
			alert(data.replace(["ERROR"],"","g")); // On affiche le message d'erreur dans une boite d'alerte
		} else {
			eval("var result="+data);
			var htmlResult = "<table id='resultAlbum'>";
			// TODO : mettre le header coté serveur
			htmlResult+= "<thead><tr>";
			htmlResult+="<td>idBel</td>";
			htmlResult+="<td>serie</td>";
			htmlResult+="<td>numero</td>";
			htmlResult+="<td>a</td>";
			htmlResult+="<td>titre</td>";
			htmlResult+="<td>scenariste</td>";
			htmlResult+="<td>dessinateur</td>";
			htmlResult+="<td>coloriste</td>";
			htmlResult+="<td>Editeur</td>";
			htmlResult+="<td>Collection</td>";
			htmlResult+="<td>depotLegal</td>";
			htmlResult+="<td>isbn</td>";
			htmlResult+="<td>cote</td>";
			htmlResult+="<td>format</td>";
			htmlResult+="<td>integrale</td>";
			htmlResult+="<td>tirageTete</td>";
			htmlResult+="<td>broche</td>";
			htmlResult+="<td>bool5</td>";
			htmlResult+="<td>nbPages</td>";
			htmlResult+="<td>couverture</td>";
			htmlResult+="<td>soumispar</td>";
			htmlResult+="<td>dateSoumission</td>";
			htmlResult+="<td>champ1</td>";
			htmlResult+="<td>champ2</td>";
			htmlResult+="<td>champ3</td>";
			htmlResult+="<td>champ4</td>";
			htmlResult+="<td>champ5</td>";
			htmlResult+="<td>champ6</td>";
			htmlResult+="<td>champ7</td>";
			htmlResult+="<td>champ8</td>";
			htmlResult+="<td>champ9</td>";
			htmlResult+="<td>idSerie</td>";
			htmlResult+="<td>idDessinateur</td>";
			htmlResult+="<td>idScenariste</td>";
			htmlResult+="<td>idColoriste</td>";
			htmlResult+="<td>editionOrignale</td>";
			htmlResult+="<td>infosEdition</td>";
			htmlResult+="<td>planche</td>";
			htmlResult+="<td>planche1</td>";
			htmlResult+="<td>AI</td>";
			htmlResult+="<td>planche3</td>";
			htmlResult+="<td>serieOrigine</td>";
			htmlResult+="<td>resume</td>";
			htmlResult+="</tr></thead>";
			htmlResult+= "<tbody>";
			for (i=0; i< result.albumResume.length-1; i++) {
				var album = result.albumResume[i];
				//TODO créé le tableau
				htmlResult+="<tr onclick='importAlbum(\""+album.idBel+"\")' class='ligneType"+(i%2)+"'>";		
				htmlResult+="<td>"+album.idBel+"</td>";
				htmlResult+="<td>"+album.serie+"</td>";
				htmlResult+="<td>"+album.numero+"</td>";
				htmlResult+="<td>"+album.a+"</td>";
				htmlResult+="<td>"+album.titre+"</td>";
				htmlResult+="<td>"+album.scenariste+"</td>";
				htmlResult+="<td>"+album.dessinateur+"</td>";
				htmlResult+="<td>"+album.coloriste.replace("<","").replace(">","")+"</td>";
				htmlResult+="<td>"+album.Editeur+"</td>";
				htmlResult+="<td>"+album.Collection+"</td>";
				htmlResult+="<td>"+album.depotLegal+"</td>";
				htmlResult+="<td>"+album.isbn+"</td>";
				htmlResult+="<td>"+album.cote+"</td>";
				htmlResult+="<td>"+album.format+"</td>";
				htmlResult+="<td>"+album.integrale+"</td>";
				htmlResult+="<td>"+album.tirageTete+"</td>";
				htmlResult+="<td>"+album.broche+"</td>";
				htmlResult+="<td>"+album.bool5+"</td>";
				htmlResult+="<td>"+album.nbPages+"</td>";
				htmlResult+="<td>"+album.couverture+"</td>";
				htmlResult+="<td>"+album.soumispar+"</td>";
				htmlResult+="<td>"+album.dateSoumission+"</td>";
				htmlResult+="<td>"+album.nomDessinateur+"</td>";
				htmlResult+="<td>"+album.prenomDessinateur+"</td>";
				htmlResult+="<td>"+album.pseudoDessinateur+"</td>";
				htmlResult+="<td>"+album.nomScenariste+"</td>";
				htmlResult+="<td>"+album.prenomScenariste+"</td>";
				htmlResult+="<td>"+album.pseudoScenariste+"</td>";
				htmlResult+="<td>"+album.nomColoriste+"</td>";
				htmlResult+="<td>"+album.prenomColoriste+"</td>";
				htmlResult+="<td>"+album.pseudoColoriste+"</td>";
				htmlResult+="<td>"+album.idSerie+"</td>";
				htmlResult+="<td>"+album.idDessinateur+"</td>";
				htmlResult+="<td>"+album.idScenariste+"</td>";
				htmlResult+="<td>"+album.idColoriste+"</td>";
				htmlResult+="<td>"+album.editionOriginale+"</td>";
				htmlResult+="<td>"+album.infosEdition+"</td>";
				htmlResult+="<td>"+album.planche+"</td>";
				htmlResult+="<td>"+album.planche1+"</td>";
				htmlResult+="<td>"+album.AI+"</td>";
				htmlResult+="<td>"+album.planche3+"</td>";
				htmlResult+="<td>"+album.serieOrigine+"</td>";
				htmlResult+="<td>"+album.resume+"</td>";
				htmlResult+="</tr>";
			}
			htmlResult+="</tbody></table>";
			$("#listeResume").html(htmlResult);
			// On espere que les données nous arrive sérialisé JSON
		}
	});
}

function afficheParaBD(idBel) {
	$.get("Proxy?action=parabdResume&idBel="+idBel, function(data) {
		// On alimente le div response
		if (data.substring(0,"[ERROR]".length) == "[ERROR]") {
			alert(data.replace(["ERROR"],"","g")); // On affiche le message d'erreur dans une boite d'alerte
		} else {
			eval("var result="+data);
			var htmlResult = "<table id='resultParaBD'>";
			// TODO : mettre le header coté serveur
			htmlResult+= "<thead><tr>";
			htmlResult+="<td>idBel</td>";
			htmlResult+="<td>idSerie</td>";
			htmlResult+="<td>idAuteur</td>";
			htmlResult+="<td>nomSerie</td>";
			htmlResult+="<td>auteur</td>";
			htmlResult+="<td>descriptif</td>";
			htmlResult+="<td>type</td>";
			htmlResult+="<td>categorie</td>";
			htmlResult+="<td>matiere</td>";
			htmlResult+="<td>aspect</td>";
			htmlResult+="<td>editeur</td>";
			htmlResult+="<td>fabricant</td>";
			htmlResult+="<td>champ8</td>";
			htmlResult+="<td>numerote</td>";
			htmlResult+="<td>signe</td>";
			htmlResult+="<td>boite</td>";
			htmlResult+="<td>horscommerce</td>";
			htmlResult+="<td>hauteur</td>";
			htmlResult+="<td>largeur</td>";
			htmlResult+="<td>profondeur</td>";
			htmlResult+="<td>dateSortie</td>";
			htmlResult+="<td>tirage</td>";
			htmlResult+="<td>champ14</td>";
			htmlResult+="<td>prix</td>";
			htmlResult+="<td>cote</td>";
			htmlResult+="<td>commentaire</td>";
			htmlResult+="<td>image</td>";
			htmlResult+="<td>nomAuteur</td>";
			htmlResult+="<td>prenomAuteur</td>";
			htmlResult+="<td>pseudoAuteur</td>";
			htmlResult+="<td>reference</td>";
			htmlResult+="<td>champ20</td>";
			htmlResult+="</tr></thead>";
			htmlResult+= "<tbody>";
			for (i=0; i< result.parabds.length-1; i++) {
				var parabd = result.parabds[i];
				//TODO créé le tableau
				htmlResult+="<tr onclick='importParaBD(\""+parabd.idBel+"\")' class='ligneType"+(i%2)+"'>";		
				htmlResult+="<td>"+parabd.idBel+"</td>";
				htmlResult+="<td>"+parabd.idSerie+"</td>";
				htmlResult+="<td>"+parabd.idAuteur+"</td>";
				htmlResult+="<td>"+parabd.nomSerie+"</td>";
				htmlResult+="<td>"+parabd.auteur+"</td>";
				htmlResult+="<td>"+parabd.descriptif+"</td>";
				htmlResult+="<td>"+parabd.type+"</td>";
				htmlResult+="<td>"+parabd.categorie+"</td>";
				htmlResult+="<td>"+parabd.matiere+"</td>";
				htmlResult+="<td>"+parabd.aspect+"</td>";
				htmlResult+="<td>"+parabd.editeur+"</td>";
				htmlResult+="<td>"+parabd.fabricant+"</td>";
				htmlResult+="<td>"+parabd.champ8+"</td>";
				htmlResult+="<td>"+parabd.numerote+"</td>";
				htmlResult+="<td>"+parabd.signe+"</td>";
				htmlResult+="<td>"+parabd.boite+"</td>";
				htmlResult+="<td>"+parabd.horscommerce+"</td>";
				htmlResult+="<td>"+parabd.hauteur+"</td>";
				htmlResult+="<td>"+parabd.largeur+"</td>";
				htmlResult+="<td>"+parabd.profondeur+"</td>";
				htmlResult+="<td>"+parabd.dateSortie+"</td>";
				htmlResult+="<td>"+parabd.tirage+"</td>";
				htmlResult+="<td>"+parabd.champ14+"</td>";
				htmlResult+="<td>"+parabd.prix+"</td>";
				htmlResult+="<td>"+parabd.cote+"</td>";
				htmlResult+="<td>"+parabd.commentaire+"</td>";
				htmlResult+="<td>"+parabd.nomAuteur+"</td>";
				htmlResult+="<td>"+parabd.prenomAuteur+"</td>";
				htmlResult+="<td>"+parabd.pseudoAuteur+"</td>";
				htmlResult+="<td>"+parabd.reference+"</td>";
				htmlResult+="<td>"+parabd.champ20+"</td>";
				htmlResult+="</tr>";
			}
			htmlResult+="</tbody></table>";
			$("#listeResume").html(htmlResult);
		}
	});	
}

function afficheRevues(nom) {
	$.get("Proxy?action=revuesResume&nom="+nom, function(data) {
		// On alimente le div response
		if (data.substring(0,"[ERROR]".length) == "[ERROR]") {
			alert(data.replace(["ERROR"],"","g")); // On affiche le message d'erreur dans une boite d'alerte
		} else {
			eval("var result="+data);
			var htmlResult = "<table id='resultParaBD'>";
			// TODO : mettre le header coté serveur
			htmlResult+= "<thead><tr>";
			htmlResult+="<td>idBel</td>";
			htmlResult+="<td>nom</td>";
			htmlResult+="<td>numero</td>";
			htmlResult+="<td>a</td>";
			htmlResult+="<td>dateRevue</td>";
			htmlResult+="<td>periodicite</td>";
			htmlResult+="<td>editeur</td>";
			htmlResult+="<td>numoureliure</td>"; //1 numero: 0 reliure
			htmlResult+="<td>prix</td>";
			htmlResult+="<td>cote</td>";
			htmlResult+="<td>commentaire</td>";
			htmlResult+="<td>couverture</td>";
			htmlResult+="<td>planche</td>";
			htmlResult+="<td>verso</td>";
			htmlResult+="<td>titre</td>";
			htmlResult+="<td>nbPages</td>";
			htmlResult+="</tr></thead>";
			htmlResult+= "<tbody>";
			for (i=0; i< result.revues.length-1; i++) {
				var revues = result.revues[i];
				//TODO créé le tableau
				htmlResult+="<tr onclick='importRevues(\""+revues.idBel+"\")' class='ligneType"+(i%2)+"'>";		
				htmlResult+="<td>"+revues.idBel+"</td>";
				htmlResult+="<td>"+revues.nom+"</td>";
				htmlResult+="<td>"+revues.numero+"</td>";
				htmlResult+="<td>"+revues.a+"</td>";
				htmlResult+="<td>"+revues.dateRevue+"</td>";
				htmlResult+="<td>"+revues.periodicite+"</td>";
				htmlResult+="<td>"+revues.editeur+"</td>";
				htmlResult+="<td>"+revues.numoureliure+"</td>";
				htmlResult+="<td>"+revues.prix+"</td>";
				htmlResult+="<td>"+revues.cote+"</td>";
				htmlResult+="<td>"+revues.commentaire+"</td>";
				htmlResult+="<td>"+revues.couverture+"</td>";
				htmlResult+="<td>"+revues.planche+"</td>";
				htmlResult+="<td>"+revues.verso+"</td>";
				htmlResult+="<td>"+revues.titre+"</td>";
				htmlResult+="<td>"+revues.nbPages+"</td>";
				htmlResult+="</tr>";
			}
			htmlResult+="</tbody></table>";
			$("#listeResume").html(htmlResult);
		}
	});	
}

function importAlbum(idAlbum) {
	alert("Import Album not yet implemented");
}

function importRevues(idRevues) {
	alert("Import Revues not yet implemented");
}

function importParaBD(idParaBD) {
	alert("Import ParaBD not yet implemented");
}

function getRevues(lettre) {
	// On demande a récupérer les informations pour les albums
	// On vide le panneau d'affichage des listes
	$("#listeResume").html("");
	// TODO : Pour l'instant on ne gere pas la langue, amélioration a faire 
	$.get("Proxy?action=revues&lettre="+lettre.charCodeAt(0), function(data) {
		populateListeObject(data);
	});
}

function getParaBD(lettre) {
	// On demande a récupérer les informations pour les albums
	// On vide le panneau d'affichage des listes
	$("#listeResume").html("");
	// TODO : Pour l'instant on ne gere pas la langue, amélioration a faire 
	$.get("Proxy?action=paradBDs&lettre="+lettre.charCodeAt(0), function(data) {
		populateListeObject(data);
	});
}