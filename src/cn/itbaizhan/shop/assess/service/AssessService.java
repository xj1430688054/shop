package cn.itbaizhan.shop.assess.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itbaizhan.shop.assess.dao.AssessDao;
import cn.itbaizhan.shop.assess.vo.Assess;
import cn.itbaizhan.shop.order.dao.OrderDao;
import cn.itbaizhan.shop.order.vo.Order;

@Transactional
public class AssessService {
	
	private AssessDao assessDao;

	public AssessDao getAssessDao() {
		return assessDao;
	}
	
	

	public void setAssessDao(AssessDao assessDao) {
		this.assessDao = assessDao;
	}

	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return assessDao.findByOid(oid);
	}
	public void saveAssess(Assess assess) {
		assessDao.save(assess);
		assessDao.updateStatus(assess.getOid());
	}



	public List<Assess> findByPid(Integer pid) {	
		return assessDao.findByPid(pid);
	}
	

}
