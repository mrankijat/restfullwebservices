package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.TouristNotFoundException;
import com.nt.model.Tourist;
import com.nt.repository.ITouristRepository;

@Service("touristService")
public class TouristServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepository touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		//use repo
		return "Tourist is registred with id value: "+touristRepo.save(tourist).getTid();
	}

	@Override
	public List<Tourist> findAllTourist() {
		
		return touristRepo.findAll();
	}

	@Override
	public String updateTourist(Tourist tourist) {
    	Optional<Tourist> opt = touristRepo.findById(tourist.getTid());
		return "Tourist is updated with id value: "+touristRepo.save(tourist).getTid();
	
	}

	@Override
	public String deleteTouristBytid(Integer tid) {
	//use Repo
		Optional<Tourist> opt = touristRepo.findById(tid);
		if (opt.isPresent()) {
			touristRepo.deleteById(tid);
			return "Tourist is deleted with id value: "+tid;
		}
		return "Tourist not found";
	}

	@Override
	public Tourist findTouristByid(Integer tid) {
		Optional<Tourist> opt = touristRepo.findById(tid);		
		if (opt.isPresent()) {
			//use Repo
                 return opt.get();
		}
	 throw new TouristNotFoundException("Tourist not found");
	}
	
	@Override
	public List<Tourist> findTouristByName(String tname) throws TouristNotFoundException {
		//use Repo
		List<Tourist> tourists = touristRepo.fetchTouristByName(tname);
		return tourists;
	}
	@Override
	public String updateTouristBudgetById(int tid, double hikePercentage) throws TouristNotFoundException {
            //use Repo
		Optional<Tourist> opt = touristRepo.findById(tid);
		if (opt.isPresent()) {
			Tourist tourist = opt.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*hikePercentage/100.0));
			return "Tourist budget is hiked and new budget is ::"+touristRepo.save(tourist).getBudget();
		}
		throw new TouristNotFoundException("Tourist not found");
	}
	@Override
	public String deleteDeleteByBudgetRange(double start, double end) {
		//use Repo
		Integer count=touristRepo.deleteByBudgetRange(start, end);
		return count+" Tourists are deleted by budget range";
	}

}
