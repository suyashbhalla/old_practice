import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXParserExample {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		
		
		parser.parse("XMLParsers\\EmployeeData.xml",new Handler());
		
	}
	
	static class Handler extends DefaultHandler{

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
			//System.out.println("Document Started");
		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
			/*System.out.println("Document End");*/
		}

		boolean a=false;
		boolean b=false;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			// TODO Auto-generated method stub
			/*super.startElement(uri, localName, qName, attributes);
			System.out.println("Element Started URI "+uri+" Local Name"+localName+" QName"+qName);
			
			for(int i=0;i<attributes.getLength();i++){
				System.out.println(attributes.getQName(i)+" "+attributes.getValue(i));
			}*/
			if(qName.equalsIgnoreCase("firstName")){
				a=true;
			}
			if(qName.equalsIgnoreCase("lastName")){
				b=true;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			// TODO Auto-generated method stub
			/*System.out.println("Element End");*/
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			/*System.out.println("Characters "+new String(ch,start,length));*/
			if(a){
				System.out.print("Name "+new String(ch,start,length));
				a=false;
			}
			if(b){
				System.out.println(" "+new String(ch,start,length));
				b=false;
			}
		}
		
	}

}
