package pagination.page_limit.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import pagination.page_limit.Model.Entity.Infor;
import pagination.page_limit.Model.Request.InfoRequest;
import pagination.page_limit.Repository.InfoRepo;

@Service
public class Services {

	private final InfoRepo inforRepository;
    @Autowired
	public Services(InfoRepo inforRepository) {
		super();
		this.inforRepository = inforRepository;
	}
	
    public Infor createData(InfoRequest req) {
    	Infor newInfo = req.requestMethod();
    	return this.inforRepository.save(newInfo);
    }
    
    public org.springframework.data.domain.Page<Infor>  listing(String q, int page, int limit, boolean isPage, String sort) throws Exception {
    	
    	//sort with desc and asc 
    	List<Sort.Order> sortByList = new ArrayList<>();
    	sortByList.add(new Sort.Order(Sort.Direction.DESC, "id"));
    	sortByList.add(new Sort.Order(Sort.Direction.ASC, "name"));
    	sortByList.add(new Sort.Order(Sort.Direction.DESC, "description"));
    	
    	
    	Pageable pageable;
    	if(isPage) pageable = PageRequest.of(page - 1, limit, Sort.by(sortByList));
    	else pageable = Pageable.unpaged();
    	
    	if(page <=0 || limit <=0 ) throw new Exception("Invalid Page");
    	
    
    	// replace with dynamic of page and limit
    	if(q == null || q.equals("")) {
    		return this.inforRepository.findAllListByNameContainingIgnoreCase(pageable, "");
    	}else {
    		return this.inforRepository.findAllListByNameContainingIgnoreCase(pageable, q);
    	}
    	
    }
}
