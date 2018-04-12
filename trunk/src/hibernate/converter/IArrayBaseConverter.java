package hibernate.converter;

import net.sf.json.JSONArray;

public interface IArrayBaseConverter {
	
	/*
	 * 子类继承Java对象转JSON对象接口
	 * @param Object Java对象
	 * @return JSONArray JSON数组
	 */
	public JSONArray toJSONArray(Object object);
}
