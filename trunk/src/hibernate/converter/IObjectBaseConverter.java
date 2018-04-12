package hibernate.converter;

import net.sf.json.JSONObject;

public interface IObjectBaseConverter{
	
	/*
	 * 子类继承Java对象转JSON对象接口
	 * @param Object Java对象
	 * @return JSONObject JSON对象
	 */
	public JSONObject toJSONObject(Object object);
}
