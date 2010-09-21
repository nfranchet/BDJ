package com.aeonconsulting.bdj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aeonconsulting.bdj.conf.DB_VERSION_1;
import com.aeonconsulting.bdj.services.BDJException;

public class GenericDao {

	private static Connection _connection;
		
	public Connection getConnection() throws BDJException {
		try {
			if (_connection == null || _connection.isClosed()) {
				// On retablit une connection
				 try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e) {
					throw new BDJException("Impossible de trouver la librairie sqlite",e);
				}
				 _connection = DriverManager.getConnection("jdbc:sqlite:bdj.db");
				 // On verifie que la BD existe et on recupere son numero de version
			}
		} catch (SQLException e) {
			throw new BDJException("Erreur a la connection",e);
		}
		return _connection;
	}
	
	public Integer getVersion() throws BDJException {
		try {
			Statement stat = getConnection().createStatement();
			ResultSet result = stat.executeQuery("select version from Version");
			// On recupere la version
			return result.getInt("version");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Code d'erreur : "+e.getErrorCode());
			if (e.getErrorCode() == 0) {
				// On demande la creation de la structure de la BD
				return createDB();
			} else {
				return -1;
			}
		}

	}
	
	/**
	 * Creation de la base de données avec le schéma voulu
	 * @return
	 * @throws BDJException 
	 */
	private Integer createDB() throws BDJException {
		//TODO: mettre cette information qqpart
		Integer version = 1;
		// On lit le fichier de creation de la BD
		
		try {
			Statement stmt = _connection.createStatement();
			// On cree la table
			stmt.executeUpdate(DB_VERSION_1.createVersionQuery());
			stmt.executeUpdate(DB_VERSION_1.createAlbumsQuery());
			stmt.executeUpdate(DB_VERSION_1.createAuteursQuery());
			// On ajoute le premier numero de version 
			stmt.executeUpdate("INSERT INTO Version VALUES ("+version+")");
		} catch (SQLException e) {
			throw new BDJException("Error de BD",e);
		}
		
		return version;
	}
	
	/**
	 * Mise a jour de la BD avec les requetes SQL 'qui vont bien'
	 * @return
	 * @throws BDJException 
	 */
	private Integer updateDB() throws BDJException {
		Integer currentVersion = getVersion();
		// On lit le fichier de maj renvoyer
		Integer lastVersion = currentVersion + 1;
		return lastVersion;
	}
}

