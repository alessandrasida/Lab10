package it.polito.tdp.rivers.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

public class TestRiversDAO {

	public static void main(String[] args) {
		RiversDAO dao = new RiversDAO();
		//System.out.println(dao.getAllRivers());
		
		Map<Integer, River > idMap  = new HashMap<Integer, River>();
		
		dao.getAllRivers(idMap);
		
		//List<Flow> ris = dao.getFlows(1, idMap);
		
		/*
		 * 		for( Flow  f : ris) {
		 * System.out.println( f);
		}
		 */
			
		
		
		
	}

}
