package hibernate.converter;

import hibernate.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import ognl.DefaultTypeConverter;

public class UserListConverter extends DefaultTypeConverter implements IArrayBaseConverter {
	@Override
	public Object convertValue(Map context, Object value, Class toType){
		if(List.class == toType){
			return toJSONArray(value).toString();
		}
		return null;
	}

	@Override
	public JSONArray toJSONArray(Object object) {
		// TODO Auto-generated method stub
		List<User> userList = (List<User>)object;
		JSONArray jsonArray = new JSONArray();
		UserConverter converter = new UserConverter();
		for(int i=0; i<userList.size();i++){
			jsonArray.add(converter.toJSONObject(userList.get(i)));
		}
		return jsonArray;
	}
}
