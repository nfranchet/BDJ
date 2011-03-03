package com.aeonconsulting.bdj.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aeonconsulting.bdj.model.Albums;
import com.aeonconsulting.bdj.services.BDJException;
import com.aeonconsulting.bdj.util.BeanUtil;

public class AlbumDao extends GenericDao {

	/**
	 * Recupere un album par son id
	 * @param idBel
	 * @return
	 * @throws BDJException 
	 */
	public Albums getByIdBel(Integer idBel) throws BDJException {
		String query = "SELECT * from Albums where idBel = ?";
		PreparedStatement stmt = null;
		ResultSet result  = null;
		try {
			stmt = getConnection().prepareStatement(query);
			stmt.setInt(1, idBel);
			result = stmt.executeQuery();
			// On verifie que l'on a bien qu'un seul objet
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BDJException("Erreur DB ",e);
		} finally {
			if (result != null) {
				try {
					result.close();
					result = null;
				} catch (Exception e) {
					// Nothing to do
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					// Nothing to do
				}
			}
		}
		return null;
	}
	
	
	/**
	 * Ajoute un album dans la BD
	 * @param album
	 * @throws BDJException 
	 */
	public void add(Albums album) throws BDJException {
		StringBuffer query = new StringBuffer("INSERT INTO Albums (");
		query.append(BeanUtil.getFieldsAsString(album));
		query.append(") VALUES (");
		query.append(BeanUtil.getValuesAsString(album));
		query.append(");");
		
	}
}
