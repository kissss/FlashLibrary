package com.book.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.book.dao.BaseDaoI;
import com.book.model.BookData;
import com.book.model.BookInfo;
import com.book.model.LendInfo;
import com.book.model.Parameter;
import com.book.model.Reader;
import com.book.pageModel.PageJson;
import com.book.pageModel.PageLendInfo;
import com.book.util.DateUtil;

@Component("catalogManageService")
public class CatalogManageServiceImpl implements CatalogManageServiceI {

	private BaseDaoI<BookData> bookDataDAO;
	private BaseDaoI<LendInfo> lendInfoDAO;
	private BaseDaoI<BookInfo> bookInfoDAO;

	@Resource
	public void setBookInfoDAO(BaseDaoI<BookInfo> bookInfoDAO) {
		this.bookInfoDAO = bookInfoDAO;
	}

	@Resource
	public void setLendInfoDAO(BaseDaoI<LendInfo> lendInfoDAO) {
		this.lendInfoDAO = lendInfoDAO;
	}

	@Resource
	public void setBookDataDAO(BaseDaoI<BookData> bookDataDAO) {
		this.bookDataDAO = bookDataDAO;
	}

	@Override
	public PageJson getCatalogList(PageJson pageJson) {
		String hql = "";
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {
			hql = "from BookData where " + pageJson.getSearchKey() + " like '%" + pageJson.getSearchValue() + "%'";
		} else {
			hql = "from BookData";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(bookDataDAO.find(hql, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(bookDataDAO.count("select count(*) " + hql));
		return pj;
	}

	@Override
	public boolean saveLendInfo(LendInfo lendInfo, Reader reader, BookInfo bookInfo) {
		try {
			Date date = new Date();
			Parameter parameter = reader.getReaderType().getParameter();// 得到该人员的系统参数对象
			String duedate = DateUtil.addDate(date, parameter.getPeriod());

			// 得到该人员类型 最多可借书多少
			Integer borrowMax = parameter.getAmount();
			// 得到该人员已经借了多少书
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("readerid", reader.getReaderid());
			int borrowCount = lendInfoDAO.find("from LendInfo where readerid=:readerid and returndate is null", map).size();
			if (borrowCount <= borrowMax)// 表示还可以借书
			{
				// 在借阅 表中 存入相应的信息
				lendInfo.setReaderid(reader.getReaderid());// 保存 读者ID
				lendInfo.setBorrowdate(DateUtil.dateFormater(date));// 保存借书天数
				lendInfo.setDuedate(duedate);// 保存应还日期
				lendInfoDAO.saveOrUpdate(lendInfo);
				// 先get出来这个对象再做更新 否则数据会更新没有
				BookInfo info = bookInfoDAO.get(BookInfo.class, bookInfo.getId());
				// 还要修改图书的状态信息
				info.setStatus(0);// 0表示不可借
				info.setDuedate(duedate);// 存入应还日期
				bookInfoDAO.saveOrUpdate(info);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageJson getBorrowInfo(PageJson pageJson, Reader reader) {
		String hql = "";
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {
			hql = "from LendInfo where readerid =" + reader.getReaderid() + " and " + pageJson.getSearchKey() + " like '%" + pageJson.getSearchValue() + "%' and returndate is null";
		} else {
			hql = "from LendInfo where readerid= " + reader.getReaderid() + " and returndate is null";
		}
		hql += " order by returndate";

		List<LendInfo> lendInfoList = lendInfoDAO.find(hql, pageJson.getStart(), pageJson.getRows());
		List<PageLendInfo> pageLendInfoList = getPageLendInfo(lendInfoList);
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(pageLendInfoList);
		pj.setListCount(lendInfoDAO.count("select count(*) " + hql));
		return pj;
	}

	private List<PageLendInfo> getPageLendInfo(List<LendInfo> lendInfoList) {
		List<PageLendInfo> pageLendInfoList = new ArrayList<PageLendInfo>();
		for (LendInfo lendInfo : lendInfoList) {
			PageLendInfo pageLendInfo = new PageLendInfo();
			BeanUtils.copyProperties(lendInfo, pageLendInfo);
			pageLendInfo.setBookLocation_ZD_location(lendInfo.getBookInfo().getBookLocation().getLocation());
			pageLendInfo.setBookLocation_ZD_locationName(lendInfo.getBookInfo().getBookLocation().getLocationName());
			pageLendInfo.setBookData_name(lendInfo.getBookInfo().getBookData().getName());
			pageLendInfo.setBookData_authors(lendInfo.getBookInfo().getBookData().getAuthors());
			pageLendInfo.setBookData_series(lendInfo.getBookInfo().getBookData().getSeries());
			pageLendInfo.setBookData_publisher(lendInfo.getBookInfo().getBookData().getPublisher());
			pageLendInfoList.add(pageLendInfo);
		}
		return pageLendInfoList;
	}

	@Override
	public PageJson getHistoryBorrowInfo(PageJson pageJson, Reader reader) {
		String hql = "";
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {
			hql = "from LendInfo where readerid =" + reader.getReaderid() + " and " + pageJson.getSearchKey() + " like '%" + pageJson.getSearchValue() + "%' and returndate is not null";
		} else {
			hql = "from LendInfo where readerid= " + reader.getReaderid() + " and returndate is not null";
		}
		hql += " order by returndate";
		List<LendInfo> lendInfoList = lendInfoDAO.find(hql, pageJson.getStart(), pageJson.getRows());
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(getPageLendInfo(lendInfoList));
		pj.setListCount(lendInfoDAO.count("select count(*) " + hql));
		return pj;
	}

	@Override
	public boolean updateLendInfo(LendInfo lendInfo, Reader reader, BookInfo bookInfo) {
		try {
			Parameter parameter = reader.getReaderType().getParameter();// 得到该人员的系统参数对象
			LendInfo lend = lendInfoDAO.get(LendInfo.class, lendInfo.getId());

			BookInfo book = bookInfoDAO.get(BookInfo.class, bookInfo.getId());
			String date = DateUtil.dateFormater(new Date());
			lend.setReturndate(date);
			int betweenDate = DateUtil.getBetweenDate(date, lend.getBorrowdate());// 还书日期和借书日期之差
			lend.setOverduedays(betweenDate);
			lend.setFine(parameter.getDailyfine() * betweenDate);
			lendInfoDAO.saveOrUpdate(lend);
			book.setStatus(1);
			book.setDuedate("");
			bookInfoDAO.saveOrUpdate(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
