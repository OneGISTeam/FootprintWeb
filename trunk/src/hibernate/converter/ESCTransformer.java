package hibernate.converter;

/*
 * 转义字符转义器，便于前台解析转义后的JSON字符串
 */
public class ESCTransformer {
	
	public static String transformESC(String str){  
	    StringBuffer res=new StringBuffer();  
	      
	    for (int i=0; i<str.length(); i++) {              
	        char c = str.charAt(i);         
	        switch (c) {         
	            case '\"':         
	                res.append("\\\"");         
	                break;         
	            case '\\':         
	                res.append("\\\\");         
	                break;         
	            case '/':         
	                res.append("\\/");         
	                break;         
	            case '\b':         
	                res.append("\\b");         
	                break;         
	            case '\f':         
	                res.append("\\f");         
	                break;         
	            case '\n':         
	                res.append("\\n");         
	                break;         
	            case '\r':         
	                res.append("\\r");         
	                break;         
	            case '\t':         
	               res.append("\\t");         
	               break;   
	            case '\'':  
	                res.append("\\\'");  
	                break;  
	           default:         
	               res.append(c);         
	        }  
	    }  
	    return res.toString();  
	}  
}
