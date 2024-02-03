package pagination.page_limit.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pagination.page_limit.Model.Entity.Infor;
import pagination.page_limit.Model.Request.InfoRequest;
import pagination.page_limit.Model.Response.InforResponse;
import pagination.page_limit.Services.Services;

@RestController
@RequestMapping("/api/info")
public  class Controller {

	private final Services serviceInfor;
    @Autowired
	public Controller(Services serviceInfor) {
		super();
		this.serviceInfor = serviceInfor;
	}

    @PostMapping
    public ResponseEntity<InforResponse> add(@RequestBody InfoRequest infoReq){
    	Infor newInfor = this.serviceInfor.createData(infoReq);
    	return ResponseEntity.ok(InforResponse.responseMethod(newInfor));
    }
    
    @GetMapping
    public ResponseEntity<List<InforResponse>> listingData(@RequestParam(name="q",required = false) String q,
    		@RequestParam(name="page") int page,
    		@RequestParam(name="limit") int limit,
    		@RequestParam(name="isPage", required = false, defaultValue = "true") String isPage
    		) throws Exception{
    	List<InforResponse> newList = this.serviceInfor.listing(q, page, limit, Objects.equals(isPage, "true") ).stream().map(InforResponse::responseMethod).toList();
    	return ResponseEntity.ok(newList);
    }
    
}