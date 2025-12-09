package com.yt.service;
import java.util.List;
import com.yt.model.Turist;

public interface ITuristService 
{
	public String registerTurist(Turist turist);
	public List<Turist> shoAllTurist();
	public String getTuristById(Integer id);
	public String  updateTurist(Turist turist);
	public String updateTuristById(Integer id,Double hikePercentage);
	public String deleteTurist(Integer id);

}
