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
 * @date 2013年4月24日 14:09:32
 * @describe 读者角色 菜单表
 * 
 */
@Entity
@Table(name = "READERROLEMENU")
public class ReaderRoleMenu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 角色ID
	 */
	private Integer readerRole_ID;
	/**
	 * 菜单表ID
	 */
	private Integer menu_ID;
	/**
	 * 菜单对象
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_ID", insertable = false, updatable = false)
	private Menu menus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenu_ID() {
		return menu_ID;
	}

	public Integer getReaderRole_ID() {
		return readerRole_ID;
	}

	public void setReaderRole_ID(Integer readerRole_ID) {
		this.readerRole_ID = readerRole_ID;
	}

	public void setMenu_ID(Integer menu_ID) {
		this.menu_ID = menu_ID;
	}

	public Menu getMenus() {
		return menus;
	}

	public void setMenus(Menu menus) {
		this.menus = menus;
	}

}
