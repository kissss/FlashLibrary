package com.book.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.book.dao.BaseDaoI;
import com.book.model.Librarian;
import com.book.model.LoginLogInfo;
import com.book.model.OperateLogInfo;
import com.book.model.Reader;
import com.book.pageModel.PageJson;
import com.book.util.DateUtil;

@Component("logService")
public class LogServiceImpl implements LogServiceI {

	private BaseDaoI<OperateLogInfo> operateLogDAO;
	private BaseDaoI<LoginLogInfo> loginLogDAO;

	@Resource
	public void setOperateLogDAO(BaseDaoI<OperateLogInfo> operateLogDAO) {
		this.operateLogDAO = operateLogDAO;
	}

	@Resource
	public void setLoginLogDAO(BaseDaoI<LoginLogInfo> loginLogDAO) {
		this.loginLogDAO = loginLogDAO;
	}

	@Override
	public void saveLog(Reader reader, String msg) {
		OperateLogInfo operateLogInfo = new OperateLogInfo();
		operateLogInfo.setName(reader.getName());
		operateLogInfo.setReaderid(reader.getReaderid());
		operateLogInfo.setDetail(msg);
		operateLogInfo.setOperateDate(DateUtil.dateTimeFormater(new Date()));
		operateLogDAO.save(operateLogInfo);
	}

	@Override
	public void saveLog(Librarian librarian, String msg) {
		OperateLogInfo operateLogInfo = new OperateLogInfo();
		operateLogInfo.setName(librarian.getName());
		operateLogInfo.setReaderid(librarian.getUserid());
		operateLogInfo.setDetail(msg);
		operateLogInfo.setOperateDate(DateUtil.dateTimeFormater(new Date()));
		operateLogDAO.save(operateLogInfo);
	}

	@Override
	public void saveLog(LoginLogInfo loginLogInfo) {
		loginLogDAO.save(loginLogInfo);
	}

	@Override
	public PageJson getAllLoginInfo(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {

			hql = "from LoginLogInfo where " + pageJson.getSearchKey() + " like :searchValue";
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from LoginLogInfo";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(loginLogDAO.find(hql, map, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(loginLogDAO.count("select count(*) " + hql, map));
		return pj;
	}

	@Override
	public PageJson getAllOperateInfo(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {

			hql = "from OperateLogInfo where " + pageJson.getSearchKey() + " like :searchValue";
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from OperateLogInfo";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(operateLogDAO.find(hql, map, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(operateLogDAO.count("select count(*) " + hql, map));
		return pj;
	}

}
