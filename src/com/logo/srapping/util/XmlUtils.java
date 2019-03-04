package com.logo.srapping.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.logo.scrapping.domain.Page;

public class XmlUtils {

	public static void jaxbObjectToXML(Page page) {
		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(Page.class);
			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// Print XML String to Console
			StringWriter sw = new StringWriter();
			// Write XML to StringWriter
			jaxbMarshaller.marshal(page, sw);
			// Verify XML Content
			String xmlContent = sw.toString();
			System.out.println(xmlContent);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
