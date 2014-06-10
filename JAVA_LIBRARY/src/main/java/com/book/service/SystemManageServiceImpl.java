package com.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.book.dao.BaseDaoI;
import com.book.model.Parameter;
import com.book.model.zd.BookLocation_ZD;
import com.book.model.zd.ReaderType_ZD;
import com.book.pageModel.PageJson;

@Component("systemManageServce")
public class SystemManageServiceImpl implements SystemManageServiceI {

	private BaseDaoI<BookLocation_ZD> bookLocationDAO;
	private BaseDaoI<ReaderType_ZD> readerTypeDAO;
	private BaseDaoI<Parameter> parameterDAO;

	@Override
	public boolean saveOrUpdateBookLocation(BookLocation_ZD bookLocation) {
		try {
			bookLocationDAO.saveOrUpdate(bookLocation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delBookLocation(int ids[]) {
		try {
			for (int id : ids) {
				bookLocationDAO.delete(bookLocationDAO.get(BookLocation_ZD.class, id));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageJson getBookLocationList(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {

			hql = "from BookLocation_ZD where " + pageJson.getSearchKey() + " like :searchValue";
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from BookLocation_ZD";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(bookLocationDAO.find(hql, map, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(bookLocationDAO.count("select count(*) " + hql, map));
		return pj;
	}

	@Override
	public List<BookLocation_ZD> getBookLocationList() {
		return bookLocationDAO.find("from BookLocation_ZD");
	}

	@Override
	public boolean saveOrUpdateReaderType(ReaderType_ZD readerType) {
		try {
			readerTypeDAO.saveOrUpdate(readerType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delReaderType(int ids[]) {
		try {
			for (int id : ids) {
				readerTypeDAO.saveOrUpdate(readerTypeDAO.get(ReaderType_ZD.class, id));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReaderType_ZD> getReaderTypeList() {
		return readerTypeDAO.find("from ReaderType_ZD");
	}

	@Override
	public PageJson getReaderTypeList(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {
			hql = "from ReaderType_ZD where " + pageJson.getSearchKey() + " like :searchValue";
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from ReaderType_ZD";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(readerTypeDAO.find(hql, map, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(readerTypeDAO.count("select count(*) " + hql, map));
		return pj;
	}

	@Override
	public boolean saveOrUpdateParameter(Parameter parameter) {
		try {
			parameterDAO.saveOrUpdate(parameter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delParameter(int ids[]) {
		try {
			for (int id : ids) {
				parameterDAO.saveOrUpdate(parameterDAO.get(Parameter.class, id));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageJson getParameterAllList(PageJson pageJson) {
		String hql = "";
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {
			hql = "from Parameter where " + pageJson.getSearchKey() + " like '%" + pageJson.getSearchValue() + "%'";
		} else {
			hql = "from Parameter";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(parameterDAO.find(hql, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(parameterDAO.count("select count(*) " + hql));
		return pj;
	}

	// ---------------------------------------DAO注入--------------------------------------
	@Resource
	public void setReaderTypeDAO(BaseDaoI<ReaderType_ZD> readerTypeDAO) {
		this.readerTypeDAO = readerTypeDAO;
	}

	@Resource
	public void setBookLocationDAO(BaseDaoI<BookLocation_ZD> bookLocationDAO) {
		this.bookLocationDAO = bookLocationDAO;
	}

	@Resource
	public void setParameterDAO(BaseDaoI<Parameter> parameterDAO) {
		this.parameterDAO = parameterDAO;
	}

}
