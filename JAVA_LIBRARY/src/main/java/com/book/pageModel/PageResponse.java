package com.book.pageModel;

/**
 * 
 * @author 王磊
 * @date 2013年4月19日 15:24:43
 * @describe flex中用于 更新 保存 删除 是否成功
 * 
 */
public class PageResponse
{

	/**
	 * 前台需要显示的提示信息，成功 或者失败
	 */
	private String msg;
	/**
	 * 用于显示 操作是否成功
	 */
	private boolean success;
	/**
	 * 前台需要的信息
	 */
	private Object obj;

	public String getMsg()
	{
		return msg;
	}

	public PageResponse()
	{
		super();
	}

	public PageResponse(String msg, boolean success)
	{
		super();
		this.msg = msg;
		this.success = success;
	}

	public PageResponse(String msg, boolean success, Object obj)
	{
		super();
		this.msg = msg;
		this.success = success;
		this.obj = obj;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public Object getObj()
	{
		return obj;
	}

	public void setObj(Object obj)
	{
		this.obj = obj;
	}
}
