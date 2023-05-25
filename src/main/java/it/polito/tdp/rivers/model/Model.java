package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.db.RiversDAO;


public class Model {
	
	Map<Integer, River > idMap;
	RiversDAO dao;
	
	public Model() {
		this.dao = new RiversDAO();
		this.idMap = new HashMap<Integer, River>();
		this.dao.getAllRivers(idMap);
	}
	
	
	public Map<Integer, River> loadAllMisurazioni() {
		for( River r : idMap.values()) {
			this.dao.getFlows(r, idMap);
		}
		
		return this.idMap;
	}
	
	public LocalDate getPrimaMisurazione( River r) {
		List<Flow> misuraz = idMap.get(r.getId()).getFlows();
		return misuraz.get(0).getDay();
	}
	
	
	public LocalDate getUltimaMisurazione( River r) {
		List<Flow> misuraz = idMap.get(r.getId()).getFlows();
		return misuraz.get(misuraz.size()-1).getDay();
	}
	
	public int getnumTotMisurazioni(  River r) {
		List<Flow> misuraz = idMap.get(r.getId()).getFlows();
		return misuraz.size();
	}
	
	public double getMediaMisurazioni(  River r) {
		List<Flow> misuraz = idMap.get(r.getId()).getFlows();
		double media = 0;
		for( Flow f : misuraz) {
			media += f.getFlow();
		}
		media = media / misuraz.size();
		return media;
	}
	
	
	
}
