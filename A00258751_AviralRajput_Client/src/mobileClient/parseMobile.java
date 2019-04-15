package mobileClient;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class parseMobile {

	boolean inmobileModels = false;
	boolean inmobile = false;
	boolean inId = false;
	boolean inName = false;
	boolean inPrice = false;
	boolean inDescription = false;

	mobile currentMobile;

	List<mobile> currentMobileList;

	public List<mobile> mobileParserFunc(String s) throws Exception {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser pullParser = factory.newPullParser();
		pullParser.setInput(new StringReader(s));
		processDocument(pullParser);
		return currentMobileList;
	}

	public void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start Document");
			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser);
			} else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser);
			} else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
	}

	public void processStartElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("mobileModels")) {
			inmobileModels = true;
			currentMobileList = new ArrayList<mobile>();
		} else if (name.equals("mobile")) {
			inmobile = true;
			currentMobile = new mobile();
		} else if (name.equals("id")) {
			inId = true;
		} else if (name.equals("name")) {
			inName = true;
		} else if (name.equals("price")) {
			inPrice = true;
		} else if (name.equals("description")) {
			inDescription = true;
		}
	}

	public void processEndElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("mobileModels")) {
			inmobileModels = false;
		} else if (name.equals("mobile")) {
			inmobile = false;
			currentMobileList.add(currentMobile);
		} else if (name.equals("id")) {
			inId = false;
		} else if (name.equals("name")) {
			inName = false;
		} else if (name.equals("price")) {
			inPrice = false;
		} else if (name.equals("description")) {
			inDescription = false;
		}
	}

	public void processText(XmlPullParser event) throws XmlPullParserException {
		if (inId) {
			String s = event.getText();
			currentMobile.setId(Integer.parseInt(s));
		}
		if (inName) {
			String s = event.getText();
			currentMobile.setName(s);
		}
		if (inPrice) {
			String s = event.getText();
			currentMobile.setPrice(Integer.parseInt(s));
		}
		if (inDescription) {
			String s = event.getText();
			currentMobile.setDescription(s);
		}
	}
}
