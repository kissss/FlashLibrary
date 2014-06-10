package hibernate.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.book.dao.BaseDaoI;
import com.book.model.BookData;
import com.book.model.Librarian;
import com.book.model.LibrarianMenu;
import com.book.model.Menu;
import com.book.model.Parameter;
import com.book.model.Reader;
import com.book.model.ReaderRole;
import com.book.model.ReaderRoleMenu;
import com.book.model.zd.ReaderType_ZD;
import com.book.pageModel.PageJson;
import com.book.service.FileManageServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
public class HibernateTest {

	private SessionFactory sessionFactory;

	private BaseDaoI<BookData> baseDao;
	private FileManageServiceI fileManagerService;

	@Resource
	public void setFileManagerService(FileManageServiceI fileManagerService) {
		this.fileManagerService = fileManagerService;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setBaseDao(BaseDaoI<BookData> baseDao) {
		this.baseDao = baseDao;
	}

	@Test
	public void testHibernate() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < 100; i++) {
			BookData book = new BookData();
			book.setIsbn("123456");
			book.setName("Linux");
			session.saveOrUpdate(book);
		}
		tx.commit();
	}

	@Test
	public void testGetAllBooks() {
		PageJson p = new PageJson();
		p.setStart(0);
		System.out.println(JSON.toJSON(fileManagerService.getAllBooks(p)));
	}

	@Test
	public void testHql() {
		Session session = sessionFactory.openSession();
		System.out.println(JSON.toJSON(session.createQuery("from BookData where ? like '%2%'").setParameter(0, "isbn").list()));
	}

	@Test
	public void testSaveOrUpdate() {
		BookData b = new BookData();
		b.setName("a");
	}

	@Test
	public void testHql1() {
		Session session = sessionFactory.openSession();
		System.out.println(JSON.toJSON(session.createQuery("from BookData").list()));
	}

	@Test
	public void testAuth() {
		Session session = sessionFactory.openSession();
		Librarian lib = (Librarian) session.get(Librarian.class, 1);
		System.out.println(JSON.toJSONString(lib.getLibMenu()));
	}

	@Test
	public void testSys() {
		System.out.println(12);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMenu() {
		Session session = sessionFactory.openSession();
		List<Menu> menuList = session.createQuery("from Menu where pid is null").list();
		Librarian lib = (Librarian) session.get(Librarian.class, 1);
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
		System.out.println(JSON.toJSONString(obj));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMenu1() {
		Session session = sessionFactory.openSession();
		List<Menu> menuList = session.createQuery("from Menu where pid is null").list();
		Reader reader = (Reader) session.get(Reader.class, 1);

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
		System.out.println(JSON.toJSONString(obj));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testParameter() {
		Session session = sessionFactory.openSession();
		List<Reader> ps = session.createQuery("from Reader").list();
		System.out.println(JSON.toJSON(ps));
		// ReaderRole a1 = JSON.parseObject(text, ReaderRole.class);
		// System.out.println(JSON.toJSONString(a1));

	}
}
