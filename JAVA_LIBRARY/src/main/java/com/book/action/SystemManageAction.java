package com.book.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.book.model.Parameter;
import com.book.model.zd.BookLocation_ZD;
import com.book.model.zd.ReaderType_ZD;
import com.book.pageModel.PageJson;
import com.book.pageModel.PageResponse;
import com.book.service.LogServiceI;
import com.book.service.SystemManageServiceI;

@Namespace("/SystemManage")
@Action("SystemManageAction")
public class SystemManageAction extends BaseAction {

	private SystemManageServiceI systemManageServce;
	private LogServiceI logService;
	private PageJson pageJson;
	private BookLocation_ZD bookLocation;
	private ReaderType_ZD readerType;
	private Parameter parameter;
	private int ids[];
	private int start;

	@Resource
	public void setLogService(LogServiceI logService) {
		this.logService = logService;
	}

	@Resource
	public void setSystemManageServce(SystemManageServiceI systemManageServce) {
		this.systemManageServce = systemManageServce;
	}

	// ---------------------------------------馆藏地点管理---------------------------------------
	/**
	 * 点击入库信息时 combobox 显示入库位置信息
	 */
	public void getBookLocationList() {
		writeJson(systemManageServce.getBookLocationList());
	}

	/**
	 * 根据分页得到所需要馆藏地点信息数据
	 */
	public void getBookLocationAllList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJsonObj(systemManageServce.getBookLocationList(pageJson));
	}

	/**
	 * 更新或者保存馆藏信息
	 */
	public void saveOrUpdateBookLocation() {
		if (systemManageServce.saveOrUpdateBookLocation(bookLocation)) {
			logService.saveLog(this.getLibrarianSession(), "保存馆藏" + bookLocation.getLocationName() + "信息");
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void delBookLocation() {
		if (systemManageServce.delBookLocation(ids)) {
			logService.saveLog(this.getLibrarianSession(), "删除馆藏" + bookLocation.getLocationName() + "信息");
			writeJson(new PageResponse("删除成功", true));
		} else {
			writeJson(new PageResponse("删除失败,此地点正在使用", false));
		}
	}

	// ---------------------------------------读者类型管理---------------------------------------
	/**
	 * 点击读者信息时 combobox 显示读者类型信息
	 */
	public void getReaderTypeList() {
		writeJson(systemManageServce.getReaderTypeList());
	}

	/**
	 * 根据分页得到所需要读者类型信息数据
	 */
	public void getReaderTypeAllList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(systemManageServce.getReaderTypeList(pageJson));
	}

	/**
	 * 更新或者保存读者信息
	 */
	public void saveOrUpdateReaderType() {
		if (systemManageServce.saveOrUpdateReaderType(readerType)) {
			logService.saveLog(this.getLibrarianSession(), "更新读者信息");
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void delReaderType() {
		if (systemManageServce.delReaderType(ids)) {
			logService.saveLog(this.getLibrarianSession(), "删除读者类型");
			writeJson(new PageResponse("删除成功", true));
		} else {
			writeJson(new PageResponse("删除失败,此类型正在使用", false));
		}
	}

	// ---------------------------------------系统参数管理---------------------------------------
	/**
	 * 根据分页得到所需要读者类型信息数据
	 */
	public void getParameterAllList() {
		if (pageJson == null) {
			pageJson = new PageJson();
			pageJson.setStart(start);
		}
		writeJson(systemManageServce.getParameterAllList(pageJson));
	}

	/**
	 * 更新或者保存读者信息
	 */
	public void saveOrUpdateParameter() {
		if (systemManageServce.saveOrUpdateParameter(parameter)) {
			writeJson(new PageResponse("保存成功", true));
		} else {
			writeJson(new PageResponse("保存失败", false));
		}
	}

	/**
	 * 更新或者 保存一条数据
	 */
	public void delParameter() {
		if (systemManageServce.delParameter(ids)) {
			writeJson(new PageResponse("删除成功", true));
		} else {
			writeJson(new PageResponse("删除失败,此地点正在使用", false));
		}
	}

	// ---------------------------------------get--
	// set---------------------------------------
	public PageJson getPageJson() {
		return pageJson;
	}

	public void setPageJson(PageJson pageJson) {
		this.pageJson = pageJson;
	}

	public ReaderType_ZD getReaderType() {
		return readerType;
	}

	public void setReaderType(ReaderType_ZD readerType) {
		this.readerType = readerType;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public BookLocation_ZD getBookLocation() {
		return bookLocation;
	}

	public void setBookLocation(BookLocation_ZD bookLocation) {
		this.bookLocation = bookLocation;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
