package com.allideas.bdgest.dao;

import org.junit.Test;

import com.aeonconsulting.bdj.dao.GenericDao;
import com.aeonconsulting.bdj.services.BDJException;

import junit.framework.TestCase;

/**
 * Classe de test pour la DAO 
 *
 */
public class GenericDaoTest extends TestCase {

	@Test
	public void testGetVersion() {
		GenericDao dao = new GenericDao();
		try {
			Integer version = dao.getVersion();
			assertTrue(version != -1);
		} catch (BDJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse(true);
		}
	}
}
