package pagination.page_limit.Services;

import java.util.List;
import java.util.Map;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    
    public org.springframework.data.domain.Page<Infor>  listing(String q, int page, int limit) throws Exception {
    	
    	//page 2 and list 3 it is static of add page
//    	return this.inforRepository.findAll(PageRequest.of(2, 3));
    	
    	
    	//page 2 and list 3 with sort
//    	return this.inforRepository.findAll(PageRequest.of(2, 3, Sort.by(Sort.Direction.DESC, "id")));
    	
    	
    	//page 2 and list 3 use dynamic of page and q == "" it mean it search all
//    	if(q == null || q.equals("")) {
//    		return this.inforRepository.findAllListByNameContainingIgnoreCase(PageRequest.of(2, 5, Sort.by(Sort.Direction.DESC, "id")), "");
//    	}else {
//    		return this.inforRepository.findAllListByNameContainingIgnoreCase(PageRequest.of(2, 5, Sort.by(Sort.Direction.DESC, "id")), q);
//    	}
    	
    	if(page <=0 || limit <=0 ) throw new Exception("Invalid Page");
    	
    	// replace with dynamic of page and limit
    	if(q == null || q.equals("")) {
    		return this.inforRepository.findAllListByNameContainingIgnoreCase(PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "id")), "");
    	}else {
    		return this.inforRepository.findAllListByNameContainingIgnoreCase(PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "id")), q);
    	}
    	
    }
}
