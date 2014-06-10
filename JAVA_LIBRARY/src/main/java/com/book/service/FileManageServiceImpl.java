package com.book.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.book.dao.BaseDaoI;
import com.book.model.BookData;
import com.book.model.BookInfo;
import com.book.model.Librarian;
import com.book.model.LibrarianMenu;
import com.book.model.Menu;
import com.book.model.Reader;
import com.book.model.ReaderRoleMenu;
import com.book.pageModel.PageBookData;
import com.book.pageModel.PageBookInfo;
import com.book.pageModel.PageJson;
import com.book.pageModel.PageReader;
import com.book.util.DateUtil;

@Component("fileManagerService")
public class FileManageServiceImpl implements FileManageServiceI {

	private BaseDaoI<BookData> fileManagerDAO;
	private BaseDaoI<BookInfo> bookInfoDAO;
	private BaseDaoI<Reader> readerDAO;
	private BaseDaoI<Librarian> librarianDAO;
	private BaseDaoI<Menu> menuDAO;
	private BaseDaoI<LibrarianMenu> librarianMenuDAO;

	@Resource
	public void setLibrarianMenuDAO(BaseDaoI<LibrarianMenu> librarianMenuDAO) {
		this.librarianMenuDAO = librarianMenuDAO;
	}

	@Resource
	public void setMenuDAO(BaseDaoI<Menu> menuDAO) {
		this.menuDAO = menuDAO;
	}

	@Resource
	public void setLibrarianDAO(BaseDaoI<Librarian> librarianDAO) {
		this.librarianDAO = librarianDAO;
	}

	@Resource
	public void setReaderDAO(BaseDaoI<Reader> readerDAO) {
		this.readerDAO = readerDAO;
	}

	@Resource
	public void setFileManagerDAO(BaseDaoI<BookData> fileManagerDAO) {
		this.fileManagerDAO = fileManagerDAO;
	}

	@Resource
	public void setBookInfoDAO(BaseDaoI<BookInfo> bookInfoDAO) {
		this.bookInfoDAO = bookInfoDAO;
	}

	@Override
	public PageJson getAllBooks(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {

			hql = "from BookData where " + pageJson.getSearchKey() + " like :searchValue";
			// map.put("searchKey", pageJson.getSearchKey());
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from BookData";
		}
		hql += " order by id";
		List<BookData> bookDataLists = fileManagerDAO.find(hql, map, pageJson.getStart(), pageJson.getRows());
		// -----------------------------------------进行前台页面信息的组装-----------------------------------------
		// 前台需要的图书基本信息
		List<PageBookData> pageBookDataList = new ArrayList<PageBookData>();
		for (BookData b : bookDataLists) {
			PageBookData page = new PageBookData();
			// 前台页面用的馆藏信息
			List<PageBookInfo> bookInfoList = new ArrayList<PageBookInfo>();
			// 组装馆藏信息
			for (BookInfo bookInfos : b.getBookInfos()) {
				PageBookInfo pageBookInfo = new PageBookInfo();

				BeanUtils.copyProperties(bookInfos, pageBookInfo);
				pageBookInfo.setBookLocation_ID(bookInfos.getBookLocation().getId());
				pageBookInfo.setBookLocation_location(bookInfos.getBookLocation().getLocation());
				pageBookInfo.setBookLocation_locationName(bookInfos.getBookLocation().getLocationName());
				bookInfoList.add(pageBookInfo);
			}
			page.setBookInfos(bookInfoList);

			BeanUtils.copyProperties(b, page, new String[] { "bookInfos" });
			pageBookDataList.add(page);
		}

		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(pageBookDataList);
		pj.setListCount(fileManagerDAO.count("select count(*) " + hql, map));
		return pj;
	}

	@Override
	public boolean saveOrUpdateBook(BookData bookData) {
		try {
			bookData.setCreateTime(DateUtil.dateTimeFormater(new Date()));
			fileManagerDAO.saveOrUpdate(bookData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delBook(int ids[]) {
		try {
			for (int id : ids) {
				fileManagerDAO.delete(fileManagerDAO.get(BookData.class, id));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveBookInfo(BookInfo bookInfo) {
		try {
			bookInfoDAO.saveOrUpdate(bookInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageJson getReadersList(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {

			hql = "from Reader where " + pageJson.getSearchKey() + " like :searchValue";
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from Reader";
		}
		hql += " order by id";
		List<Reader> readerList = readerDAO.find(hql, map, pageJson.getStart(), pageJson.getRows());
		List<PageReader> pageReaderList = new ArrayList<PageReader>();

		for (Reader reader : readerList) {
			PageReader pageReader = new PageReader();
			BeanUtils.copyProperties(reader, pageReader);
			pageReader.setReaderType_name(reader.getReaderType().getName());
			pageReaderList.add(pageReader);
		}

		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(pageReaderList);
		pj.setListCount(readerDAO.count("select count(*) " + hql, map));
		return pj;
	}

	@Override
	public boolean saveOrUpdateReader(Reader reader) {
		try {
			readerDAO.saveOrUpdate(reader);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delReader(int ids[]) {
		try {
			for (int id : ids) {
				readerDAO.delete(readerDAO.get(Reader.class, id));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageJson getAdminsList(PageJson pageJson) {
		String hql = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (pageJson.getSearchKey() != null && pageJson.getSearchValue() != null) {

			hql = "from Librarian where " + pageJson.getSearchKey() + " like :searchValue";
			map.put("searchValue", "%" + pageJson.getSearchValue() + "%");
		} else {
			hql = "from Librarian";
		}
		hql += " order by id";
		// 前台需要 查询得到数据 和 条数
		PageJson pj = new PageJson();
		pj.setData(librarianDAO.find(hql, map, pageJson.getStart(), pageJson.getRows()));
		pj.setListCount(librarianDAO.count("select count(*) " + hql, map));
		return pj;
	}

	@Override
	public boolean saveOrUpdateAdmin(Librarian librarian) {
		// 分别对应图书管理，读者管理，参数管理权限
		Integer auth[] = { librarian.getBookp(), librarian.getReaderp(), librarian.getParameterp() };
		// 与上面分别对应的菜单ID
		Integer menu[] = { 7, 8, 15 };
		try {
			librarianDAO.saveOrUpdate(librarian);
			librarianMenuDAO.executeHql("delete LibrarianMenu where librarian_ID = " + librarian.getId());
			for (int i = 0; i < auth.length; i++) {
				if (auth[i] == 1)// 1 表示此用户有这个权限
				{
					librarianMenuDAO.saveOrUpdate(new LibrarianMenu(librarian.getId(), menu[i]));
				}
			}
			librarianMenuDAO.saveOrUpdate(new LibrarianMenu(librarian.getId(), 16));
			librarianMenuDAO.saveOrUpdate(new LibrarianMenu(librarian.getId(), 17));
			librarianMenuDAO.saveOrUpdate(new LibrarianMenu(librarian.getId(), 18));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delAdmin(int ids[]) {
		try {
			for (int id : ids) {
				librarianDAO.delete(librarianDAO.get(Librarian.class, id));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map<String, Object> login(Reader reader) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapLib = new HashMap<String, Object>();
		map.put("readerid", reader.getReaderid());
		map.put("passwd", reader.getPasswd());
		Reader readerMenu = readerDAO.get("from Reader where readerid=:readerid and passwd=:passwd", map);
		if (readerMenu != null) {
			mapLib.put("reader", readerMenu);
			mapLib.put("libMenu", getReaderMenu(readerMenu));
		}
		return mapLib;
	}

	private Object getReaderMenu(Reader reader) {

		List<Menu> menuList = menuDAO.find("from Menu where pid is null");

		Set<ReaderRoleMenu> libMenu = reader.getReaderRole().getRoleMenus();

		List<Object> obj = new ArrayList<Object>();
		for (Menu firstMenu : menuList) // 循环一级菜单
		{
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> subMenuList = new ArrayList<Map<String, Object>>();
			map.put("caption", firstMenu.getName());
			map.put("icon", firstMenu.getIcon());
			for (Menu second : firstMenu.getMenus())// 得到二级菜单
			{
				for (ReaderRoleMenu menu_ID : libMenu) {
					if (menu_ID.getMenu_ID() == second.getId()) {
						Map<String, Object> subMap = new HashMap<String, Object>();
						subMap.put("caption", second.getName());
						subMap.put("icon", second.getIcon());
						subMap.put("url", second.getUrl());
						subMenuList.add(subMap);
					}
				}
			}
			map.put("subMenuList", subMenuList);
			if (subMenuList.size() > 0) {
				obj.add(map);
			}
		}
		return obj;
	}

	@Override
	public Map<String, Object> loginLibrarian(Librarian librarian) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapLib = new HashMap<String, Object>();
		map.put("username", librarian.getUsername());
		map.put("pwd", librarian.getPwd());
		Librarian lib = librarianDAO.get("from Librarian where username=:username and pwd=:pwd", map);
		if (lib != null) {
			mapLib.put("librarian", lib);
			mapLib.put("libMenu", getLibrarianMenu(lib));

		}
		return mapLib;
	}

	public Object getLibrarianMenu(Librarian lib) {
		List<Menu> menuList = menuDAO.find("from Menu where pid is null");
		Set<LibrarianMenu> libMenu = lib.getLibMenu();
		List<Object> obj = new ArrayList<Object>();
		for (Menu firstMenu : menuList) // 循环一级菜单
		{
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> subMenuList = new ArrayList<Map<String, Object>>();
			map.put("caption", firstMenu.getName());
			map.put("icon", firstMenu.getIcon());
			for (Menu second : firstMenu.getMenus())// 得到二级菜单
			{
				for (LibrarianMenu menu_ID : libMenu) {
					if (menu_ID.getMenu_ID() == second.getId()) {
						Map<String, Object> subMap = new HashMap<String, Object>();
						subMap.put("caption", second.getName());
						subMap.put("icon", second.getIcon());
						subMap.put("url", second.getUrl());
						subMenuList.add(subMap);
					}
				}
			}
			map.put("subMenuList", subMenuList);
			if (subMenuList.size() > 0) {
				obj.add(map);
			}
		}
		return obj;
	}
}
