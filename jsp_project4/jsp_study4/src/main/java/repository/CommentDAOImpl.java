package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;
import service.CommentService;

public class CommentDAOImpl implements CommentDAO {

	private static final Logger log = LoggerFactory.getLogger(CommentService.class);
	private SqlSession sql;
	private String NS = "CommentMapper.";
	
	public CommentDAOImpl() {
		new DatabaseBuilder(); 
		sql = DatabaseBuilder.getFactory().openSession(); 
	}
	
	@Override
	public int insert(CommentVO cvo) {
		log.info(">>> insert DAO 진입");
		int isOk = sql.insert(NS+"reg",cvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info(">>> list DAO 진입");
		return sql.selectList(NS+"list",bno);
	}

	@Override
	public int update(CommentVO cvo) {
		log.info(">>> update DAO 진입");
		return sql.update(NS+"up",cvo);
	}

	@Override
	public int delete(int cno) {
		log.info(">>> delete DAO 진입");
		int isOk = sql.delete(NS+"del",cno);
		if(isOk>0) sql.commit();
		return isOk;
	}
	
	

}
 