package cn.itbaizhan.shop.assess.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.engine.ExecuteUpdateResultCheckStyle;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itbaizhan.shop.assess.vo.Assess;
import cn.itbaizhan.shop.order.vo.Order;
import cn.itbaizhan.shop.order.vo.OrderItem;
import cn.itbaizhan.shop.utils.PageHibernateCallback;

public class AssessDao extends HibernateDaoSupport{
	public void save(Assess assess) {
 		this.getHibernateTemplate().save(assess);
	}

	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, new Object[] { uid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// DAO层根据订单id查询订单
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	// DAO层修改订单的方法:
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}

	// DAO中统计订单个数的方法
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, null, begin, limit));
		return list;
	}

	// DAo中根据订单id查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public void updateStatus(Integer oid) {
		String sql="update orders set status =1 where oid = "+ oid; 
		 this.getSession().createSQLQuery(sql).executeUpdate();

		
	}

	public List<Assess> findByPid(Integer pid) {
		String hql = "from Assess oi where oi.pid = ?";
		List<Assess> list = this.getHibernateTemplate().find(hql, pid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
