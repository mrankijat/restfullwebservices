package com.nt.service;

import java.util.List;

import com.nt.exception.TouristNotFoundException;
import com.nt.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> findAllTourist();
	public String updateTourist(Tourist tourist);
	public String deleteTouristBytid(Integer tid)throws TouristNotFoundException;
	public Tourist findTouristByid(Integer tid)throws TouristNotFoundException;
	public List<Tourist> findTouristByName(String tname)throws TouristNotFoundException;
	public String updateTouristBudgetById(int tid,double hikePercentage)throws TouristNotFoundException;
	public String deleteDeleteByBudgetRange(double start,double end);
}
