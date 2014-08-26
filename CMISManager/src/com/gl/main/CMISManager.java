package com.gl.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.alfresco.cmis.client.AlfrescoDocument;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.ObjectType;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.PropertyData;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class CMISManager {

	private String userName = "ecm-prov";
    private String password ="A!fr3$c0Pa$$";
    private static Session session;



	//private String atomPubUrl = "http://localhost:8080/alfresco/service/api/cmis";
    private static String atomPubUrl;
   
    
    public static Session getSession() {
    	return session;
    }
    
    public static void setSession(Session session) {
    	CMISManager.session = session;
    }
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAtomPubUrl() {
		return atomPubUrl;
	}

	public void setAtomPubUrl(String atomPubUrl) {
		CMISManager.atomPubUrl = atomPubUrl;
	}



	private Session staticSession;
    public static final String BINDING_TYPE = BindingType.ATOMPUB.value();
    public static final String FACTORY_CLASS = "org.alfresco.cmis.client.impl.AlfrescoObjectFactoryImpl";
    public static final String CMIS_NAME = "cmis:name";
    public static final String CMIS_OBJ_ID = "cmis:objectId";
	/**
	 * @param args
	 */
    public static final String s1= "/share/page/site/";
  //  public static final String s1= "http://localhost:8080/share/page/site/";
    public static final String s2= "/document-details?nodeRef=";

	String streamToString(InputStream in) throws IOException {
		  StringBuilder out = new StringBuilder();
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  for(String line = br.readLine(); line != null; line = br.readLine()) 
		    out.append(line);
		  br.close();
		  return out.toString();
		}
	 public Session prepareSession() {
	        if (staticSession == null) {
	            Map<String, String> parameter = new HashMap<String, String>();
	            parameter.put(SessionParameter.USER, userName);
	            parameter.put(SessionParameter.PASSWORD, password);
	            parameter.put(SessionParameter.ATOMPUB_URL, atomPubUrl+"/alfresco/service/api/cmis");
	            parameter.put(SessionParameter.BINDING_TYPE, BINDING_TYPE);
	            parameter.put(SessionParameter.OBJECT_FACTORY_CLASS, FACTORY_CLASS);

	            SessionFactory factory = SessionFactoryImpl.newInstance();
	            staticSession = factory.getRepositories(parameter).get(0).createSession();
	        }
	        return staticSession;
	    }


	 
	  String createExcel(Map<String, List<Object>> data) throws Exception{
	
		 HSSFWorkbook workbook = new HSSFWorkbook();
	 HSSFSheet sheet = workbook.createSheet("Sheet");
	  
	  
	 Set<String> keyset = data.keySet();
	 String months[] = {
		      "Jan", "Feb", "Mar", "Apr",
		      "May", "Jun", "Jul", "Aug",
		      "Sep", "Oct", "Nov", "Dec"};
	 
	 
	 int rownum = 0;
	 for (String key : keyset) {
	     Row row = sheet.createRow(rownum++);
	     List<Object> objArr = data.get(key);
	     
	     int cellnum = 0;
	     for (Object obj : objArr) {
	         Cell cell = row.createCell(cellnum++);
	         if(obj instanceof GregorianCalendar) {
	        	 
	        	 Calendar calendar = (GregorianCalendar)obj;
	        	 int year       = calendar.get(Calendar.YEAR);
	     	int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
	     	int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 
	     	int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
	     	int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
	     	int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);
	      
	     	int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
	     	int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
	     	int minute     = calendar.get(Calendar.MINUTE);
	     	int second     = calendar.get(Calendar.SECOND);
	     	int millisecond= calendar.get(Calendar.MILLISECOND);
	        	 
	     	// Jun 20, 2014 3:52:23 PM
	             cell.setCellValue(months[month]+" "+hourOfDay+", "+year+" "+hourOfDay+":"+minute+":"+second);
	 } else if(obj instanceof Boolean)
	             cell.setCellValue((Boolean)obj);
	         else if(obj instanceof String)
	             cell.setCellValue((String)obj);
	         else if(obj instanceof Double)
	             cell.setCellValue((Double)obj);
	     }
	 }
	 String path = "C:\\Report_"+System.currentTimeMillis()+".xls";
	     FileOutputStream out = 
	             new FileOutputStream(new File(path));
	     workbook.write(out);
	     out.close();
	     System.out.println("Excel written successfully..");
	      
		 return path;
	 }



	public String generateReport(Session session2, String value) throws Exception{
            
            ItemIterable<QueryResult> query = session.query(value, false);
            System.out.println("Total Number: "+ query.getTotalNumItems());
            int counter = 1;
            int counterTotal = 1;
            Map<String, List<Object>> data = new LinkedHashMap<String, List<Object>>();
       	    List<Object> listOfHeader = new ArrayList<Object>();
       	    boolean status = true;
            for (QueryResult queryResult : query) {
            	try{
            		List<Object> listOfValue = new ArrayList<Object>();
            		String objectid = null;
            		List<PropertyData<?>> properties = queryResult.getProperties();
            		first:
            		for(PropertyData propertyData :properties){
            			if(status)
            			listOfHeader.add(propertyData.getDisplayName());
            			listOfValue.add(propertyData.getFirstValue());
            			
            					List values = propertyData.getValues();
            					for (Object o : values) {
            						if (o.toString().contains("workspace://SpacesStore/")) {
            							objectid = o.toString();
            							break;
            						}
            					}
            			}
            		
            		if(status){
            			listOfHeader.add("Path");
            			listOfHeader.add("URL");
            			data.put("0", listOfHeader);
            			status = false;
            		}
            		/*Object versionLabel = queryResult.getPropertyByQueryName("d.cmis:versionLabel").getFirstValue();
            		Object createdBy = queryResult.getPropertyByQueryName("d.cmis:createdBy").getFirstValue();
            		Object name = queryResult.getPropertyByQueryName("d.cmis:name").getFirstValue();
            		Object creationDate = queryResult.getPropertyByQueryName("d.cmis:creationDate").getFirstValue();
            		*/
            			// objectid = (String)queryResult.getPropertyByQueryName("d."+CMIS_OBJ_ID).getFirstValue();
            			System.out.println("noderef: "+objectid);
                		CmisObject cmisObject = session.getObject(objectid);
                		Document document = (Document)cmisObject;   
                		List<String> paths = document.getPaths();
                		String p="";
                		for(String s: paths ){
                			//System.out.println("-------Path: "+s);
                			p=s;
                		}
                		//System.out.println(paths);
                		String[] split = p.split("/");
                		String nameD = null; 
                		if(split.length>=2){
                			nameD = split[2];
                		}
                		String fullPath=atomPubUrl+s1+nameD+s2+objectid;
                		System.out.println( atomPubUrl+s1+nameD+s2+objectid);
            			
                		listOfValue.add(p);
            			listOfValue.add(fullPath);
            			data.put(""+(counter++), listOfValue);
            		//System.out.println(creationDate +"	"+createdBy+"      "+versionLabel+"       "+p+"  --------"+atomPubUrl+s1+split[2]+s2+objectid);
            		
            	}catch(Exception e){
            		e.printStackTrace();
            	}
            	
            	System.out.println(++counterTotal);
            }
            
            return createExcel(data);
    	}

	public String documentActions(Session session2, String value, String aspectName,String action) throws Exception {
		boolean contains = value.toUpperCase().contains("SELECT");
		
		if(!contains){
			
			String[] split = value.split(",");
			StringBuffer stringBuffer = new StringBuffer();
			for(String s:split){
				stringBuffer.append("'"+s+"',");
			}
			value = stringBuffer.toString();
			value = value.substring(0,(value.length()-1));
			value = "select cmis:objectId from cmis:document where cmis:objectId in("+value+")";
			
		}
			
	     ItemIterable<QueryResult> query = session.query(value, false);
         System.out.println("Total Number: "+ query.getTotalNumItems());
         StringBuilder stringBuilder = new StringBuilder();
		for (QueryResult queryResult : query) {

			String objectid = null;
			if(!contains){
				 objectid = (String) queryResult.getPropertyByQueryName(CMIS_OBJ_ID).getFirstValue();
			}else{
			List<PropertyData<?>> properties = queryResult.getProperties();
			first:
				for (PropertyData propertyData : properties) {
					List values = propertyData.getValues();
					for (Object o : values) {
						if (o.toString().contains("workspace://SpacesStore/")) {

							objectid = o.toString();
							break first;
						}
					}
				}
			}
			System.out.println("noderef: " + objectid);
			CmisObject cmisObject = session.getObject(objectid);

			Document document = (Document) cmisObject;
			
			stringBuilder.append("\n \n Document Name: "+document.getName());
			
			AlfrescoDocument alfDoc = (AlfrescoDocument) document;

			if("add".equals(action)){
			alfDoc.addAspect("P:" + aspectName);
			}else if("remove".equals(action)){
				Collection<ObjectType> aspects = alfDoc.getAspects();
				for(ObjectType objectType : aspects){
					if(objectType.getQueryName().equals(aspectName)){
						alfDoc.removeAspect(objectType);	
					}
				}
		//		alfDoc.removeAspect("P:" + aspectName);
			}else if("listAspects".equals(action)){
				
				Collection<ObjectType> aspects = alfDoc.getAspects();
				for(ObjectType objectType : aspects){
					stringBuilder.append("\n\t"+objectType.getQueryName());
					System.out.println(objectType.getQueryName());
				}
			}else if("objectPath".equals(action)){
				List<String> paths = document.getPaths();
				String p="";
				for(String s: paths ){
					p=s;
				}
				String[] split = p.split("/");
				stringBuilder.append("\n"+atomPubUrl+s1+split[2]+s2+objectid);
				System.out.println(atomPubUrl+s1+split[2]+s2+objectid);
				}
				
		}		
		return stringBuilder.toString();
	}
	 
}
