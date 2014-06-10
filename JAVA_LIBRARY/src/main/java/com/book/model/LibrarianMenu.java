package com.book.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author 王磊
 * @date 2013年4月24日 00:52:01
 * @describe 管理员菜单
 * 
 */
@Entity
@Table(name = "LIBRARIANMENU")
public class LibrarianMenu implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 管理员菜单ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 图书管理员ID
	 */
	private Integer librarian_ID;
	/**
	 * 菜单
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * @JoinColumn(name = "librarian_ID", insertable = false, updatable = false) private Librarian librarian;
	 */
	/**
	 * 菜单表ID
	 */
	private Integer menu_ID;
	/**
	 * 菜单
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_ID", insertable = false, updatable = false)
	private Menu menu;

	public LibrarianMenu(Integer id, Integer librarian_ID, Integer menu_ID)
	{
		super();
		this.id = id;
		this.librarian_ID = librarian_ID;
		this.menu_ID = menu_ID;
	}

	public LibrarianMenu()
	{
	}

	public LibrarianMenu(Integer librarian_ID, Integer menu_ID)
	{
		super();
		this.librarian_ID = librarian_ID;
		this.menu_ID = menu_ID;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getLibrarian_ID()
	{
		return librarian_ID;
	}

	public void setLibrarian_ID(Integer librarian_ID)
	{
		this.librarian_ID = librarian_ID;
	}

	public Integer getMenu_ID()
	{
		return menu_ID;
	}

	public void setMenu_ID(Integer menu_ID)
	{
		this.menu_ID = menu_ID;
	}

	public Menu getMenu()
	{
		return menu;
	}

	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

}
