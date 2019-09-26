package cn.itbaizhan.shop.assess.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itbaizhan.shop.assess.service.AssessService;
import cn.itbaizhan.shop.assess.vo.Assess;
import cn.itbaizhan.shop.order.dao.OrderDao;
import cn.itbaizhan.shop.order.vo.Order;
import cn.itbaizhan.shop.user.vo.User;
import cn.itbaizhan.shop.utils.Appconst;
import cn.itbaizhan.shop.utils.DateTime;

public class AssessAction extends ActionSupport implements ModelDriven<Assess> {

	/**
	 * 
	 */
	//	private static final long serialVersionUID = 1L;
	private AssessService assessService;
	// 模型驱动使用的对象
	private Assess assess = new Assess();
	public Assess getModel() {
		// TODO Auto-generated method stub
		return assess;
	}
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	// 接收page
	private Integer page;


	public String saveAssess() {
		try {
			User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
			//StringBuffer pid = ServletActionContext.getRequest().getRequestURL();
			Integer uid = existUser.getUid();
			Assess assesss = new Assess();
			String oid = Appconst.getOid();
			String pid = Appconst.getPid();
			assesss.setUsername(existUser.getUsername());
			assesss.setMsg(ServletActionContext.getRequest().getParameter("msg"));
			assesss.setPid(Integer.parseInt(pid));
			assesss.setOid(Integer.parseInt(oid));
			assesss.setRemark(ServletActionContext.getRequest().getParameter("remark"));
			assesss.setUid(uid);
			assesss.setUpdatetime(DateTime.getDate());
			assesss.setStatus(1);
			assessService.saveAssess(assesss);
			
			System.out.println("修改是否已经评价");
			
			this.addActionMessage("评价成功");
			return "msg";
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionMessage("评价失败");
			// return "msg";
		}
		return "msg";
	}

	public String pageAssess() {
		//		Object pid = ServletActionContext.getRequest().getSession().getAttribute("pid");
		// ServletActionContext.getRequest().getParameter();
		String pid = ServletActionContext.getRequest().getParameter("pid");
		String oid = ServletActionContext.getRequest().getParameter("oid");
		Appconst.setOid(oid);
		Appconst.setPid(pid);
		return "pageAssess";
	}
	

	public String listAssess() {
		Integer pid = Appconst.getPpid();
		List<Assess> assessList = assessService.findByPid(pid);
		
		
		ServletContext application = ServletActionContext.getServletContext ();
		application.setAttribute("assessList",assessList);
//		ActionContext.getContext().getValueStack().set("assessList", assessList);
		
		

		return "listAssess";
	}

	public AssessAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssessAction(AssessService assessService) {
		super();
		this.assessService = assessService;
	}

	public AssessService getAssessService() {
		return assessService;
	}

	public void setAssessService(AssessService assessService) {
		this.assessService = assessService;
	}



	public Assess getAssess() {
		return assess;
	}

	public void setAssess(Assess assess) {
		this.assess = assess;
	}

	private String pid;
	private String oid;



	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}
