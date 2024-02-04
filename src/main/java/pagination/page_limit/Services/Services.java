package pagination.page_limit.Services;

import java.util.ArrayList;
import java.util.Arrays;
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
    	
    	//sort with desc and asc with param id:desc,name:asc
    	List<Sort.Order> sortByList = Arrays.stream(sort.split(",")).map((t) -> {
    		String direction = t.split(":")[1].toLowerCase();
    		String field = t.split(":")[0];
    		return new Sort.Order(direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, field);
    	}).toList();

    	
    	
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
