package pagination.page_limit.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.websocket.server.PathParam;
import pagination.page_limit.Model.Entity.Infor;

@Repository
public interface InfoRepo extends JpaRepository<Infor, Long> {
	
	//import page from org.springframwork.data.domain it use in awt(desktop application)
//	Page<Infor> findAll(Pageable pageable);
	
	
//	set pagination with search param q
	Page<Infor> findAllListByNameContainingIgnoreCase( Pageable pageable, String q);
	
	
}
