package com.logo.scrapping.index;

import com.logo.scrapping.bussiness.forumophilia.ForumPhiliaLogic;
import com.logo.scrapping.domain.Page;
import com.logo.srapping.util.GeneralUtils;
import com.logo.srapping.util.XmlUtils;

public class Index {

	static Index index = new Index();
	static GeneralUtils generalUtils = new GeneralUtils();
	private static int nivelScrappping;
	private static String url = "https://www.forumophilia.com/";

	public static void main(String[] args) {
		nivelScrappping = 10;
		long startTime = System.currentTimeMillis();
		obtainForumphilia();
		long endTime = System.currentTimeMillis();
		generalUtils.calculateTimeExecute(startTime, endTime);
	}

	private static void obtainForumphilia() {
		ForumPhiliaLogic logic = new ForumPhiliaLogic(url, nivelScrappping);
		Page page = new Page();
		page.setNivel(0);

		page.setUrl(url);
		logic.obtainForum(page, ".topic-title");
		if (!page.getFormus().isEmpty()) {
//			logic.obtainTopics(page);
//			logic.obtainContents(page);
		} else {
			System.out.println("No hay sub urls");
		}

		XmlUtils.jaxbObjectToXML(page);

	}

//	+56965025810

}
